package day07;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class Test25 {
	WebDriver driver;
	private boolean acceptNextAlert = true;
	
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
	public void testa() throws Exception {
//		ECShop前台页面
		driver.get("http://localhost//ecshop/upload/index.php");
//		断言搜索区域分类的下拉框默认选项是“所有分类”
		Select s1 = new Select(driver.findElement(By.id("category")));
		String t1 = s1.getFirstSelectedOption().getText();
		assertEquals("所有分类",t1);
//		再选择“     GSM手机”，
		s1.selectByVisibleText("    GSM手机");
//		输入关键字“a”
		driver.findElement(By.id("keyword")).sendKeys("a");
//		点击“搜索”，
		driver.findElement(By.name("imageField")).click();
//		断言页码区域统计个数是4，
		String c1=driver.findElement(By.tagName("b")).getText();
		assertEquals("4",c1);
//		断言搜索结果区域显示的商品信息有4个
		List<WebElement> divs=driver
			.findElements(By.className("goodsItem"));
		assertEquals(4,divs.size());
//		断言排序默认是"按照上架时间排序”
		Select s2=new Select(driver.findElement(By.name("sort")));
		assertEquals("按上架时间排序",
				s2.getFirstSelectedOption().getText());
//		并且是“倒序”，
		Select s3=new Select(driver.findElement(By.name("order")));
		assertEquals("倒序",s3.getFirstSelectedOption().getText());
//		选择包含“更新时间”的选项
		for(WebElement o:s2.getOptions()){
			if (o.getText().contains("更新时间")){
				o.click(); //点击选项来选中该选项
				break;
			}
		}
//		按照选项的	value值来选择“正序”
		s3.selectByValue("ASC");
		Thread.sleep(3000);
	}

	
	@Test
	public void testb() throws Exception {
//		ECShop前台页面中
		driver.get("http://localhost/ws/ecshop/upload/index.php");
//		点击“高级搜索”
		driver.findElement(By.linkText("高级搜索")).click();
//		在“扩展选项”下拉框中选择“精品手机”
		Select s1 = new Select(
				driver.findElement(By.name("goods_type")));
		s1.selectByVisibleText("精品手机");
//		断言价格下限文本框的值是0
		assertEquals("0",driver.findElement(
				By.id("min_price")).getAttribute("value"));
//		断言颜色的下拉框出现
		assertTrue(isElementPresent(By.name("attr[185]")));
//		选择“白色”
		Select s2 = new Select(
				driver.findElement(By.name("attr[185]")));
		s2.selectByVisibleText("白色");
//		断言隐藏已脱销的商品的复选框的状态是默认未被选中
		assertFalse(driver.
				findElement(By.id("outstock")).isSelected());
//		点击“立即搜索”
		driver.findElement(By.name("Submit")).click();
	}
	
	@Test
	public void testc() throws Exception {
		driver.get("http://localhost/ws/ecshop/upload/index.php");
		//点击“搜索”
		driver.findElement(By.name("imageField")).click();
		//断言弹出提示框
		assertTrue(isAlertPresent());
		//断言弹出窗口中的文本内容是否等于“请输入搜索关键词！”
//		acceptNextAlert = false; //如果点击“取消”或“否”时，需要加该行

		String a = closeAlertAndGetItsText();
		assertEquals("请输入搜索关键词！",a);
		//断言弹出窗口中的文本内容是否包含“请输入搜索关键词”

		assertTrue(a.contains("请输入搜索关键词"));
		
	}
	
	@Test
	public void testd() throws Exception {
		//打开登录页
		driver.get("http://localhost/ws/ecshop/upload/user.php");
		//点击“立即登录”
		driver.findElement(By.name("submit")).click();
		//断言提示框出现
		assertTrue(isAlertPresent());
		//断言提示内容包含“用户名不能为空”
		String info = closeAlertAndGetItsText();
//		assertTrue(info.contains("用户名不能为空"));
//		//断言提示内容包含“登录密码不能为空”
//		assertTrue(info.contains("登录密码不能为空"));
		assertTrue(info.contains("用户名不能为空")&&info.contains("登录密码不能为空"));
	}
	
	@Test
	public void teste() throws Exception {
//		ECShop前台首页
		driver.get("http://localhost/ws/ecshop/upload/index.php");
//		输入关键字“a”
		driver.findElement(By.id("keyword")).sendKeys("a");
//		点击"搜索"
		driver.findElement(By.name("imageField")).click();
//		点击“P806”的商品图片
		driver.findElement(
			By.xpath(".//*[@id='compareForm']/div/div/div[1]/a[1]/img"))
			.click();
//		在商品数量中输入1000
		WebElement n = driver.findElement(By.id("number"));
		n.clear();
		n.sendKeys("1000");
//		点击“加入购物车”
		driver.findElement(
				By.xpath(".//*[@id='ECS_FORMBUY']/ul/li[9]/a[1]/img"))
				.click();
		Thread.sleep(3000);
//		断言提示框出现
		assertTrue(isAlertPresent());
//		再断言提示内容包含两行文本(要求点击“取消”来关闭该提示框)
		acceptNextAlert = false;
		String t = closeAlertAndGetItsText();
		assertTrue(t.contains("对不起，该商品已经库存不足暂停销售"));
		assertTrue(t.contains("你现在要进行缺货登记来预订该商品吗"));
		Thread.sleep(3000);
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





