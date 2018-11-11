package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//留言板页面
//如果想调用网页就把构造方法的driver传递给他，这样这个类就有这个driver页面驱动的值了
public class MessagePage1 {
	//定义一个driver变量
	WebDriver driver;
	//设置一个常量
	String url = "http://localhost//ecshop/upload/message.php";
	//定义构造方法没有返回值，方法名和类名相同，把WebDriver传递进来这个driver变量
	public MessagePage1(WebDriver driver){
		//用this.driver当前变量接收参数变量
		//这个类就用driver的值，就可以调用了
		//this只自己的driver变量，等于右边值参数
		this.driver = driver;
	}
	
	//打开留言板页面
	public void get(){
		//打开这个网页进入网页
		//get方法打开页面
		driver.get(url);
	}
	
	//发送留言
	//抛异常线程中断的异常
	//调用参数可以使用不同组数据，有4个参数，邮箱，编号类型，主题，内容4个参数
	public void sendMessage(String email,int msgTypeIndex,String title,
			String content) throws InterruptedException{
		 WebElement e = driver.findElement(By.name("user_email"));
		  if (e.getAttribute("value").equals("")){
			  e.sendKeys(email);
		  }
		  //get获取编号，0为第一个编号
		  //findElements获取多个元素，get获取编号是msgTypeIndex
		  driver.findElements(By.name("msg_type")).get(msgTypeIndex).click();
		  driver.findElement(By.name("msg_title")).sendKeys(title);
		  driver.findElement(By.name("msg_content")).sendKeys(content);
		  driver.findElement(By.xpath("//*[@value='我要留言']")).click();
		  Thread.sleep(3000);
	}

}
