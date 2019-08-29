package com.qa.salesforce.util;

import java.util.Iterator;
import java.util.Set;

import com.qa.salesforce.base.Base;

public class Util extends Base{
	public static void switchChildWindow()
    {
    	Set<String> ids=driver.getWindowHandles();
		Iterator <String> it=ids.iterator();
		String parentID= it.next();
		String childID=it.next();
		driver.switchTo().window(childID);
		//https://docs.google.com/forms/d/e/1FAIpQLSdXsewlLwj_KzmShOzZKUInjpWLr_yCFagkZATGToEAlo_gaA/viewform
		
    }

}
