package testCases_ArrivalDeparture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testBase.BaseClasslogin;

public class TC_016_DDTestArrivalDeparture extends BaseClasslogin {

	int col = 0;
	String path = ".\\testdata\\ADdata.xlsx";
	ExcelUtils xutils = new ExcelUtils(path);

	@SuppressWarnings("static-access")
	@Test
	public void writeArrivalDepartureData() throws IOException, InterruptedException {

		driver.findElement(By.xpath("//div[@id='main_menu_tab_7']//span[contains(text(),'Reports')]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Arrival Departure']")).click();

		List<WebElement> Title = driver.findElements(
				By.xpath("//div[@id='thisneedstobeprinted']//h5[@class='grayback mt-3 mb-3 gray-sub-head']"));
		ArrayList<String> adData = new ArrayList<String>();
		ArrayList<String> aData = new ArrayList<String>();
		ArrayList<String> dData = new ArrayList<String>();

		for (WebElement adtitle : Title) {
			String arrival = adtitle.getText();

			// System.out.println(arrival);

			xutils.setCellData("sheet1", 0, col, arrival);
			List<WebElement> table = driver.findElements(By.xpath("(//div[contains(@class,'table-responsive mb-3')])["
					+ (col + 1) + "]/table[@class='table table-striped']//tbody//td[1]/child::b"));
			for (int i = 0; i < table.size(); i++) {
				if (arrival.equals("Arrivals")) {
					adData.add(table.get(i).getText());
					
					
				} 
				else if (arrival.equals("Departures"))
				{
					dData.add(table.get(i).getText());
					

				} else {
					System.out.println("Condition fail");
				}
				aData.add(table.get(i).getText());
				xutils.setCellData("sheet1", i + 1, col, table.get(i).getText());
			}
			col++;

		}

		System.out.println("Total Array list Size of Arrival 0f AD form data : " + adData.size());
		System.out.println("Total Array list Size of depature  0f AD form data : " + dData.size());

		// Navigate on dispatch menu and select Assignment Date

		driver.findElement(By.xpath("//span[normalize-space()='Dispatch']")).click();
		String year = "2023";
		String month = "June";
		String date = "05";
		driver.findElement(By.xpath("//a[@class='datechanger btn btn-default ']")).click();

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
		Thread.sleep(3000);

		xutils.setCellData("sheet1", 0, 2, "Inspection");

		xutils.setCellData("sheet1", 0, 3, "Houskeeping");

		int col1 = 2;
		int col2 = 3;
		List<WebElement> inspElems = driver.findElements(
				By.xpath("//div[contains(@class,'eventbody')][@eventtype='insp']//span[@class='unit_code_label']"));
		List<WebElement> hkElems = driver.findElements(By.xpath(
				"//div[contains(@eventtype,'hk')] [@title!='Laundry Pickup'][@title!='Laundry Drop-off']//span[@class='unit_code_label']"));
		// System.out.println(inspElems.size());
		// System.out.println(hkElems.size());
		ArrayList<String> inspData = new ArrayList<String>();
		ArrayList<String> hkData = new ArrayList<String>();

		for (int i = 0; i < inspElems.size(); i++) {
			inspData.add(inspElems.get(i).getText());
			xutils.setCellData("sheet1", i + 1, col1, inspElems.get(i).getText());

		}

		for (int i = 0; i < hkElems.size(); i++) {

			hkData.add(hkElems.get(i).getText());
			xutils.setCellData("sheet1", i + 1, col2, hkElems.get(i).getText());

		}
		System.out.println("Total Array list Size of Inspection data : " + inspData.size());
		System.out.println("Total Array list Size of Housekeeping data : " + hkData.size());

		// 6 col ad => a

//		aData
//		adData
		xutils.setCellData("sheet1", 0, 5, "Departure => Housekeeping");
		for (int i = 0; i < hkData.size(); i++) {
			if (dData.contains(hkData.get(i))) {
				xutils.setCellData("sheet1", i + 1, 5, "Value Match");
			} else {
				xutils.setCellData("sheet1", i + 1, 5, "Value Does not Match");
			}
		}
		xutils.setCellData("sheet1", 0, 6, "Arrival  => Inspection");
		for (int i = 0; i < inspData.size(); i++) {
			if (aData.contains(inspData.get(i))) {
				xutils.setCellData("sheet1", i + 1, 6, "Value Match");
			} else {
				xutils.setCellData("sheet1", i + 1, 6, "Value Does not Match");
			}
		}

		// Navigate on arrival menu and select Assignment Date
		int col3 = 4;
		driver.findElement(By.xpath("//span[normalize-space()='Arrivals']")).click();

		String year1 = "2023";
		String month1 = "June";
		String date1 = "05";
		driver.findElement(By.xpath("//a[@class='datechanger btn btn-sm btn-default ']")).click();

		// Select month & year

		while (true) {
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (mon.equals(month1.toUpperCase()) && yr.equals(year1)) {
				break;
			}
			driver.findElement(By.xpath("//a[@title='Next']")).click(); // Next date
			driver.findElement(By.xpath("//a[@title='Prev']")).click(); // Prev date

		}
		// select date
		List<WebElement> creatAllDates1 = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		for (WebElement dt : creatAllDates1) {
			if (dt.getText().equals(date1)) {
				dt.click();
				break;
			}
		}

		xutils.setCellData("sheet1", 0, 4, "ArrivalData");

		List<WebElement> arrivalElems = driver
				.findElements(By.xpath("//table[@id='arrivalunits']/child::tbody//td[1]"));
		ArrayList<String> arrivalData = new ArrayList<String>();

		// System.out.println(arrivalElems.size());

		for (int i = 0; i < arrivalElems.size(); i++) {
			arrivalData.add(arrivalElems.get(i).getText());
			xutils.setCellData("sheet1", i + 1, col3, arrivalElems.get(i).getText().replace("Cancelled", ""));
		}

		System.out.println("Array size of Arrival data " + arrivalData.size());

		// 6 col ad => a

//		aData
//		adData

		xutils.setCellData("sheet1", 0, 7, "FORMULA A => AD");
		for (int i = 0; i < arrivalData.size(); i++) {
			if (adData.contains(arrivalData.get(i))) {
				xutils.setCellData("sheet1", i + 1, 7, "Value Match");
			} else {
				xutils.setCellData("sheet1", i + 1, 7, "Value Does not Match");
			}
		}
		int count = 0;

		xutils.setCellData("sheet1", 0, 8, "Arrival=>Inspection=>Arrival&Depature");
		for (int i = 0; i < adData.size(); i++) {
			String singleAD = adData.get(i);
			if(inspData.contains(singleAD) && arrivalData.contains(singleAD)) {
				xutils.setCellData("sheet1", i + 1, 8, "Value Match");
			} else {
				xutils.setCellData("sheet1", i + 1, 8, "Value Does not Match");
			}

//			for (int j = 0; j < inspData.size(); j++) {
//
//				for (int k = 0; k < arrivalData.size(); k++) {
//					if ( adData.contains(inspData.get(j)) == (adData.contains(arrivalData.get(k)))) {
//						count = count + 1;
//						if (adData.contains(arrivalData.get(i))) {
//							xutils.setCellData("sheet1", i + 1, 8, "Value Match");
//						} else {
//							xutils.setCellData("sheet1", i + 1, 8, "Value Does not Match");
//						}
//					}
//
//				}
//			}
		}

		// xutils.setCellData("sheet1", 0, 7, "A => AD");
//		int maxRow = Math.max(aData.size(), adData.size());
//		for (int i = 0; i < maxRow; i++) {
//			xutils.setCellFormula("sheet1", i + 1, 7,
//					"IF(ISERROR(VLOOKUP(E" + (i + 2) + ",$A$2:$A$" + (maxRow + 1) + ",1,Value Does not Match)),Value Does not Match,Value Match)");
//		}

		// xutils.workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	}

}