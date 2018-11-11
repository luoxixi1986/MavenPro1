package testdemoday3;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class zuoye20181103pagechaxun  {

	private WebDriver driver;

	public zuoye20181103pagechaxun(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * 打开测试URL
	 * 
	 * @param driver
	 * @throws InterruptedException 
	 */
	
	public void GoToUrl(String url) throws InterruptedException {
		this.driver.get(url);
		Thread.sleep(1000);
	}



	

	
	
	public void clickrenyuan() throws NotFoundException {
		driver.findElement(By.id("ri2")).click();
	}
	private void tiaozhuanchuangkou(String title) throws  InterruptedException {
		String hand =driver.getWindowHandle();//获取当前句柄

		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
		System.out.println(handles.size());
		for (String handle : handles) {
			driver.switchTo().window(handle);// 放循环前面不会漏掉页面
			Thread.sleep(5000);
			if (driver.getTitle() == title) {
				break;
			}
			System.out.println(driver.getPageSource());
		}
	}

	public void clickrenyuan1() throws NotFoundException {
		kuangjia("heading");
		Actions build = new Actions(driver);
		build.click(driver.findElement(By.id("ri2"))).perform();
	}
	public void setu_name (String passText) throws NotFoundException, InterruptedException {
		tiaozhuanchuangkou("软件应用框架");
		kuangjia("main");
		this.setText(driver.findElement(By.id("select-key:useruuid")), passText);
		System.out.println(driver.getPageSource());

	}
	public void setenable_flag  (String arg) throws NotFoundException {

		WebElement roleuuid =driver.findElement(By.id("select-key:display"));
		roleuuid.click();
		if (arg.equals("不可用")) {
			roleuuid.click();
			roleuuid.sendKeys(Keys.DOWN);
			roleuuid.sendKeys(Keys.ENTER);
		} else if(arg.equals("可用")) {
			roleuuid.click();
			roleuuid.sendKeys(Keys.DOWN);
			roleuuid.sendKeys(Keys.DOWN);
			roleuuid.sendKeys(Keys.ENTER);
		}
		
	}
	public void clickchaxun() throws NotFoundException {
		driver.findElement(By.name("select-key_submit")).click();
	}
	

	private void setText(WebElement e, String text) {
		e.clear();
		e.sendKeys(text);
	}
	private void kuangjia( String text) {
		driver.switchTo().defaultContent();// 跳到默认
		driver.switchTo().frame(text);

	}

}