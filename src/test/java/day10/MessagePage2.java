package day10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//留言板页面
public class MessagePage2 {
	WebDriver driver;
	//使用的是pageFactory，页面工厂写法
	//selenium提供的注解@FindBy
	//注解有二个参数，第一个参数是定位方式，写成how = How.NAME，等位是用NAME定位
	//大写How是个类，小写how是一个参数，用How类定义NAME元素
	//第二个参数是using等于xpath的属性值
	@FindBy(how = How.NAME,using = "user_email")
	//userEmailWE类型的一个变量是userEmailWE
	//邮箱的变量名，在网页上找到元素赋值给userEmailWE变量
	WebElement userEmailWE;	
	@FindBy(how = How.NAME,using = "msg_type")
	//list集合，类型是WebElement，变量是msgTypeList
	List<WebElement> msgTypeList;
	
	@FindBy(how = How.NAME,using = "msg_title")
	WebElement titleWE;
	
	@FindBy(how = How.NAME,using = "msg_content")
	WebElement contentWE;
	
	@FindBy(how = How.XPATH,using = "//*[@value='我要留言']")
	WebElement buttonWE;
	
	String url = "http://localhost//ecshop/upload/message.php";
	
	//构造方法调用PageFactory的方法initElements，需要二个参数，driver，this这个类自己
	public MessagePage2(WebDriver driver){
		this.driver = driver;
		//在构造方法中执行这个代码用PageFactory必须执行这个方法
		//使用PageFactory，会自动初始化元素，定位元素
		//和FindBy一起用的，把元素从网页中找到
		PageFactory.initElements(driver, this);
	}
	
	//打开留言板页面
	public void get(){
		driver.get(url);
	}
	
	//发送留言
	public HomePage2 sendMessage(String email,int msgTypeIndex,String title,String content) throws InterruptedException{
		 if (userEmailWE.getAttribute("value").equals("")){
			 userEmailWE.sendKeys(email);
		  }
		  msgTypeList.get(msgTypeIndex).click();
		  titleWE.sendKeys(title);
		  contentWE.sendKeys(content);
		  buttonWE.click();
		  Thread.sleep(3000);
		  return new HomePage2(driver);
	}

}
