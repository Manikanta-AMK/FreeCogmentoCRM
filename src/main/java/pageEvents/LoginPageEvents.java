package pageEvents;


import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.baseTest;
import pageElements.LoginPageElements;
import utills.constants;
import utills.elementFetch;

public class LoginPageEvents {

	elementFetch ele = new elementFetch();
	public void verifyIfPageIsLoaded()
	{
		Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.Loginbutton).size()>0, "Element is not found");
	}
	
	public void enterCredentials()
	{
		WebDriverWait wait = new WebDriverWait(baseTest.driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.textToBePresentInElementLocated(constants.username,"Login"));
		ele.getWebElement("XPATH", LoginPageElements.email).sendKeys(constants.username);
		ele.getWebElement("XPATH",LoginPageElements.password).sendKeys(constants.password);
		ele.getWebElement("XPATH", LoginPageElements.Loginbutton).click();
	}
	
}
