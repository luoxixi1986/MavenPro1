package day11;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TestWait3 {
	WebDriver driver;
  @Test
  public void f() throws Exception {
		 //打开ECShop前台首页
		 driver.get("file:///C:/example/Wait.html");
		 //点击搜索
		 driver.findElement(By.id("b")).click();
		 //显示等待结果出现(超时时间：10秒，检查间隔时间为1000毫秒)
		 //第三个参数不写，表示每500毫秒去检查一次条件是否成功
		 //如果第三个参数写了，写1000是1秒钟检查一次条件是否成功
		 //第二个参数是超时时间为10秒
		 //第一是实例
		//实例化一个WebElement对象
		 //WebDriverWait需要调用自己的构造方法来做实例化操作
		 //driver变量实例，超时时间，可省略参数，10秒没有成功报超时错误
		 WebDriverWait ww = new WebDriverWait(driver,10,1000);
		 //until 等待操作，方法ExpectedConditions，条件presenceOfElementLocated
		 //通过这个ww.until回调函数就可以，把他存储在变量res里面
		 WebElement res = ww.until(ExpectedConditions.presenceOfElementLocated(By.id("result")));
		 //获得搜索结果输出,存储的数据获取他的值
		 System.out.println(res.getText());
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
