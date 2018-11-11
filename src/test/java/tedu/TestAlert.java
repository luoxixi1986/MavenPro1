package tedu;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestAlert {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("file:///C:/example/alert.html");
	  //打开网页没有弹框
	  Utils.assertAlertNotPresent();
	  //点完按钮后有弹框
	  driver.findElement(By.id("a1")).click();
	  Utils.assertAlertPresent();
	  Utils.sleep(1000);
	  Utils.assertAlertText("Welcome!");
	  Utils.sleep(3000);
  }
  
  @Test
  public void f1() {
	  driver.get("file:///C:/example/alert.html");
	  driver.findElement(By.id("c1")).click();
	  Utils.assertAlertTextAndDismiss("Press a button");
	  Utils.sleep(3000);
  }
  
  @Test
  public void f2() {
	  driver.get("file:///C:/example/alert.html");
	  driver.findElement(By.id("a1")).click();
	  Utils.sleep(1000);
	  Utils.assertAlertContainsText("Wel","come","!");
	  Utils.sleep(1000);
  }
  
  @Test
  public void f3() {
	  driver.get("file:///C:/example/alert.html");
	  driver.findElement(By.id("c1")).click();
	  Utils.sleep(1000);
	  Utils.assertAlertContainsTextAndDismiss("Press","Press");
	  Utils.sleep(2000);
  }
  
  @Test
  public void f4() {
	  driver.get("http://localhost/ecshop/upload/user.php");
	  driver.findElement(By.name("submit")).click();
	  Utils.sleep(2000);
	  Utils.assertAlertContainsText("用户名不能为空","登录密码不能为空");
	  
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
