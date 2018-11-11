package ecshop2;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import ecshop.page.AdvancedSearchPage;
import ecshop.page.SearchResultPage;
import utils.ReadFile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAdvancedSearch2 {
	WebDriver driver;
	//asp变量，放到AdvancedSearchPage类中
	AdvancedSearchPage asp;
	SearchResultPage srp;
	
  @Test(dataProvider = "dp")
  //9个参数的顺序要和Excel中一样
  public void f(
		    String kw,//关键字
			String cg,//分类
			String bd,//品牌
			String minp, //最小价格
			String maxp, //最大价格
			String ext, //扩展选择
			String dt, //上市日期
			String cl, //颜色 
			String expCount //预期结果个数
		  ) {
	  asp.get();
	  try {
		srp = asp.advancedSearch(kw, cg, bd, minp, maxp, ext, dt, cl);
		String actCount = srp.getCount();
		assertEquals(actCount,expCount);
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  asp = new AdvancedSearchPage(driver);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
	  //读取Excel文件
	  //return ReadFile.getTestDataFromExcel("C:\\", "数据_ECshop_高级搜索.xls", "高级搜索"); 
	  //读取CSV文件,只有两个参数
	  return ReadFile.getTestDataFromCSVFile("C:\\", "数据_ECshop_高级搜索.csv"); 
  }
}
