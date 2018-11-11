//第一层是执行测试流程(赋值值)，第二层是调用模块的方法，第三层是执行模块中的元素步骤

package testdemoday3;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Dl_Tj_Cx_TestCases {
	private WebDriver driver;
	private String baseUrl;
	 @BeforeTest()
	    public void beforeTest() {
		 driver = new InternetExplorerDriver();
		 //隐试等待时间默认不超过30秒
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	       
	    }

	    @AfterTest()
	    public void afterTest() {
	    	//driver.quit();
	    }
	
	
	@Test
	//线程中断异常
  public void dltjch() throws InterruptedException {
		//新建一个类，调用方法
		new zuoyeLoginBusiness_20181103(driver).denglu("admin", "admin", "1111", "http://localhost:8040/");
		String arg[] ={"xiaowang","男性","小wang","15210251101","开发部","15210251101","项目负责人","86916601@qq.com","java开发","10","123456"};
		String username="";
		username=new zuoyetianjiaBusiness_20181103(driver).tianjia(arg);
		new zuoyetchaxunBusiness_20181103(driver).chaxun(username, "可用");
  }

}


