package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utills.commonlib;
import utills.elementFetch;

public class HomePageTest extends baseTest {

	elementFetch ele = new elementFetch();
	LoginPageEvents loginpageevents = new LoginPageEvents();
	HomePageEvents homepageevents = new HomePageEvents();
	LoginTest logintest = new LoginTest();

	@Test
	public void HomepageTest() throws Throwable {
		logintest.loginTestCase();
		Assert.assertEquals(baseTest.driver.getTitle(), "Cogmento CRM", "title is not matching");
		log.info("page Title is matching");
		WebElement username = baseTest.driver.findElement(By.xpath("//span[text()='Manikanta A']"));
		Assert.assertEquals(username.getText(), "Manikanta A", "username is not matched");
		log.info("Logged into the correct account");
		commonlib.screenShots("usernameVerification");
		homepageevents.verifyLogo();
		commonlib.screenShots("logoVerification");
		log.info("Logo is validated");
		homepageevents.calander();
		commonlib.screenShots("calander");
		homepageevents.contacts();
		commonlib.screenShots("contacts");
		homepageevents.companies();
		commonlib.screenShots("companies");
		homepageevents.deals();
		commonlib.screenShots("deals");
		homepageevents.tasks();
		commonlib.screenShots("tasks");
		homepageevents.cases();
		commonlib.screenShots("cases");
		homepageevents.calls();
		commonlib.screenShots("calls");
		homepageevents.documents();
		commonlib.screenShots("documents");
		//	commonlib.mousehover(baseTest.driver, homepageevents.homeicon());
		log.info("Mousehover to the home icon");
		commonlib.screenShots("homePage");
		
		

	}


}
