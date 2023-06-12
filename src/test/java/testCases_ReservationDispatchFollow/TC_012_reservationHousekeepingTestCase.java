package testCases_ReservationDispatchFollow;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ReservationMenu;
import testBase.BaseClasslogin;

public class TC_012_reservationHousekeepingTestCase extends BaseClasslogin {
	@Test
	public void validatereservationtoHousekeepingwithValidCredentials() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ReservationMenu reservation = new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickreservationgrid();

		Actions act = new Actions(driver);
		int singleDayWidth = 24;
		int nights = 3;
		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));// 427,220
																												
		String unitName = "AM118B"; // 220
		WebElement unit = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped unitscode-holder']//td[contains(@unit_code,'"+ unitName + "')]"));// 240,277
		WebElement quote = driver.findElement(By.xpath("//a[@id='quickquotemodelanchor']"));
		// Search unit
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(unitName);
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
			if (date.equals("17")) {
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
				.moveByOffset(singleDayWidth * nights, 3).contextClick().click(quote).perform();

		String actualunitname = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//b[contains(.,'Quick Quote')]"))).getText();
	
		Assert.assertEquals(actualunitname, "Quick Quote");

		driver.findElement(By.xpath("//button[@class=\"btn btn-primary continue\"]")).click();
		driver.findElement(By.xpath("//input[@id='searchguest']")).sendKeys("parekhsmruti31@gmail.com");
		Thread.sleep(3000);
		List<WebElement> guestlist = driver.findElements(By.xpath(
				"//ul//div[@class='d-flex justify-contnet-start align-items-start flex-wrap ui-menu-item-wrapper']"));
		for (WebElement guest : guestlist) {
			guest.click();
		}
		driver.findElement(By.xpath("//button[@class='btn btn-primary continue']")).click();
		String ActualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success text-center p-3']"))
				.getText();
		Assert.assertEquals(ActualMessage, "Reservation Created Successfully.");
		
		
		driver.findElement(By.xpath(
				"//div[@class='uk-modal-dialog uk-modal-body modal-content modal-dialog-scrollable']//div[@class='modal-header']//button[@type='button']"))
				.click();
		driver.findElement(By.xpath("//div[@class='sidebar-body thisactive ps']//a[@id='mainmenua7 ']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Dispatch']")).click();
		
		// Assignment Date
				String year = "2023";
				String month = "May";
				String date = "20";
				driver.findElement(By.xpath("//a[@class='datechanger btn btn-default ']")).click();

				// Select month & year
				
				while (true) {
					String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
					String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
					if (mon.equals(month.toUpperCase()) && yr.equals(year)) {
						break;
					}

					driver.findElement(By.xpath("//a[@title='Prev']")).click(); // Prev date

				}
				// select date
				List<WebElement> creatAllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
				for (WebElement dt : creatAllDates) {
					if (dt.getText().equals(date)) {
						dt.click();
						break;
					}
				} //
				
				Thread.sleep(5000);
				String unitCode = "AM118B";
				WebElement terms = driver.findElement(By.xpath("//span[normalize-space()='AM118B']"));
			      // scroll down the web element for viewing
			
				js.executeScript("arguments[0].scrollIntoView();", terms);
			     
				
				
	}

}
