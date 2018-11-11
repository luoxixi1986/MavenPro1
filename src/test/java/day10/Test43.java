package day10;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test43 {
	WebDriver driver;
	//给这个MessagePage1类，设置一个变量
	MessagePage1 mp1;
	
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
	public void testSendMessage() throws Exception {
		//新建一个 MessagePage1调用这个构造方法，把数据转到个构造方法，就可以new出来了
		//创建一个对象，把值赋值给mp1类的构造方法，mp1所有的方法都可以使用driver启动页面元素
		mp1 = new MessagePage1(driver);
		//get打开网页
		mp1.get();
		mp1.sendMessage("abc@163.com", 1, "aaaaaaaa", "bbbbbbb");
	}
}

