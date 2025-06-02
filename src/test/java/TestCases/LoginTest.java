package TestCases;

import org.testng.annotations.Test;

import base.baseTest;
import pageElements.HomePageElements;
import pageElements.LoginPageElements;
import pageEvents.LoginPageEvents;
import utills.elementFetch;

public class LoginTest extends baseTest {

	elementFetch ele = new elementFetch();
	LoginPageEvents loginpageevents = new LoginPageEvents();
//	HomePageEvents homepageevents = new HomePageEvents();
	
	@Test
	public void loginTestCase()
	{
		loginpageevents.verifyIfPageIsLoaded();
//		logger.info("waited untill page loaded");
		loginpageevents.enterCredentials();
//		logger.info("logged in succesfully");
	}
}
