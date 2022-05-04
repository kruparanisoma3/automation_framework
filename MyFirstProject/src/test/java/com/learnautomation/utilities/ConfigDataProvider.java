package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;
	
	public ConfigDataProvider() {
		
		File file=new File(System.getProperty("user.dir")+"\\Configurations\\Config.properties");
		try {
			FileInputStream fis=new FileInputStream(file);
		
		prop=new Properties();
		
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("not able to load config file:"+e.getMessage());
		}
		
		
		
		
	}
	
	public String getDataFromConfig(String key) {
		return prop.getProperty(key);
		
		
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
		
	}
	
	public String getStagingURL() {
		return prop.getProperty("qaURL");
		
	}

}
