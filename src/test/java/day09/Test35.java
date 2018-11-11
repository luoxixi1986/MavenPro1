package day09;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Test35 {
	WebDriver driver;
	
  @Test
  public void testa() {
	//打开前台首页
	driver.get("http://localhost//ecshop/upload/index.php");
	//http://localhost//ecshop/upload/index.php
	//输入关键字：私有变量kw的值
	driver.findElement(By.id("keyword")).sendKeys("a");
	//点击”搜索“
	driver.findElement(By.name("imageField")).click();
	//断言统计个数是：私有变量count的值
	String c = driver
		.findElement(By.tagName("b")).getText();
	//预期值是4，实际值是字符串类型的
	assertEquals(c,"4");
  }
  
  @BeforeMethod
  //声明参数，声明一个参数：browser，游览器
  //获取TS1。xml游览器数据
  //<parameter name="browser" value="firefox" />
  @Parameters("browser")
  //beforeMethod方法获取参数，参数是按照顺序赋值的
  //行参数
  public void beforeMethod(String b) {
	  //equalsIgnoreCase比较字符串忽略大小写
	if (b.equalsIgnoreCase("firefox")) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.ipc.plugins.enabled", false);
		driver = new FirefoxDriver(profile);
	} else if (b.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	} else if (b.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
	
	//浏览器最大化
	driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
