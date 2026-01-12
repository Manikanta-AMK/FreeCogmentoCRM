package com.CogmentoCRM.TestCases;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.CogmentoCRM.base.baseTest;
import com.CogmentoCRM.page.deleteCompanys;
import com.CogmentoCRM.utills.commonlib;

public class deleteCompaniesNamesTest {

	WebDriver driver;
	LoginTest logintest = new LoginTest();
	HomePageTest hompepagetest = new HomePageTest();
	NewCompanyTest newcompany = new NewCompanyTest();
	deleteCompanys deletecompanys = new deleteCompanys();
	commonlib cmlb = new commonlib();
	
	@Test
	public void deleteCompaniesNames() throws Throwable
	{
		logintest.loginTestCase();
		hompepagetest.HomepageTest();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		Iterator<WebElement> checkboxiterator = checkboxes.iterator();

		while (checkboxiterator.hasNext()) {
		    WebElement checkbox = checkboxiterator.next();
		    if (!checkbox.isSelected()) {
		        checkbox.click();
		        
		    	if(deletecompanys.clickNextArrowIcon().isDisplayed() && deletecompanys.clickNextArrowIcon().isEnabled())
				{
					deletecompanys.clickNextArrowIcon().click();
				}
		    }
		}
		deletecompanys.clickActionsDropdown();
		deletecompanys.selectOptionFromDropdown().click();
		deletecompanys.clickOnCheckMarkIcon();
	}
	
}
