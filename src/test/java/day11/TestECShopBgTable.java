package day11;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class TestECShopBgTable {
	WebDriver driver;
  @Test
  public void f() {
	 //打开ECShop前台首页
	 driver.get("http://localhost/ecshop/upload/admin/privilege.php?act=login");
	 //登录
	 driver.findElement(By.name("username")).sendKeys("admin");
	 driver.findElement(By.name("password")).sendKeys("admin123");
	 //验证码，用万能验证码
	 driver.findElement(By.name("captcha")).sendKeys("0");
	 //点击管理中心
	 driver.findElement(By.className("button")).click();
	 Utils.sleep(2000);
	 //进入商品列表页面,switchTo()句柄切换框架frame
	 driver.switchTo().frame("menu-frame");
	 //点击商品列表链接
	 driver.findElement(By.linkText("商品列表")).click();
	 Utils.sleep(3000);
	 //先切换到默认网页
	 driver.switchTo().defaultContent();
	 //在切换到main-frame
	 driver.switchTo().frame("main-frame");
	 //输入关键字，点击搜索
	 driver.findElement(By.name("keyword")).sendKeys("a");
	 //点击搜索按钮,使用层级切换
	 driver.findElement(By.name("searchForm")).findElement(By.className("button")).click();
	 Utils.sleep(2000);
	 //1.断言商品数据行有3个(存在td子元素的tr个数)
	 //获取tr个数是size()，必须和findElements定位多个元素使用
	 ////div[@id='listDiv']/table[1]/tbody/tr[td] --获取相对路径元素是id属性是listDiv，tr[td],是tr中是td的子节点
	 assertEquals(driver.findElements(By.xpath("//div[@id='listDiv']/table[1]/tbody/tr[td]")).size(),3);
	 //2.断言商品数据行有3个(存在td子元素的tr个数)
	 //2-1、构建一个数组，存储列名的预期值
	 String[] expColNames = {"编号","商品名称","货号","价格","上架","精品","新品","热销","推荐排序","库存","操作"};
	 //2-2、断言列数正确(第1个tr下的th个数)
	 List<WebElement> colList = driver.findElements(By.xpath("//div[@id='listDiv']/table[1]/tbody/tr[1]/th"));
	 //获取的值和预期的列名的长度是一样的，列数都是正确的
	 assertEquals(colList.size(),expColNames.length);
	 //2-3、获得前10个列的元素(所有可以排序的链接类型的列)
	 //查看有a标签的列
	 List<WebElement> list2 = driver.findElements(By.xpath("//div[@id='listDiv']/table[1]/tbody/tr[1]/th/a"));
	 //2-4、断言前10个列的列名正确
	 //i=0，从第一个元素开始获取，0到9个元素
	 for (int i=0;i<list2.size();i++) {
		 //list2.get(i).getText()获取实际页面中列的内容
		 //expColNames[i]获取数组中的值
		 assertEquals(list2.get(i).getText(),expColNames[i]);
	 }
		 //2-5、断言第11列的列名正确
		 //findElement获取单个元素可用用getText()
		 assertEquals(driver.findElement(By.xpath("//div[@id='listDiv']/table[1]/tbody/tr[1]/th[11]")).getText(),expColNames[10]);
		 //查看这个元素是否出现了
		 //3-1、检验编号列名后存在降序的图片
		 assertTrue(isElementPresent(By.xpath("//div[@id='listDiv']/table[1]/tbody/tr[1]/th[1]/img[contains(@src,'sort_desc')]")));
		 //3-2、获取编号第1列的所有数据(有效数据行中的第一列的文本内容)
		 //WebElement对象的集合
		 List<WebElement> resGoodsNumList = driver.findElements(By.xpath(".//*[@id='listDiv']/table[1]/tbody/tr/td[1]"));
		 //3-3、定义整型数组存放所有商品的编号
		 //获取一共多少列
		 //实例化一个数组，数组的名称叫nums，数组的长度，size()
		 int[] nums = new int[resGoodsNumList.size()];
		 //循环获取数据，把list的文本都获得到，转换成整型。存储在我们的数组里
		 //减1的元素是我们获取的长度是从1开始的，我们从0开始循环，所有减1
		 for (int i=0;i<resGoodsNumList.size();i++) {
			 //Integer.parseint()就是把整形对象Integer转换成基本数据类型int（整数）
			 //resGoodsNumList.get(i).getText()，获取对象集合中的文本内容转换成整数，存放到编号为i的数组元素中，从第一个元素开始存储
			 //i从0做循环一致到i减1
			 nums[i] = Integer.parseInt(resGoodsNumList.get(i).getText());
			 //3-4、循环内部，每次存储数组都要检查从第2行开始的每个商品编号都比上一个商品的编号小或等于它。
			 //要从第2行开始，i=0代表处理的是第一行数据，只有大于等于1才是暑处理第2行数据
			 if (i>=1) {
				 //每次断言条件都是成立的
				 //nums[i]检查这一行，
				 //nums[i-1]检查上一行 
				 //当前行总是比上一行小，断言整个商品按照降序排列的
				 assertTrue(nums[i]<=nums[i-1]);
				 Utils.sleep(2000);
			 }
		 }
		 //4.断言点击库存的连接后，按照库存量降序排列
		 //4-1、点击库存,后出现小的图片
		 driver.findElement(By.id("listDiv")).findElement(By.linkText("库存")).click();
		 Utils.sleep(5000);
		 
		 //4-2、检查库存列名后出现一个降序的图片 库存连接的同级同父的后续节点存在一个图片，他的文件名称中包含sort-desc文本的
		 assertTrue(isElementPresent(By.xpath("//a[text()='库存']/following-sibling::img[contains(@src,'sort_desc')]")));
		 //4-3、获取库存列的所有数据(有效数据行的第10列的文本内容)
		//WebElement对象的集合
		 List<WebElement> resGoodsCountList = driver.findElements(By.xpath("//div[@id='listDiv']/table[1]/tbody/tr/td[10]/span"));
		 //第10列存储到列表里
		 //4-4、定义整数数组存放所有商品库存量
		 //数组名叫counts，数组的长度resGoodsCountList.size()得到的长度，list列表元素获得文本
		 int[] counts = new int[resGoodsCountList.size()];
		 //i从0开始，获取list列表中的WebElement对象集合数
		 for (int i=0;i<resGoodsCountList.size();i++) {
			 //Integer.parseint()就是把整形对象Integer转换成基本数据类型int（整数）
			 //resGoodsNumList.get(i).getText()，获取对象集合中的文本内容转换成整数，存放到编号为i的数组元素中，从第一个元素开始存储
			 //i从0做循环一致到i减1
			 counts[i] = Integer.parseInt(resGoodsCountList.get(i).getText());
			 //循环的内容进行检查，第一条数据不检查
			 //4-5、检查从第2行商品开始，每个商品的库存量都小于或等于上一商品的库存量
			 if(i>=1) {
				 //每次断言条件都是成立的
				 //nums[i]检查这一行，
				 //nums[i-1]检查上一行 
				 //当前行总是比上一行小，断言整个商品按照降序排列的
				 assertTrue(counts[i]<=counts[i-1]);
				 Utils.sleep(2000);
			 }
		 }
		 //5.检查搜索后所有商品 商品名称 或 货号中包含a(不区分大小写)
		 //5-1、定义变量用于存储每行的商品名称和货号
		 String goodsName,goodsNum;
		 //5-2、获得所有商品行(包含td子元素的tr)
		 //得到商品行，作为依据得到列表
		 List<WebElement> resGoodsList = driver.findElements(By.xpath("//div[@id='listDiv']/table[1]/tbody/tr[td]"));
		 //5-3、循环遍历所有商品行
		 //获取每一行
		 for (WebElement row:resGoodsList) {
			 //5-4、获得每行的商品名称和货号
			 //获取第2列,获取每一行中的第2列
			 //获得商品名称
			 goodsName = row.findElement(By.xpath("//td[2]/span")).getText();
			 //获得商品货号
			 goodsNum = row.findElement(By.xpath("//td[3]/span")).getText();
			 //5-5、断言每行的商品名称和货号中包含a
			 //断言商品名称和商品货号连接在一起，转换成小写toLowerCase()，是否包含a --contains
			 assertTrue((goodsName+goodsNum).toLowerCase().contains("a"));
		 }
		 //6.点击编号列前的复选框，检查所有数据行中编号前的复选框都被选中
		 driver.findElement(By.xpath("//a[text()='编号']/preceding-sibling::input[contains(@onclick,'selectAll')]")).click();
		 //6-2、获得所有商品行的编号复选框
		 //获得所有复选框的所有列表
		 List<WebElement> chkboxList = driver.findElements(By.xpath("//div[@id='listDiv']/table[1]/tbody/tr/td[1]/input"));
		 //6-3、断言所有复选框都被选中
		 //chkboxList对象集合，元素遍历给chkbox
		 for (WebElement chkbox:chkboxList) {
			 //断言这个返回值是true，选中的
			 assertTrue(chkbox.isSelected());
		 }
		 Utils.sleep(1000);
		 //8-1.点击编辑前，获取第二行数据第4列价格的值
		 //价格的预期值
		 String goodsPriceExp = driver.findElement(By.xpath(".//*[@id='listDiv']/table[1]/tbody/tr[4]/td[4]/span")).getText();
		 //7.点击第二行操作列的第二个图标编辑，断言跳转到商品编辑的页面
		 //7-1。点击第二行操作列的第二个图标编辑
		 driver.findElement(By.xpath("//div[@id='listDiv']/table[1]/tbody/tr[4]/td[11]/a[2]/img")).click();
		 //7-2、断言跳转到商品编辑的页面
		 assertTrue(isElementPresent(By.xpath("//*[@id='search_id' and contains(text(),'编辑商品信息')]")));
		 Utils.sleep(2000);
		 //8.断言商品编辑页面显示，本店售价等于编辑点击之前表格中该行数据显示的价格
		 //8-2.点击编辑后，获得商品的本店售价
		 //getAttribute("value"),可用获得文本框内容
		 String goodsPriceAct = driver.findElement(By.name("shop_price")).getAttribute("value");
		 //断言实际值和预期值是否相等
		 assertEquals(goodsPriceAct,goodsPriceExp);
		 //切换框架，先切换到默认的框架
		 driver.switchTo().defaultContent();
		 //切换header-frame
		 driver.switchTo().frame("header-frame");
		 driver.findElement(By.linkText("退出"));
		 Utils.sleep(2000);
		 
  }
  //私有方法断言元素出现了,布尔值真或假
  private boolean isElementPresent(By by) {
	  try {
		  //启动驱动页面，查看元素，如果存在就返回真
		  driver.findElement(by);
		  return true;
		  //没有这个元素异常
	  }catch (NoSuchElementException e) {
		  //不存在就返回false
	  return false;
	  }
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
