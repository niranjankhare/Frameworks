package org.seleniumng.utils;

import java.util.ArrayList;
import java.util.List;

import org.seleniumng.controls.*;
import org.seleniumng.utils.PageConfigLoader;

import com.typesafe.config.Config;

public class PageObjectBaseClass {

	public PageObjectBaseClass (){
		List <Class<?>> classHeirarchy = new ArrayList<Class<?>>();
		classHeirarchy.add(this.getClass());
		Class<?> c = this.getClass().getSuperclass();
		while  (!c.isAssignableFrom(org.seleniumng.utils.PageObjectBaseClass.class) ) /*(!c.isAssignableFrom(java.lang.Object.class) )*/{
			classHeirarchy.add(c);
			c = c.getSuperclass();
		}
		Config conf = PageConfigLoader. loadPageConfig(classHeirarchy.get(classHeirarchy.size()-1));
		for (int i = classHeirarchy.size()-1; i>0; i--){
			conf = PageConfigLoader.loadPageConfig(classHeirarchy.get(i-1)).withFallback(conf);
		}
//		this.thisPageConfig = conf;
		PageConfigLoader.loadPage(this, conf);
	}
}
