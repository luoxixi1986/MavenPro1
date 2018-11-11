package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Test41 {
	WebDriver driver;
	
//  @Test
	//InterruptedException：中断故障（异常）
//  public void f() throws InterruptedException {
////	  driver.get("file:///E:/Selenium/example/operation.html");
//	  driver.get("file:///E:/Selenium/example/id.html");
//	  //Actions（动作）类鼠标和键盘操作类 ，把driver作为构造方法参数传递过来
//	  Actions a = new Actions(driver);
//	  //双击
//		  //doubleClick双击鼠标，指定元素的中间位置双击
		  //build()打包命令
		  //perform()执行这个命令
////	  a.doubleClick(driver.findElement(By.id("dblclick"))).build().perform();
////	  	
//	  //右击
////	  a.contextClick(driver.findElement(By.id("rightclick"))).build().perform();
//	  
////	  //移入
////	  a.moveToElement(driver.findElement(By.id("div1"))).build().perform();
////	  Thread.sleep(3000);
////	  //移出
		  //左上角移出到那个位置去，横向和纵向移动多少
////	  a.moveToElement(driver.findElement(By.id("div1")),300,300).build().perform();
//	  
//	  //拖拽
		  //bar是要拖拽的元素
////	  WebElement b = driver.findElement(By.id("bar"));
	      //div1想拖拽的位置
//////	  WebElement t = driver.findElement(By.id("div1"));
		  //把第一个元素内容拖拽到第二个元素的位置，二个控件，把A控件拖拽到B控件上
	      //指定元素位置
//////	  a.dragAndDrop(b, t).build().perform(); //将b元素拖拽到t元素的位置
		  //第一个参数是控件，第二和第三是x坐标和y坐标，相对位置的横坐标和纵坐标，多拽多少像素
		  //指定像素的
////	  a.dragAndDropBy(b, 200, 300).build().perform(); //将b元素拖拽指定的像素值
//	  
//	  //向用户名输入abc，在用户名中Ctrl+A全选，再Ctrl+C复制，最后到密码框Ctrl+V粘贴
//	  WebElement un = driver.findElement(By.id("username"));
//	  WebElement pw = driver.findElement(By.id("password"));
//	  un.sendKeys("abc");
	//点击一下框
//	  pw.click();
//	  un.sendKeys(Keys.CONTROL,"a");
//	  un.sendKeys(Keys.CONTROL,"c");
		//点击一下框
//	  pw.click();
//	  pw.sendKeys(Keys.CONTROL,"v");
//	  
//	  Thread.sleep(5000);
//  }
//  
  @Test
  public void f1() throws InterruptedException { 
	  driver.get("file:///C:/example/message.html");
	  driver.findElement(By.name("name")).sendKeys("abcd");
	  //Actions（动作）类，鼠标和键盘操作类 ，把driver作为构造方法参数传递过来
	  Actions a = new Actions(driver);
	  //点击“Tab”
	  a.sendKeys(Keys.TAB).build().perform();
	  Thread.sleep(3000);	 
	  //点击“Enter”回车
	  a.sendKeys(Keys.ENTER).build().perform();
	  Thread.sleep(3000);
	  driver.findElement(By.name("comments")).sendKeys("123");
	  a.sendKeys(Keys.ENTER).build().perform();
	  driver.findElement(By.name("comments")).sendKeys("456");
	  Thread.sleep(3000);
  }

  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();  //把浏览器窗口最大化
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
