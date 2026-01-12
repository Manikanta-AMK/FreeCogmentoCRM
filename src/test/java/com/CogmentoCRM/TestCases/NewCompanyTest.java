package com.CogmentoCRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CogmentoCRM.base.baseTest;
import com.CogmentoCRM.page.newCompanyDetailspageElements;
import com.CogmentoCRM.pageEvents.CompaniesPageEvents;
import com.CogmentoCRM.pageEvents.HomePageEvents;
import com.CogmentoCRM.pageEvents.LoginPageEvents;
import com.CogmentoCRM.pageEvents.newCompanyDetailsPageEvents;
import com.CogmentoCRM.utills.constants;
import com.CogmentoCRM.utills.elementFetch;
import com.CogmentoCRM.utills.excelutills;

public class NewCompanyTest extends baseTest {

	elementFetch ele = new elementFetch();
	LoginPageEvents loginpageevents = new LoginPageEvents();
	HomePageEvents homepageevents = new HomePageEvents();
	LoginTest logintest = new LoginTest();
	HomePageTest hompepagetest = new HomePageTest();
	CompaniesPageEvents companiespageevent = new CompaniesPageEvents();
	excelutills excelutils = new excelutills();
	newCompanyDetailsPageEvents newcompanypageevents = new newCompanyDetailsPageEvents();
	
	@Test(dataProvider="newCompaniesDetails")
	public void addNewCompany(String name, String website, String city, String phoneNumber, String industry, String noofemployees) throws Throwable
	{
		hompepagetest.HomepageTest();
		homepageevents.companies();
		System.out.println("clicked on companies link");
		Assert.assertTrue(companiespageevent.companiesTextIsDisplayed(),"Companies text is not visible");
		companiespageevent.clickCreateButton();
		Assert.assertTrue(companiespageevent.CreatenewCompanyTextIsDisplayed(),"Create New Company text is not displayed");
		companiespageevent.enterName(name);
		log.info("company name eneterd");
		companiespageevent.enterWebsite(website);
		log.info("website link eneterd");
		companiespageevent.enterCity(city);
		log.info("city name eneterd");
		companiespageevent.enterPhoneNumber(phoneNumber);
		log.info("phone number eneterd");
		companiespageevent.enterIndustry(industry);
		log.info("industry name eneterd");
		companiespageevent.enterNumbeOfEmployees(noofemployees);
		log.info("employers number eneterd");
		companiespageevent.clickSaveButton();
		log.info("clicked on save button");
		Thread.sleep(5000);
		//Assert.assertEquals(newcompanypageevents.newCompanyDetails(), newcompanypageevents.validateCompanyNames(), "company name is not matching");
//		log.info("company name is matched");
	}

	@DataProvider(name="newCompaniesDetails")
	public Object[][] getdata() throws Throwable
	{
		int rc = excelutills.getrowcount(constants.excelPath, "NewCompanyDetails");
	    int cc = excelutills.getcellcount(constants.excelPath, "NewCompanyDetails", 1);
	    
	    Object[][] newCompaniesDetails = new Object[rc][cc];
	    
	    for(int i=1;i<=rc;i++)
	    {
	    	for(int j=0;j<cc;j++)
	    	{
	    		newCompaniesDetails[i-1][j] = excelutills.getDataFromExcel(constants.excelPath, "NewCompanyDetails", i, j);
	    	}
	    	
	    }
		return newCompaniesDetails;
	}
	
	

}
