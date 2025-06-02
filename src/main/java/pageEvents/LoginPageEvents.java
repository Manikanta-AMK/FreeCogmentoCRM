package pageEvents;


import org.testng.Assert;

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
		ele.getWebElement("XPATH", LoginPageElements.email).sendKeys(constants.username);
		ele.getWebElement("XPATH",LoginPageElements.password).sendKeys(constants.password);
		ele.getWebElement("XPATH", LoginPageElements.Loginbutton).click();
	}
	
}
