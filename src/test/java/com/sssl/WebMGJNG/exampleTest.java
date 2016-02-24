package com.sssl.WebMGJNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

public class exampleTest {
	
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void searchTest() {
	driver.get(baseUrl);
	driver.findElement(By.id("lst-ib")).clear();
	driver.findElement(By.id("lst-ib")).sendKeys("marcus catt andover");
	driver.findElement(By.name("btnG")).click();
	System.out.println(driver.getTitle());
	assertEquals("Google", driver.getTitle());
	assertEquals("Marcus Roland Catt - Andover SP10 - full address - 192.com", 
	  driver.findElement(By.linkText("Marcus Roland Catt - Andover SP10 - full address - 192.com")).getText());
	System.out.println("searchTest Complete");    
  }
  @BeforeTest
  public void setUp() {
	System.out.println("Starting up before Tests");
	driver = new FirefoxDriver();
	baseUrl = "https://www.google.co.uk/";
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @AfterTest
  public void tearDown() {
    System.out.println("Stopping After Tests");
	driver.quit();
	String verificationErrorString = verificationErrors.toString();
	if (!"".equals(verificationErrorString)) {
	  fail(verificationErrorString);
	}
  }
	

  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
  }

  private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
  }

  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
  }

} // end class
