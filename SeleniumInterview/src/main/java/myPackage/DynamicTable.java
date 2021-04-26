package myPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://demo.opencart.com/admin/");

		driver.findElement(By.xpath("//button[normalize-space()=\"Login\"]")).click();

		driver.findElement(By.xpath("//a[normalize-space()=\"Sales\"]")).click();

		driver.findElement(By.xpath("//a[normalize-space()=\"Orders\"]")).click();

		String TotalPagenumber = driver.findElement(By.xpath("//div[@class=\"col-sm-6 text-right\"]")).getText();

		String totalpage = TotalPagenumber.substring(25, 28);
		String totalpage1 = TotalPagenumber.substring(TotalPagenumber.indexOf("(") + 1,
				TotalPagenumber.indexOf("Pages") - 1);
		int totalPages = Integer.parseInt(totalpage1);

		for (int i = 1; i <= totalPages; i++) {

			int total_tables = (driver.findElements(By.xpath("//table[@class=\"table table-bordered table-hover\"]//tbody/tr")).size());
			for (int j = 1; j <= total_tables; j++) {
				String Status = driver
						.findElement(By.xpath("//form[@id=\"form-order\"]/table/tbody/tr[" + j + "]/td[4]"))
						.getText();

				if (Status.equals("Pending")) {
					System.out.print(driver
							.findElement(
									By.xpath("//form[@id=\"form-order\"]/table/tbody/tr[" + j + "]/td[2]"))
							.getText());
					System.out.print(driver
							.findElement(
									By.xpath("//form[@id=\"form-order\"]/table/tbody/tr[" + j + "]/td[3]"))
							.getText());
					System.out.print(driver
							.findElement(
									By.xpath("//form[@id=\"form-order\"]/table/tbody/tr[" + j + "]/td[4]"))
							.getText());
				}
				System.out.println();

			}

			driver.findElement(By.xpath("//ul[@class=\"pagination\"]/li/a[text()='" + (i + 1) + "']")).click();

		}
	}
}
