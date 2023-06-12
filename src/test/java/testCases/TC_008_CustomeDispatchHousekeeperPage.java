package testCases;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClasslogin;

public class TC_008_CustomeDispatchHousekeeperPage extends BaseClasslogin {
	@Test
	public void validateNewAssignmenIntoTheApplicationUsingValidCredentialsForHousekeeper()
			throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		// Unit
		WebElement selectunit = driver.findElement(By.xpath("//select[contains(@name,'unit_id')]"));
		selectunit.click();
		Select unit = new Select(selectunit);

		unit.selectByVisibleText("test01");
		// Housekeeper
		WebElement selecthk = driver.findElement(By.xpath("//select[@name='hkuser']"));
		selecthk.click();
		Select hk = new Select(selecthk);

		hk.selectByVisibleText("24-7cleaning");

		// Assignment Date
		String year = "2023";
		String month = "May";
		String date = "12";
		driver.findElement(By.xpath("//input[@name='datehk']")).click();

		// Select month & year

		while (true) {
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (mon.equals(month.toUpperCase()) && yr.equals(year)) {
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Future date

		}
		// select date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement dt : allDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;

			}
		}
		// Cleaning Type
		WebElement selectCleaning = driver.findElement(By.xpath("//select[@name='types']"));
		selectCleaning.click();
		Select Cleaning = new Select(selectCleaning);
		Cleaning.selectByVisibleText("Check Out Clean");

		//
		driver.findElement(By.xpath("//textarea[@name='hknote']")).sendKeys("Test HouseKeeping menu");
		driver.findElement(By.xpath("//input[@class='btn btn-primary submitform col-md-12']")).click();

		String taskaddsucessfully = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();

		Assert.assertEquals(taskaddsucessfully, "Task Added.");
	}

	@Test
	public void validateNewAssignmentIntoTheApplicationWithoutProvideAnyCredentialsForHousekeeperOption()
			throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		// Unit
		WebElement selectunit = driver.findElement(By.xpath("//select[contains(@name,'unit_id')]"));
		selectunit.click();
		Select unit = new Select(selectunit);

		unit.selectByVisibleText("Select Unit");

		// Housekeeper
		WebElement selecthk = driver.findElement(By.xpath("//select[@name='hkuser']"));
		selecthk.click();
		Select hk = new Select(selecthk);

		hk.selectByVisibleText("Select User");

		// Assignment Date
		driver.findElement(By.xpath("//input[@name='datehk']")).sendKeys("");
		// Cleaning Type
		WebElement selectCleaning = driver.findElement(By.xpath("//select[@name='types']"));
		selectCleaning.click();
		Select Cleaning = new Select(selectCleaning);
		Cleaning.selectByVisibleText("Check Out Clean");

		// Note
		driver.findElement(By.xpath("//textarea[@name='hknote']")).sendKeys("Test HouseKeeping menu");
		// Assign
		driver.findElement(By.xpath("//input[@class='btn btn-primary submitform col-md-12']")).click();
		// Check condition for unit drp
		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(alertMessage, "Please Select Unit For Inspect");
		alert.accept();
		// Check condition for housekeeper
		Alert alert1 = driver.switchTo().alert();
		String alertMessage1 = driver.switchTo().alert().getText();
		Assert.assertEquals(alertMessage1, "Please Select Housekeeper or Inspector.");
		alert1.accept();
	}

	@Test
	public void validateNewAssignmenIntoTheApplicationUsingValidCredentialsForHousekeeperAndCheckTaskAddInDispatchPage()
			throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		// Unit
		WebElement selectunit = driver.findElement(By.xpath("//select[contains(@name,'unit_id')]"));
		selectunit.click();
		Select unit = new Select(selectunit);

		unit.selectByVisibleText("test01");
		// Housekeeper
		WebElement selecthk = driver.findElement(By.xpath("//select[@name='hkuser']"));
		selecthk.click();
		Select hk = new Select(selecthk);

		hk.selectByVisibleText("24-7cleaning");

		// Assignment Date
		String year = "2023";
		String month = "May";
		String date = "12";
		driver.findElement(By.xpath("//input[@name='datehk']")).click();

		// Select month & year

		while (true) {
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (mon.equals(month.toUpperCase()) && yr.equals(year)) {
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Future date

		}
		// select date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement dt : allDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;

			}
		}
		// Cleaning Type
		WebElement selectCleaning = driver.findElement(By.xpath("//select[@name='types']"));
		selectCleaning.click();
		Select Cleaning = new Select(selectCleaning);
		Cleaning.selectByVisibleText("Check Out Clean");

		//
		driver.findElement(By.xpath("//textarea[@name='hknote']")).sendKeys("Test HouseKeeping menu");
		driver.findElement(By.xpath("//input[@class='btn btn-primary submitform col-md-12']")).click();

		String taskaddsucessfully = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();

		Assert.assertEquals(taskaddsucessfully, "Task Added.");

		// Assignment Date
		String Hyear = "2023";
		String Hmonth = "May";
		String Hdate = "12";

		driver.findElement(By.xpath("//a[@class='datechanger btn btn-default ']")).click();

		// Select month & year

		while (true) {
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (mon.equals(Hmonth.toUpperCase()) && yr.equals(Hyear)) {
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Future date

		}
		// select date
		List<WebElement> allDates1 = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement dt : allDates1) {
			if (dt.getText().equals(Hdate)) {
				dt.click();
				break;

			}
		}
		
		
		

	}

}