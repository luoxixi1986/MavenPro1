package day09;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Test37 {
	WebDriver driver;
	//在 @Test注解添加dataProvider参数，指定你要使用的数据源，可用从注解中获取，如果注解没有写，默认获取方法名称
  @Test(dataProvider = "dp1")
  //变量的个数要和我前面所准备的二维数组中第一维元素个数相同，数据类型相同
  //形参类型要一致
  //字符串变量kw、count
  //直接写入数据是常量
  //接受参数,就是方法的参数，按顺序获取，形参变量名可用自己定义
  public void f(String kw, String count) {
	//打开前台首页
	driver.get("http://localhost//ecshop/upload/index.php");
	//输入关键字：私有变量kw的值
	driver.findElement(By.id("keyword")).sendKeys(kw);
	//点击”搜索“
	driver.findElement(By.name("imageField")).click();
	//断言统计个数是：私有变量count的值
	String c = driver.findElement(By.tagName("b")).getText();
	assertEquals(c,count);
  }


  @BeforeMethod
  public void beforeMethod() {
	FirefoxProfile profile = new FirefoxProfile();
	profile.setPreference("dom.ipc.plugins.enabled", false);
	driver = new FirefoxDriver(profile);
	//浏览器最大化
	driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  //第一种方式参数化
  //@DataProvider注解，设定这个数据源名称为dp1
  //把我们的测试数据封装好
  //如果不设定数据源名称也可以，默认使用dp1()方法名称，当做你的数据源名称
  @DataProvider(name="dp1")
  //一定要返回一个object二维数组
  public Object[][] dp1() throws IOException {
	  //必须返回一个二维数组
    return new Object[][] {
      //两个一维数组，游览器执行三次
      //每一行输入一组测试数据
      new Object[] { "a", "4" },
      new Object[] { "b", "1" },
      new Object[] { "c", "24" }
    };
//	  return ReadExcelJXL.getTestData("E:\\Selenium",
//			  "测试数据.xls", "搜索");
  }
//第二种方式参数化
//  @DataProvider
//  public Object[][] dp2() {
//	  //return有返回值得括号需要加分号
//    return new Object[][] {
//      new Object[] { "a", "4" },
//      new Object[] { "b", "1" },
//      new Object[] { "c", "24" }
//    };
//  }

}
