package com.CogmentoCRM.pageEvents;

import org.testng.Assert;

import com.CogmentoCRM.page.HomePageElements;
import com.CogmentoCRM.utills.elementFetch;

public class HomePageEvents {
	
	elementFetch ele = new elementFetch();
	public void verifyLogo()
	{
	    Assert.assertTrue(ele.getWebElement("XPATH", HomePageElements.crmLogo).isDisplayed());
	}
	
	public void homeicon()
	{
		ele.getWebElement("XPATH",HomePageElements.homelink).click();
	}

	public void calander()
	{
		ele.getWebElement("XPATH", HomePageElements.calanderLink).click();
	}
	
	public void contacts()
	{
		ele.getWebElement("XPATH",HomePageElements.contactsLink).click();
	}

	public void companies()
	{
		ele.getWebElement("XPATH", HomePageElements.companiesLink).click();
	}

	public void deals()
	{
	    ele.getWebElement("XPATH", HomePageElements.dealsLink).click();
	}

	public void tasks()
	{
		ele.getWebElement("XPATH", HomePageElements.tasksLink).click();
	}

	public void cases()
	{
		ele.getWebElement("XPATH", HomePageElements.casesLink).click();
	}

	public void calls()
	{
		ele.getWebElement("XPATH", HomePageElements.callsLink).click();
	}

	public void documents()
	{
		ele.getWebElement("XPATH", HomePageElements.documentsLink).click();
	}

	
}
