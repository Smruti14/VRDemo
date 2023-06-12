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
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.JSONUtils;
import utils.SessionManager;

public class BaseClasslogin {

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	public SessionManager sessionManager;
	public boolean isLoggedin = false;

	@BeforeMethod
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

		sessionManager = new SessionManager(driver);

		// Get Cookies
		this.putDataToSession();
//		System.out.println(sessionManager.getCookiesData().toString());
//		System.exit(0);
		if (this.openDispatch()) {

		} else {
//			System.out.println("hre");
			try {
				this.loginUser();
				sessionManager.storeSessionFile("VRWorks", "bestbeach");
			} catch (IOException e) {
//				 TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean openDispatch() {
		driver.get("https://vrmanaged1.com/login");
		try {
			return driver.findElement(By.xpath("//h4[@class='mb-3 mb-md-0']")).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean loginUser() {
//			System.out.println("user login called");
		driver.manage().deleteCookie(driver.manage().getCookieNamed("CAKEPHP"));
		driver.get("https://vrmanaged1.com/login");
		driver.findElement(By.id("users-email")).sendKeys("bestbeach"); //
		driver.findElement(By.xpath("//a[normalize-space()='Next']")).click(); //
		driver.findElement(By.id("users-password")).sendKeys("Winter-house2021"); //
		driver.findElement(By.xpath("//select[@name='userlayout']")).click(); //
		Select drpCountry = new Select(driver.findElement(By.name("userlayout"))); //
		drpCountry.selectByVisibleText("Select view or Default"); //
		driver.findElement(By.id("loginSubmitBtn")).click(); // // // Method 1: //
		// TODO : identify that user is successfully loggedin
//		  System.out.println("user login called finish");
		isLoggedin = true;
//		  boolean status = false;
//		 
		return isLoggedin;

	}

	public void putDataToSession() {
		try {
			JSONObject jo = JSONUtils.parseJsonFile("VRWorks.json");
			JSONObject session_data = jo.getJSONObject("session_data");
			JSONArray cookies = session_data.getJSONArray("cookies");
			JSONObject cookie = (cookies.getJSONObject(cookies.length() - 1));
			cookie.put("path", "/");
			cookie.put("domain", "vrmanaged1.com");
			sessionManager.setCookies(cookie);
		} catch (Exception e) {
		}
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
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
