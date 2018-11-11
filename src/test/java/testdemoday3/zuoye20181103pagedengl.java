package testdemoday3;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class zuoye20181103pagedengl  {

	private WebDriver driver;

	public zuoye20181103pagedengl(WebDriver driver) {
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

	/**
	 * 设置用户名
	 * 
	 * @param driver
	 * @param userText
	 */
	public void setUsername(String userText) throws NotFoundException {

	     
		this.setText(driver.findElement(By.id("username")), userText);
	}

	/**
	 * 设置密码
	 * 
	 * @param driver
	 * @param passText
	 */
	public void setPassword(String passText) throws NotFoundException {

		this.setText(driver.findElement(By.id("password")), passText);
	}
	
	public void setyanzhenma(String passText) throws NotFoundException {

		this.setText(driver.findElement(By.id("add-code")), passText);
	}

	/**
	 * 点击登录按钮
	 * 
	 * @param driver
	 */
	public void clickLogin() throws NotFoundException {
		driver.findElement(By.name("imageField")).click();
	}

	private void setText(WebElement e, String text) {
		e.clear();
		e.sendKeys(text);
	}

}