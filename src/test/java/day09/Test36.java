package day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Test36 {
	WebDriver driver;
  @Test
  public void testa() {
		driver.get("http://localhost/ws/ecshop/upload/index.php");
		driver.findElement(By.xpath(".//*[@id='ECS_MEMBERZONE']/a[1]/img")).click();
		driver.findElement(By.name("username")).sendKeys("zhengxj");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("退出")).click();
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

}
