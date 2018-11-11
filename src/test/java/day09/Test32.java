package day09;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class Test32 {
	WebDriver driver;
	private boolean acceptNextAlert = true;
	
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
//		a.打开ECShop前台首页
		driver.get("http://172.166.100.59/ws/ecshop/upload/index.php");
//		b.输入关键字a
		driver.findElement(By.xpath("//input[@id='keyword']")).sendKeys("a");
//		c.点击”搜索“按钮
		driver.findElement(By.xpath("//input[@name='imageField']")).click();
//		d.点击所有商品中最后一个商品的图片
		driver.findElement(By.xpath("//div[@class='goodsItem'][last()]/a[1]/img")).click();
//		e.点击”加入购物车“
		driver.findElement(By.xpath("//img[contains(@src,'bnt_cat')]")).click();
//		f.等待5秒，将购物车页面中的”购买数量“修改为3
		Thread.sleep(5000);
		WebElement gn = driver
			.findElement(By.xpath("//input[contains(@id,'goods_number')]"));
		gn.clear();
		gn.sendKeys("3");	
//		g.等待5秒，点击操作列的”删除“链接
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='删除']")).click();
//		在提示上点击”确定“
		closeAlertAndGetItsText();
		Thread.sleep(5000);
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
