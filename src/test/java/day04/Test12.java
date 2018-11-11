package day04;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test12 {
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
		//打开留言簿
		driver.get("file:///E:/Selenium/example/message.html");
		//……
		//等待3000毫秒
		Thread.sleep(3000);
	}

}
