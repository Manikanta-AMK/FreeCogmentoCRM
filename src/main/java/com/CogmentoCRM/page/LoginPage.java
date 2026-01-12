package com.CogmentoCRM.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Email']") private WebElement emailTxtBx;
	@FindBy(xpath="//input[@placeholder='Password']") private WebElement passwordTxtBx;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']") private WebElement loginBtn;
	
	public void loginCredentials(String email, String password)
	{
		emailTxtBx.sendKeys(email);
		passwordTxtBx.sendKeys(password);
		loginBtn.click();
	}	
	public String loginPageTitleValidation()
	{
		String pagetitle = driver.getTitle();
		return pagetitle;
	}
	
}


