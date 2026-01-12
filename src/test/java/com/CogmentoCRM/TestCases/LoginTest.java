package com.CogmentoCRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.CogmentoCRM.base.baseTest;
import com.CogmentoCRM.page.LoginPage;
import com.CogmentoCRM.utills.constants;

public class LoginTest extends baseTest {
	
	
	LoginPage lp;
	
	@Test
	public void loginTestCase()
	{
		lp = new LoginPage(driver);
		Assert.assertEquals(lp.loginPageTitleValidation(),"Free CRM","page title is not matching");
		lp.loginCredentials(constants.username, constants.password);
		log.info("Logged in successfully");
	}
}
