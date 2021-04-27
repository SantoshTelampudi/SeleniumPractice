package myPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		// options.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.calculator.net/age-calculator.html");
		String Year = "2015";
		String Month = "July";
		String date = "24";
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL);

		driver.findElement(By.xpath("//a[@id=\"today_ID_Link\"]//img[@title=\"Calendar\"]")).click();
		System.out.println(driver.findElement(By.xpath("//td[@id=\"today_Current_ID\"]")).getText());
		
		while (true) {
			
			String MonthYear = driver.findElement(By.xpath("//td[@id=\"today_Current_ID\"]")).getText();
			String arr[] = MonthYear.split(" ");
			String currentyear = arr[1];
			String currentMonth = arr[0];
			//System.out.println(arr[0]);
			//System.out.println(arr[1]);
			if ((currentMonth.equalsIgnoreCase(Month)) && (currentyear.equals(Year))) {
				driver.findElement(By.xpath("//span[@id=\"today_ID\"]/span/table/tbody/tr/td[normalize-space(text())='1']")).click();
				break;
			} else {
				driver.findElement(By.xpath("//td[@id=\"today_Previous_ID\"]")).click();
			}
		}

	}

}
