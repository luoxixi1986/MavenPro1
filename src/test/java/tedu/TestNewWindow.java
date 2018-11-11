package tedu;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class TestNewWindow {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("file:///C:/example/newWindow.html");
	  //partialLinkText 获取文本中的唯一性标志
	  driver.findElement(By.partialLinkText("3")).click();
	  //切换到原来窗口的句柄，创建对象为hdl1(默认的句柄)
	  //因为没有切换新窗口，还是在原来的窗口进行操作
	  String hdl1 = driver.getWindowHandle();
	  System.out.println("1"+driver.getTitle());
	  //获取新窗口
	  Utils.switchWindow("windName");
	  driver.findElement(By.name("username"));
	  Utils.sleep(3000);
	  //关闭掉新窗口
	  driver.close();
	  //切换到旧窗口
	  Utils.switchWindow(hdl1);
	  //就窗口的标题
	  System.out.println("1"+driver.getTitle());
	  Utils.sleep(3000);
  }
  
  @Test
  public void f1() {
	  driver.get("file:///C:/example/newWindow.html");
	  //点击2这个窗口，在加上原窗口一共是两个窗口
	  driver.findElement(By.partialLinkText("2")).click();
	  //切换另一个窗口
	  Utils.switchWindow();
	  driver.findElement(By.id("username")).sendKeys("jack");
	  Utils.sleep(2000);
	  //切换回原窗口，不用关闭
	  Utils.switchWindow();
	  System.out.println(driver.getTitle());
  }
  
  @Test
  public void f2() {
	  driver.get("file:///C:/example/newWindow.html");
	  //连接文本中等于2的点击它
	  driver.findElement(By.partialLinkText("2")).click();
	  //点击2连接弹出一个新窗口，点击3连接又弹出一个新窗口
	  //加上原窗口有3个窗口
	  driver.findElement(By.partialLinkText("3")).click();
	  //1代表标题搜索，标题有id就切过去
	  Utils.switchWindow(1,"id");
	  //如果能输入进去说明切换成功
	  driver.findElement(By.id("username")).sendKeys("rose");
	  Utils.sleep(3000);
	  //网页为3的窗口标题是什么通过getTitel获取
	  Utils.switchWindow(3,"3");
	  System.out.println(driver.getTitle());
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
