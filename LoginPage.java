package com.ibm.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name="email")
	WebElement emailEle;
	
	@FindBy(name="pword")
	WebElement passEle;
	
	@FindBy(xpath="//span[@class='btn-label']")
	WebElement loginEle;
	
		
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterEmailAddress(String email)
	{
		emailEle.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		passEle.sendKeys(password);
	}
	
	public void clickOnLogin()
	{
		loginEle.click();
	}
	
}
