package day12;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

public class TestKillProcess {
  WebDriver driver;
  @Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
	  
  }

  @AfterMethod
  public void afterMethod() {
	  //如果捕获到异常，说明没有关闭游览器，那么就在进程中杀死它
	 try {
		 //断言是失败的，真不等于假，所有就还抛出异常，执行catch下的语句
		 assertTrue(false);
		 //打印到控制台
		 System.out.println("quitquitquitquitquitquitquitquitquitquitquitquitquit");
		  driver.quit();
	 }catch(Error e) {
		 //查看源码
		 e.printStackTrace();
		 //打印到控制台
		 System.out.println("killkillkillkillkillkillkillkillkillkillkillkillkillkill");
		 //强制关闭游览器,关闭进程
		 WindowsUtils.tryToKillByName("firefox.exe");
		 //WindowsUtils.tryToKillByName("iexplore.exe");
		 //WindowsUtils.tryToKillByName("chrome.exe");
	 }

  }

}
