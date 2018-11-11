package day05;

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

public class Test16 {
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
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTC0331() throws Exception {
    driver.get(baseUrl + "/ws/ecshop/upload/index.php");
    driver.findElement(By.id("keyword")).clear();
    driver.findElement(By.id("keyword")).sendKeys("abcd");
    driver.findElement(By.name("imageField")).click();
    assertEquals("0", driver.findElement(By.cssSelector("b")).getText());
    assertTrue(isElementPresent(By.cssSelector("div.f5")));
    assertEquals("无法搜索到您要找的商品！", driver.findElement(By.cssSelector("div.f5")).getText());
  }
  
  @Test
  public void testTC0332() throws Exception {
    driver.get(baseUrl + "/ws/ecshop/upload/index.php");
    driver.findElement(By.name("imageField")).click();
    assertEquals("请输入搜索关键词！", closeAlertAndGetItsText());
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
