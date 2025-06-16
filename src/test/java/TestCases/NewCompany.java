package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import base.baseTest;
import pageEvents.CompaniesPageEvents;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utills.constants;
import utills.elementFetch;
import utills.excelutills;

public class NewCompany extends baseTest {

	elementFetch ele = new elementFetch();
	LoginPageEvents loginpageevents = new LoginPageEvents();
	HomePageEvents homepageevents = new HomePageEvents();
	LoginTest logintest = new LoginTest();
	HomePageTest hompepagetest = new HomePageTest();
	CompaniesPageEvents companiespageevent = new CompaniesPageEvents();
	excelutills excelutils = new excelutills();
	
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
		companiespageevent.enterWebsite(website);
		companiespageevent.enterCity(city);
		companiespageevent.enterPhoneNumber(phoneNumber);
		companiespageevent.enterIndustry(industry);
		companiespageevent.enterNumbeOfEmployees(noofemployees);
		companiespageevent.clickSaveButton();
		Thread.sleep(5000);
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
