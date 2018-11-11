package day04;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class Test8 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
//    driver = new FirefoxDriver();
//	FirefoxProfile profile = new FirefoxProfile();
//	profile.setPreference("dom.ipc.plugins.enabled", false);
//	driver = new FirefoxDriver(profile);
	//启动Chrome
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	driver = new ChromeDriver();
    baseUrl = "http://172.166.100.59/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTC0311() throws Exception {
    driver.get(baseUrl + "/ws/ecshop/upload/index.php");
    driver.findElement(By.id("keyword")).clear();
    driver.findElement(By.id("keyword")).sendKeys("a");
    driver.findElement(By.name("imageField")).click();
    assertEquals("4", driver.findElement(By.cssSelector("b")).getText());
  }
  
  @Test
  public void testTC0312() throws Exception {
    driver.get(baseUrl + "/ws/ecshop/upload/index.php");
    driver.findElement(By.cssSelector("#ECS_MEMBERZONE > a > img")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("zhengxj");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.name("submit")).click();
    assertTrue(isElementPresent(By.linkText("退出")));
    driver.findElement(By.linkText("退出")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
