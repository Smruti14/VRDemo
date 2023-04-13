package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.GuestPage;
import pageObjects.ReservationMenu;
import testBase.BaseClasslogin;

public class TC_005_ReservationGuestPage extends BaseClasslogin {
	@Test
	public void verifycreatevalidNewGuest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		ReservationMenu reservation = new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickreservationgrid();

		Actions act = new Actions(driver);
		int singleDayWidth = 24;
		int nights = 3;
		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));// 427,
																													// 220
																													// //
																													// 220
		WebElement unit = driver.findElement(By.xpath(
				"//table[@class='table table-bordered table-striped unitscode-holder']//td[contains(@unit_id,'1503')]"));// 240,
																															// 277
		WebElement quote = driver.findElement(By.xpath("//a[@id='quickquotemodelanchor']"));

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
			if (date.equals("29")) {
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
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary continue\"]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary newguest float-end']")).click();
		GuestPage GP = new GuestPage(driver);
		GP.firstName("Smruti");
		GP.lastName("Parekh");
		GP.email("test14@gmail.com");
		GP.phone("704373307");
		GP.add1("Address1");
		GP.add2("Address2");
		GP.city("Florida");
		GP.state("Florida");
		GP.postal("390021");
		GP.cardno("4141 4141 4141 4141");
		GP.CVV("12345");
		GP.ExpirationDate();
		GP.year("2023");
		GP.save();
		
		WebElement Guestdetails=driver.findElement(By.xpath("//div[@id='guestinfodiv']//ul"));
		List<WebElement> links = Guestdetails.findElements(By.xpath("//ul[@id='guestinfoui']//li[@class='list-group-item']"
				+ ""));
		for (int i = 1; i < links.size(); i++)
		{
		    System.out.println(links.get(i).getText());
		}
	}

	public void verifycreateinvalidNewGuest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		ReservationMenu reservation = new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickreservationgrid();

		Actions act = new Actions(driver);
		int singleDayWidth = 24;
		int nights = 3;
		WebElement recervationpoint = driver.findElement(By.xpath("//div[@class='reservationgridholderholder']"));// 427,
																													// 220
																													// //
																													// 220
		WebElement unit = driver.findElement(By.xpath(
				"//table[@class='table table-bordered table-striped unitscode-holder']//td[contains(@unit_id,'1503')]"));// 240,
																															// 277
		WebElement quote = driver.findElement(By.xpath("//a[@id='quickquotemodelanchor']"));

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
			if (date.equals("29")) {
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
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary continue\"]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary newguest float-end']")).click();
		GuestPage GP = new GuestPage(driver);
		GP.firstName("Smruti");
		GP.lastName("Parekh");
		GP.email("test14@gmail.com");
		GP.phone("704373307");
		GP.add1("Address1");
		GP.add2("Address2");
		GP.city("Florida");
		GP.state("Florida");
		GP.postal("390021");
		GP.cardno("4141 4141 4141 4141");
		GP.CVV("12345");
		GP.ExpirationDate();
		GP.year("2023");
		GP.save();

		
		
	}

}
