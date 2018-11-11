package tedu;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class TestFrame {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("file:///C:/example/main1.html");
	  Utils.switchFrameByPageSource("input1");
	  Utils.inputValue(driver.findElement(By.id("input1")),"123456");
	  //切换到默认主网页，才能在切换f2
	  //Utils.switchToDefault();
	  Utils.switchFrameByPageSource("input2");
	  Utils.inputValue(driver.findElement(By.id("input2")),"654321");
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
