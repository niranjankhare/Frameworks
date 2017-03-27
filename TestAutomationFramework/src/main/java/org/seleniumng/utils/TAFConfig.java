package org.seleniumng.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class TAFConfig {
	private static final Config resolver = ConfigFactory.parseResourcesAnySyntax("resolver");
	public static Config tafConfig = ConfigFactory.load().withFallback(resolver).resolve();
}
