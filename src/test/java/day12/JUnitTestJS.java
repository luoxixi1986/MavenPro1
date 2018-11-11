package day12;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utils.Utils;

public class JUnitTestJS {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = Utils.openBrowser("firefox");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws Exception {
		  //打开example的js.html
		  driver.get("file:///C:/example/js.html");
		  //调用JS方式向用户名文本框中输入abcd
		  //有但引号不需要转义
		  String js1="document.getElementById('username').setAttribute('value','abced');";
		  Utils.sleep(2000);
		  //要将driver强制转换成一种
		  ((JavascriptExecutor)driver).executeScript(js1);
		  Utils.sleep(2000);
	}

}
