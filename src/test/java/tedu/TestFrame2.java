package tedu;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestFrame2 {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("file:///C:/example/main1.html");
	  Utils.switchFrame("f1");
	  Utils.inputValue(driver.findElement(By.id("input1")),"123456");
	  Utils.switchFrame("f2");
	  Utils.inputValue(driver.findElement(By.id("input2")),"654321");
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
