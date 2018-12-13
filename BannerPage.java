package com.ibm.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BannerPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public BannerPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver,this);
	}

	
	public void addBanner() throws FileNotFoundException, IOException, InterruptedException {
		
		Properties p = new Properties();
		p.load(new FileInputStream("./TestData/magentodata.properties"));
		
		driver.findElement(By.xpath("//i[@class='ti-tag']")).click();
		driver.findElement(By.xpath("//ul[@id='side-menu']/li[2]/ul/li[2]")).click();
		driver.findElement(By.xpath("//a[@title='Add New']")).click();
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(p.getProperty("bannername"));
		driver.findElement(By.xpath("//input[@name='sort']")).clear();
		driver.findElement(By.xpath("//input[@name='sort']")).sendKeys(p.getProperty("sortorder"));
		driver.findElement(By.xpath("//select[@name='status']/option[1]")).click();
		driver.findElement(By.xpath("//input[@id='files']")).sendKeys(p.getProperty("imagepath"));
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@name='dataTableExample2_length']/option[4]")).click();
		
		String pagesource = driver.getPageSource();
		
		if(pagesource.contains(p.getProperty("bannername"))) {
			System.out.println("The presence of added banner is confirmed!");
		}
		else {
			System.out.println("The banner is not added to the Banner List");
		}
			
		
	}

}
