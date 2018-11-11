package tedu;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestChecked {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("file:///C:/example/check.html");
	  WebElement chk1 = driver.findElement(By.id("m1"));
	  Utils.assertChecked(chk1);
	  Utils.sleep(2000);
	  WebElement chk2 = driver.findElement(By.id("m2"));
	  Utils.assertNotChecked(chk2);
	  Utils.sleep(2000);
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = Utils.openBrowser("firefox");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
