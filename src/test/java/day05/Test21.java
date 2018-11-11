package day05;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class Test21 {
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
		//打开ECShop前台首页
		driver.get("http://localhost/ws/ecshop/upload/index.php");
		//输入关键字a
		driver.findElement(By.id("keyword")).sendKeys("a");
		//点击“搜索”
		driver.findElement(By.name("imageField")).click();
		//点击“ECSHOP"图片回到首页
		driver.findElement(By.tagName("img")).click();
		//断言网页标题是否等于首页的标题
		String t1 = driver.getTitle();
		assertEquals("ECSHOP演示站 - Powered by ECShop",t1);
		//断言网页标题以“ECSHOP演示站”开头
		boolean b1 = t1.startsWith("ECSHOP演示站");
//		assertEquals(true,b1);
		assertTrue(b1);
		
		Thread.sleep(5000);
	}
	
	@Test
	public void testb() throws Exception {
		//打开ECShop前台首页
		driver.get("http://localhost/ws/ecshop/upload/index.php");
		//点击”选购中心“，等待3秒
		driver.findElement(
				By.linkText("选购中心")).click();
		Thread.sleep(3000);
		//再点击包含”您的购物车中有“的链接，等待5秒
//		driver.findElement(
//				By.partialLinkText("您的购物车中有"))
//				.click();
		//再点击包含”您的购物车中有“的链接，等待5秒---层级定位
		driver.findElement(By.id("ECS_CARTINFO"))
			.findElement(By.tagName("a"))
			.click();
		
		Thread.sleep(5000);
	}
	
	@Test
	public void testc() throws Exception {
		//打开ECShop前台首页
		driver.get("http://localhost/ws/ecshop/upload/index.php");
		//点击“留言板”
//		driver.findElement(By.linkText("留言板")).click();
		WebElement a;
		a = driver.findElement(By.linkText("留言板"));
		a.click();
		
		//通过点击操作来选中“售后”的单选按钮
		List<WebElement> b = driver
			.findElements(By.name("msg_type"));
		//点击编号为3（第4个）元素
		b.get(3).click();
		//断言单选按钮的个数是否等于预期值5
		int count = b.size();
		assertEquals(5,count);
		
		Thread.sleep(5000);
	}
	
	@Test
	public void testd() throws Exception {
		//打开ECShop前台首页
		driver.get("http://localhost/ws/ecshop/upload/index.php");
		//点击“登录”---层级定位
//		driver.findElement(By.id("ECS_MEMBERZONE")).findElement(By.tagName("img")).click();
		WebElement a = driver.findElement(By.id("ECS_MEMBERZONE"));
		WebElement b =a.findElement(By.tagName("img"));
		b.click();
		
		//向整个网页中的第一个input标签的元素中输入abcde
		driver.findElement(By.tagName("input"))
			.sendKeys("abcde");
		//向登录区域内的第一个input标签中输入fgh
		driver.findElement(By.name("formLogin"))
			.findElement(By.tagName("input"))
			.sendKeys("fgh");
		
		//点击“注册”---xpath定位
		driver.findElement(By.xpath(".//*[@id='ECS_MEMBERZONE']/a[2]/img")).click();
		
		//等待5秒
		Thread.sleep(5000);
	}
	
	@Test
	public void teste() throws Exception {
		//打开ECShop前台首页
		driver.get("http://localhost/ws/ecshop/upload/index.php");
//		//使用xpath定位点击“选购中心”
		driver.findElement(By.xpath(".//*[@id='topNav']/a[2]")).click();
		
//		//再使用xpath定位点击“您的购物车中有……”
//		driver.findElement(By.xpath(".//*[@id='ECS_CARTINFO']/a")).click();
		driver.findElement(By.cssSelector("#ECS_CARTINFO>a")).click();
		
		//等待5秒
		Thread.sleep(5000);
	}

}



