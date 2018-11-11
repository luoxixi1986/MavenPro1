package day05;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test19 {
	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	@Test
	public void testa() throws Exception {
		driver.get("file:///E:/Selenium/example/message.html");
		driver.findElement(By.name("name"))
			.sendKeys("peter");
		driver.findElement(By.name("e-mail"))
			.sendKeys("peter@163.com");
//		driver.findElement(By.name("comments"))
//			.sendKeys("Hello,peter!");
		driver.findElement(By.tagName("textarea")).sendKeys("Hello!");
		Thread.sleep(5000);
	}
	
	@Test
	public void testb() throws Exception {
		driver.get("file:///E:/Selenium/example/message.html");
		//获得一个元素
		driver.findElement(By.tagName("input"))
			.sendKeys("abc");
		//获得一组元素
		List<WebElement> a;
		a = driver.findElements(By.tagName("input"));
		a.get(1).sendKeys("123");
		a.get(0).clear();
		a.get(0).sendKeys("456");
		Thread.sleep(5000);
	}
}
