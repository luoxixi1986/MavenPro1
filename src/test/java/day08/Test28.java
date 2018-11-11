package day08;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test28 {
	WebDriver driver;
	private boolean acceptNextAlert = true;
	
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
		//打开ECShop后台首页
		driver.get("http://172.166.100.59/ws/ecshop/upload/admin/index.php");
		//登录
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.name("captcha")).sendKeys("0");
		driver.findElement(By.className("button")).click();
		//点击“会员列表”
		driver.switchTo().frame("menu-frame");
		driver.findElement(By.linkText("会员列表")).click();
		//输入会员名称“zheng”
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main-frame");
		driver.findElement(By.name("keyword")).sendKeys("zheng");
		//点击“搜索”
		driver.findElement(By.xpath("html/body/div[1]/form/input[4]")).click();
		Thread.sleep(3000);
		//判断“会员名称”的列中第一行是否出现
		if (isElementPresent(By
			.xpath(".//*[@id='listDiv']/table/tbody/tr[3]/td[2]"))) {
			//点击该行后的“操作”列的“移除”图片
			driver.findElement(By.xpath(".//*[@id='listDiv']/table/tbody/tr[3]/td[10]/a[5]/img")).click();
			Thread.sleep(3000);
			//断言弹出提示框
			assertTrue(isAlertPresent());
			//断言提示框的内容是“您确定要删除该会员账号吗？”，点击“取消”来关闭
			acceptNextAlert = false;
			assertEquals("您确定要删除该会员账号吗？",
					closeAlertAndGetItsText());
		}
		//点击“退出”
		driver.switchTo().defaultContent();
		driver.switchTo().frame("header-frame");
		driver.findElement(By.linkText("退出")).click();
	}
	
  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
  }
  
  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }
  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}





