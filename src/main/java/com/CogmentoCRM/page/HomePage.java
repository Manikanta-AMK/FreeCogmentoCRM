package com.CogmentoCRM.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CogmentoCRM.base.baseTest;

public class HomePage extends baseTest{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Manikanta A']") private WebElement accountholder;
	@FindBy(xpath="//div[@class='header item']") private WebElement crmLogo ; 
	@FindBy(xpath="//*[text()='Home']") private WebElement homeLink;
	@FindBy(xpath="//span[text()='Calendar']") private WebElement calanderLink ;
	@FindBy(xpath="//span[text()='Contacts']") private WebElement contactsLink ;
	@FindBy(xpath="//span[text()='Companies']") private WebElement  companiesLink  ;
	@FindBy(xpath="//span[text()='Deals']") private WebElement dealsLink ;
	@FindBy(xpath="//span[text()='Tasks']") private WebElement tasksLink ;
	@FindBy(xpath="//span[text()='Cases']") private WebElement casesLink ;
	@FindBy(xpath="//span[text()='Calls']") private WebElement callsLink ;
	@FindBy(xpath="//span[text()='Documents']") private WebElement documentsLink ;
	
	public String validateAccountHolder() {
		return accountholder.getText();
	}
	
	public Boolean verifyLogo() {
		return crmLogo.isDisplayed();
	}

	public void clickOnHomeLink() {
		homeLink.click();
	}

	public void clickOnCalanderLink() {
		calanderLink.click();
	}
	
	public void clickOnContactsLink() {
		contactsLink.click();
	}
	
	public void clickOnCompaniesLink() {
		companiesLink.click();
	}
	
	public void clickOnDealsLink() {
		dealsLink.click();
	}
	
	public void clickOnTasksLink() {
		tasksLink.click();
	}
	
	public void clickOnCasesLink() {
		casesLink.click();
	}
	
	public void clickOnCallsLink() {
		callsLink.click();
	}
	
	public void clickOnDocumentsLink() {
		documentsLink.click();
	}
	
}
