package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.baseTest;
import pageEvents.CompaniesPageEvents;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import pageEvents.newCompanyDetailsPageEvents;
import utills.constants;
import utills.elementFetch;
import utills.excelutills;

public class newCompanyNameDetails2 extends baseTest{

	elementFetch ele = new elementFetch();
	LoginPageEvents loginpageevents = new LoginPageEvents();
	HomePageEvents homepageevents = new HomePageEvents();
	LoginTest logintest = new LoginTest();
	HomePageTest hompepagetest = new HomePageTest();
	CompaniesPageEvents companiespageevent = new CompaniesPageEvents();
	excelutills excelutils = new excelutills();
	newCompanyDetailsPageEvents newcompanydetailspageevents = new newCompanyDetailsPageEvents();
	NewCompany newcompany = new NewCompany();
	
	
//	@Test
//	public void newCompanyNameDetailsTest(String name, String website, String city, String phoneNumber, String industry, String noofemployees) throws Throwable
//	{
//		newcompany.addNewCompany(name, website, city, phoneNumber, industry, noofemployees);
//	
//		
//		int rc = excelutills.getrowcount(constants.excelPath, "NewCompanyDetails");
//		for(int i=1;i<=rc;i++)
//		{
//			//String newcompanyname = ele.getWebElement("XPATH", newCompanyDetailspageElements.companyName).getText();
//    		Assert.assertEquals(newcompanydetailspageevents.newCompanyDetails(), excelutils.getDataFromRow(constants.excelPath, "NewCompanyDetails", i));
//		}
//	}
	
//	
//	@DataProvider(name = "companyData")
//	public Object[][] getCompanyData() throws Throwable {
//		int rc = excelutils.getrowcount(constants.excelPath, "NewCompanyDetails");
//		Object[][] data = new Object[rc][6];
//		for (int i = 0; i < rc; i++) {
//			for (int j = 0; j < 6; j++) {
//				data[i][j] = excelutils.getDataFromExcel(constants.excelPath, "NewCompanyDetails", i + 1, j);
//			}
//		}
//		return data;
//	}
//
//	@Test(dataProvider = "companyData")
//	public void newCompanyNameDetailsTest(String name, String website, String city, String phoneNumber, String industry, String noofemployees) throws Throwable {
//		newcompany.addNewCompany(name, website, city, phoneNumber, industry, noofemployees);
//		
//		String actualCompanyName = newcompanydetailspageevents.newCompanyDetails(); // Assume this returns name
//		Assert.assertEquals(actualCompanyName, name, "company name is not  matching");
//	}
	
}
