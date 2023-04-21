package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	ContactPage contactPage;
	HomePage homePage;

	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsLabel() {
		Assert.assertTrue(contactPage.verifyContactsLabel(), "Contacts Page not Landed");
	}

	@Test(priority = 2)
	public void selectSingleContactTest() {
		contactPage.selectContact("test2 2 test2");
	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactPage.selectContact("test2 2 test2");
		contactPage.selectContact("test test test");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String fName, String lName, String compName) {
		homePage.clickOnNewContactLink();
		contactPage.createNewContact(fName, lName, compName);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
