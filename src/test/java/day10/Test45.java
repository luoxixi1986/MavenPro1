package day10;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test45 {
	WebDriver driver;
	MessagePage2 mp2;
	HomePage2 hp2;
	LoginPage2 lp2;
	
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
	
	//登录、留言、退出
	@Test
	public void testSendMessage() throws Exception {
		hp2 = new HomePage2(driver);
		hp2.get();
		lp2 = hp2.toLoginPage();
		hp2 = lp2.login("luoxixi", "luoxixi123456");
		mp2 = hp2.toMessagePage();
		hp2 = mp2.sendMessage("abc@163.com", 1, "aaaaaaaa", "bbbbbbb");
		hp2.logout();
	}
	
	
	//登录、退出
	@Test
	public void testLoginLogout() throws Exception {
		hp2 = new HomePage2(driver);
		hp2.get();
		lp2 = hp2.toLoginPage();
		hp2 = lp2.login("zhengxj", "123456");
		hp2.logout();
	}
}
