package testdemoday3;


import org.openqa.selenium.WebDriver;



public class zuoyetianjiaBusiness_20181103 {
	private WebDriver driver;
	public zuoyetianjiaBusiness_20181103(WebDriver driver) {
		this.driver = driver;
	}
	
	//登录
	public String tianjia(String arg1[]) throws InterruptedException
	{	
		zuoye20181103pagetianjia tianjia_20181103 = new zuoye20181103pagetianjia(driver);
		//tianjia_20181103.GoToUrl(url);// 打开测试网址
		tianjia_20181103.clickrenyuan();
		tianjia_20181103.clickadd();
		String name=""; 
		System.out.println(driver.getTitle());
		name=tianjia_20181103.setuseruuid(arg1[0]);
		tianjia_20181103.setsex(arg1[1]);
		tianjia_20181103.setyname(arg1[2]);

		tianjia_20181103.setphone(arg1[3]);
		tianjia_20181103.setdepartment(arg1[4]);
		tianjia_20181103.setmobile(arg1[5]);
		tianjia_20181103.setroleuuid(arg1[6]);
		tianjia_20181103.setemail(arg1[7]);
		tianjia_20181103.setability(arg1[8]);
		tianjia_20181103.setjobyear(arg1[9]);
		tianjia_20181103.setmemo(arg1[10]);
		tianjia_20181103.clickrecord_record_saveAndExit();
		return name;
	}
	
	

}
