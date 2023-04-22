package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	Logger log = Logger.getLogger(LoginPageTest.class);

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		log.info("********** STARTING LOGIN TESTS************");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM App for every business customer relationship management cloud");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		Boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("********** ENDING LOGIN TESTS************");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
