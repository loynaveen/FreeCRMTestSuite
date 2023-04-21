package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {

	public ContactPage() {
		// super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='selectable ']")
	WebElement contactsLabel;

	@FindBy(xpath = "//button[contains(@class, 'linkedin')]")
	WebElement saveContact;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@class='search'][1]")
	WebElement companyName;

	public Boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContact(String name) {
		Actions a = new Actions(driver);
		a.moveByOffset(500, 500).click().build().perform();
		a.moveToElement(driver.findElement(By.xpath("//a[contains(text(), '" + name
				+ "')]//parent::td//preceding-sibling::td//div[contains(@class, 'checkbox')]"))).click().build()
				.perform();

	}

	public void createNewContact(String ftName, String lName, String comp) {
//		Select select = new Select(driver.findElement(By.name("status")));
//		select.selectByVisibleText(status);

		firstName.sendKeys(ftName);
		lastName.sendKeys(lName);
		companyName.sendKeys(comp);
		saveContact.click();

	}

}
