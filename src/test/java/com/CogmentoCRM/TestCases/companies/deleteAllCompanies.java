package com.CogmentoCRM.TestCases.companies;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.CogmentoCRM.TestCases.HomePageTest;
import com.CogmentoCRM.base.baseTest;
import com.CogmentoCRM.page.CompaniesPage;
import com.CogmentoCRM.page.HomePage;
import com.CogmentoCRM.page.LoginPage;
import com.CogmentoCRM.utills.commonlib;
import com.CogmentoCRM.utills.constants;

public class deleteAllCompanies extends baseTest {

	LoginPage loginpage;
	HomePage hp;
	CompaniesPage cp;
	commonlib clb;
	
	@Test
	public void deleteAllCompaniesDetails() throws Throwable
	{
		loginpage = new LoginPage(driver);
		loginpage.loginCredentials(constants.username, constants.password);
		hp = new HomePage(driver);
		Assert.assertEquals(baseTest.driver.getTitle(), "Free CRM", "title is not matching");
		log.info(driver.getTitle()+" -page Title is matching");
		Assert.assertEquals(hp.validateAccountHolder(), constants.accountName,"account name is not matching");
		log.info("Logged into the correct account");
		hp.clickOnCompaniesLink();
		log.info("landed on companies page");
		cp = new CompaniesPage(driver);
		while(cp.clickOnrightChevronIcon().isEnabled())
		{
			log.info("rightChevronIcon is enabled");
			clb = new commonlib();
			clb.moveToElementAndClick(driver, cp.clickOnrightChevronIcon());
			log.info("mouse moved");
			if(!cp.selectDeleteCheckBox().isSelected())
			{
				log.info("Delete check box is not selected");
				cp.selectDeleteCheckBox();
				log.info("Delete check box is selected");
			}
			
			cp.clickOnrightChevronIcon().click();
			log.info("rightChevronIcon clicked");
		}
		cp.clickActionsDropdown();
		cp.selectDeleteOptionFromActionsDropdown();
		cp.clickOnCheckMarkIcon();
		
		
		
	}
	
	
}
