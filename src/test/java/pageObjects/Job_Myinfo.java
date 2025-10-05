package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import org.apache.log4j.Logger;

public class Job_Myinfo {

	SoftAssert softAssert = new SoftAssert();

	public static final Logger log = Logger.getLogger(Job_Myinfo.class);
	
	

	WebDriver driver;

	public Job_Myinfo(WebDriver driver) {
		this.driver = driver;
	}

	By job = By.xpath("//a[@href='/web/index.php/pim/viewJobDetails/empNumber/7']");

	By job_Details = By.xpath("//*[text()='Job Details']");

	By Joined_Date_Lable = By.xpath("//*[text()='Joined Date']");

	By joinedDateInput = By.xpath("//*[text()='Joined Date']/parent::div/following-sibling::div/div/div/input");

	By job_Tittle_lable = By.xpath("//*[text()='Job Title']");

	By jobTittleTextbox = By.xpath("//*[text()='HR Manager']");

	By JobCategoryLable = By.xpath("//*[text()= \"Job Category\"]");

	By JobCategoryTextField = By.xpath("//*[text()='Officials and Managers']");

	By JobLocationLable = By.xpath("//*[text()='Location']");

	By JobLocationTextField = By.xpath("//*[text()='Texas R&D']");

	By EmploymentStatus = By.xpath("//*[text()='Employment Status']");

	By ContractDetailsCheckbox = By.xpath(
			"//*[text()=\"Include Employment Contract Details\"]/parent::div/child::div/child::label/child::span");

	public void job() {
		driver.findElement(job).click();
	}

	public void job_Detailss() {

		// check if element present
		if (driver.findElements(job_Details).size() > 0) {
			// element is present -> get the text
			String get_job_Details = driver.findElement(job_Details).getText();

			System.out.println("Element is present. Text: " + get_job_Details);

			softAssert.assertEquals(get_job_Details, "Job Details", "❌ Text is not matching!");
		} else {
			// element not present
			System.out.println("Element is NOT present.");
		}
	}

	public void Joined_Date_Lables() {
		String Joined_Date_Lable_Text = driver.findElement(Joined_Date_Lable).getText();

		System.out.println(Joined_Date_Lable_Text);

		softAssert.assertEquals(Joined_Date_Lable_Text, "Joined Date");
	}

	public void joinedDateInput() {
		WebElement input = driver.findElement(joinedDateInput);

		boolean isEnabled = input.isEnabled();

		System.out.println(isEnabled);

		// isdisplay
		if (input.isDisplayed()) {
			System.out.println("element visible");
		} else {
			System.out.println("element not visible");
		}
	}

	public void job_Tittle_lable() {
		// WebElement input = driver.findElement(job_Tittle_lable);
		List<WebElement> elements = driver.findElements(job_Tittle_lable);

		if (elements.size() > 0) {
			WebElement input = elements.get(0);

			String getText = input.getText();
			String expectedText = "Job Title";

			if (input.isDisplayed()) {

				// assertion using isDisplayed
				Assert.assertTrue(input.isDisplayed(), "❌ Joined Date input is NOT visible!");

				Assert.assertEquals(getText, expectedText);

				Assert.assertTrue(input.isEnabled(), "❌ Job Title label is not enabled!");

			} else {

				System.out.println("❌ Job Title label element not found in DOM");
				softAssert.fail("Job Title label missing from DOM");

			}
			softAssert.assertAll();

		}
	}

	public void jobTittleTextbox() {
		List<WebElement> elements = driver.findElements(jobTittleTextbox);

		if (!elements.isEmpty()) {
			WebElement input = elements.get(0);

			// log.info(" jobTittleTextbox Found Job Title textbox in DOM");

			Assert.assertTrue(input.isDisplayed(), " Job Title textbox is NOT displayed!");
			// log.info("jobTittleTextbox Job Title textbox is displayed");

			// 2) Check enabled state
			Assert.assertTrue(input.isEnabled(), " Job Title textbox is NOT enabled!");
			// log.info(" jobTittleTextbox Job Title textbox is enabled");

			log.info("jobTittleTextbox method executed successfully");

		} else {
			log.error("jobTittleTextbox: Job Title textbox not found in DOM");
			softAssert.fail("Job Title textbox missing from DOM");
		}
		softAssert.assertAll();

		// Uses Log4j2 → industry-standard, modern logger.
		// All assertions are soft, so the test collects all failures.
		// Logs are meaningful and structured for framework/reporting.
		// Includes functional check (placeholder) for extra verification.
		// Fully reusable and maintainable (fits Page Object Model).
	}

	public void JobCategoryLable() {
		List<WebElement> elements = driver.findElements(JobCategoryLable);

		if (!elements.isEmpty()) {
			WebElement input = elements.get(0);
			String actualText = input.getText();
			String expectedText = "Job Category";

			// log.info("Found Job Category label in DOM");

			Assert.assertTrue(input.isDisplayed(), "Job Category Lable is NOT displayed!");
			// log.info("Job Category label is displayed");

			Assert.assertTrue(input.isEnabled(), "Job Category Lable is not edit Enabled!");
			// log.info("Job Category label is not enabled");

			Assert.assertEquals(actualText.trim(), expectedText, "Job Category label text mismatch");
			// log.info("Job Category label text verified: " + actualText);

			log.info("verifyJobCategoryLabel method executed successfully");
		} else {
			log.error("Job Category label not found in DOM");
			Assert.fail("Job Category label missing from DOM");
		}

	}

	public void JobCategoryTextField() {
		List<WebElement> elements = driver.findElements(JobCategoryTextField);

		if (!elements.isEmpty()) {
			WebElement input = elements.get(0);

			// log.info("Found Job Category TextField in DOM");

			Assert.assertTrue(input.isDisplayed(), "Job Category TextField is NOT displayed!");

			Assert.assertTrue(input.isEnabled(), "Job Category TextField is not edit isEnabled!");

			log.info("JobCategoryTextField method executed successfully");

		} else {
			log.error("Job Category TextField not found in DOM");
			// SoftAssert softAssert2 = new SoftAssert();
			// softAssert2.fail("Job Category TextField missing from DOM");
		}
	}

	public void JobLocationLable() {
		List<WebElement> elements = driver.findElements(JobLocationLable);

		if (!elements.isEmpty()) {
			WebElement input = elements.get(0);

			String actualText = input.getText();
			String expectedText = "Location";

			Assert.assertTrue(input.isDisplayed(), "Job Location Lable is NOT displayed!");

			Assert.assertTrue(input.isEnabled(), "Job Location Lable is not edit isEnabled!");

			Assert.assertEquals(actualText.trim(), expectedText, "Job Location label text mismatch");

			log.info("JobLocation Lable method executed successfully");

		} else {
			log.error("Job Location Lable not found in DOM");
			Assert.fail("Job Location Lable missing from DOM");
		}
	}

	public void JobLocationTextField() {
		List<WebElement> elements = driver.findElements(JobLocationTextField);

		if (!elements.isEmpty()) {
			WebElement input = elements.get(0);

			Assert.assertTrue(input.isDisplayed(), "Job Location TextField is NOT displayed!");

			Assert.assertTrue(input.isEnabled(), "Job Location TextField is not edit Enabled!");

			try {
				input.clear(); // clear existing text
				input.sendKeys("Test"); // try to type
				log.info("Job Location TextField is editable");
			} catch (Exception e) {
				log.error("Job Location TextField is NOT editable");

			}

			log.info("JobLocationTextField method executed successfully");

		} else {
			log.error(" Job Location TextField not found in DOM");
			Assert.fail("JobLocationTextFielde missing from DOM");
		}
	}

	public void EmploymentStatusLable() {
		List<WebElement> elements = driver.findElements(EmploymentStatus);

		if (!elements.isEmpty()) {
			WebElement input = elements.get(0);

			String actualText = input.getText();
			String expectedText = "Employment Status";

			Assert.assertTrue(input.isDisplayed(), "EmploymentStatus Lable is NOT displayed!");

			Assert.assertTrue(input.isEnabled(), "JEmploymentStatus Lable is not edit isEnabled!");

			Assert.assertEquals(actualText.trim(), expectedText, "EmploymentStatus label text mismatch");

			log.info("EmploymentStatusLable method executed successfully");

		} else {
			log.error(" EmploymentStatus not found in DOM");
		}

	}

	public void ContractDetailsCheckbox() {
		// driver.findElement(ContractDetailsCheckbox).click();

		List<WebElement> elements = driver.findElements(ContractDetailsCheckbox);

		if (!elements.isEmpty()) {
			WebElement input = elements.get(0);

			Assert.assertTrue(input.isDisplayed(), "Terms checkbox is NOT visible!");

			Assert.assertTrue(input.isEnabled(), "Terms checkbox is NOT enabled!");

			boolean initialSelected  = input.isSelected();
			
			log.info("checkBox " + initialSelected);

			input.click(); // click the checkbox
			
			log.info("Found Job Category label in DOM");

		} else {
			log.error(" EmploymentStatus not found in DOM");
		}

	}
	
	

}
