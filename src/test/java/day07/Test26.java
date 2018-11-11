package day07;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test26 {
	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testa() throws Exception {
		//打开main1.html
		driver.get("file:///E:/Selenium/example/main1.html");
		//切换到frame1中
		driver.switchTo().frame("f1");
		//向第一个文本框输入abc
		driver.findElement(By.id("input1")).sendKeys("abc");
		//切换回默认页面
		driver.switchTo().defaultContent();
		//切换到frame2中
		driver.switchTo().frame("f2");
		//向第二个文本框中输入def
		driver.findElement(By.id("input2")).sendKeys("def");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("f1");
		//向第一个文本框输入123
		driver.findElement(By.id("input1")).sendKeys("123");
		
		Thread.sleep(3000);
	}
	
	@Test
	public void testb() throws Exception {
		driver.get("file:///E:/Selenium/example/main2.html");
		driver.switchTo().frame(0);
		driver.findElement(By.id("input1")).sendKeys("hello");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElement(By.id("input2")).sendKeys("你好");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.id("input1")).sendKeys("jack");
		Thread.sleep(3000);
	}
	
	@Test
	public void testc() throws Exception {
		driver.get("file:///E:/Selenium/example/main3.html");
		WebElement we1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(we1);
		driver.findElement(By.id("input1")).sendKeys("hello");
		driver.switchTo().defaultContent();
		
		//切换到input2文本所在的frame---了解
		List<WebElement> fs = driver
			.findElements(By.tagName("iframe"));
		for(int i=0;i<fs.size();i++){
			driver.switchTo().defaultContent();
			driver.switchTo().frame(i);
			if (driver.getPageSource().contains("input2")) {
				break;
			}
		}
		
//		driver.switchTo().frame(1);
		driver.findElement(By.id("input2")).sendKeys("你好");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.id("input1")).sendKeys("jack");
		Thread.sleep(3000);
	}
	
	@Test
	public void testd() throws Exception {
		driver.get("file:///E:/Selenium/example/newWindow.html");
		driver.findElement(By.linkText("3链接到name.html")).click();
		//保留原窗口的句柄（窗口的唯一标识）
		String h1 = driver.getWindowHandle();
		
		//通过窗口名称切换到新窗口
		//窗口名称：link的target属性的值（不能是_blank、_self、_top、_parent）
		driver.switchTo().window("windName");
		driver.findElement(By.name("username")).sendKeys("abc");
		Thread.sleep(3000);
		//关闭当前窗口，保留其他窗口
		driver.close();
		Thread.sleep(3000);
		
		//通过窗口句柄来切换窗口
		driver.switchTo().window(h1);
		driver.findElement(By.tagName("input")).click();
		
		//通过窗口名称切换到新窗口
		//input标签的元素的onclick事件的window.open方法的第二个参数值
		driver.switchTo().window("windName1");
		driver.findElement(By.name("username")).sendKeys("abc");
		Thread.sleep(3000);
		//关闭当前窗口，保留其他窗口
		driver.close();
		Thread.sleep(3000);
		
		//通过窗口句柄来切换窗口
		driver.switchTo().window(h1);
		driver.findElement(By.linkText("2链接到id.html")).click();
		//切换到新窗口，但是不知道新窗口的名称
		//(1)获得所有窗口的句柄
		Set<String> all = driver.getWindowHandles();
		//(2)遍历所有窗口句柄
		Iterator<String> it = all.iterator();
		while (it.hasNext()){
			//获得当前遍历到的窗口句柄
			String cwh = it.next();
		//(3)每次都判断遍历到到窗口句柄，如果不等于原窗口的句柄
			if (!cwh.equals(h1)){
		//(4)就切换到该窗口
				driver.switchTo().window(cwh);
		//(5)退出循环
				break;
			}
		}
		
		driver.findElement(By.id("username")).sendKeys("123456789");
		Thread.sleep(3000);
	}
}




