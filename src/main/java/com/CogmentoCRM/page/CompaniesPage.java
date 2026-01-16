package com.CogmentoCRM.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaniesPage {
	
	WebDriver driver;
	
	public CompaniesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class=\"ui header item mb5 light-black\"]//span") private WebElement companieslink;
	@FindBy(xpath= "//button[@class='ui linkedin button'])[3]") private WebElement createBtn ;
	@FindBy(xpath=" //div[@class=\"ui header item mb5 light-black\"]//span") private WebElement CreatenewCompany;
	@FindBy(xpath = "//div[@class='ui right corner labeled input']//input[@name='name']") private WebElement nameTxtBx;
	@FindBy(xpath="//input[ @name='url' and contains(@type,'text')]") private WebElement websiteTxtBx;
	@FindBy(xpath="input[placeholder='City']") private WebElement cityTxtBx;
	@FindBy(xpath="//input[@placeholder='Number']") private WebElement phoneNumberTxtBx;
	@FindBy(xpath="(//input[@autocomplete='new-password'])[3]") private WebElement industryTxtBx;
	@FindBy(xpath="//input[@autocomplete='new-password' and @name='num_employees']") private WebElement numberOfEmployeeTxtBx;
	@FindBy(xpath= "//button[@class='ui linkedin button']") private WebElement saveBtn;
	
	
	@FindBy(xpath="//thead[@class=\"full-width\"]//input[@type='checkbox']") private WebElement deleteChkbx;
	@FindBy(xpath="//i[@class=\"right chevron icon\"]") private WebElement nextArrowIcon;
	@FindBy(xpath="//div[@class=\"item\"]//div[@name=\"action\"]") private WebElement actionsDropdown;
	@FindBy(xpath="//div[@class=\"item\"]//div[@name=\"action\"]//i//following-sibling::div//span[text()='Delete']") private WebElement deleteoption;
	@FindBy(xpath="//div[@class=\"item\"]//div[@name=\"action\"]//following-sibling::div[@class=\"ui basic icon left attached button\"]") private WebElement checkmarkIcon;
//	@FindBy(xpath="//i[@class=\"right chevron icon\"]") private WebElement rightChevronIcon;
	@FindBy(xpath="//div[@class=\"ui right floated pagination menu custom-pagination\"]//a[contains(@class,\"item\")]") private List<WebElement> paginationItems;
	@FindBy(xpath="//button[text()='Yes']") private WebElement confirmationYesBtn; 
	
	public WebElement selectDeleteCheckBox()
	{
		deleteChkbx.click();
		return deleteChkbx;
	}
	
	public WebElement clickNextArrowIcon()
	{
		nextArrowIcon.click();
		return nextArrowIcon;
	}
	
	public void clickActionsDropdown()
	{
		actionsDropdown.click();
	}
	
	public WebElement selectDeleteOptionFromActionsDropdown()
	{
		deleteoption.click();
		return deleteoption;
	}
	
	public void clickOnCheckMarkIcon()
	{
		checkmarkIcon.click();
	}

//	public WebElement clickOnrightChevronIcon()
//	{
//		 return  rightChevronIcon;
//	}
	
	public WebElement clickOnYesButton()
	{
		 confirmationYesBtn.click();
		 return confirmationYesBtn;
	}
	
	public WebElement getRightChevronIcon() {
	    return paginationItems.get(paginationItems.size() - 1);
	}

	
}
