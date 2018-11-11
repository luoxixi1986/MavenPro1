package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import ecshop.page.AdvancedSearchPage;

public class BaseTest {
	public WebDriver driver;
	
	  @BeforeMethod
	  //testng.xml测试套件配置要和要和工具类一致,可以执行多个游览器
	  @Parameters({"browser"})
	  public void beforeMethod(String b) {
		  driver = Utils.openBrowser(b);
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }


}
