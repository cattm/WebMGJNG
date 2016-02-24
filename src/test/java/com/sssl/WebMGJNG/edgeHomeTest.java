package com.sssl.WebMGJNG;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class edgeHomeTest {
	
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();	
	
  @Test
  public void homeTest() {
	openHomePage();
	checkTitle();
	checkFooter();
	checkMenu();
	checkText();
	  
	  
  }
  private void openHomePage(){
		// check the title of the page 
		// maybe check a 200 code?
		driver.get(baseUrl);
		driver.findElement(By.linkText("Home")).click();
		(new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
            	return d.findElement(By.cssSelector("h1")).getText().contentEquals("Automated Tools Test Site");
            }
        });
		System.out.println("End of homePage.openHomePage Test");
  }
	

	private void checkTitle () {
	
		//String header = (driver.findElement(By.tagName("title")).getText());
		String header = (driver.findElement(By.xpath("/html/body/div[2]/div[2]/h1")).getText());
		assertEquals("Automated Tools Test Site", header);
		System.out.println("End of homePage.checkTitle Test");
	}
	
	
	private void checkFooter() {
		// check the footer text
		// //*[@id="footer"]
		String footer = (driver.findElement(By.xpath("//*[@id=\"footer\"]")).getText());
		assertEquals("©2012 Edgewords Limited", footer);
		System.out.println("End of homePage.checkFooter Test");
	}
	
	
	private void checkMenu() {
		//check there are 5 menu options
		//check the text on each one
		assertTrue(driver.findElement(By.linkText("Home")).isDisplayed());
		assertTrue(driver.findElement(By.linkText("Basic HTML")).isDisplayed());
		assertTrue(driver.findElement(By.linkText("Forms")).isDisplayed());
		assertTrue(driver.findElement(By.linkText("Dynamic Content")).isDisplayed());
		assertTrue(driver.findElement(By.linkText("CSS/XPath")).isDisplayed());
		System.out.println("End of homePage.checkMenu Test");
	}
	
	
	private void checkText() {
		// check some of the text.
		// begin/middle/end
		// font?
		System.out.println("End of homePage.checkText Test");
	}
	
  @BeforeTest
  public void beforeClass() {
	  System.out.println("Starting up before Tests");
	  driver = new FirefoxDriver();
      baseUrl = "http://www.edgewordstraining.co.uk/webdriver/docs/index.html";
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  System.out.println("End of homeTest beforeClass");
  }

  @AfterTest
  public void afterClass() {
	System.out.println("Stopping After Tests");
    driver.quit();
	String verificationErrorString = verificationErrors.toString();
	if (!"".equals(verificationErrorString)) {
	  fail(verificationErrorString);
	}
  }

}
