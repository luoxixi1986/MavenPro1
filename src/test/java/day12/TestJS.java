package day12;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TestJS {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  //调用JS方式向用户名文本框中输入abcd
	  //有但引号不需要转义
	  String js1 = "document.getElementById('username').setAttribute('value','abced');";
	  Utils.sleep(2000);
	  //要将driver强制转换成一种
	  ((JavascriptExecutor)driver).executeScript(js1);
	  Utils.sleep(2000);	  
  }
  @Test
  public void f2() throws Exception {
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  //要将driver强制转换成一种
	  //单引号不需要转义
	 // ((JavascriptExecutor)driver).executeScript("alert('Hello World!')");
	  //杠转义符\
	  //打开一个提示框为Hello World！
	 //((JavascriptExecutor)driver).executeScript("alert(\"Hello World!\")");
	  //用字符串连接起来
	  String info ="Hello";
	  ((JavascriptExecutor)driver).executeScript("alert('"+info+"')");
	  Utils.sleep(2000);
	  //点击确定关闭弹出框
	  //通过switchTo()方法，进入新的页面，并操作对应元素
	  driver.switchTo().alert().accept();
  } 
  
  @Test
  public void f3() throws Exception {
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  //获取网页中的标题
	  //返回网页标题
	  String js2="return document.title;";
	  //转换成JavascriptExecutor，调用executeScript方法来执行代码块
	  //字符串类型，赋值给字符串变量
	  String t1 = (String)((JavascriptExecutor)driver).executeScript(js2);
	  assertEquals(t1,"执行js");
  } 
  
  @Test
  public void f4() throws Exception {
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  //定义一个变量var存储所有inputs的元素
	  //得到所有input标签的元素，返回input的个数
	  String js3 = "var inputs=document.getElementsByTagName('input'); "
	  		+ "return inputs.length;";
	  //把driver强制转换成driver，在把他转换成long长整型，在执行语句，赋值给inputCount长整型
	  //存储的是input元素标签的个
	  //注意强制转换成long
	  long inputCount = (Long)((JavascriptExecutor)driver).executeScript(js3);
	  assertEquals(inputCount,2);
  } 
  
  @Test
  public void f5() throws Exception {
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  //等待网页加载完毕，查看是否是预期的标题啊
	  //waitForPageLoad1();
	  //waitForPageLoad2();
	  waitForPageLoad3();
	  assertEquals(driver.getTitle(),"执行js");
	  Utils.sleep(2000);
	  
  } 
  
  //方法体中有等待时间，就要抛出异常
  public void waitForPageLoad1() throws Exception {
	  //定义一个JavascriptExecutor执行器，变量名称是jse，把driver变量强制转换成JavascriptExecutor对象
	  JavascriptExecutor jse = ((JavascriptExecutor)driver);
	  //定义一个字符串的JavaScript代码的块，内容是return返回document.readyState
	  //readyState是否加载完成
	  String js4 = "return document.readyState;";
	  //循环语句加载，知道加载完成，执行一次循环等待1秒钟
	  while
	  //complete如果为真，说明加载成功，返回toString字符串类型和complete想等，退出循环，如果为假继续执行循环
	  (!"complete".equals(jse.executeScript(js4).toString()))
	  { 
		  Utils.sleep(1000);
	  }
  }
  
  /*
   * Javascript判断页面的状态
   */
  
  public void waitForPageLoad2() throws Exception {
	  JavascriptExecutor jse = ((JavascriptExecutor)driver);
	  String js4 = "return document.readyState;";
	  //30秒作为超时时间，最多等待30秒
	  for(int i=1;i<=30;i++){
		  //判断complete是否等于返回状态，如果想等就退出循环，如果不相等就等待一秒，继续循环
		  if("complete".equals(jse.executeScript(js4).toString()))
		  {
			  break;
		  }
		  Thread.sleep(1000);
	  }
  }
  
  public void waitForPageLoad3() {
	  //自定义显示等待，driver参数，和一个超时时间30
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  //针对WebDriverWait，用until等待条件出现，isPageLoaded是一个boolean数据，通过这个方法来获得的
	  wait.until(isPageLoaded());
  }
  
  //配置一个isPageLoaded方法，方法返回值是一个ExpectedCondition他里面的数据是boolean数据
  public ExpectedCondition<Boolean> isPageLoaded(){
	  //需要返回这样的数据我们就new一个这样的数据
	  return new ExpectedCondition<Boolean>() {
		  //这个方法是从父类/接口 继承过来的，需要你重写一次，这样就可以方便你阅读,可用不写，就是注释
		  //在这个构造方法里我们要重新apply方法
		  @Override
		  //需要返回的数据是boolean数据，他有一个webDriver参数
			public Boolean apply(WebDriver driver) {
			  //将driver强制转换成JavascriptExecutor类型
			  JavascriptExecutor jse = ((JavascriptExecutor)driver);
			  //还需要一个javascript的一个字符串，返回当前状态
			  String js4 = "return document.readyState;";
			  //执行jse获取他的状态，将我们获得的一个状态还预期进行对比,想等返回trun，不相等返回false
			  return "complete".equals((String)jse.executeScript(js4));	
		  }
	  //teturn 返回值加分号
	  };
  }
  
  /*
   * JavaScript中判断页面元素是否存在
   */
  @Test
  public void f6() throws Exception {
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  //断言密码框存在
	  //JavaScript代码，存在if else基本结构，能找到就return truen 否则就return false
	  String js10="if(document.getElementById('password'))"
	  		+ "{ return true;} else{return false;}";
	  		//driver封装成JavascriptExecutor，封装好的JavascriptExecutor调用executeScript的方法，来执行我们的js10
	  		//返回值是boolean，用不二接收值
		  	boolean result =(Boolean)((JavascriptExecutor)driver).executeScript(js10);
		  	//断言是否为真
		  	assertTrue(result);
  }
  
  /*
   * JavaScript获取元素输入数据
   */
  @Test
  public void f7() throws Exception {
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  //输入密码
	  //创建字符串，返回当前页面元素中的密码，把找到的元素用return 关键字返回过来
	  String js11 = "return document.getElementById('password');";
	  //运行这个元素等到这个元素，封装好，来执行executeScript方法执行js11，强制转换成WebElement数据，存在到WebElement的变量里
	  WebElement pw = (WebElement)((JavascriptExecutor)driver).executeScript(js11);
	  //把获取的pw变量元素密码文本框输入123456
	  pw.sendKeys("123456");
  }
  

  //运行js方式得到一个列表，我们强制转换为一个list类型的数据，就可以操作列表中的每一个元素了
  @Test
  public void f8() throws Exception {
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  //输入用户名和密码
	  //通过一个js获取所有标签名是input的元素
	  //return关键字获取的一组页面元素
	  //getElementsByTagName，标签名称是input
	  String js12 = "return document.getElementsByTagName('input');";
	  //运行js得到所有的input元素，driver强制转换成功JavascriptExecutor，运行JavaScript代码js12，他的返回值是list，list里是WebElment，存放在list的变量里面
	  List<WebElement> inputs =(List<WebElement>)((JavascriptExecutor)driver).executeScript(js12);
	  //list用get0获取第一个数据，输入123
	  inputs.get(0).sendKeys("123");
	  inputs.get(1).sendKeys("456");	  
  }
  
  /*
   * JavaScript点击按钮
   */
  @Test
  public void f9() throws Exception {
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  //arguments[0]，函数调用参数数组，0是调用第一个值
	  String js4="arguments[0].click();";
	  //页面元素定位的一个语句，返回值是WebElement对象，得到一个WebElement对象，命名成buttonElement
	  WebElement buttonElement=driver.findElement(By.id("submit"));
	  //运行executeScript，调用js4，将js4作为第一个参数，应为js4也是需要参数的，他的参数列表是写在他的后面的
	  //点击到登录按钮了
	  ((JavascriptExecutor)driver).executeScript(js4,buttonElement);  
  }
  
  /*
   * 三个参数：
   * arguments[0]是元素
   * arguments[1]属性名
   * arguments[2]属性值
   */
  @Test
  public void f10() throws Exception {
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  //setAttribute需要两个参数一个是属性名，一个是属性值
	  //这个有三个参数，一个元素，一个属性名，一个属性值
	  String js5="arguments[0].setAttribute(arguments[1],arguments[2]);";
	  //用户名和密码，arguments[0]元素是id
	  WebElement we1 = driver.findElement(By.id("username"));
	  WebElement we2 = driver.findElement(By.id("password"));
	  //得到这两个元素之后，接下来我们就可以去生成JavascriptExecutor对象
	  JavascriptExecutor jse = ((JavascriptExecutor)driver);
	  //利用JavascriptExecutor对象运行js代码了
	  //我们使用executeScript方法来运行，第一个参数是我们的js语句，后面填写的是js5所需要的参数，we1属性元素，value属性记录文本框的数值，value属性中设置什么值
	  jse.executeScript(js5,we1,"value","jack");
	  jse.executeScript(js5,we2,"value","123456");
	  Utils.sleep(3000);  
  }
  
  /*
   * JavaScript对日期进行操作
   */
  @Test
  public void f11() throws Exception {
	  //打开example的js.html
	  driver.get("file:///C:/example/calendar.html");
	  //输入文本框控件，用id元素定位train_date，之后移除readonly属性
	  String js="document.getElementById('train_date').removeAttribute('readonly');";
	  //把driver强制转换为JavascriptExecutor，调用executeScript方法调用js参数，这样就可以知晓js去除掉属性
	  ((JavascriptExecutor) driver).executeScript(js);
	  //定位元素进行清空
	  driver.findElement(By.id("train_date")).clear();
	  //在定位元素输出日期
	  driver.findElement(By.id("train_date")).sendKeys("2019-10-01");
	  Utils.sleep(2000);
  }
  
  /*
   * JavaScript对当天日期进行操作生成一个8天后的日期
   */
  @Test
  public void f12() throws Exception {
	  //打开example的js.html
	  driver.get("file:///C:/example/calendar.html");
	  String js="document.getElementById('train_date').removeAttribute('readonly');";
	  ((JavascriptExecutor)driver).executeScript(js);
	  //生成8天后的日期
	  //Calendar获取当前日期，用Calendar.getInstance()方法获取
	  Calendar rightNow =Calendar.getInstance();
	  //生成一个日期格式的转换器，设定好我们希望的日期格式比如yyyy-MM-dd
	  SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	  //得到当前时间，然后+8天
	  //用add方法增加指定的日期数，增加天数，日期的单位Calendar.DAY_OF_MONTH
	  //如果要添加8天前的日期就-8
	  rightNow.add(Calendar.DAY_OF_MONTH, 8);
	  //rightNow.add(java.util.Calendar.DAY_OF_MONTH,-3);
	  //迚行时间转换，sim设定好的格式的实例调用format方法来实现转换
	  //rightNow.getTime()得到这个日期转换我们要的格式
	  String date = sim.format(rightNow.getTime());
	  //输入被测系统的时间文本框中
	  //定位文本框输入日期，清空日期
	  driver.findElement(By.id("train_date")).clear();
	  //获取的是指定的格式加8的日期
	  driver.findElement(By.id("train_date")).sendKeys(date);
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
