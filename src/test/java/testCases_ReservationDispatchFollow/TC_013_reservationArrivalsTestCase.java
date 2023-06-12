package testCases_ReservationDispatchFollow;

import testBase.BaseClasslogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.dispatchMenu;

public class TC_013_reservationArrivalsTestCase extends BaseClasslogin {
	@Test
	public void validateArrivalswithvaliddata() throws InterruptedException {

		dispatchMenu housekeepingMenu = new dispatchMenu(driver);
		
			housekeepingMenu.houseKeepingMenu();
			housekeepingMenu.arrivals();
		

		// Assignment Date
		String year = "2023";
		String month = "May";
		String date = "18";
		driver.findElement(By.xpath("//a[@class='datechanger btn btn-sm btn-default ']")).click();

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
		} //
		List<WebElement> allUnitCode = driver.findElements(By.xpath("//table[@id='arrivalunits']//td[1]"));
//		 boolean markChecked = driver.findElement(By.xpath("//table[@id='arrivalunits']//i[contains(@class,'fas fa-times eventmodalhandler')]")).isDisplayed();
//		 boolean unChecked = driver.findElement(By.xpath("//table//i[@style='color:#05a34a;']")).isDisplayed();

		int unitCodeCounter = 0;

		String unitcodename = "DWH502";
		for (WebElement ele : allUnitCode) {

			int total=allUnitCode.size();
			unitCodeCounter++;
			// System.out.println(unitCode);
			if (ele.getText().equals(unitcodename)) {
				WebElement clickInsunit = driver.findElement(By.xpath("//td[normalize-space()='" + unitcodename
						+ "']/following-sibling::td//i[contains(@class,'fas fa-times eventmodalhandler')]"));
				clickInsunit.click();
				break;
			}
		}
	
		// Click on mark all 
		driver.findElement(By.xpath("//a[@id='modalcompletedlink']")).click();
		Thread.sleep(2000);
		//close the window
		driver.findElement(By.xpath("//div[@id='eventsmodel']//button[@type='button'][normalize-space()='×']")).click();
		Thread.sleep(3000);
		//HouseKeeping 
		List<WebElement> allUnitCode1 = driver.findElements(By.xpath("//table[@id='arrivalunits']//td[1]"));
		
		String unitcodename1 = "DWH502";
		for (WebElement ele : allUnitCode1) {

			//String unitCode = ele.getText();
			unitCodeCounter++;
			// System.out.println(unitCode);
			if (ele.getText().equals(unitcodename1)) {
				WebElement clickInsunit1 = driver.findElement(By.xpath("//td[normalize-space()='" + unitcodename1
						+ "']/following-sibling::td//i[contains(@class,'fas fa-times eventmodalhandler')]"));
				clickInsunit1.click();
				break;
			}
		}
	
		// Click on mark all 
		driver.findElement(By.xpath("//a[@id='modalcompletedlink']")).click();
		Thread.sleep(2000);
		//close the window
		driver.findElement(By.xpath("//div[@id='eventsmodel']//button[@type='button'][normalize-space()='×']")).click();
		//HouseKeeping 
	}

}
