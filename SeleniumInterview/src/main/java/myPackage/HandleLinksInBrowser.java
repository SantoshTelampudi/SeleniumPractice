package myPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinksInBrowser {

	public static void main(String[] args) {
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		for(WebElement link : links)
		{
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}
		

	}

}
