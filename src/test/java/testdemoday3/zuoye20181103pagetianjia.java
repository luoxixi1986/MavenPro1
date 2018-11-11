package testdemoday3;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class zuoye20181103pagetianjia {

	private WebDriver driver;

	public zuoye20181103pagetianjia(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 打开测试URL
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */

	public void GoToUrl(String url) throws InterruptedException {
		this.driver.get(url);
		Thread.sleep(1000);
	}

	public void clickadd() throws NotFoundException, InterruptedException {
		kuangjia(3);
		driver.findElement(By.name("record_record_addRecord")).click();
		tiaozhuanchuangkou("增加人员维护");

	}

	public void clickrenyuan() throws NotFoundException {
		kuangjia(1);
		//动作，键盘和鼠标操作
		Actions build = new Actions(driver);
		build.click(driver.findElement(By.id("ri2"))).perform();
	}

	private void tiaozhuanchuangkou(String title) throws InterruptedException {
		String hand =driver.getWindowHandle();//获取当前句柄
		//Set是集合,同种对象的集合,对象都是String类型的对象
		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
		//通过循环获取所有窗口放到handle里
		for (String handle : handles) {
			//通过for循环把每个窗口切换一遍
			driver.switchTo().window(handle);// 放循环前面不会漏掉页面
			Thread.sleep(5000);
			//如果窗口的标题是增加人员维护切换成功
			if (driver.getTitle() == title) {
				//停止循环
				break;
			}

		}
	}
	//String arg[] ={"xiaowang","男性","小wang","15210251101","开发部","15210251101","项目负责人","86916601@qq.com","java开发","10","123456"};
	public String setuseruuid(String userText) throws NotFoundException {
		//Math.random()获取0到1直接的随机数乘以1000
		//强制转换为整型，赋值给x
		int x = (int) (Math.random() * 1000);
		this.setText(driver.findElement(By.id("record:useruuid")), userText + x);
		//返回值就是xiaowang拼接随机数
		return userText+x;
	
	}
	//arg=男性
	//数据都在测试步骤中，修改测试步的数据就可以选择不同的内容了
	public void setsex(String arg) throws NotFoundException {
		//定位元素位置赋值给sex的WebElement类型
		WebElement sex = driver.findElement(By.id("record:sex"));
		//点击元素
		sex.click();
		//判断如果是未知的性别，就点击向下按键，在回车男性
		//arg数组等于未知的性别就执行它，这里写死了获取的是
		if (arg.equals("未知的性别")) {
			sex.sendKeys(Keys.DOWN);
			sex.sendKeys(Keys.ENTER);
		//所有就是else执行
		} else if(arg.equals("男性")) {
			//点击元素后，在有键盘点击向下键
			sex.sendKeys(Keys.DOWN);
			sex.sendKeys(Keys.DOWN);
			sex.sendKeys(Keys.ENTER);
		}
		else if(arg.equals("女性")) {
			sex.sendKeys(Keys.DOWN);
			sex.sendKeys(Keys.DOWN);
			sex.sendKeys(Keys.DOWN);
			sex.sendKeys(Keys.ENTER);
		}
		else if(arg.equals("未说明性别")) {
			sex.sendKeys(Keys.DOWN);
			sex.sendKeys(Keys.DOWN);
			sex.sendKeys(Keys.DOWN);
			sex.sendKeys(Keys.DOWN);
			sex.sendKeys(Keys.ENTER);
		}
	}
	//passText=小wang
	public void setyname(String passText) throws NotFoundException {
		
		this.setText(driver.findElement(By.id("record:name")), passText);
	}

	public void setphone(String userText) throws NotFoundException {

		this.setText(driver.findElement(By.id("record:phone")), userText);
	}

	public void setdepartment(String passText) throws NotFoundException {

		this.setText(driver.findElement(By.id("record:department")), passText);
	}

	public void setmobile(String passText) throws NotFoundException {

		this.setText(driver.findElement(By.id("record:mobile")), passText);
	}

	public void setroleuuid(String arg) throws NotFoundException {

		WebElement roleuuid = driver.findElement(By.id("record:roleuuid"));
		roleuuid.click();
		if (arg.equals("系统管理")) {
			roleuuid.sendKeys(Keys.DOWN);
			roleuuid.sendKeys(Keys.ENTER);
		} else if(arg.equals("开发人员")) {
			roleuuid.sendKeys(Keys.DOWN);
			roleuuid.sendKeys(Keys.DOWN);
			roleuuid.sendKeys(Keys.ENTER);
		}
		else if(arg.equals("项目管理")) {
			roleuuid.sendKeys(Keys.DOWN);
			roleuuid.sendKeys(Keys.DOWN);
			roleuuid.sendKeys(Keys.DOWN);
			roleuuid.sendKeys(Keys.ENTER);
		}
		else if(arg.equals("项目负责人")) {
			roleuuid.sendKeys(Keys.DOWN);
			roleuuid.sendKeys(Keys.DOWN);
			roleuuid.sendKeys(Keys.DOWN);
			roleuuid.sendKeys(Keys.DOWN);
			roleuuid.sendKeys(Keys.ENTER);
		}

	}

	public void setemail(String passText) throws NotFoundException {

		this.setText(driver.findElement(By.id("record:email")), passText);
	}

	public void setability(String arg) throws NotFoundException {

		WebElement setability = driver.findElement(By.id("record:ability"));
		setability.click();
		if (arg.equals("java开发")) {
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.ENTER);
		} else if(arg.equals("管理人员")) {
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.ENTER);
		}
		else if(arg.equals("flex开发")) {
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.ENTER);
		}
		else if(arg.equals("系统架构设计")) {
			setability.click();
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.ENTER);
		}
		else if(arg.equals("美工")) {
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.ENTER);
		}
		else if(arg.equals("C#开发")) {
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.DOWN);
			setability.sendKeys(Keys.ENTER);
		}

		
		
	}

	public void setjobyear(String passText) throws NotFoundException {

		this.setText(driver.findElement(By.id("record:jobyear")), passText);
	}

	public void setmemo(String passText) throws NotFoundException {

		this.setText(driver.findElement(By.id("record:memo")), passText);
	}

	public void clickrecord_record_saveAndExit() throws NotFoundException {
		driver.findElement(By.name("record_record_saveAndExit")).click();
	}

	public void clickrecord_record_goBack() throws NotFoundException {
		driver.findElement(By.name("record_record_goBack")).click();
	}

	private void setText(WebElement e, String text) {
		e.clear();
		e.sendKeys(text);
	}

	private void kuangjia(int text) {
		driver.switchTo().defaultContent();// 跳到默认
		driver.switchTo().frame(text);

	}

}