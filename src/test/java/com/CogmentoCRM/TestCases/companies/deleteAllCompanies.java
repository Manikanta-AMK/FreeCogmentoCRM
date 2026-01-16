package com.CogmentoCRM.TestCases.companies;

import org.openqa.selenium.WebElement;
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
		
		while(!cp.getRightChevronIcon().getAttribute("class").contains("disabled"))
		{
			log.info("rightChevronIcon is enabled");
			clb = new commonlib();
			clb.moveToElement(driver, cp.getRightChevronIcon());
			log.info("mouse moved");
			if(!cp.selectDeleteCheckBox().isSelected())
			{
				log.info("Delete check box is not selected");
				cp.selectDeleteCheckBox();
				log.info("Delete check box is selected");
			}else {
				log.info("Delete check box is already selected so unselected");
				cp.selectDeleteCheckBox();
				cp.selectDeleteCheckBox();
				log.info("Delete check box is selected");
			}
				WebElement next = cp.getRightChevronIcon();
				next.click();
				log.info("rightChevronIcon clicked");
				
				Thread.sleep(2000);
				
				if(cp.getRightChevronIcon().getAttribute("class").contains("disabled"))
				{
					cp.selectDeleteCheckBox();
					cp.selectDeleteCheckBox();
				}
			
		}
		cp.clickActionsDropdown();
		log.info("clicked on Actions Dropddown");
		Thread.sleep(1000);
		cp.selectDeleteOptionFromActionsDropdown();
		log.info("delete option selected");
		Thread.sleep(1000);
		cp.clickOnCheckMarkIcon();
		log.info("clicked on mark icon");
		cp.clickOnYesButton();
		log.info("clicked on yes button");
		
		
		
	}
	
	
}
