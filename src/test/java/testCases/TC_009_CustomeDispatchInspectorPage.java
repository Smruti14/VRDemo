package testCases;

import testBase.BaseClasslogin;

import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_009_CustomeDispatchInspectorPage extends BaseClasslogin {
	@Test
	public void validateNewAssignmenIntoTheApplicationUsingValidCredentialsForInspectorOption()
			throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		// Unit
		WebElement selectunit = driver.findElement(By.xpath("//select[contains(@name,'unit_id')]"));
		selectunit.click();
		Select unit = new Select(selectunit);

		unit.selectByVisibleText("test01");
		// Inspector
		WebElement selecthk = driver.findElement(By.xpath("//select[@name='inspuser']"));
		selecthk.click();
		Select hk = new Select(selecthk);

		hk.selectByVisibleText("Smruti_test");

		// Assignment Date
		String year = "2023";
		String month = "May";
		String date = "12";
		driver.findElement(By.xpath("//input[@name='dateinsp']")).click();

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
		WebElement selectCleaning = driver.findElement(By.xpath("//select[@name='insptypes']"));
		selectCleaning.click();
		Select Cleaning = new Select(selectCleaning);
		Cleaning.selectByVisibleText("Inspection");

		//
		driver.findElement(By.xpath("//textarea[@name='inspnote']")).sendKeys("Test HouseKeeping menu");
		driver.findElement(By.xpath("//input[@class='btn btn-primary submitform col-md-12']")).click();

		String taskaddsucessfully = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();

		Assert.assertEquals(taskaddsucessfully, "Task Added.");
	}

	@Test
	public void validateNewAssignmentIntoTheApplicationWithoutProvideCredentialsForInspectorOption()
			throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		// Unit
		WebElement selectunit = driver.findElement(By.xpath("//select[contains(@name,'unit_id')]"));
		selectunit.click();
		Select unit = new Select(selectunit);

		unit.selectByVisibleText("Select Unit");

		// Inspector
		WebElement selectInspector = driver.findElement(By.xpath("//select[@name='inspuser']"));
		selectInspector.click();
		Select hk = new Select(selectInspector);

		hk.selectByVisibleText("Select User");

		// Assignment Date
		driver.findElement(By.xpath("//input[@name='dateinsp']")).sendKeys("");
		// Cleaning Type
		WebElement selectInspection  = driver.findElement(By.xpath("//select[@name='insptypes']"));
		selectInspection.click();
		Select Cleaning = new Select(selectInspection);
		Cleaning.selectByVisibleText("Inspection");

		// Note
		driver.findElement(By.xpath("//textarea[@name='inspnote']")).sendKeys("Test Inspector menu");
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

	

}