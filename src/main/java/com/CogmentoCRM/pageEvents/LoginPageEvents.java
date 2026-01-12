package com.CogmentoCRM.pageEvents;


import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.CogmentoCRM.base.baseTest;
import com.CogmentoCRM.page.LoginPageElements;
import com.CogmentoCRM.utills.constants;
import com.CogmentoCRM.utills.elementFetch;
import com.sun.tools.sjavac.Log;

public class LoginPageEvents {

	elementFetch ele = new elementFetch();
//	public void verifyIfPageIsLoaded()
//	{
//		Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.Loginbutton).size()>0, "Element is not found");
//	}
	
	public void enterCredentials()
	{
		WebDriverWait wait = new WebDriverWait(baseTest.driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.textToBePresentInElementLocated(constants.username,"Login"));
		ele.getWebElement("XPATH", LoginPageElements.email).sendKeys(constants.username);
		Log.info("entered Username");
		ele.getWebElement("XPATH",LoginPageElements.password).sendKeys(constants.password);
		Log.info("entered Password");
		ele.getWebElement("XPATH", LoginPageElements.Loginbutton).click();
		Log.info("clicked on login button");
	}
	
}
