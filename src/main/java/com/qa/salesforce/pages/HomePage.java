package com.qa.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.salesforce.base.Base;

public class HomePage extends Base {
	@FindBy(xpath="//span[@id='userNavLabel']")
	WebElement UserMenu;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement Logout;
	@FindBy(xpath="//a[@class='debugLogLink menuButtonMenuLink']")
	WebElement DevConsole;
	@FindBy(xpath="//a[contains(text(),'Accounts')]")
	WebElement Accounts;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public AccountPage AccountsTab() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[contains(text(),'Accounts')]"))));
		Accounts.click();
		return new AccountPage();
	}
	public void ValidateDevConsole() throws InterruptedException {
		Thread.sleep(1000);
		UserMenu.click();
		DevConsole.click();
	}
	public void LogoutBtn() {
		Logout.click();
	}
}
