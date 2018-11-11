package day12;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.JavascriptExecutor;

public class TestUpload1 {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("file:///C:/example/upload.html");
	  //上传一个文件,类型是file可用实现这种方法(type=file)
	  //使用方法1
	  driver.findElement(By.id("inFile")).sendKeys("C:\\eclipse-workspace\\MavenPro1\\test-output\\snapshot\\2018-10-29 20-54-37.jpg");
	  Utils.sleep(2000);
	  
  }
  
  @Test
  public void f1()  throws Exception  {
	  driver.get("file:///C:/example/upload.html");
	  //上传一个文件方式二模拟键盘操作
	  //1、点击页面元素，游览
	  //把对象存储在一个变量里
	  WebElement element = driver.findElement(By.id("inFile"));
	  
	  //对象有JavaScript代码实现点击操作
	  //把driver强制转换成JavascriptExecutor对象
	  //把对象封装好之后，调用executeScript方法
	  //第一个参数写js代码，第二个参数写页面元素
	  //arguments[0]获得一个参数，点击按钮(element),在代码中必须从0开始
	  ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	  Utils.sleep(2000);
	  //2.向剪切板中加入文件路径
	  String path = "C:\\eclipse-workspace\\MavenPro1\\test-output\\snapshot\\2018-10-29 20-54-37.jpg";
	  //Toolkit.getDefaultToolkit()得到Toolkit对象，在用getSystemClipboard方法获取剪切板对象，放到Clipboard对象里
	  //获取系统剪切板
	  Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
	  //创建一个Transferable实例，赋值一个参数
	  Transferable t = new StringSelection(path);
	  //对剪切板加入数据内容t获取的是文件路径的jpg图片，后面赋值为空，加入文件路径
	  cb.setContents(t, null);
	  //3.把图片粘贴到提示框中
	  //使用健康操作粘贴到文件上传对话框的文件名文本框中，回车确认
	  //可用用java语言robot类操作窗口里面的操作
	  //创建一个robot实例
	  Robot robot = new Robot();
	  //首先要按下键盘按键回车键
	  robot.keyPress(KeyEvent.VK_ENTER);
	  //释放回车键
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  //粘贴的快捷键Ctrl、+ v
	  //按下ctrl键
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  //按下字母V键
	  robot.keyPress(KeyEvent.VK_V);
	  //释放ctrl键
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  //释放V键
	  robot.keyRelease(KeyEvent.VK_V);
	  //在按一下回车键
	  robot.keyPress(KeyEvent.VK_ENTER);
	  //释放回车键
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  Utils.sleep(3000);	  
  }
  
  @Test
  public void f2()  throws Exception  {
	  driver.get("file:///C:/example/upload.html");
	  //点击游览
	 WebElement element = driver.findElement(By.id("inFile"));
	 //利用JavaScript实现点击 
	//arguments[0]获得一个参数，点击按钮(element),在代码中必须从0开始
	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	 Utils.sleep(2000);
	 //运行teduexe -- 方式三：AutoIt生成的exe
	 try {
		 //Runtime是java语言提供的可以运行exe文件
		 Runtime.getRuntime().exec("C:\\tedu.exe");
		 Utils.sleep(5000);
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
  }
  
  @BeforeMethod
  public void beforeMethod(){
	  driver = Utils.openBrowser("firefox");
  }

  @AfterMethod
  public void afterMethod() {
	  Utils.sleep(3000);
	  driver.quit();
  }

}
