package day12;

import org.testng.annotations.Test;

import utils.Utils;

import org.testng.annotations.BeforeMethod;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;


//只能对游览器里面进行截图，无法对游览器的弹框进行截图
public class TestScreenShot {
	WebDriver driver;
  @Test
  public void f() {
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  //应为在查找的时候有可能抛出异常
	  try{
		  //查找元素，进行一个点击的动作,输入错误的元素名称
		  driver.findElement(By.id("abcd")).click();
		  //捕获异常，只要有异常就处理
		  }catch(Exception e){
		  //查看源码
		  e.printStackTrace();
		  //截图
		  snapshot(); 
		  }
  }
  
  @Test
  //不能截图，有提示框
  public void f1() {
	  //打开example的js.html
	  driver.get("file:///C:/example/alert.html");
	  //应为在查找的时候有可能抛出异常
		  //查找元素，进行一个点击的动作,输入错误的元素名称
		  driver.findElement(By.id("a1")).click();
		  Utils.sleep(2000);
		  //截图
		  snapshot(); 
  }
  
  @Test
  //全屏截图，有提示框
  public void f2() {
	  //打开example的js.html
	  driver.get("file:///C:/example/alert.html");
	  //应为在查找的时候有可能抛出异常
	  //查找元素，进行一个点击的动作,输入错误的元素名称
	  driver.findElement(By.id("a1")).click();
	  Utils.sleep(2000);
	  //全屏截图
	  takeFullCreenShot(); 
  }
  
  @Test
  public void f3() throws Exception{
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  //定位用户名文本框的页面元素
	  //un用来存储定位到的元素
	  WebElement un = driver.findElement(By.id("username"));
	  //输入数据
	  un.sendKeys("jack");
	  //对用户名文本框截图动作
	  //指定对那个元素做截图了
	  takeScreenShotForElement(un);
	  //定位一下登录按钮做截图
	  WebElement btn = driver.findElement(By.id("submit"));
	  takeScreenShotForElement(btn);
	  
  }
  
  @Test
  public void f4() throws Exception{
	  //打开example的js.html
	  driver.get("http://localhost/ecshop/upload/admin/privilege.php?act=login");
	  Thread.sleep(2000);
	  //定位验证码图片
	 WebElement captImg =  driver.findElement(By.xpath("html/body/form/table/tbody/tr/td[2]/table/tbody/tr[4]/td/img"));
	 //截图，针对这个图片做截图动作
	 takeScreenShotForElement(captImg);
	 //登录
	 driver.findElement(By.name("username")).sendKeys("admin");;
	 driver.findElement(By.name("password")).sendKeys("admin123");
	 //验证码，用万能验证码
	 driver.findElement(By.name("captcha")).sendKeys("0");
	 //点击管理中心
	 driver.findElement(By.className("button")).click();
	 Utils.sleep(2000);
	 //对界面上方显示的内容做截图
	 WebElement hf = driver.findElement(By.id("header-frame"));
	 takeScreenShotForElement(hf);  
  }
  
  @Test
  public void f5() throws Exception{
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  //向用户名文本框输入12345678
	  //存储在WebElement对象中变量名是un
	  WebElement un = driver.findElement(By.id("username"));
	  un.sendKeys("123435678");
	  Utils.sleep(2000);
	  //高亮用户名文本框
	  //定义JavaScript字符串，来给指定的元素设置一个属性为0，设定的属性为style，设定的值是第二个参数
	  //将un代替arguments[0]，将style1代替arguments[1]
	  String js1 = "arguments[0].setAttribute('style',arguments[1]);";
	  //文本框中内容的颜色,设定一下(border:2px)边界的粗心为2个像素和边界的颜色(solid red)
	  String style1 ="color:bule;border:2px solid red";
	  //把driver强制转换成JavascriptExecutor对象，然后调用方法executeScript
	  //第一个参数Javascript字符串作为第一个参数
	  //第二个参数是页面元素un
	  //第三个参数style1,高亮，运行js代码
	  ((JavascriptExecutor)driver).executeScript(js1,un,style1);
	  Utils.sleep(2000);
	  snapshot(); 
	  //取消高亮显示用户名文本框，不设置背景颜色高亮
	  ((JavascriptExecutor)driver).executeScript(js1,un,"");
	  //截图
	  snapshot();
	  Utils.sleep(2000);
  }
  
  @Test
  public void f6() throws Exception{
	  //打开example的js.html
	  driver.get("file:///C:/example/js.html");
	  WebElement un = driver.findElement(By.id("username"));
	  //输入数据
	  un.sendKeys("123435678");
	  Utils.sleep(2000);
	  String js1 = "arguments[0].setAttribute('style',arguments[1]);";
	//文本框中内容的颜色为绿色,设定一下(border:2px)边界的粗心为2个像素和边界的颜色(solid yellow)是黄色
	  String style1 ="color:green;border:4px solid yellow";
	  //driver强制转换成JavascriptExecutor，赋值给一个变量jse，变量类型和driver的要一致   
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  //连续三次高亮后取消高亮的测试
	  for (int i=1;i<=3;i++) {
		  //高亮
		  //jse执行脚本
		  //执行的脚本是js1，脚本执行所需要的参数un要设定高亮显示的元素。style1元素进行高亮
		  jse.executeScript(js1, un,style1);
		  Utils.sleep(1000);
		  //取消高亮,第三个参数不输入代码没有设置边界颜色
		  jse.executeScript(js1, un,"");
		  Utils.sleep(1000);
	  }

	  
  }
  

  /*
   * 对页面中的元素截图
   */
  public void takeScreenShotForElement(WebElement element) {
	  //获得当前工程路径
	  String currentPath = System.getProperty("user.dir");
	  //拼接截图文件存储路径
	  String filePath = currentPath + "\\\\test-output\\\\snapshot";
	  //生成截图文件的名称(系统日期和系统时间组成的字符串)
	  //DateFormat.getDateTimeInstance获取日期和时间的对象实例
	  //format进行格式转换,获取当前系统的时间，时间是有冒号的，必须修改不支持冒号，替换成杠
	  String filename = DateFormat.getDateTimeInstance().format(System.currentTimeMillis()).replace(":","-")+".jpg";
	  //截图的动作放到try里
	  try {
		  //对网页做整体截图
		  //driver强制转换成为TakesScreenshot接口的具体实例，调用方法getScreenshotAs，网页的截图以文件的方式返回
		  //srcFile就是截好的图片文件
		  //现在有了大的图片
		  File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  //获取当前参数所提供的element的坐标位置
		  //这个方法就知道他的位置了
		  //Point存储对象的位置
		  //也有了他左上角坐标位置
		  Point p= element.getLocation();
		  //获得元素的宽度值和高度值
		  //获得尺寸和宽度，宽度是整数
		  int width = element.getSize().getWidth();
		  //获取高度
		  int height = element.getSize().getHeight();
		  //图片的裁剪操作
		  //用read方法将我们srcFile读取到BufferrImage读取返回来的数据
		  BufferedImage image = ImageIO.read(srcFile);
		  //image,提供了一个getSubimage方法
		  //对图片裁剪操作，需要4个参数，位置坐上角，x坐标和y坐标，高度和宽度
		  BufferedImage desc = image.getSubimage(p.getX(), p.getY(), width, height);
		  //将裁剪后的图存储在截图文件中
		  //第一个参数desc裁剪好的小图片，保存在指定的文件中
		  //第二个参数文件格式
		  //第三个保存在哪个文件下
		  //srcFile 裁剪后的小图片
		  ImageIO.write(desc, "jpg", srcFile);
		  //
		  FileUtils.copyFile(srcFile, new File(filePath+"\\"+filename));
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  } 
  
  
  /*
   * 对当前屏幕进行截图
   */
  public void takeFullCreenShot() {
	  //获得当前工程路径
	  String currentPath = System.getProperty("user.dir");
	  //拼接截图文件路径
	  String filePath = currentPath + "\\test-output\\snapshot";
	  //生成截图文件名称(系统日期和时间的名称)
	  //DateFormat.getDateTimeInstance()获取截图名称
	  //format(System.currentTimeMillis())格式化处理
	  //把系统时间都用replace替换，把冒号替换成杠,可用考虑用png格式
	  String filename=DateFormat.getDateTimeInstance().format(System.currentTimeMillis()).replace(":", "-")+".jpg";
	  //截图，有可能抛出io异常
	  try {
		  Utils.sleep(3000);
		  //定义一个矩形的变量，
		  //初始化需要提供屏幕尺寸,的方法Toolkit.getDefaultToolkit().getScreenSize()
		  //把屏幕尺寸的大小封装成一个Rectangle矩形，
		  Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		  //把这个矩形作为作为截图的参数，这样就可以截屏了
		  //BufferedImage生成一个图片，当前的屏幕，截取屏幕用Robot对象
		  //方法叫createScreenCapture，需要一个变量作为参数
		  BufferedImage image = new Robot().createScreenCapture(rec);
		  //把截好的图作为第一个参数，第二个参数是jpg格式的和上面一致，第三个参数存储图片的文件
		  ImageIO.write(image, "jpg", new File(filePath+"\\"+filename));
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  
  }

  /*
   * 对页面截图
   */
  //公共的实现一个方法
  public void snapshot(){
	 //获得当前工程路径
	 //System.getProperty 获取系统属性值，user.dir获取工程路径
	 String currentPath = System.getProperty("user.dir");
	 //拼接截图文件路径
	 //filePath工程路径连接上下一级路径用\\连接，snapshot存储所有截图文件
	  String filePath = currentPath + "\\test-output\\snapshot";
	  //生成系统日期和时间的截图文件名称 
	  //构建截图文件名称(使用系统日期和时间作为文件)
	  //截图文件名称叫filename，通过DateFormat.getDateTimeInstance()获取一个日期和时间的实例
	  //format对当前的日期和日期进行简单的处理，用System.currentTimeMillis获取到日期和时间
	  //用replace替换，把冒号替换成减号，后缀是jpg
	  String filename=DateFormat.getDateTimeInstance().format(System.currentTimeMillis()).replace(":", "-")+".jpg";
	  //截图，有可能抛出io异常
	  try {
		  Utils.sleep(3000);
		  //dirver强制转换成截图的实例，调用getScreenshotAs方法实现动作
		  //getScreenshotAs方法的参数中要制定类型OutputType.FILE，我们使用的是文件类型
		  //把文件类型存储到scrFile文件变量里了
		   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  System.out.println("save snapshot pathis:"+filePath+"\\"+filename);
				  //用FileUtils做一个拷贝的工作
				  //第一参数是我们定义的参数获取文件类型
				  //第二个参数是文件工程的路径加文件名，生成一个文件
				  //就是我们截好图放到我们新文件路径上去了
				  FileUtils.copyFile(scrFile, new File(filePath+"\\"+filename));
				  //截图过程中可能报的异常时IO异常
		   } catch (IOException e) {
			      //控制台输出信息
				  System.out.println("Can't save screenshot");
				  //查看源码
				  e.printStackTrace();
				  //不管截图成功没有成功，都输出语句，代码执行完毕
				  } finally {
					  System.out.println("screen shot finished");
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
