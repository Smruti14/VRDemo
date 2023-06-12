package testCases_ArrivalDeparture;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import testBase.BaseClasslogin;

public class TC_015_arrivalDepartureTestCase extends BaseClasslogin {

	@Test
	public void validateArrivalDeparturePage() throws InterruptedException {

		// Locate the table element on the first page
		driver.findElement(By.xpath("//div[@id='main_menu_tab_7']//span[contains(text(),'Reports')]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Arrival Departure']")).click();
		List<WebElement> table = driver.findElements(By.xpath("//table[@class='table table-striped']//td//b"));

		for (WebElement name : table) {

			System.out.println("columnname text" + name.getText() + ", "); // here is is just printing number of rows,
																			// like 1, 2
		}

		driver.findElement(By.xpath("//span[normalize-space()='Arrival Departure']")).click();

		// Table 1
		WebElement table1 = driver.findElement(By.xpath("//table[@class='table table-striped']//td//b"));
		List<List<String>> table1Data = getTableData(table1);

		driver.get("https://example.com/page2");

		// Table 2
		WebElement table2 = driver.findElement(By.id("table2"));
		List<List<String>> table2Data = getTableData(table2);

		driver.get("https://example.com/page3");

		// Table 3
		WebElement table3 = driver.findElement(By.id("table3"));
		List<List<String>> table3Data = getTableData(table3);

		// Compare the tables
		if (compareTables(table1Data, table2Data, table3Data)) {
			System.out.println("Tables are the same.");
		} else {
			System.out.println("Tables have differences.");
		}

		driver.quit();
	}

	private static List<List<String>> getTableData(WebElement table) {
		List<List<String>> tableData = new ArrayList<>();

		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List<String> rowData = new ArrayList<>();
			List<WebElement> columns = row.findElements(By.tagName("td"));
			for (WebElement column : columns) {
				rowData.add(column.getText());
			}
			tableData.add(rowData);
		}

		return tableData;
	}

	private static boolean compareTables(List<List<String>> table1Data, List<List<String>> table2Data,
			List<List<String>> table3Data) {
		// Compare table sizes
		if (table1Data.size() != table2Data.size() || table1Data.size() != table3Data.size()) {
			return false;
		}

		// Compare table data
		for (int i = 0; i < table1Data.size(); i++) {
			List<String> row1 = table1Data.get(i);
			List<String> row2 = table2Data.get(i);
			List<String> row3 = table3Data.get(i);

			if (!row1.equals(row2) || !row1.equals(row3)) {
				return false;
			}
		}

		return true;

	}
}
