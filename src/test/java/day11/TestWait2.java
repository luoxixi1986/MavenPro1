package day11;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestWait2 {
	WebDriver driver;
  @Test
  public void f() throws Exception {
		 //打开ECShop前台首页
		 driver.get("file:///C:/example/Wait.html");
		 //点击搜索
		 driver.findElement(By.id("b")).click();
		 //获得搜索结果输出
		 //等待5秒,线程等待(固定等待)
		 Thread.sleep(5000);
		 System.out.println(driver.findElement(By.id("result")).getText());
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
