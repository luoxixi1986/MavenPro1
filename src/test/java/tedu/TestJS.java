package tedu;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class TestJS {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("file:///C:/example/id.html");
	  //获取返回当前页面标题
	  String js1 = "return document.title;";
	  //调用Utils类中的executeJS方法传递参数
	  String t1 = (String)Utils.executeJS(js1);
	  //获取结果和预期结果对比
	  assertEquals(t1,"id定位");
	  String js2 = "arguments[0].setAttribute(arguments[1],arguments[2]);";
	  WebElement we1 = driver.findElement(By.id("username"));
	  //察看是否即可见有可以用
	  if (Utils.getElementStatus(we1)) {
		  Utils.sleep(3000);
		  Utils.executeJS(js2, we1,"value","123456");
	  }
	  Utils.sleep(15000);
	  
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
