package tedu;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestElementPresent {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("file:///C:/example/link.html");
	  driver.findElement(By.linkText("链接到id.html")).click();
	  Utils.assertElementPresent(By.id("username"));
	  Utils.assertElementNotPresent(By.linkText("链接到id.html"));
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
