package com.CogmentoCRM.utills;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.CogmentoCRM.base.baseTest;

public class elementFetch {

	public WebElement getWebElement(String IdentifierType, String IdentifierValue)
	{
		switch(IdentifierType)
		{
		case "XPATH":
			return baseTest.driver.findElement(By.xpath(IdentifierValue));
		case "CSS":
		    return baseTest.driver.findElement(By.cssSelector(IdentifierValue));
		case "ID":
			return baseTest.driver.findElement(By.id(IdentifierValue));
		case "NAME":	
			return baseTest.driver.findElement(By.name(IdentifierValue));
		case "LINKTEXT":	
			return baseTest.driver.findElement(By.linkText(IdentifierValue));
		case "PARTIALLINKTEXT":
			return baseTest.driver.findElement(By.partialLinkText(IdentifierValue));
		case "CLASSNAME":
			return baseTest.driver.findElement(By.className(IdentifierValue));
		default :
			return null;
		}
	}
	
	public List<WebElement> getWebElements(String IdentifierType, String IdentifierValue)
	{
		switch(IdentifierType)
		{
		case "XPATH":
			return baseTest.driver.findElements(By.xpath(IdentifierValue));
		case "CSS":
		    return baseTest.driver.findElements(By.cssSelector(IdentifierValue));
		case "ID":
			return baseTest.driver.findElements(By.id(IdentifierValue));
		case "NAME":	
			return baseTest.driver.findElements(By.name(IdentifierValue));
		case "LINKTEXT":	
			return baseTest.driver.findElements(By.linkText(IdentifierValue));
		case "PARTIALLINKTEXT":
			return baseTest.driver.findElements(By.partialLinkText(IdentifierValue));
		case "CLASSNAME":
			return baseTest.driver.findElements(By.className(IdentifierValue));
		default :
			return null;
		}
	}
}
