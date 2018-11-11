package day08;


import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test30 {
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
		driver.get("file:///E:/Selenium/example/newWindow.html");
		//点击“2链接到id.html”，切换到新窗口，输入数据，关闭新窗口，切换回原窗口
		driver.findElement(By.partialLinkText("2")).click();
		String h1 = driver.getWindowHandle();
		
		//（一共有2个窗口）
		Set<String> all = driver.getWindowHandles();
		Iterator<String> it = all.iterator();
		while (it.hasNext()) {
			String h2 = it.next();
			if (!h2.equals(h1)){
				driver.switchTo().window(h2);
				break;
			}
		}
		driver.findElement(By.id("username")).sendKeys("123");
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(h1);
		//在原窗口中点击“3链接到name.html”
		driver.findElement(By.partialLinkText("3")).click();
		//在原窗口中点击“2链接到name.html”
		driver.findElement(By.partialLinkText("2")).click();
		Thread.sleep(3000);
		//切换到name.html的窗口中（一共有3个窗口）
		String h3 = driver.getWindowHandle();
		Set<String> all2 = driver.getWindowHandles();
		Iterator<String> it2 = all2.iterator();
		while (it2.hasNext()) {
			String h4 = it2.next();
			if (!h4.equals(h3)) {
				driver.switchTo().window(h4);
				//如果当前切换到的窗口标题等于“name定位”，就停止切换
				if (driver.getTitle().equals("name定位")){
					break;
				}
			}
		}
		driver.findElement(By.name("username")).sendKeys("456");
		Thread.sleep(3000);
	}

}



