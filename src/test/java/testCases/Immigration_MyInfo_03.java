package testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.DB_Userid_Pass;
import pageObjects.Immigration_MyInfo;
import pageObjects.LoginPage;
import pageObjects.MyInfo;
import testBase.TestBase;

public class Immigration_MyInfo_03 extends TestBase {
	
	public static final Logger log = Logger.getLogger(Job_MyInfo_04.class);


	@Test()
	public void Immigration_Login() {

		// Step 1: Fetch credentials from SQL Server
		String[] credentials = DB_Userid_Pass.getLoginCredentials();
		String username = credentials[0];
		String password = credentials[1];

		LoginPage hp = new LoginPage(driver);
		// MyInfo my = new MyInfo(driver);
		hp.enterUsername(username);
		hp.password(password);
		hp.gettext();
		hp.Login_button();

	}

	@Test()
	public void Immigration() throws InterruptedException {

		MyInfo myInfo = new MyInfo(driver);
		myInfo.info();

		Immigration_MyInfo Immigration = new Immigration_MyInfo(driver);

		Immigration.Immigration();

		Immigration.Assignre_GetText();

		Immigration.Immigration_Add();

		Immigration.Visa_chec();
		Immigration.Visa_check_click();

		Immigration.number();
		Immigration.issued_Date();

		Immigration.expireyDate();

		Immigration.Visa_check_click();

		Immigration.Eligibale_Status();

		Immigration.issued_By();

		Immigration.counrty();
		Immigration.Eligible_Review_Date();

		Immigration.comments();

		Immigration.Savee();

		Thread.sleep(3000);
		
		Immigration.delete();
		
		Thread.sleep(2000); 
		
		Immigration.No_cancel();
		Thread.sleep(2000);
		Immigration.delete();
		
		Immigration.Yes_Delete();
		
		log.info("All Immigration verifications completed successfully");
	}
}
