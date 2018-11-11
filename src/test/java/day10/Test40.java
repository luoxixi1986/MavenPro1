package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Test40 {
	WebDriver driver;
  @Test
  public void login() throws InterruptedException {
	  driver.get("http://localhost//ecshop/upload/index.php");
	  driver.findElement(By.xpath(".//*[@id='ECS_MEMBERZONE']/a[1]/img")).click();
	  driver.findElement(By.name("username")).sendKeys("luoxixi");
	  driver.findElement(By.name("password")).sendKeys("luoxixi123456");
	  driver.findElement(By.name("submit")).click();
	  Thread.sleep(3000);
  }
  
  //dependsOnMethods各个方法有前后顺序
  //message是方法的名称
  @Test(dependsOnMethods={"message"})
  public void logout() throws InterruptedException {
	  driver.findElement(By.linkText("退出")).click();
	  Thread.sleep(3000);
  }

  @Test(dependsOnMethods={"login"})
  public void message() throws InterruptedException {
	  driver.findElement(By.linkText("留言板")).click();
	  WebElement e = driver.findElement(By.name("user_email"));
	  Thread.sleep(2000);
	  if (e.getAttribute("value").equals("")){
		  Thread.sleep(2000);
		  e.sendKeys("a@163.com");
	  }
	  driver.findElements(By.name("msg_type")).get(3).click();
	  Thread.sleep(2000);
	  driver.findElement(By.name("msg_title")).sendKeys("abc");
	  Thread.sleep(2000);
	  driver.findElement(By.name("msg_content")).sendKeys("def");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@value='我要留言']")).click();
	  Thread.sleep(3000);
  }
  
  //BeforeClass和AfterClass意思是先启动游览器，等到Test都执行完成后，在关闭游览器
  //以前是执行一个test，开一次游览器和关闭一次游览器
  //执行所有方法在关闭游览器
  @BeforeClass
  public void beforeMethod() {
	FirefoxProfile profile = new FirefoxProfile();
	//忽略flash插件
	profile.setPreference("dom.ipc.plugins.enabled", false);
	driver = new FirefoxDriver(profile);
  }

  @AfterClass
  public void afterMethod() {
	 driver.quit();
  }

}
