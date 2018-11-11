package day10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//登录页面
public class LoginPage2 {
	WebDriver driver;
		
	@FindBy(how = How.NAME,using = "username")
	WebElement unWE;
	
	@FindBy(how = How.NAME,using = "password")
	WebElement pwWE;
	
	@FindBy(how = How.NAME,using = "submit")
	WebElement buttonWE;
	
	String url = "http://localhost/ws/ecshop/upload/user.php";
	
	public LoginPage2(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//打开页面
	public void get(){
		driver.get(url);
	}
	
	//登录
	public HomePage2 login(String username,String password) throws InterruptedException{
		  unWE.sendKeys(username);
		  pwWE.sendKeys(password);
		  buttonWE.click();
		  Thread.sleep(3000);
		  return new HomePage2(driver);
	}

}
