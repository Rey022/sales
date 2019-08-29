package com.qa.salesforce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.salesforce.base.Base;

public class LoginPage extends Base{
	

	@FindBy(id="username")
	WebElement Username;
	@FindBy(id="password")
	WebElement Password;
	@FindBy(id="Login")
	WebElement LoginBtn;
	@FindBy(id="rememberUn")
	WebElement remMe;
	@FindBy(id="error")
	WebElement Error;
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public HomePage ValidateLogin(String UN,String PWD) {
		Username.sendKeys(UN);
		Password.sendKeys(PWD);
		LoginBtn.click();
		return new HomePage();
		
	}
	
	public void RememberMe() {
		if(remMe.isSelected()) {
			
			
		}else {
			remMe.click();
		}
		
	}
	public String ValidateUnameText() {
		 return Username.getText();
		 
	}
	public String Validateerrormsg() {
		return Error.getText();
		
	}
	
	
}

	

