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
		log.info("waited untill page fully loaded");
		loginpageevents.enterCredentials();
		log.info("Loggedin successfully");
	}
}
