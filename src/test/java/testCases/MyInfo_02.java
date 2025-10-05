package testCases;

import org.testng.annotations.Test;

import pageObjects.DB_Userid_Pass;
import pageObjects.LoginPage;
import pageObjects.MyInfo;
import pageObjects.PersonalDetails_MyInfo;
import testBase.TestBase;
import utils.DB_ContactDetailsFetcher;
import utils.DB_ContactDetailsFetcher.ContactDetails;


public class MyInfo_02   extends TestBase{
	
	
	@Test()
	public void Myinfo() {
		
		   // Step 1: Fetch credentials from SQL Server
        String[] credentials = DB_Userid_Pass.getLoginCredentials();
        String username = credentials[0];
        String password = credentials[1];
        
        
		
		LoginPage hp = new LoginPage(driver);
		//MyInfo my = new MyInfo(driver);
		hp.enterUsername(username);
		hp.password(password);
		hp.gettext();
		hp.Login_button();
		
		
	}
	
	
	@Test()
	public void myinfo2() throws InterruptedException {
		
		
		// Inside your test method
		ContactDetails details = DB_ContactDetailsFetcher.fetchFirstContactDetails();
		System.out.println(details.street1); 
		
		MyInfo myInfo = new MyInfo(driver);
		myInfo.info();
		
		PersonalDetails_MyInfo PersonalDetails = new PersonalDetails_MyInfo(driver);
		PersonalDetails.name();
		PersonalDetails.stree1(details.street1);
		PersonalDetails.street2(details.street2);
		PersonalDetails.Stree22(details.city);
		PersonalDetails.State(details.state);
		PersonalDetails.PinCode(details.zip);
		PersonalDetails.country();
		PersonalDetails.Afghanistan();
		PersonalDetails.home(details.home);
		PersonalDetails.Mobilee(details.mobile);
		PersonalDetails.workk(details.workEmail);
		PersonalDetails.Other_Email(details.otherEmail);
		PersonalDetails.Save();
		//PersonalDetails.Custom_Fields();
		//PersonalDetails.First();
		//Thread.sleep(2000);
		//PersonalDetails.Save2();
		//Thread.sleep(2000);
	//PersonalDetails.add();
		//PersonalDetails.upload();
		
	}

}
