package com.CogmentoCRM.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class deleteCompanys {

	@FindBy(xpath="//input[@type=\"checkbox\"]") WebElement deleteChkbx;
	@FindBy(xpath="//i[@class=\"right chevron icon\"]") WebElement nextArrowIcon;
	@FindBy(xpath="//div[@class=\"item\"]//div[@name=\"action\"]") WebElement actionsDropdown;
	@FindBy(xpath="//div[@class=\"item\"]//div[@name=\"action\"]//i//following-sibling::div//span[text()='Delete']") WebElement deleteoption;
	@FindBy(xpath="//div[@class=\"item\"]//div[@name=\"action\"]//following-sibling::div[@class=\"ui basic icon left attached button\"]") WebElement checkmarkIcon;
	
	public WebElement selectDeleteCheckBox()
	{
		return deleteChkbx;
	}
	
	public WebElement clickNextArrowIcon()
	{
		return nextArrowIcon;
	}
	
	public void clickActionsDropdown()
	{
		actionsDropdown.click();
	}
	
	public WebElement selectOptionFromDropdown()
	{
		return deleteoption;
	}
	
	public void clickOnCheckMarkIcon()
	{
		checkmarkIcon.click();
	}
	
}
