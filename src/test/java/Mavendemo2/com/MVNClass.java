package Mavendemo2.com;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MVNClass {
public 	WebDriver driver;
  @Test
  public void Loginwithvaliddetails() 
  {
	  System.out.println("Login with valid details");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap1");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword1");
	  driver.findElement(By.xpath("//input[@name='login']")).click(); 
  }
  @BeforeMethod
  public void getallCookie() 
  {
	  Set<Cookie>Cookies=driver.manage().getCookies();
	  for (Cookie Cookie:Cookies)
	  {
		  System.out.println("The Name of Cookie:"+ Cookie.getName());
	
	  }
	  
  }

  @AfterMethod
  public void Screenshot() throws IOException 
  {
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyToDirectory(src, new File("E:\\MEGHA\\CJC new\\Megha Eclips\\MVNdemo2\\Screenshot\\"));
	 
  }

  @BeforeClass
  public void maximizebrowser() 
  {
	  driver.manage().window().maximize();
	  System.out.println("Miximize the Browser");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("DB Connections");
  }

  @BeforeTest
  public void siteopen() {
	  driver.get("http://newtours.demoaut.com/");
	  System.out.println("site open Sucessfully");
  }

  @AfterTest
  public void deletecookies() {
	  driver.manage().deleteAllCookies();
	  System.out.println("Delete all Cookies");
  }

  @BeforeSuite
  public void openbrowser() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
       driver = new ChromeDriver();
       System.out.println("Chrome driver open Sucessfully");
  }

  @AfterSuite
  public void closebrowser() 
  {
	  driver.close();
  }

}
