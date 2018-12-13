package com.ibm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	
	By logOutLoc = By.xpath("//a[@title='Logout']");
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(linkText="Logout")
	WebElement logOutEle;
	
	public AdminPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver,this);
	}
	
	public String getCurrentTitle() {
		wait.until(ExpectedConditions.presenceOfElementLocated(logOutLoc));
		String actualTitle = driver.getTitle();
		return actualTitle;
	}
	
	public void clickOnLogOut()
	{
		logOutEle.click();
	}	

}
