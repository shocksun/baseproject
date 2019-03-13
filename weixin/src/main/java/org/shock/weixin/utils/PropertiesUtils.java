package org.shock.weixin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtils {
	private static OutputStream output;
	private static InputStream input;
	private static Properties prop;
	public static void read() {
		if(prop==null) {
			try {
				prop = new Properties();
				File file = new File("src/main/resources/config.properties");
				if(file.exists()) {
					input = new FileInputStream(file);
					output = new FileOutputStream(file);
					prop.load(input);
				}else {
					output = new FileOutputStream(file);
					prop.store(output, "weixin config");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void putData(String key,Object value) {
		if(prop==null) {
			throw new NullPointerException("请先read()");
		}else {
			prop.put(key, String.valueOf(value));
			store();
		}
	}
	public static String getData(String key) {
		if(prop==null) {
			throw new NullPointerException("请先read()");
		}else {
			return getData(key, "");
		}
	}
	public static String getData(String key,String defaultValue) {
		if(prop==null) {
			throw new NullPointerException("请先read()");
		}else {
			return prop.getProperty(key,defaultValue);
		}
	}
	public static void store() {
		if(prop==null) {
			throw new NullPointerException("请先read()");
		}else {
			try {
				prop.store(output, "weixin config");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
