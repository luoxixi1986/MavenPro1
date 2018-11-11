package tedu;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class TestVlalue {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("file:///C:/example/id.html");
	  WebElement un = driver.findElement(By.id("username"));
	  Utils.inputValue(un, "123");
	  Utils.assertValue(un, "123");	   
}
  @Test
  public void f1() {	  
	  driver.get("file:///C:/example/xpath.html");
	  WebElement c = driver.findElement(By.id("txt1"));
	  Utils.assertContainsValue(c, "Hello","!"); 
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
