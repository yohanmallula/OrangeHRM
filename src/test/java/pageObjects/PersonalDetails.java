package pageObjects;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PersonalDetails {
	
	SoftAssert softAssert = new SoftAssert();

	public static final Logger log = Logger.getLogger(Job_Myinfo.class);
	
	

	WebDriver driver;

	public PersonalDetails(WebDriver driver) {
		this.driver = driver;
	}
	
	By PersonalDetails = By.xpath("//a[@href='/web/index.php/pim/viewPersonalDetails/empNumber/7']");
	
	By PersonalDetailsHeading = By.xpath("(//*[text()='Personal Details'])[2]");
	
	By EmployeeFullNameLabel = By.xpath("//*[text()='Employee Full Name']");
	
	
	By UserName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6");
	
	By Firstname = By.xpath("//*[@name=\"firstName\"]");
	
	By Required = By.xpath("//*[text()='Required']");
	
	public void PersonalDetails() {
		driver.findElement(PersonalDetails).click();
	}

	public void PersonalDetailsHeading() {
		List<WebElement>  elements = driver.findElements(PersonalDetailsHeading);
		
		
		if(!elements.isEmpty()) {
			WebElement input =  elements.get(0);
			
			String actualText = input.getText();
			String expectedText = "Personal Details";
			
			Assert.assertTrue(input.isDisplayed() , "Personal Details Heading is not display");
						
			
			Assert.assertEquals(actualText.trim(), expectedText , "Personal Details Heading is not equal");
			
			//log.info("PersonalDetails Heading method executed successfully");
		}else {
			log.error("Personal Details Heading is not found the DOM");
		}
	}
	
	public void EmployeeFullNameLabel() {
		List<WebElement> elements = driver.findElements(EmployeeFullNameLabel);
		
		
		if(!elements.isEmpty()) {
			WebElement input = elements.get(0);
			
			String actualText = input.getText();
			String exectedText = "Employee Full Name";
			
			Assert.assertTrue(input.isDisplayed() , "Employee FullName Label is not Display");
			
			Assert.assertEquals(actualText.trim(), exectedText , "Employee FullName  is not equal");
			
			//log.info("EmployeeFullName Label method executed successfully");
		}else {
			log.error("EmployeeFullNameLabel is not found the DOM");
		}
		
		
	}
	
	public void UserName() {

		
	/*	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(UserName));
		System.out.println(el.getText());  */
		
	/*	JavascriptExecutor js = (JavascriptExecutor) driver;
		String name = (String) js.executeScript(
		    "return arguments[0].innerText;", 
		    driver.findElement(UserName)
		);
		System.out.println("Fetched name: " + name);  */
		
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(
			    driver1 -> !driver1.findElement(UserName).getText().isEmpty()
			);
			String name = driver.findElement(UserName).getText();
			
			
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//WebElement firstNameInput = wait.until(ExpectedConditions.elementToBeClickable(Firstname));
			
		
	}
	
	public void firstname() {
		List<WebElement> elements = driver.findElements(Firstname);
		
		if(!elements.isEmpty()) {
			WebElement input = elements.get(0);
			
			input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			input.sendKeys(Keys.BACK_SPACE);
		}
	}
	
	public void Required() {
		 // Fetch the 'Required' text
	    String requiredText = driver.findElement(Required).getText();
	    System.out.println(requiredText);
		

	    // Find the input field(s)
	    List<WebElement> elements = driver.findElements(Firstname);
	    
	    System.out.println("");
		
		if(!elements.isEmpty()) {
			WebElement input = elements.get(0);
			
		
		        
		        String expectedText = "Required";
			
		        if (requiredText.equals(expectedText)) {
		            // Clear and type value (use the Ctrl+A+Backspace trick if needed)
		           // input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		           // input.sendKeys(Keys.BACK_SPACE);
		            input.sendKeys("Yohan");  // enter the desired value
		        }
			
			
		}
		
		
	}
	
	
}
