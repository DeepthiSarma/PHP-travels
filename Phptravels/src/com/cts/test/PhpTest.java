package com.cts.test;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cts.base.LaunchWebDriver;


public class PhpTest extends LaunchWebDriver {
@Test
public  void phptravelTest() throws InterruptedException
{
	driver.findElement(By.xpath("//a[@class='btn btn-primary btn-sm btn-wide mt-20 btn-block']")).click();
//	WebDriverWait wait = new WebDriverWait(driver, 30);
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Read More'])[7]")));
	driver.findElement(By.xpath("(//a[text()='Read More'])[7]")).click();
	driver.findElement(By.name("name")).sendKeys("deepthi");
	driver.findElement(By.name("phone")).sendKeys("9877676810");
	driver.findElement(By.name("message")).sendKeys("summer vacation");
	driver.findElement(By.xpath("//input[@class='btn btn-success btn-success btn-block btn-lg']")).click();
	String text = driver.findElement(By.xpath("//div[text()='Thanks For Contacting']")).getText();
	System.out.println(text);
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).pause(1000).build().perform();
	Thread.sleep(2000);
	
	Date date= new Date();
	String dateStr=date.toString().replace(":","-");
			
	TakesScreenshot ts = (TakesScreenshot) driver;
	File file = ts.getScreenshotAs(OutputType.FILE);
	file.renameTo(new File("resources/screenshot/img"+dateStr+".png"));
	
	Assert.assertEquals(text, "Thanks For Contacting");
}
}
