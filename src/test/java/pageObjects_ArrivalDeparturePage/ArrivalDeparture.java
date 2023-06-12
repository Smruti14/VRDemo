package pageObjects_ArrivalDeparturePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ArrivalDeparture {
	WebDriver driver;

	public void startdate (String year, String month, String date) {

		driver.findElement(By.xpath("//input[@name='forhkrepstartdate']")).click();

		// Select month & year

		while (true) {
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (mon.equals(month.toUpperCase()) && yr.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//a[@title='Next']")).click(); // Next date
			driver.findElement(By.xpath("//a[@title='Prev']")).click(); // Prev date

		}
		// select date
		List<WebElement> creatAllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement dt : creatAllDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}

	}
	
	public void enddate(String year, String month, String date) {

		driver.findElement(By.xpath("//input[@name='forhkrependdate']")).click();

		// Select month & year

		while (true) {
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (mon.equals(month.toUpperCase()) && yr.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//a[@title='Next']")).click(); // Next date
			driver.findElement(By.xpath("//a[@title='Prev']")).click(); // Prev date

		}
		// select date
		List<WebElement> creatAllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement dt : creatAllDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}

	}
	
	public void zone(String zoneName) {

		WebElement selectZone= driver.findElement(By.xpath("//select[@name='forhkrepzone']"));
		selectZone.click();
		Select view1=new Select(selectZone);
		view1.selectByVisibleText(zoneName);

	}
	
	public void bookingStatus(String bookingStatusName) {

		WebElement selectbookingStatus= driver.findElement(By.xpath("//select[@name='reservation_status']"));
		selectbookingStatus.click();
		Select view1=new Select(selectbookingStatus);
		view1.selectByVisibleText(bookingStatusName);

	}
	

}
