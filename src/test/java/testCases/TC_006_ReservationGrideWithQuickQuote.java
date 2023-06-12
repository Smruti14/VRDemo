package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.ReservationMenu;
import testBase.BaseClasslogin;

public class TC_006_ReservationGrideWithQuickQuote extends BaseClasslogin {

	@Test
	public void verifywithvalidquickquote() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		ReservationMenu reservation = new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickreservationgrid();

		//Actions act = new Actions(driver);
		int singleDayWidth = 24;
		int nights = 3;
		String Unitname = "SMR001";
		
		
		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));
		WebElement unit = driver.findElement(By
				.xpath("//table[@class='table table-bordered table-striped unitscode-holder']//td[contains(@unit_code,'"
						+ Unitname + "')]"));// 240,
		// 277
		WebElement quote = driver.findElement(By.xpath("//a[@id='quickquotemodelanchor']"));
		// Search unit
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Unitname);
		// this will find all matching nodes in calendar
		List<WebElement> allDates = driver.findElements(By.xpath(
				"//div[@class='day-header-holder']/table[@class='table']//tr[contains(@class,'daynumberheader')]//div"));// (453,
																															// 201)

		// to do MAKE DATE COUNTER DYNAMIC
		int dateCounter = 0;
		// now we will iterate all values and will capture the text. We will select when
		// date is 28

		for (WebElement ele : allDates) {

			String date = ele.getText();
			dateCounter++;
			// System.out.println(date); // once date is 28 then click and break
			if (date.equals("9")) {
				break;
			}
		}
		// System.out.println(dateCounter);
		Actions act2 = new Actions(driver);

		// System.out.println(recervationpoint.getRect().x+" - "+
		// recervationpoint.getRect().y);
		act2
				// initially mouse will be at (0,0)
				.moveByOffset(recervationpoint.getRect().x + (singleDayWidth * dateCounter) + 2,
						unit.getLocation().y + 2)
				// click and hold on current location, will be res div
				.click()

				// move by days + width
				.moveByOffset(singleDayWidth * nights, 5).contextClick().click(quote).perform();

		// Get from date
		String checkInDate = driver.findElement(By.xpath("//input[@id='qqfirstnight']")).getAttribute("value");
		System.out.println("Check in date : " + checkInDate);
		String checkOutDate = driver.findElement(By.xpath("//input[@id='qqlastnight']")).getAttribute("value");
		System.out.println("Check out  date : " + checkOutDate);
		String night = driver.findElement(By.xpath("//input[@id='qqnights']")).getAttribute("value");
		System.out.println("Check in date : " + night);

		// get total value of rent charges
		String rentCharges = driver.findElement(By.xpath("//input[@name='rent']")).getAttribute("value");
		System.out.println("Total nights: " + night + " " + "Total Charges of nights : " + rentCharges);

		driver.findElement(By.xpath(
				"//div[@class='uk-modal-dialog uk-modal-body modal-content modal-dialog-scrollable']//div[@class='modal-header']//button[@type='button']"))
				.click();

		driver.findElement(By.xpath("//span[normalize-space()='Properties']")).click();
		driver.findElement(By.xpath("//input[@name='unit_code']")).sendKeys(Unitname);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[@class='unitname']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='RU'])"))).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Price & Availability']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='pricing-tab']"))).click();

		// Assuming the date and price values are in the same row of the table

		// New

		// Step 1: Find the table element
		String[] arrayDates = {"05/01/2023","05/02/2023","05/03/2023"}; // Example array of dates
		double[] arrayPrices = {9.0,8.0,9.0 }; // Example array of prices
		double sumArray = 0;

		Thread.sleep(3000);
		for (String date : arrayDates) {
		
			WebElement dateElem = driver.findElement(By.xpath("//div[text()='" + date+ "']/ancestor::td/following-sibling::td[contains(@class,'seasonal-price-daily-price')]//span[@class='price']"));
			String dateElemD = dateElem.findElement(By.xpath("./..")).getText();
			String price = dateElemD.replaceAll("[^a-zA-Z0-9]", " ");
	        System.out.println("Unit Price of "+ date +" "+  price);
	
		}
		for(double price1 : arrayPrices )
        {
        	sumArray +=price1;
        	
        }
		System.out.println("Total price " +  sumArray);
	}

//	@Test
//	public void ValidateCreateQuickQuoteWithInValiddate() throws InterruptedException {
//		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//		ReservationMenu reservation = new ReservationMenu(driver);
//		reservation.clickReservationMenu();
//		reservation.clickreservationgrid();
//
//		Actions act = new Actions(driver);
//		int singleDayWidth = 24;
//		int nights = 3;
//		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));
//		String Unitname = "ALER104E";
//		WebElement unit = driver.findElement(By
//				.xpath("//table[@class='table table-bordered table-striped unitscode-holder']//td[contains(@unit_code,'"
//						+ Unitname + "')]"));// 240,
//		// 277
//		WebElement quote = driver.findElement(By.xpath("//a[@id='quickquotemodelanchor']"));
//		// Search unit
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Unitname);
//		// this will find all matching nodes in calendar
//		List<WebElement> allDates = driver.findElements(By.xpath(
//				"//div[@class='day-header-holder']/table[@class='table']//tr[contains(@class,'daynumberheader')]//div"));// (453,
//																															// 201)
//
//		// to do MAKE DATE COUNTER DYNAMIC
//		int dateCounter = 0;
//		// now we will iterate all values and will capture the text. We will select when
//		// date is 28
//
//		for (WebElement ele : allDates) {
//
//			String date = ele.getText();
//			dateCounter++;
//			// System.out.println(date); // once date is 28 then click and break
//			if (date.equals("18")) {
//				break;
//			}
//		}
//		// System.out.println(dateCounter);
//		Actions act2 = new Actions(driver);
//
//		// System.out.println(recervationpoint.getRect().x+" - "+
//		// recervationpoint.getRect().y);
//		act2
//				// initially mouse will be at (0,0)
//				.moveByOffset(recervationpoint.getRect().x + (singleDayWidth * dateCounter) + 2,
//						unit.getLocation().y + 2)
//				// click and hold on current location, will be res div
//				.click()
//
//				// move by days + width
//				.moveByOffset(singleDayWidth * nights, 5).contextClick().click(quote).perform();
//
//		WebElement Cleardiscount = driver.findElement(By.id("qqdiscinput"));
//		Cleardiscount.sendKeys("0.00");
//		Cleardiscount.clear();
//
//		WebElement discount = driver.findElement(By.id("qqdiscinput"));
//		discount.sendKeys("10");
//		discount.click();

	//}

}
