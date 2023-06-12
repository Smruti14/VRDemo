package testCases;

import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ReservationMenu;
import testBase.BaseClasslogin;

public class TC_007_ReservationGridPagewithreservation extends BaseClasslogin {
	@Test
	public void verifyQuoteopen() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		ReservationMenu reservation = new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickreservationgrid();

		Actions act = new Actions(driver);
		int singleDayWidth = 24;
		int nights = 3;
		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));
		String Unitname = "SMR001";
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
			if (date.equals("10")) {
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

		Thread.sleep(1000);
		String actualunitname = driver.findElement(By.xpath(".//b[contains(.,'Quick Quote')]")).getText();
		Assert.assertEquals(actualunitname, "Quick Quote");

	}

	@Test
	public void verifyQuotewithinvalidatedata() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		ReservationMenu reservation = new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickreservationgrid();

		Actions act = new Actions(driver);
		int singleDayWidth = 24;
		int nights = 3;
		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));// 427,//
																													// 220

		String Unitname = "SMR001";
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
			if (date.equals("10")) {
				break;
			}
		}

		Actions act2 = new Actions(driver);

		// System.out.println(recervationpoint.getRect().x+" - "+
		// recervationpoint.getRect().y);
		act2
				// initially mouse will be at (0,0)
				.moveByOffset(recervationpoint.getRect().x + (singleDayWidth * dateCounter) + 2,
						unit.getLocation().y + 2)
				// click and hold on current location, will be res div

				// move by days + width
				.moveByOffset(singleDayWidth * nights, 3).contextClick().click(quote).perform();

		Thread.sleep(1000);
		Alert alertwindo = wait.until(ExpectedConditions.alertIsPresent());

		String alertwindomsg = driver.switchTo().alert().getText();

		alertwindo.accept();
		Assert.assertEquals(alertwindomsg, "Unit Not Available For Dates Provided.");

	}

	@Test
	public void verifyreservationwithlessdate() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		ReservationMenu reservation = new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickreservationgrid();

		Actions act = new Actions(driver);
		int singleDayWidth = 24;
		int nights = 1;
		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));// 427,
																													// 220
																													// //
																													// 220
		String Unitname = "SHORE146";
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
			if (date.equals("11")) {
				break;
			}
		}

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
				.moveByOffset(singleDayWidth * nights, 1).contextClick().click(quote).perform();

		String actualWarningMsg = driver.findElement(By.xpath("//div[@class='quote-error-block']//p")).getText();

		Assert.assertEquals(actualWarningMsg,
				"We apologize you are unable to book your dates. Some units have either minimum stay or day of week restrictions. Please call our office at (888) 567-5150 for assistance.This property has 3 nights minimum during this period.");
	}

	@Test
	public void verifyOpenReservationWithDeleteOption() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		ReservationMenu reservation = new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickreservationgrid();

		Actions act = new Actions(driver);
		int singleDayWidth = 24;
		int nights = 3;
		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));
		String Unitname = "AM118B";
		WebElement unit = driver.findElement(By
				.xpath("//table[@class='table table-bordered table-striped unitscode-holder']//td[contains(@unit_code,'"
						+ Unitname + "')]"));// 240,
												// 277
		WebElement quote = driver.findElement(By.xpath("//div[@id='contextMenu']//a[@id='openreservation']"));
		// Search unit
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Unitname);
		// this will find all matching nodes in calendar
		List<WebElement> allDates = driver.findElements(By.xpath(
				"//div[@class='day-header-holder']/table[@class='table']//tr[contains(@class,'daynumberheader')]//div"));

		// to do MAKE DATE COUNTER DYNAMIC
		int dateCounter = 0;
		// now we will iterate all values and will capture the text. We will select when
		// date is 28

		for (WebElement ele : allDates) {

			String date = ele.getText();
			dateCounter++;
			// System.out.println(date); // once date is 28 then click and break
			if (date.equals("11")) {
				break;
			}
		}

		Actions act2 = new Actions(driver);

		// System.out.println(recervationpoint.getRect().x + " - " +
		// recervationpoint.getRect().y);// 455 - 220
		act2
				// initially mouse will be at (0,0)
				.moveByOffset(recervationpoint.getRect().x + (singleDayWidth * dateCounter), unit.getLocation().y)
				// click and hold on current location, will be res div
				.click()

				// move by days + width
				.moveByOffset(singleDayWidth * nights, 3).contextClick().click(quote).build().perform();
		// delete reservation
		driver.findElement(By.xpath("//a[@class='btn btn-sm btn-secondary mb-2']")).click();
		// opens the dropdown
		driver.findElement(By.xpath("//div[@class='mb-3 ']//select")).click();

		List<WebElement> options = driver.findElements(By.xpath("//div[@class='mb-3 ']//option"));

		for (WebElement option : options) {
			// System.out.println(option.getText());
			if (option.getText().equals("Other")) {
				option.click();
				break;
			}
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='d-flex justify-content-between']//a[@class='btn btn-primary cancelres']")))
				.click();

	}

}
