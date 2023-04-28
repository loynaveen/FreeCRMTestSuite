package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//a[contains(@href, 'contacts')]//parent::div//button")
	WebElement addContact;

	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(@href, 'contacts')]//span[contains(text(), 'Contacts')]")
	WebElement contactsLabel;

	@FindBy(xpath = "//a[contains(@href, 'deals')]//span[contains(text(), 'Deals')]")
	WebElement dealsLabel;

	@FindBy(xpath = "//a[contains(@href, 'tasks')]//span[contains(text(), 'Tasks')]")
	WebElement tasksLabel;

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactPage clickOnContactsLink() {
		contactsLabel.click();
		return new ContactPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLabel.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasksLabel.click();
		return new TasksPage();
	}

	public Boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public void clickOnNewContactLink() {
		addContact.click();
	}


}
