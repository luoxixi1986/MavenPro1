package day06;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test24 {
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
		driver.get("file:///E:/Selenium/example/xpath.html");
		//封装选择汽车品牌的下拉框
		WebElement a = driver.findElement(By.name("cars"));
		Select s1 = new Select(a);
		//通过选项文本来选择“宝马”
		s1.selectByVisibleText("宝马");
		Thread.sleep(3000);
		//通过选项编号来选择第5个选项
		s1.selectByIndex(4);
		Thread.sleep(3000);
		//通过选项的value属性值来选择“奥迪”选项
		s1.selectByValue("audi");
		Thread.sleep(3000);
		//断言当前选项的文本是“奥迪”
		assertEquals("奥迪",s1.getFirstSelectedOption().getText());
		//选择包含"卡迪"的选项
		//(1)获得所有选项列表
		List<WebElement> all = s1.getOptions();
		//(2)遍历所有选项
		for(WebElement o:all){
		//(3)判断每个选项，是否包含“卡迪”
			if (o.getText().contains("卡迪")){
		//(4)如果包含，通过点击操作来对选项做选择的操作
				o.click();
		//(5)结束后退出循环
				break;
			}
		}
		Thread.sleep(3000);
	}
	
	@Test
	public void testb() throws Exception {
		driver.get("file:///E:/Selenium/example/select.html");
		//封装选择选择设置项目的列表框
		WebElement a = driver.findElement(By.id("menus_navlist"));
		Select s1 = new Select(a);
		//通过选项文本来选择“订单列表”
		s1.selectByVisibleText("订单列表");
		Thread.sleep(3000);
		//通过选项编号来选择第4个选项
		s1.selectByIndex(3);
		Thread.sleep(3000);
		//通过选项的value属性值来选择“商店设置”选项
		s1.selectByValue("shop_config");
		Thread.sleep(3000);
		//取消选择选项
		s1.deselectByIndex(1);
		s1.deselectByValue("shop_config");
		s1.deselectByVisibleText("会员列表");
		s1.deselectAll();
		Thread.sleep(3000);
		
		s1.selectByIndex(1);
		s1.selectByIndex(2);
		s1.selectByIndex(4);
		
		//获得被选中的选项列表
		List<WebElement> o1 = s1.getAllSelectedOptions();
		//断言被选中的元素个数
		assertEquals(3,o1.size());
		//断言被选中的元素中包含“订单列表”
		boolean f = false; 
		//f代表是否找到“订单列表”，false代表未找到，true代表找到了
		for (WebElement o:o1) {
			if (o.getText().contains("订单列表")){
				f = true; //找到了订单列表
				break; //退出循环
			}
		}
		assertTrue(f);
		
		//获得第一个被选中的选项
		assertEquals("订单列表",
				s1.getFirstSelectedOption().getText());
		
		//断言列表框是可以多选的
		assertTrue(s1.isMultiple());
	}
}





