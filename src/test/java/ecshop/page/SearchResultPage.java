package ecshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage {
	
	//搜索结果个数
	@FindBy(how = How.TAG_NAME,using="b")
	@CacheLookup
	WebElement count;
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	//加一个带参数的构造方法，指定这个title为网页标题
	public SearchResultPage(WebDriver driver,String title) {
		super(driver,title);
	}
	//获得搜索结果个数
	public String getCount() {
		return count.getText();
	}

}
