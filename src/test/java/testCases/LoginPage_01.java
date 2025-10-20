package testCases;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.DB_Userid_Pass;
import pageObjects.LoginPage;
import pageObjects.MyInfo;
import testBase.TestBase;



public class LoginPage_01 extends TestBase{
	
	public static final Logger log = Logger.getLogger(Job_MyInfo_04.class);
	
	
	@Test
	public void login_page(){
		
		
		
        // Step 1: Fetch credentials from SQL Server
        String[] credentials = DB_Userid_Pass.getLoginCredentials();
        String username = credentials[0];
        String password = credentials[1];

		
		LoginPage hp = new LoginPage(driver);
		MyInfo my = new MyInfo(driver);
		hp.enterUsername(username);
		hp.password(password);
		hp.gettext();
		hp.Login_button();
		//my.info();
		
		log.info("All login_page  verifications completed successfully");
	}

}
