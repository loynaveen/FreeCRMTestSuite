package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(), 'Log In')]")
	WebElement enterLoginPageButton;

	@FindBy(name = "email")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement loginButton;

	@FindBy(xpath = "//div[contains(text(),'SignUp')]")
	WebElement signUpButton;

	@FindBy(xpath = "//div[contains(@class, 'rd-navbar-brand')]")
	WebElement crmLogo;

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public Boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String username, String passWord) {
		enterLoginPageButton.click();
		userName.sendKeys(username);
		password.sendKeys(passWord);
		loginButton.click();
		return new HomePage();
	}

}
