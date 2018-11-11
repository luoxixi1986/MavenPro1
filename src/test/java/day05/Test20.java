package day05;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test20 {
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
		driver.get("file:///E:/Selenium/example/class.html");
		//向用户名文本框中输入rose
		driver.findElement(By.className("spread")).sendKeys("rose");
		//向密码文本框中输入456789
		driver.findElement(By.className("tight")).sendKeys("456789");
		
		Thread.sleep(5000);
	}
}
