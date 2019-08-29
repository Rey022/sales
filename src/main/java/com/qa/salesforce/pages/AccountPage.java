package com.qa.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.salesforce.base.Base;

public class AccountPage extends Base{

	@FindBy(xpath="//a[contains(text(),'Create New View')]")
	WebElement NewView;
	@FindBy(id="fname")
	WebElement ViewName;
	@FindBy(id="devname")
	WebElement UniqueName;
	@FindBy(xpath="//div[@class='pbHeader']//input[@name='save']")
	WebElement SaveBtn;
	public AccountPage() {
		PageFactory.initElements(driver, this);
	}
	public void CreateNewView() {
		NewView.click();
		ViewName.sendKeys("Reshma");
		UniqueName.sendKeys("Shaik");
		SaveBtn.click();
	}

	}


