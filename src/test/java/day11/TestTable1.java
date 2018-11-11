package day11;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class TestTable1 {
	WebDriver driver;
  @Test
  public void f() {
	  //打开example下的table.html
	  driver.get("file:///C:/example/table.html");
	  //断言表格中数据行数,实际值和预期值
	  //findElements。TagName(tr) 方法会使用指定的标签名返回所有的元素,tagName标签名
	  //size()获取个数
	  assertEquals(driver.findElements(By.tagName("tr")).size(),6);
	  //断言第2行的列数
	  assertEquals(driver.findElements(By.xpath("//table/tbody/tr[2]/td")).size(),3);
	  //断言第3行的列数
	  //get(2)获取第3行，从0开始，在找一下标签名称为td列的个数
	  //findElements定位多个元素
	  assertEquals(driver.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")).size(),3);
	  //断言第4行
	  //findElement获取单个元素tagName标签
	  assertEquals(driver.findElement(By.xpath("//table//tr[4]/td[3]")).getText(),"$650.00");
  } 
  
  @Test
  public void f1() {
	  //打开example下的table2.html
	  driver.get("file:///C:/example/table2.html");
	  //断言一下第一个表格数据的行数
	  assertEquals(driver.findElements(By.xpath("//table[1]//tr")).size(),2);
	  //断言一下第二个表格的数据行数
	  assertEquals(driver.findElements(By.xpath("//table[2]//tr")).size(),3);
	  //断言第一个表格第1行的列
	  assertEquals(driver.findElements(By.xpath("//table[1]//tbody/tr[1]/th")).size(),2);
	 //断言第一个表格第2行的列
	 assertEquals(driver.findElements(By.xpath("//table[1]//tbody/tr[2]/td")).size(),3);
	 //断言第二个表格第2行的列数(包含表头)
	 //星号代表获取trhang下所有列元素
	 assertEquals(driver.findElements(By.xpath("//table[2]/tbody/tr[2]/*")).size(),2); 
	//断言第二个表格第2行的列数(不包含表头)
	 //td获取所有列，th是表头
	 assertEquals(driver.findElements(By.xpath("//table[2]/tbody/tr[2]/td")).size(),1); 
	//断言第三个表格第2行的列数(没有表头)
	assertEquals(driver.findElements(By.xpath("//table[2]/tbody/tr[2]/td")).size(),1); 
	//断言第一个表格中第2行第3列的文本数据
   assertEquals(driver.findElement(By.xpath("html/body/table[1]/tbody/tr[2]/td[3]")).getText(),"555 77 855");
   //断言第二个表格中第2行的第1个数据列(不包含表头)的文本数据
   assertEquals(driver.findElement(By.xpath("html/body/table[2]/tbody/tr[2]/td[1]")).getText(),"555 77 854");
  }
  
  @Test
  public void f2() throws Exception {
	  //打开example下的table.html
	  driver.get("file:///C:/example/table.html");
	  //输出该网页内表格中所有单元格中的数据
	  //List集合
	  List<WebElement> trs = driver.findElements(By.tagName("tr"));
	  //遍历所有的循环，遍历trs集合给row，遍历行
	  for(WebElement row:trs) { 
		  //当前行是不是表头的行th
		  //查看这个列表是否为空
		  List<WebElement> ths = row.findElements(By.tagName("th"));
		  //判断一下th标签元素个数
		  //当前th不等于0，代表当前遍历的行是一个表头所在的行，第一行和最后一行是th标签，中间行是td标签
		  if(ths.size() != 0) {
			  //如果当前行是一个表头
			  //遍历表头行的所有列，每个列称为一个单元格
			  for(WebElement cell:ths) {
				  //输出单元格的数据
				  System.out.println(cell.getText());				  
			  } 
			  //除了表头以外的中间行
		  }else {
			  //获得中间行的所有单元格
			  List<WebElement> tds = row.findElements(By.tagName("td"));
			  //对列进行遍历操作
			  //遍历中间行的所有列
			  for(WebElement cell:tds) {
				  //输出文本结果，显示在控制台上
				  System.out.println(cell.getText());	
			  }	  
		  }
	  }  
  }
  
  
  @Test
  public void f3() throws Exception {
	  //打开example下的table.html
	  driver.get("file:///C:/example/table.html");
	  //输出该网页内表格中所有单元格的文本数据---简化写法
	  //获取所有tr下的元素包括表头和列
	  List<WebElement> cells = driver.findElements(By.xpath("//table/tbody/tr/*"));
	  //遍历所有单元格
	  for(WebElement cell:cells) { 
		  //输出文本结果，显示在控制台上
		  System.out.println(cell.getText());
	  }
  }
  
  @Test
  public void f4() throws Exception {
	  //打开example下的table.html
	  driver.get("file:///C:/example/table.html");
	  //向第5行第2列的第一个文本框输入alice
	  driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]/input[1]")).sendKeys("alice");
	  //向第5行第2列的第二个文本框输入smith
	  driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]/input[2]")).sendKeys("smitch");
	  Utils.sleep(3000);
	  //循环选中第5行第3列的所有复选框
	  //获得一个复选框列表，用WebElement提取出来
	  List<WebElement> chkboxList = driver.findElements(By.xpath("//table//tr[5]/td[3]/input"));
	  //for循环列表WebElement集合数据，赋值给chkbox
	  for(WebElement chkbox:chkboxList) {
		  //通过点击动作进行循环操作
		  chkbox.click();	  
	  }
	  Utils.sleep(3000);	  
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
