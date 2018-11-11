package ecshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage2 {
	WebDriver drvier;
	//搜索结果个数
	@FindBy(how = How.TAG_NAME,using="b")
	@CacheLookup
	WebElement count;
	
	public SearchResultPage2(WebDriver driver) {
		this.drvier = driver;
		PageFactory.initElements(driver, this);
	}
	//获得搜索结果个数
	public String getCount() {
		return count.getText();
	}

}
