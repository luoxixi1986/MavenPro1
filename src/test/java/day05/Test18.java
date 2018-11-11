package day05;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test18 {
	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testa() throws Exception {
		driver.get("file:///E:/Selenium/example/name.html");
		//向用户名的文本框中输入alice
		driver.findElement(By.name("username")).sendKeys("alice");
		//向密码的文本框中输入654321
		driver.findElement(By.name("password")).sendKeys("654321");
		//等待5秒
		Thread.sleep(5000);
	}

}
