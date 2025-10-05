package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PersonalDetails_MyInfo {
	
	 WebDriver driver;
	 
	 public PersonalDetails_MyInfo(WebDriver driver) {
		 this.driver = driver;
	}
	 
	 
	  By contact_tab = By.xpath("(//*[text() = 'Contact Details'])[1]");
	 By name = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div[1]/div[2]/input");
	 
	 By  steet1 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input");
	 
	 By street23 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/input");
	 
	 By Stree22 = By.xpath("(//*[@class=\"oxd-input oxd-input--active\"])[3]");
	 
	 By State = By.xpath("//*[text()='State/Province']/parent::div/following-sibling::div[1]/child::input");
	 
	 By PinCode = By.xpath("//*[text()='Zip/Postal Code']/parent::div/following-sibling::div/child::input");
	 
	 By country = By.xpath("//*[@class=\"oxd-select-text oxd-select-text--active\"]");
	 
	 By Afghanistan = By.xpath("//*[text()='Afghanistan']");
	 
	 By homee = By.xpath("//*[text()='Home']/parent::div/following-sibling::div/child::input");
	 
	 By Mobilee = By.xpath("//*[text()='Mobile']/parent::div/following-sibling::div/child::input");
	 
	 By workk = By.xpath("//*[text()='Work Email']/parent::div/following-sibling::div/child::input");
	 
	 By Other_Email = By.xpath("//*[text()='Other Email']/parent::div/following-sibling::div/child::input");
	 
	 By Save = By.xpath("(//*[text()=' Save '])[1]");
	 
	 
	 By Custom_Fields = By.xpath("//*[text()='New1']/parent::div/following-sibling::div/child::div/child::div");
	 
	 By First = By.xpath("//*[text()='first']");
	 
	 By Save2 = By.xpath("(//*[text()=' Save '])[2]");
	 
	 By add = By.xpath("//*[text()='Attachments']/parent::div/child::button");
	 
	 By upload = By.xpath("//*[text()='No file selected']");
	 
	 public void name() {
			driver.findElement(contact_tab).click();
		}
	 
	 public void stree1(String street1) {
		 driver.findElement(steet1).sendKeys(street1);
	 }
	 
	 public void street2(String street2) {
		 driver.findElement(street23).sendKeys(street2);
	 }
	 
	 public void Stree22(String city) {
		 driver.findElement(Stree22).sendKeys(city);
	 }
	 
	 public void State(String state) {
		 driver.findElement(State).sendKeys(state);
	 }
	 
	 public void PinCode(String zip) {
		 driver.findElement(PinCode).sendKeys(zip);
	 }
	 
	 public void country() {
		 
		// Assuming driver is already initialized
		// WebElement dropdownElement = driver.findElement(country);
		// Select dropdown =  new Select(dropdownElement);
		// dropdown.selectByIndex(2);
		 driver.findElement(country).click();
	 }
	 
	 public void Afghanistan() {
		 driver.findElement(Afghanistan).click();
	 }
	 
	 public void home(String home) {
		 driver.findElement(homee).sendKeys(home);
	 }
	 
	 public void Mobilee(String mobile) {
		 driver.findElement(Mobilee).sendKeys(mobile);
	 }
	 
	 public void workk(String workEmail) {
		 driver.findElement(workk).clear();
		 
	 }
	 
	 public void Other_Email(String otherEmail) {
		 driver.findElement(Other_Email).sendKeys(otherEmail);
	 }
	 
	 public void Save() {
		 driver.findElement(Save).submit();
	 }
	 
	 public void Custom_Fields() {
		 driver.findElement(Custom_Fields).click();
	 }
	 
	 public void First() {
		 driver.findElement(First).click();
	 }
	 
	 public void Save2() {
		 driver.findElement(Save2).click();
	 }
	 
	 public void add() {
		 driver.findElement(add).click();
	 }
	 
	 public void upload() {
		 //driver.findElement(upload).click();
		 driver.findElement(upload).sendKeys("C:\\Users\\Yohan\\OneDrive\\Documents\\yohan");
	 }
}










