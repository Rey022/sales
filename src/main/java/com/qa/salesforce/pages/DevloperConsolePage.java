package com.qa.salesforce.pages;

import com.qa.salesforce.base.Base;

public class DevloperConsolePage extends Base{
	public String ValidateTitle() {
		return driver.getTitle();
	}

}
