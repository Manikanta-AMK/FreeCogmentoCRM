package pageEvents;


import pageElements.CompaniesPageElements;
import utills.elementFetch;

public class CompaniesPageEvents {

	elementFetch ele = new elementFetch();
	
	public boolean companiesTextIsDisplayed()
	{
		 return ele.getWebElement("XPATH", CompaniesPageElements.companieslink).isDisplayed();
	}
	
	public void clickCreateButton()
	{
		ele.getWebElement("XPATH", CompaniesPageElements.createBtn).click();
	}
	
	public boolean CreatenewCompanyTextIsDisplayed()
	{
		return ele.getWebElement("XPATH", CompaniesPageElements.CreatenewCompany).isDisplayed();
	}
	
	public void enterName(String name)
	{
		ele.getWebElement("NAME", CompaniesPageElements.nameTxtBx).sendKeys(name);
	}
	
	public void enterWebsite(String website)
	{
		ele.getWebElement("XPATH", CompaniesPageElements.websiteTxtBx).sendKeys(website);
	}
	
	public void enterCity(String city)
	{
		ele.getWebElement("NAME", CompaniesPageElements.cityTxtBx).sendKeys(city);
	}
	
	public void enterPhoneNumber(String phoneNumber)
	{
		ele.getWebElement("XPATH", CompaniesPageElements.phoneNumberTxtBx).sendKeys(phoneNumber);
	}
	
	public void enterIndustry(String industry)
	{
		ele.getWebElement("XPATH", CompaniesPageElements.industryTxtBx).sendKeys(industry);
	}
	
	public void enterNumbeOfEmployees(String numberOfEmployee)
	{
		ele.getWebElement("XPATH", CompaniesPageElements.numberOfEmployeeTxtBx).sendKeys(numberOfEmployee);
	}

	public void clickSaveButton()
	{
		ele.getWebElement("XPATH", CompaniesPageElements.saveBtn).click();
	}
	
}
