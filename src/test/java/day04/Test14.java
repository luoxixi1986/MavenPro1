package day04;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test14 {
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
		//打开check.html
		driver.get("file:///E:/Selenium/example/check.html");
		//通过点击来选中”流行“的复选框
		driver.findElement(By.id("m3")).click();
		//取消选中”摇滚“的复选框
		driver.findElement(By.id("m1")).click();
		//选中”男“单选按钮
		driver.findElement(By.id("s1")).click();
		//等待5000毫秒
		Thread.sleep(5000);
	}

}
