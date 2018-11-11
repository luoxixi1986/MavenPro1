package testdemoday3;


import org.openqa.selenium.WebDriver;



public class zuoyetchaxunBusiness_20181103 {
	private WebDriver driver;
	public zuoyetchaxunBusiness_20181103(WebDriver driver) {
		this.driver = driver;
	}
	
	//登录
	public void chaxun
	(String u_name,String isenable) throws InterruptedException
	{
		
		zuoye20181103pagechaxun chaxun_20181103 = new zuoye20181103pagechaxun(driver);
		chaxun_20181103.setu_name(u_name);
		chaxun_20181103.setenable_flag(isenable);
		chaxun_20181103.clickchaxun();
	}
	
	

}
