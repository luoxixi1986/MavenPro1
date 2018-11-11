package day09;


import static org.junit.Assert.*;

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
public class Test33 {
	WebDriver driver;
	private String kw;
	private String count;
	
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
		//打开前台首页
		driver.get("http://localhost/ws/ecshop/upload/index.php");
		//输入关键字：私有变量kw的值
		driver.findElement(By.id("keyword")).sendKeys(kw);
		//点击”搜索“
		driver.findElement(By.name("imageField")).click();
		//断言统计个数是：私有变量count的值
		String c = driver
			.findElement(By.tagName("b")).getText();
		assertEquals(count,c);
		
	}
	
	@Parameters
	public static Collection<String[]> getData() {
		return Arrays.asList(new String[][] {
			{"a","4"},
			{"b","1"},
			{"c","24"}
		});
	}
	
	public Test33(String kw,String count){
		this.kw = kw;
		this.count = count;
	}

}
