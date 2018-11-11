package tedu;

import org.testng.annotations.Test;

import utils.log;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@Test
public class TestLog4j {
	WebDriver driver;
  public void f() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  Log.info("Baidu page is loaded");
	  Thread.sleep(3000);

  }
  @BeforeMethod
  public void beforeMethod() {
	  Log.info("Try to Open broser");
	  driver =new FirefoxDriver();
	  Log.info("Browser is opened");
  }

  @AfterMethod
  public void afterMethod() {
	Log.info("Try to close browser");
	driver.quit();
	Log.info("Browser is closed");
  }

}
