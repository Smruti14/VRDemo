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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;

	@BeforeMethod
	public void setup() {

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
		
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.close();
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
