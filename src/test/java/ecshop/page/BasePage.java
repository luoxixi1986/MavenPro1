package ecshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.Constants;
import utils.Utils;

public class BasePage {
	WebDriver driver;
	//赋值RUL变量
	String url;
	//构造方法
	public BasePage(WebDriver driver){
		//BasePage方法赋值为当前为形参的方法
		this.driver = driver;
		//对元素进行初始化driver作为第一个参数，把this作为第二个参数
		PageFactory.initElements(driver, this);
	}
	//等待网页的变化
	public BasePage(WebDriver driver, String title) {
		//加载网页
		this.driver = driver;
		//显式等待标题包含预期值
		Utils.explicitWaitTitle(title);
		//对元素进行初始化driver作为第一个参数，把this作为第二个参数
		PageFactory.initElements(driver, this);
	}
		/*
		 * 打开页面
		 * 注意，在子类的网页中如果有执行打开网页的需求，那么需要在构造方法中给url赋值
		 */
		public void get() {
			driver.get(url);
			//显示最大窗口
			//driver.manage().window().maximize();
		}
		
		/*
		 * 获取网页的标题，有返回值
		 * @return
		 */
		
		public String getTitle() {
			return driver.getPageSource();
		}
		
		/*
		 * 获得网址
		 * @return
		 */
		//得到URL返回值就可以了
		public String getURL() {
			return driver.getCurrentUrl();
		}
		
		/*
		 * 获得网页源码
		 * @return
		 */
		public String getPageSource() {
			return driver.getPageSource();
		}

}
