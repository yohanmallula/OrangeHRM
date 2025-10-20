package testBase;
import utils.ConfigReader;


import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;
import reports.ExtentReportListener;


@Listeners(ExtentReportListener.class)
public class TestBase {

    public WebDriver driver;
   

    @BeforeClass
    public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 String url = ConfigReader.get("url");
		driver.get(url);
		//Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Clean up properly
        }
    }
}
