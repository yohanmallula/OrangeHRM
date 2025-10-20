package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import exceptions.Exceptions;
import testCases.Job_MyInfo_04; 

public class Immigration_MyInfo {
	
	public static final Logger log = Logger.getLogger(Job_MyInfo_04.class);
	//
	SoftAssert softAssert = new SoftAssert();

	 WebDriver driver;
	 
	 public Immigration_MyInfo(WebDriver driver) {
		 this.driver = driver;
	}
	
	 By Immigration = By.xpath("//*[text()='Immigration']");
	 
	 By Assignre_GetText = By.xpath("//*[text()='Assigned Immigration Records']");
	 
	 By Immigration_Add = By.xpath("(//*[text()=' Add '])[1]");
	 
	 By Visa_chec = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div[2]/div[2]/div/label");
	 
	 By number = By.xpath("//*[text()='Number']/parent::div/following-sibling::div/child::input");
	 
	 By issued_Date = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/div/div/input");
	 
	 By expireyDate = By.xpath("(//*[text()='Expiry Date'])[1]/parent::div//following-sibling::div/child::div/child::div/child::input");
	 
	 By Eligibale_Status = By.xpath("//*[text()='Eligible Status']/parent::div/following-sibling::div/child::input");
	 
	 By issued_By = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[5]/div/div[2]/div/div");
	 
	 By counrty = By.xpath("(//*[text()='Afghanistan'])[1]");
	 
	 By Eligible_Review_Date = By.xpath("//*[text()= 'Eligible Review Date']/parent::div/following-sibling::div/child::div/child::div/child::input");
	 
	 By comments = By.xpath("//*[text()='Comments']/parent::div/following-sibling::div/textarea");
	 
	 By Savee = By.xpath("//*[text()=' Save ']");
	 
	 
	 By delete = By.xpath("(//*[text() = 'Romania']/parent::div/following-sibling::div)[3]/child::div/child::button");
	 
	 By No_cancel = By.xpath("//*[text()=' No, Cancel ']");
	 
	 By Yes_Delete = By.xpath("//*[text()=' Yes, Delete ']");
	 
	 

	 public void Immigration() {
		    try {
		        driver.findElement(Immigration).click();
		    } catch (NoSuchElementException e) {
		    	log.error("Immigration element not found on the page", e);
		        throw new Exceptions("Immigration element not found on the page", e);
		    }
		}


	 
	 public void Assignre_GetText() {
		 String GetText =  driver.findElement(Assignre_GetText).getText();
 
		 System.out.println(GetText);		 
		 softAssert.assertEquals(GetText, "Assigned Immigration Records");
		 
		   // Collect all asserts at the end
		    softAssert.assertAll();
	 }
	 
	 public void Immigration_Add() {
		 driver.findElement(Immigration_Add).click();
	 }
	 
	 public void Visa_chec() {
		    // Find the radio button
		    WebElement radioButton = driver.findElement(Visa_chec);

		    // Check if it is selected
		    boolean isEditable = radioButton.isEnabled();
		    
		    // Soft Assert
		  
		    softAssert.assertTrue(isEditable, "❌ Visa radio button is DISABLED (not editable)!");

		    
		    softAssert.assertAll();
		    
		    // Print to console
		    if (isEditable) {
		        System.out.println("✅ Visa radio button is editable (enabled).");
		    } else {
		        System.out.println("❌ Visa radio button is NOT editable (disabled).");
		    }
	 }
	 public void Visa_check_click() {
		    driver.findElement(Visa_chec).click();
		 
	 }
	 
	 public void number() {
		 driver.findElement(number).sendKeys("123455678");
	 }
	 
	 
	 public void issued_Date() {
		 driver.findElement(issued_Date).sendKeys("2025-27-08");
	 }
	 
	 public void expireyDate() {
		 driver.findElement(expireyDate).sendKeys("2025-28-08");
	 }
	 
	 public void Eligibale_Status() {
		 driver.findElement(Eligibale_Status).sendKeys("Yes");
	 }
	 
	 public void issued_By() {
		    driver.findElement(issued_By).click();
	 }
	 
	 public void counrty() {
		 driver.findElement(counrty).click();
	 }
	 
	 public void Eligible_Review_Date() {
		 driver.findElement(Eligible_Review_Date).sendKeys("2025-15-09");
	 }
	 
	 public void comments() {
		 driver.findElement(comments).sendKeys("helooooo");
	 }
	 
	 public void Savee() {
		 driver.findElement(Savee).submit();
	 }
	 
	 public void delete() {
		 driver.findElement(delete).click();
	 }
	 
	 
	 public void No_cancel() {
		 driver.findElement(No_cancel).click();
	 }
	 
	 public void Yes_Delete() {
		 driver.findElement(Yes_Delete).click();
	 }
	 
}
