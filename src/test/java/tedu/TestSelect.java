package tedu;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class TestSelect {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("file:///C:/example/select.html");
	  WebElement n1 = driver.findElement(By.id("menus_navlist"));
	  //编号为1是第二个选项，从0开始选择
	  //选择第2,4,5个文本
	  Utils.selectDropDown(n1, "byindex", "1");
	  Utils.selectDropDown(n1, "byindex", "3");
	  Utils.selectDropDown(n1, "byindex", "4");
	  Utils.sleep(2000);  
	  //断言当前被选中的下拉框选项中包含会员列表和订单
	  //断言用的是包含的，可用选择整个文本或半个文本
	  Utils.assertSelectedContains(n1, "会员","订单");
	  //断言列表框所有选项的个数是5
	  Utils.assertOptionsCount(n1, 5);
	  //断言列表框被选中的选项个数是3
	  Utils.assertSelectedOptionsCount(n1, 3);
  }
  
  @Test
  public void f1() {
	  driver.get("file:///C:/example/select.html");
	  WebElement n1 = driver.findElement(By.id("menus_navlist"));
	  //断言列表框可用多选
	  Utils.assertMultiple(n1);
	  Utils.sleep(2000);  
	  WebElement b = driver.findElement(By.id("brand"));
	  //断言品牌下拉框不可可用多选
	  Utils.assertNotMultiple(b);
	  
	  //断言当前默认选项是否等于所有品牌
	  Utils.assertSelectedOption(b, "所有品牌");
	  //断言所有选项中包含联想和三星,可用有多个预期结果
	  Utils.assertOptionsContains(b, "联想","三星");
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
