package tedu;

import org.testng.annotations.Test;

import utils.Utils;
import utils.log;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestScreenShotID {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("file:///C:/example/id.html");
	  try {
	  driver.findElement(By.id("abcdef")).click();
	  }catch(Exception e) {
		  e.printStackTrace();
		  log.error(e.getMessage());
		  //截图必须要有测试用例类名
		  String sTestCaseName=this.getClass().getName();
		  //获取类名作为参数传递给Utils类中的takeScreenshot方法的参数
		  Utils.takeScreenshot(sTestCaseName);
	  }
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
