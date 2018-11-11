package day11;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class TestWait1 {
	WebDriver driver;
  @Test
  public void f() throws Exception {
		 //打开ECShop前台首页
		 driver.get("file:///C:/example/Wait.html");
		 //点击搜索
		 driver.findElement(By.id("b")).click();
		 //获得搜索结果输出，隐士等待元素是10秒
		 System.out.println(driver.findElement(By.id("result")).getText());
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  //页面中所有元素都以他为准 
	  //1、等待定位页面元素---最常用
	  //设置隐士等待(等待定位到页面元素)超时时间是10秒
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  //2、等待网页加载：
	  driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
	  //3、等待异步脚本执行：
	  driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
