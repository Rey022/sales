package com.qa.salesforce.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public Base() {
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\reshm\\Google Drive\\Reshma\\Read Write\\Workspace\\SalesforceTest\\src\\main\\java\\com\\qa\\salesforce\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void initialization() {
	   String browserName=prop.getProperty("Browser");
	   if(browserName.equals("chrome")) {
		    String ChromeDriverPath = "C:\\Users\\reshm\\Downloads\\selinium\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
			driver = new ChromeDriver();
	   }else {
		   System.out.println("d");
	   }
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.get(prop.getProperty("Url"));
		   
	}
	
    
	
    }


