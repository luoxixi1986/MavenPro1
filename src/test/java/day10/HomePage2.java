package day10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//主页
//pageFactory的好处是统一在一起好维护定位元素
//pageObject，数据分离，把不同的页面封装成一个对象，对每个操作步骤可以封装成不同的方法调用，不同的方法调用不同的数据执行不同的操作
public class HomePage2 {
	WebDriver driver;
	//使用的是pageFactory，页面工厂写法
	//selenium提供的注解@FindBy
	//注解有二个参数，第一个参数是定位方式，写成how = How.XPATH，等位是用xpath定位
	//大写How是个类，小写how是一个参数，用How类定义XPATH元素
	//第二个参数是using等于xpath的属性值
	@FindBy(how = How.XPATH,using = ".//*[@id='ECS_MEMBERZONE']/a[1]/img")
	WebElement loginImgWE;
	
	@FindBy(how = How.LINK_TEXT,using = "退出")
	WebElement logoutLinkWE;
	
	@FindBy(how = How.LINK_TEXT,using = "留言板")
	WebElement msgLinkWE;
	
	String url = "http://localhost//ecshop/upload/index.php";
	
	public HomePage2(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//打开主页
	public void get(){
		driver.get(url);
	}
	
	//进入登陆页
	public LoginPage2 toLoginPage() throws InterruptedException{
		  loginImgWE.click();
		  Thread.sleep(3000);
		  return new LoginPage2(driver);
	}
	
	//进入留言板页
	public MessagePage2 toMessagePage() throws InterruptedException{
		  msgLinkWE.click();
		  Thread.sleep(3000);
		  return new MessagePage2(driver);
	}
	
	//退出登录
	public void logout() throws InterruptedException{
		  logoutLinkWE.click();
		  Thread.sleep(3000);
	}

}
