package tedu;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class TestSelectDropDown {
	WebDriver driver;
  /*
   *    byvalue --通过value属性值选择
   * 	byindex --通过编号选项
   * 	byvisibletext --通过文本选择	
   */
  @Test
  public void f() {
	  driver.get("file:///C:/example/select.html");
	  WebElement wel = driver.findElement(By.id("menus_navlist"));
	  Utils.selectDropDown(wel, "byvisibletext", "用户评论");
	  //输入1选择第2个选择
	  Utils.selectDropDown(wel, "byindex", "1");
	  Utils.selectDropDown(wel, "byvalue", "shop_config");
	  Utils.sleep(3000);
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
