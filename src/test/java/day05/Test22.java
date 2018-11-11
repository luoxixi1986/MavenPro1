package day05;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test22 {
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
		//打开link.html
		driver.get("file:///E:/Selenium/example/link.html");
		//点击“链接到name.html”
//		driver.findElement(By.linkText("链接到name.html")).click();
		driver.findElement(By.partialLinkText("name")).click();
		//断言当前网页标题是否正确
		String t = driver.getTitle();
		assertEquals("name定位",t);
		
		//等待3000毫秒
		Thread.sleep(3000);
	}

}
