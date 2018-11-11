package day11;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class TestECShopTable {
	WebDriver driver;
  @Test
  public void f() {
	  //打开ECShop前台首页
	  driver.get("http://localhost/ecshop/upload/index.php");
	  //输入关键字A30
	  driver.findElement(By.id("keyword")).sendKeys("A30");
	  //点击搜索
	  driver.findElement(By.name("imageField")).click();
	  //点击金立A30的商品链接
	  //层级定位，搜索区域,在找准定位
	  //linkText文本链接
	  driver.findElement(By.id("compareForm")).findElement(By.linkText("金立 A30")).click();
	  //等待2秒
	  Utils.sleep(3000);
	  //点击加入购物车
	  //相对路径获取img包含元素为src，属性包含bnt_cat
	  driver.findElement(By.xpath("//img[contains(@src,'bnt_cat')]")).click();
	  Utils.sleep(2000);
	  //定位金立A30商品的购买数量文本框
	  //轴返回上一层ancestor::tr
	  WebElement num = driver.findElement(By.xpath("//*[@id='formCart']/table[1]//tr[2]/td[1]/"
	  		+ "a[contains(text(),'金立 A30')]/ancestor::tr//input"));
	  //清空操作
	  num.clear();
	  //输入3
	  num.sendKeys("3");
	  //等待2秒
	  Utils.sleep(3000);
	  //点击金立A30商品行的删除按钮
	  driver.findElement(By.xpath("//*[@id='formCart']/table[1]//tr[2]/td[1]/"
	  		+ "a[contains(text(),'金立 A30')]/ancestor::tr//a[contains(text(),'删除')]")).click();
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
