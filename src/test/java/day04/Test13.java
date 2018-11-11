package day04;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test13 {
	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		//启动Firefox
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		//退出浏览器
		driver.quit();
	}
	
	@Test
	public void testa() throws Exception {
		//打开id.html
		driver.get("file:///E:/Selenium/example/id.html");
		//向用户名的文本框中输入jack
		driver.findElement(By.id("username")).sendKeys("jack");
		//向密码的文本框中输入123456
		driver.findElement(By.id("password")).sendKeys("123456");
		//等待3000毫秒
		Thread.sleep(3000);
	}

}
