package day09;


import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


@RunWith(Parameterized.class)
public class Test34 {
	WebDriver driver;
	private String un;
	private String pw;
	
	@Before
	public void setUp() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.ipc.plugins.enabled", false);
		driver = new FirefoxDriver(profile);
		//浏览器最大化
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testa() throws Exception {
		driver.get("http://localhost/ws/ecshop/upload/index.php");
		driver.findElement(By.xpath(".//*[@id='ECS_MEMBERZONE']/a[1]/img")).click();
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("退出")).click();
	}

	@Parameters
	public static Collection<String[]> getData() {
		return Arrays.asList(new String[][]{
				{"zhengxj","123456"},
				{"zhengxj3","654321"}
		});
	}
	
	public Test34(String un,String pw){
		this.un = un;
		this.pw = pw;
	}
}
