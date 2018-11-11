package testdemoday3;


import org.openqa.selenium.WebDriver;



public class zuoyeLoginBusiness_20181103 {
	private WebDriver driver;
	public zuoyeLoginBusiness_20181103(WebDriver driver) {
		this.driver = driver;
	}
	
	//登录
	public void denglu(String username ,String password,String yanzhengma,String url) throws InterruptedException
	{
		//类创建一个对象名称为login_20181103，参数是driver
		zuoye20181103pagedengl login_20181103 = new zuoye20181103pagedengl(driver);
		login_20181103.GoToUrl(url);// 打开测试网址
		login_20181103.setUsername(username);
		login_20181103.setPassword(password);
		login_20181103.setyanzhenma(yanzhengma);
		login_20181103.clickLogin();
		
		Thread.sleep(3000);
	}
	
	

}
