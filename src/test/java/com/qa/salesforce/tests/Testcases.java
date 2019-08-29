package com.qa.salesforce.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.salesforce.base.Base;
import com.qa.salesforce.pages.AccountPage;
import com.qa.salesforce.pages.DevloperConsolePage;
import com.qa.salesforce.pages.HomePage;
import com.qa.salesforce.pages.LoginPage;
import com.qa.salesforce.util.Util;

public class Testcases extends Base {
    LoginPage loginpage;
    HomePage homepage;
    DevloperConsolePage DevConsolePage;
    AccountPage Accounts;
    Util util;
    public Testcases() {
    	super();
    }
    @BeforeMethod
    public void setup() {
    	initialization();
    	util= new Util();
    	loginpage=new LoginPage();
    	homepage=new HomePage();
    }
    @Test(priority=1)
    public void loginTestcase() {
    	loginpage.ValidateLogin(prop.getProperty("Username"), prop.getProperty("Password"));
    }
   
    @Test(priority=2)
    public void WrongPasswd() {
    	loginpage.ValidateLogin(prop.getProperty("Username"), prop.getProperty("WrongPassword"));
    	String actual=loginpage.Validateerrormsg();
    	String expected="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
    	Assert.assertEquals(actual, expected);
    }
    @Test(priority=3)
    public void Wronguser() {
    	loginpage.ValidateLogin(prop.getProperty("WrongUsername"), prop.getProperty("Password"));
    	String actual=loginpage.Validateerrormsg();
    	String expected="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
    	Assert.assertEquals(actual, expected);
    	 }
    @Test(priority=4)
    public void CreateViewTest() {
    	loginpage.ValidateLogin(prop.getProperty("Username"), prop.getProperty("Password"));
    	homepage.AccountsTab();
    	Accounts.CreateNewView();
    	
    }
    @Test(priority=5)
    public void DevConsoleTest() throws InterruptedException {
    	loginpage.ValidateLogin(prop.getProperty("Username"), prop.getProperty("Password"));
    	homepage.ValidateDevConsole();
    	util.switchChildWindow();
    	String actual=DevConsolePage.ValidateTitle();
    	String expected="Developer Console";
    	Assert.assertEquals(actual, expected);
    }
    @AfterMethod
    public void TearDown() {
    	driver.quit();
    }
}
