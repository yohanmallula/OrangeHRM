package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyInfo {
	
	
	
	  WebDriver driver;

	public MyInfo(WebDriver driver) {
		 this.driver = driver;
	}
	
	
	By myinfo = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a");
	
	By myinfo2 = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a");
	
	
	
	public void info() {
		driver.findElement(myinfo2).click();
	}
	
	 
	

}
