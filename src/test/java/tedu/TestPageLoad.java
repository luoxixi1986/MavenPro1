package tedu;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class TestPageLoad {
	WebDriver driver;
 
/* 
@Test
 public void f() {
	  driver.get("file:///C:/example/link.html");
	  driver.findElement(By.partialLinkText("id")).click();
	  //等待网页加载完毕
	  Utils.waitForPageLoad();
	  //页面等待30秒
	  Utils.waitForPageLoad30();
	  WebElement wel = driver.findElement(By.partialLinkText("id"));
	  Utils.clickAndWait(wel);
  }
*/
  @Test
  public void f1() {
	  driver.get("file:///C:/example/id.html");

	  WebElement wel = driver.findElement(By.id("username"));
	  Utils.inputValue(wel, "jack");
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
