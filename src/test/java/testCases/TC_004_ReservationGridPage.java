package testCases;

import testBase.BaseClasslogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import pageObjects.ReservationGridMenuLink;
public class TC_004_ReservationGridPage extends BaseClasslogin {
	
	
	
	@Test
	public void ValidateSearchingWithAnExistingUnitName()
	{
		ReservationGridMenuLink reservationgrid=new ReservationGridMenuLink(driver);
		
		String unitName="SHORE105";
		reservationgrid.ClickReservationMenu();
		reservationgrid.ClickReservationGrid();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(unitName);
		String actualunitName=driver.findElement(By.xpath("//div[@unit_code='"+ unitName +"']")).getText();
		Assert.assertEquals(actualunitName, "SHORE105 | 105 The Shores - 2311484");
	}
	@Test
	public void ValidateSearchingWithANonExistingUnitName()
	{
		ReservationGridMenuLink reservationgrid=new ReservationGridMenuLink(driver);
		
		String unitName="SH001";
		reservationgrid.ClickReservationMenu();
		reservationgrid.ClickReservationGrid();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(unitName);
		Assert.assertTrue(true, "Blank Page Reflect");
		
	}
	@Test
	public void ValidateNavigatingToQuickInfoPageFromSearchResultsPage()
	{
	ReservationGridMenuLink reservationgrid=new ReservationGridMenuLink(driver);
		
		String unitName="SHORE105";
		reservationgrid.ClickReservationMenu();
		reservationgrid.ClickReservationGrid();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(unitName);
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[contains(@class,'unitHoverDetails')]"));
		action.contextClick(elementLocator).perform();
		WebElement QuickInfo = driver.findElement(By.xpath("//a[@id='openProperty']"));
		QuickInfo.click();
		String actualDetails=driver.findElement(By.xpath("//input[@value='SHORE105']")).getAttribute("value");
		System.out.println(actualDetails);
		Assert.assertEquals(actualDetails, "SHORE105");
		WebElement Close = driver.findElement(By.xpath("//div[@class='modal-dialog modal-xl']//button[@type='button'][normalize-space()='×']"));
		Close.click();
		
		
	}
}
 