package day08;

import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class Test29 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	FirefoxProfile profile = new FirefoxProfile();
	profile.setPreference("dom.ipc.plugins.enabled", false);
	driver = new FirefoxDriver(profile);
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "//ecshop/upload/user.php?act=register");
    
    String name = "zhengxj" + getCurrentTime();
    System.out.println(name);
    
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys(name);
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(name+"@tdu.cn");
    driver.findElement(By.id("password1")).clear();
    driver.findElement(By.id("password1")).sendKeys("123456");
    driver.findElement(By.id("conform_password")).clear();
    driver.findElement(By.id("conform_password")).sendKeys("123456");
    driver.findElement(By.name("extend_field1")).clear();
    driver.findElement(By.name("extend_field1")).sendKeys(name+"@tdu.cn");
    driver.findElement(By.name("extend_field2")).clear();
    driver.findElement(By.name("extend_field2")).sendKeys("12345678");
    driver.findElement(By.name("extend_field3")).clear();
    driver.findElement(By.name("extend_field3")).sendKeys("01012345678");
    driver.findElement(By.name("extend_field4")).clear();
    driver.findElement(By.name("extend_field4")).sendKeys("01087654321");
    driver.findElement(By.name("extend_field5")).clear();
    driver.findElement(By.name("extend_field5")).sendKeys("13012345678");
    new Select(driver.findElement(By.name("sel_question"))).selectByVisibleText("我最好朋友的生日？");
    driver.findElement(By.name("passwd_answer")).clear();
    driver.findElement(By.name("passwd_answer")).sendKeys("123");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.linkText("退出")).click();
    
    //访问ECShop后台首页
    driver.navigate().to("http://172.166.100.59/ws/ecshop/upload/admin/index.php");
    driver.navigate().back(); //后退
    driver.navigate().forward(); //前进
    driver.navigate().refresh(); //刷新当前网页
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
  
  private String getCurrentTime() {
	  Calendar c = Calendar.getInstance();
	  String y = String.valueOf(c.get(Calendar.YEAR));
	  String m = String.valueOf(c.get(Calendar.MONTH));
	  String d = String.valueOf(c.get(Calendar.DATE));
	  String h = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
	  String mm = String.valueOf(c.get(Calendar.MINUTE));
	  String s = String.valueOf(c.get(Calendar.SECOND));
	  return y+m+d+h+mm+s;
  }
  
}



