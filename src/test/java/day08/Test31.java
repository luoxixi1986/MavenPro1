package day08;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test31 {
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
		//登录后退出
		driver.get("http://localhost/ws/ecshop/upload/index.php");
		driver.findElement(By.xpath("//font[@id='ECS_MEMBERZONE']/a[1]/img")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("zhengxj");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.xpath("//font[@id='ECS_MEMBERZONE']/font/a[2]")).click();
	}

}
