package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import utils.SessionManager;

public class BaseClasslogin {

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;

	@BeforeClass
	public void setup() throws InterruptedException, IOException {

		rb = ResourceBundle.getBundle("config");// Load config.properties
		logger = LogManager.getLogger(this.getClass()); // logging
		logger.info("in setup ");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--incognito");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cap);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.navigate().to("https://vrmanaged1.com/login");
		driver.manage().window().maximize();

		
		
		/*
		 * driver.findElement(By.id("users-email")).sendKeys("bestbeach");
		 * driver.findElement(By.xpath("//a[normalize-space()='Next']")).click();
		 * driver.findElement(By.id("users-password")).sendKeys("Winter-house2021");
		 * driver.findElement(By.xpath("//select[@name='userlayout']")).click(); Select
		 * drpCountry = new Select(driver.findElement(By.name("userlayout")));
		 * drpCountry.selectByVisibleText("Select view or Default");
		 * driver.findElement(By.id("loginSubmitBtn")).click();
		 */
		 
		// Get Cookies

	        SessionManager sessionManager = new SessionManager(driver);

	        // Method 1:
	         sessionManager.storeSessionFile("VRWorks","bestbeach");
	        // Method 2:

			
		     JSONObject existingSession = new JSONObject(); //
			  existingSession.put("path","/"); //
			  existingSession.put("domain",".vrmanaged1.com"); //
			  existingSession.put("name","CAKEPHP"); //
			  existingSession.put("isHttpOnly",true); //
			  existingSession.put("isSecure",true); //
			  existingSession.put("expiry","Sat Jun 10 13:51:24 IST 2023"); //
			  existingSession.put("value","25c9faf2e369a6be04036802a7cfde12"); // //
			  sessionManager.setCookies(existingSession);
			 		
		
		/*
		 * String title = "VR WORKS - Dispatch";
		 * 
		 * String actualTitle = driver.getTitle();
		 * 
		 * System.out.println("Verifying the page title has started");
		 * Assert.assertEquals(actualTitle,title,"Page title doesnt match");
		 * 
		 * System.out.println("The page title has been successfully verified");
		 * 
		 * System.out.println("User logged in successfully");
		 */
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return (generatedString);
	}

	public String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		return (str + "@!$%*_-" + num);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
