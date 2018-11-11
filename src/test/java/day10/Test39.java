package day10;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.*;

import day09.ReadExcelPOI;

public class Test39 {
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void f(String keyword, String category, String brand1, 
		  String minPrice, String maxPrice, String external,
		  String launchDate, String color, String expCount)
  		  throws InterruptedException {
	  driver.get("http://localhost/ws/ecshop/upload/index.php");
	  driver.findElement(By.linkText("高级搜索")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("keywords")).sendKeys(keyword);
	  new Select(driver.findElement(By.id("select")))
	  	.selectByVisibleText(category);
	  new Select(driver.findElement(By.id("brand")))
	  	.selectByVisibleText(brand1);
	  driver.findElement(By.id("min_price")).sendKeys(minPrice);
	  driver.findElement(By.id("max_price")).sendKeys(maxPrice);
	  new Select(driver.findElement(By.name("goods_type")))
	  	.selectByVisibleText(external);
	  if (external.equals("精品手机")) {
		  new Select(driver.findElement(By.name("attr[172]")))
		  	.selectByVisibleText(launchDate);
		  new Select(driver.findElement(By.name("attr[185]")))
		  	.selectByVisibleText(color);
	  }
	  driver.findElement(By.name("Submit")).click();
	  Thread.sleep(3000);
	  assertEquals(expCount,driver.findElement(By.xpath(
			  ".//*[@id='pager']/span/b")).getText());
  }

  @BeforeTest
  public void beforeMethod() {
	FirefoxProfile profile = new FirefoxProfile();
	profile.setPreference("dom.ipc.plugins.enabled", false);
	driver = new FirefoxDriver(profile);
  }

  @AfterTest
  public void afterMethod() {
	  driver.quit();
  }
  
  @DataProvider
  public Object[][] dp() throws IOException {
	  return ReadExcelPOI.getTestData("E:\\Selenium", "ECShopAdvancedSearch.xls", "testSearch");
  }

}
