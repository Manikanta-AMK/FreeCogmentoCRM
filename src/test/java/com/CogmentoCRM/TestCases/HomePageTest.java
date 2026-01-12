package com.CogmentoCRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.CogmentoCRM.base.baseTest;
import com.CogmentoCRM.page.HomePage;
import com.CogmentoCRM.page.LoginPage;
import com.CogmentoCRM.utills.commonlib;
import com.CogmentoCRM.utills.constants;

public class HomePageTest extends baseTest {

	LoginPage loginpage;
	HomePage hp;

	@Test
	public void HomepageTest() throws Throwable {
		loginpage = new LoginPage(driver);
		loginpage.loginCredentials(constants.username, constants.password);
		hp = new HomePage(driver);
		Assert.assertEquals(baseTest.driver.getTitle(), "Free CRM", "title is not matching");
		log.info(driver.getTitle()+" -page Title is matching");
		Assert.assertEquals(hp.validateAccountHolder(), constants.accountName,"account name is not matching");
		log.info("Logged into the correct account");
		commonlib.screenShots("usernameVerification");
		hp.verifyLogo();
		commonlib.screenShots("logoVerification");
		log.info("Logo is validated");
		hp.clickOnCalanderLink();
		commonlib.screenShots("calander");
		hp.clickOnContactsLink();
		commonlib.screenShots("contacts");
		hp.clickOnCompaniesLink();
		commonlib.screenShots("companies");
		hp.clickOnDealsLink();
		commonlib.screenShots("deals");
		hp.clickOnTasksLink();
		commonlib.screenShots("tasks");
		hp.clickOnCasesLink();
		commonlib.screenShots("cases");
		hp.clickOnCallsLink();
		commonlib.screenShots("calls");
		hp.clickOnDocumentsLink();
		commonlib.screenShots("documents");
		//	commonlib.mousehover(baseTest.driver, hp.homeicon());
		log.info("Mousehover to the home icon");
		commonlib.screenShots("homePage");
		
		

	}


}
