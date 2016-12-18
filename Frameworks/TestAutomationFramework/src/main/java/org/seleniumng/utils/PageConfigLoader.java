package org.seleniumng.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import static org.seleniumng.utils.TAFConfig.*;
public class PageConfigLoader {

	public static Config loadPageConfig (Class<?> class1){
		String langPath = tafConfig.getString("language")+ "/";
		String langDefault = tafConfig.hasPath("language.fallback")?tafConfig.getString("language.fallback")+ "/": "en_us/"; 
		String propFile = class1.getName().replace(".", "/")+ ".p";
		String prop_lang ="gui/"+langPath + propFile;
		String prop_fallback ="gui/" +langDefault+ propFile ;
		URL u = Thread.currentThread().getContextClassLoader().getResource("gui/" +propFile);
		URL u_lang = Thread.currentThread().getContextClassLoader().getResource(prop_lang);
		URL u_en_us = Thread.currentThread().getContextClassLoader().getResource(prop_fallback);
		Config c_lang = ConfigFactory.parseURL(u_lang);
		Config c_en_us = ConfigFactory.parseURL(u_en_us );
		Config cf = c_lang.withFallback(c_en_us);
		Config c = ConfigFactory.parseURL(u);
		return c.resolveWith(cf);
	}
	
	static Object getField(Field field, Config myConfig) {
		Class<?> ftype = field.getType();
		
		List <Class<?>> classHeirarchy = new ArrayList<Class<?>>();
		classHeirarchy.add(ftype);
		Class<?> c = ftype.getSuperclass();
		while (!c.isAssignableFrom(org.seleniumng.driver.GuiControl.class) ){	
			
			classHeirarchy.add(c);
			c = c.getSuperclass();
		}
		
		Config confControl = myConfig.getConfig(field.getName());
		Constructor<?> constructor = null;
		for (int i = classHeirarchy.size()-1; i>0; i--){
			confControl = loadPageConfig(classHeirarchy.get(i-1)).withFallback(confControl);
		}
		
		try {
			constructor = ftype.getConstructor(new Class[]{Config.class});
			Object o = constructor.newInstance(confControl);
			return o;
		} catch (Exception e){
			
		}
		return null;
	}
	
	static List<Field> listAllFields(Object obj) {
	    List<Field> fieldList = new ArrayList<Field>();
	    Class<?> tmpClass = obj.getClass();
	    while (tmpClass != null) {
	        fieldList.addAll(Arrays.asList(tmpClass .getDeclaredFields()));
	        tmpClass = tmpClass .getSuperclass();
	    }
	    return fieldList;
	}
	
	public static Object loadPage (Object obj, Config pageConf){
		List<Field> fields = listAllFields(obj);
		for (Field f:fields){
			Object o = getField (f,pageConf);
			try {
				f.set(obj, o);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
	
}
