package testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.DB_Userid_Pass;
import pageObjects.LoginPage;
import pageObjects.MyInfo;
import pageObjects.PersonalDetails;
import testBase.TestBase;

public class PersonalDetails_MyInfo_05 extends  TestBase {
	
	public static final Logger log = Logger.getLogger(Job_MyInfo_04.class);
	
	
	@Test()
	public void PersonalDetails_Login() {

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
	public void PersonalDetails() throws InterruptedException {

		MyInfo myInfo = new MyInfo(driver);
		myInfo.info();
		
		PersonalDetails personalDetailsPage = new PersonalDetails(driver);
		
		personalDetailsPage.PersonalDetails();
		personalDetailsPage.PersonalDetailsHeading();
		personalDetailsPage.EmployeeFullNameLabel();
		personalDetailsPage.UserName();
		personalDetailsPage.firstname();
		personalDetailsPage.Required();
		personalDetailsPage.middelname();
		personalDetailsPage.lastname();
		personalDetailsPage.verifyEmployeeLabels();
		personalDetailsPage.verifyEmployeeTextFields();
		personalDetailsPage.DrivingLiceneceLabel();
		
		log.info("All Job MyInfo verifications completed successfully");
		
	}

}
