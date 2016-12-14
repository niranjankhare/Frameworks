package org.seleniumng.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import app.heimdall.gui.pageObjects.*;

public class PageObjectRepository {
	 public void load  () {
		Class<?> cls = this.getClass();
		
		Field[] fields = cls.getDeclaredFields();
		
		for (Field f:fields){
			Class<?> ftype = f.getType();
			Constructor<?> constructor = null;
			try {
				constructor = ftype.getConstructor();
				Object o = constructor.newInstance();
				f.set(this, o);
				System.out.println("done");
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.println("done");
		}
	}
	public PageObjectRepository() {
		load();
	}
	
	
	
}
