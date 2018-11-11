package tedu;



import utils.Utils;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestFrame4 {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("file:///C:/example/main1.html");
	  WebElement wel = driver.findElement(By.name("f1"));
	  Utils.switchFrame(wel);
	  Utils.inputValue(driver.findElement(By.id("input1")),"123456");
	  //切换到默认主网页，才能在切换f2
	  Utils.switchToDefault();
	  WebElement we2 = driver.findElement(By.name("f2"));
	  Utils.switchFrame(we2);
	  Utils.inputValue(driver.findElement(By.id("input2")),"654321");
	  Utils.sleep(2000);
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = Utils.openBrowser("firefox");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
