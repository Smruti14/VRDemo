package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ReservationMenu;
import testBase.BaseClasslogin;

public class TC005ReservationGrideWithQuickQuote extends BaseClasslogin{
	@Test
	public void verifywithvalidquickquote() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		ReservationMenu reservation = new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickreservationgrid();

			Actions act = new Actions(driver);
			int singleDayWidth = 24;
			int nights = 5;
			WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));// 427,
																														// 220
																														// //
																														// 220
			WebElement unit = driver.findElement(By.xpath(
					"//table[@class='table table-bordered table-striped unitscode-holder']//td[contains(@unit_code,'SMR001')]"));// 240,
																																	// 277
			WebElement quote = driver.findElement(By.xpath("//a[@id='quickquotemodelanchor']"));

			// this will find all matching nodes in calendar
			List<WebElement> allDates = driver.findElements(By.xpath(
					"//div[@class='day-header-holder']/table[@class='table']//tr[contains(@class,'daynumberheader')]//div"));// (453,
			// Search unit
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("SMR001");
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
			driver.findElement(By.xpath("//input[@name='unit_code']")).sendKeys("SMR001");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//p[@class='unitname']")).click();
			driver.findElement(By.xpath("(//a[normalize-space()='RU'])")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Price & Availability']")).click();
			driver.findElement(By.xpath("//a[@id='pricing-tab']")).click();
			List<WebElement> rows = driver.findElements(By.xpath(
					"//table[@class='table table-striped table-bordered align-middle seasonal-price-list ru-busy is-component']//tr"));
			// assuming the ArrayList of prices is already populated
//					Map<String, Double> priceMap = new HashMap<>();
//					priceMap.put("04/10/2023", 10.0);
//					priceMap.put("04/11/2023", 10.0);
//					priceMap.put("04/12/2023", 09.0);
//					priceMap.put("04/13/2023", 09.0);
//					priceMap.put("04/14/2023", 09.0);
			// iterate through the rows of the table
			for (WebElement row : rows) {
				System.out.println(row.getSize());

				List<WebElement> cells = row.findElements(By.xpath(
						"//table[@class='table table-striped table-bordered align-middle seasonal-price-list ru-busy is-component']//td"));
				// assuming the first cell contains the date and the second cell contains the
				// total price
				String date = cells.get(3).getText();
				System.out.println(date);
				Double totalPrice = Double.parseDouble(cells.get(4).getText());
				System.out.println(totalPrice);

			}
		}
	}

