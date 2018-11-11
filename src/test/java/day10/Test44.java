package day10;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test44 {
	WebDriver driver;
	MessagePage2 mp2;
	
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
		mp2 = new MessagePage2(driver);
		mp2.get();
		mp2.sendMessage("abc@163.com", 1, "aaaaaaaa", "bbbbbbb");
	}
}
