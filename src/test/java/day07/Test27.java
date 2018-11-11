package day07;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test27 {
	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.ipc.plugins.enabled", false);
		driver = new FirefoxDriver(profile);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testa() throws Exception {
		//打开ECShop后台首页
		driver.get("http://localhost//ecshop/upload/admin/index.php");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.name("captcha")).sendKeys("0");
		driver.findElement(By.className("button")).click();
		driver.switchTo().frame("menu-frame");
		//点击左侧的”商品列表“
		driver.findElement(By.linkText("商品列表")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main-frame");
		//输入关键字a
		driver.findElement(By.name("keyword")).sendKeys("a");
		//点击“搜索”		
		driver.findElement(By.className("button")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("header-frame");
		//点击“退出”
		driver.findElement(By.linkText("退出")).click();
		Thread.sleep(3000);
	}
}



