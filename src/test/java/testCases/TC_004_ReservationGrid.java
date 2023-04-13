package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ReservationMenu;
import testBase.BaseClasslogin;

public class TC_004_ReservationGrid extends BaseClasslogin{
	
	@Test
	public void ValidateSearchingWithAnExistingUnitName()
	{
		String unitName="SHORE105";
		ReservationMenu reservation = new ReservationMenu(driver);
		reservation.clickReservationMenu();
		reservation.clickreservationgrid();
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(unitName);
		String actualunitName=driver.findElement(By.xpath("//div[@unit_code='"+ unitName +"']")).getText();
		Assert.assertEquals(actualunitName, "SHORE105 | 105 The Shores - 2311484");
	
	}
  
}
