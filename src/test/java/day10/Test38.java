package day10;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import day09.ReadExcelPOI;

public class Test38 {
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void f(String un, String pw) {
	  driver.get("http://localhost/ws/ecshop/upload/index.php");
	  driver.findElement(By.xpath(".//*[@id='ECS_MEMBERZONE']/a[1]/img")).click();
	  driver.findElement(By.name("username")).sendKeys(un);
	  driver.findElement(By.name("password")).sendKeys(pw);
	  driver.findElement(By.name("submit")).click();
	  driver.findElement(By.linkText("退出")).click();
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
	  return ReadExcelPOI.getTestData("E:\\Selenium", "ECShopLogin.xls", "testLogin");
  }

}
