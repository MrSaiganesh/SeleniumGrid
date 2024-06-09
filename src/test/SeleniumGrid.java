package test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException; 
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGrid {
	WebDriver driver;
	 String baseUrl, nodeURL; 
	 
	 @Parameters("browser")
	 @BeforeTest 
	 public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
	 nodeURL = "http://192.168.101.1:4444"; 
	 
	 DesiredCapabilities capability = new DesiredCapabilities();
	 capability.setBrowserName(browser);
	 capability.setPlatform(Platform.WIN10);
	 driver = new RemoteWebDriver(new URL(nodeURL), capability); 
	} 
	@AfterTest 
	public void afterTest() {
	 driver.quit(); 
	 }
	
	 @Parameters("browser")
	@Test
	public void simpleTest(@Optional("chrome") String browser) throws InterruptedException { 
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().window().maximize();
	Thread.sleep(10000);
	System.out.println(driver.getTitle()+":"+browser);
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Saiganesh1a");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("S72US1");
	driver.findElement(By.xpath("//input[@id='login']")).click();
//	 Assert.assertEquals("Welcome: Adactin", driver.getTitle());
	 } 
	} 
