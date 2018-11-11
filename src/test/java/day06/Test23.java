package day06;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test23 {
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
		driver.get("http://172.166.100.59/ws/ecshop/upload/index.php");
		//点击"登录"
		driver.findElement(By.xpath(".//*[@id='ECS_MEMBERZONE']/a[1]/img")).click();
		//断言当前网页标题以“用户中心”开头
//		String t1 = driver.getTitle();
//		boolean b1 = t1.startsWith("用户中心");
//		assertTrue(b1);
		assertTrue(driver.getTitle().startsWith("用户中心"));
		//断言url以“user.php”结尾
		assertTrue(driver.getCurrentUrl().endsWith("user.php"));
		//断言“立即登录”的页面元素出现
		assertTrue(isElementPresent(By.name("submit")));
		
		//输入用户名
		driver.findElement(By.name("username")).sendKeys("zhengxj");
		//输入密码
		driver.findElement(By.name("password")).sendKeys("123456");
		//点击“立即登录”
		driver.findElement(By.name("submit")).click();
		//断言当前网页标题以“系统提示”开头
		assertTrue(driver.getTitle().startsWith("系统提示"));
		//断言当前网页源代码中包含“登录成功”
		assertTrue(driver.getPageSource().contains("登录成功"));
		//断言“退出”链接出现
		assertTrue(isElementPresent(By.linkText("退出")));
		//断言用户名显示正确
		String u1 = driver.findElement(By.xpath(".//*[@id='ECS_MEMBERZONE']/font/font")).getText();
		assertEquals("zhengxj",u1);
		
		Thread.sleep(5000);
		//断言当前网页标题以“ECShop演示站”开头
		assertTrue(driver.getTitle().startsWith("ECSHOP演示站"));
		//断言url以“index.php”结尾
		assertTrue(driver.getCurrentUrl().endsWith("index.php"));
				
		//点击“退出”
		driver.findElement(By.linkText("退出")).click();
		//断言当前网页标题以“系统提示”开头
		assertTrue(driver.getTitle().startsWith("系统提示"));
		//断言url包含“logout”
		assertTrue(driver.getCurrentUrl().contains("logout"));
		//断言当前网页源代码中包含“您已经成功的退出了”
		assertTrue(driver.getPageSource().contains("您已经成功的退出了"));
		//断言“退出”链接消失
		assertFalse(isElementPresent(By.linkText("退出")));
				
		Thread.sleep(5000);
		//断言当前网页标题以“ECShop演示站”开头
		assertTrue(driver.getTitle().startsWith("ECSHOP演示站"));
		//断言url以“index.php”结尾
		assertTrue(driver.getCurrentUrl().endsWith("index.php"));

	}

	
	@Test
	public void testb() throws Exception {
		//打开留言板页面
		driver.get("http://172.166.100.59/ws/ecshop/upload/message.php");
		//获得“留言类型”所有的单选按钮
		List<WebElement> a = driver.findElements(By.name("msg_type"));
		//断言单选按钮的个数为5
		assertEquals(5,a.size());
		//断言第1个单选按钮默认被选中
		assertTrue(a.get(0).isSelected());
		//断言第2个以后的单选按钮默认未被选中
		for(int i=1;i<a.size();i++){
			assertFalse(a.get(i).isSelected());
		}
		
		//点击第5个单选按钮
		a.get(4).click();
		//依次点击所有单选按钮
//		for (int i=0;i<a.size();i++){
//			a.get(i).click();
//			Thread.sleep(2000);
//		}
		for(WebElement b:a){
			b.click();
			Thread.sleep(2000);
		}
	}
	
	
	@Test
	public void testc() throws Exception {
		//打开ECShop前台首页
		driver.get("http://172.166.100.59/ws/ecshop/upload/index.php");
		//输入关键字a
		driver.findElement(By.id("keyword")).sendKeys("a");
		//点击“搜索”
		driver.findElement(By.name("imageField")).click();
		Thread.sleep(3000);
		//断言搜索结果统计个数等于预期值4
		String c1 = driver.findElement(By.xpath(".//*[@id='pager']/span/b")).getText();
		assertEquals("4",c1);
		//断言搜索结果统计个数等于预期值4
		String c2 = driver.findElement(By.xpath(".//*[@id='pager']/span")).getText();
		System.out.println(c2);
		assertTrue(c2.contains("4"));	
		//断言搜索条件（关键字文本框）中仍然保留原值“a”
		String kw1 = driver.findElement(By.id("keyword"))
			.getAttribute("value");
		assertEquals("a",kw1);
		//断言搜索结果区域内显示了4个商品
		List<WebElement> goods = 
			driver.findElements(By.className("goodsItem"));
		assertEquals(4,goods.size());
		//点击第3个商品的图片
		goods.get(2).findElement(By.tagName("img")).click();
		Thread.sleep(2000);
		//断言默认购买数量等于1
		assertEquals("1",driver.findElement(By.id("number"))
				.getAttribute("value"));
		//断言“黑色”单选按钮被选中
		assertTrue(driver.findElement(By.id("spec_value_201")).isSelected());
		}
	
	
	@Test
	public void testd() throws Exception {
		//打开ECShop前台首页
		driver.get("http://172.166.100.59/ws/ecshop/upload/index.php");
//		//断言登录图片的src属性中包含“log”
//		String s1 = driver.findElement(
//				By.xpath(".//*[@id='ECS_MEMBERZONE']/a[1]/img"))
//			.getAttribute("src");
//		assertTrue(s1.contains("log"));
//		//断言注册图片的src属性中包含“reg”
//		String s2 = driver.findElement(
//				By.xpath(".//*[@id='ECS_MEMBERZONE']/a[2]/img"))
//			.getAttribute("src");
//		assertTrue(s2.contains("reg"));
		
		List<WebElement> a = driver
			.findElement(By.id("ECS_MEMBERZONE"))
			.findElements(By.tagName("img"));
		
		String[] c = new String[]{"log","reg"};
		
		for(int i=0;i<a.size();i++) {
			String b = a.get(i).getAttribute("src");
			assertTrue(b.contains(c[i]));
		}
	}
	

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  
}





