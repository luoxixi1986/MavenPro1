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

public class Test42 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
//	  a.打开Message.html
	  driver.get("file:///C:/example/message.html");
	  WebElement n = driver.findElement(By.name("name"));
	  WebElement e = driver.findElement(By.name("e-mail"));
	  WebElement c = driver.findElement(By.name("comments"));
//		b.向名字文本框中输入jack
	  n.sendKeys("jack");
//		c.通过键盘Ctrl+A对名字文本框内容作全选
	  n.sendKeys(Keys.CONTROL,"a");
//		d.通过键盘Ctrl+C对名字文本框内容作复制
	  n.sendKeys(Keys.CONTROL,"c");
//		e.通过键盘Ctrl+V对E-mail文本框内容作粘贴
	  e.sendKeys(Keys.CONTROL,"v");
//		f.在E-mail文本框通过双击来全选
	  Actions a = new Actions(driver);
	  //双击鼠标
	  a.doubleClick(e).build().perform();
//		g.在E-mail文本框点击右键
	  a.contextClick(e).build().perform();
//		i.通过点击三次向下箭头(Keys.ARROW_DOWN)后点击回车(Keys.ENTER)的方式选中右键菜单中“复制”
	  a.sendKeys(Keys.ARROW_DOWN).build().perform();
	  a.sendKeys(Keys.ARROW_DOWN).build().perform();
	  a.sendKeys(Keys.ARROW_DOWN).build().perform();
	  a.sendKeys(Keys.ENTER).build().perform();
//		j.在留言文本框中点击右键
	  a.contextClick(c).build().perform();
//		k.通过点击四次向下箭头(Keys.ARROW_DOWN)后点击回车(Keys.ENTER)的方式选中右键菜单中“粘贴”
	  a.sendKeys(Keys.ARROW_DOWN).build().perform();
	  a.sendKeys(Keys.ARROW_DOWN).build().perform();
	  a.sendKeys(Keys.ARROW_DOWN).build().perform();
	  a.sendKeys(Keys.ARROW_DOWN).build().perform();
	  a.sendKeys(Keys.ENTER).build().perform();
//		l.等待5000毫秒
	  Thread.sleep(5000);
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
