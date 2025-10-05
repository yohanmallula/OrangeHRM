package testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.DB_Userid_Pass;
import pageObjects.Job_Myinfo;
import pageObjects.LoginPage;
import pageObjects.MyInfo;
import testBase.TestBase;

public class Job_MyInfo_04   extends  TestBase{
	
	public static final Logger log = Logger.getLogger(Job_MyInfo_04.class);
	
	
	@Test()
	public void Myinfo() {

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
	public void myinfo2() throws InterruptedException {

		MyInfo myInfo = new MyInfo(driver);
		myInfo.info();
		
		Job_Myinfo job = new Job_Myinfo(driver);
		
		job.job();
		job.job_Detailss();
		job.Joined_Date_Lables();
		job.joinedDateInput();
		job.job_Tittle_lable();
		job.jobTittleTextbox();
		job.JobCategoryLable();
		job.JobCategoryTextField();
		job.JobLocationLable();
		job.JobLocationTextField();
		job.EmploymentStatusLable();
		job.ContractDetailsCheckbox();
		
		log.info("All Job MyInfo verifications completed successfully");
		
	}
	

}
