package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	
	  WebDriver driver;
	
	
	  public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }
	  
	   By usernameField = By.name("username");
	   By password = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
	   By getText = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[1]");
	   By login__Button = By.xpath("//*[text() =\" Login \"]");
	   By expand_Button = By.xpath("//*[@class=\"oxd-icon-button oxd-main-menu-button\"]");
	  
	  

	    
	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }
	    
	    public void password(String password1) {
	    	driver.findElement(password).sendKeys(password1);
	    }
	    
	    public void gettext() {
	    	String text = driver.findElement(getText).getText();
	    	System.out.println(text);
	    }
	    
	    public void Login_button() {
	    	driver.findElement(login__Button).submit();
	    }
	
	public void expaned() {
		driver.findElement(expand_Button).click();
	}
	
}
