package day12;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;

public class TestDownLoad1 {
	WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
	  //启动带配置文件的Firefox(在配置文件中设置自动下载相关的首选项)
	  //FirefoxProfile的对象实例，构造方法进行实例化，不需要任何参数，定义了一个配置文件
	  FirefoxProfile profile = new FirefoxProfile();
	  //设置首选项，第一个参数下载是否显示管理器，true显示，false为不显示下载管理器，自动完成下载，缺省是true
	  profile.setPreference("browser.download.manager.showWhenStarting", false);
	  //自定一下自动下载的文件类型,只有这一种类型会自动下载(excel),
	  //application/octetstream,二进制流，不知道什么类型，都可以自动下载
	  //还有csv格式的,还有zip的文件
	  profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octetstream,application/vnd.ms-excel,text/csv,application/zip");
	  //默认下载文件夹，0桌面，1是默认系统用户下载文件夹，2自定义文件夹
	  profile.setPreference("browser.download.folderList", 2);
	  //设置自定义文件存储路径
	  profile.setPreference("browser.download.dir","C:\\360Downloads");
	  //启动Firefox,把profile作为构造方法传递进去，他就会使用这个配置文件了
	  //启动火狐后自动下载的相关游览项，自动保存下载文件
	  driver = new FirefoxDriver(profile);
  }
  @Test
  public void f () {
	  //打开ECShop后台首页，来进行登录操作
	  driver.get("http://localhost/ecshop/upload/admin/index.php");
	  //登录
	  driver.findElement(By.name("username")).sendKeys("admin");;
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  //验证码，用万能验证码
	  driver.findElement(By.name("captcha")).sendKeys("0");
	  //点击管理中心
	  driver.findElement(By.className("button")).click();
	  Utils.sleep(2000);	
	  //点击左侧流量分析,switchTo()句柄
	  driver.switchTo().frame("menu-frame");
	  driver.findElement(By.linkText("流量分析")).click();
	  Utils.sleep(2000);
	  //点击右侧流量分析报表下载
	  //应为已经切换过页面了，必须先切回主页面，在切换要进入的页面
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame("main-frame");
	  //获得下载前自定义文件夹内的文件数
	  //得到这个文件夹所有文件listFiles(),得到的是一个数组
	  //length,得到数组的长度，可用获取到下载前文件夹文件数
	  int c1 = new File("C:\\360Downloads").listFiles().length;
	  //流量报表分析的连接了
	  driver.findElement(By.linkText("流量分析报表下载")).click();
	  Utils.sleep(2000);
	  //在获取文件夹文件数
	  int c2 = new File("C:\\360Downloads").listFiles().length;
	  //断言下载后自定义文件内容多了一个文件
	  assertEquals(c1+1,c2);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
