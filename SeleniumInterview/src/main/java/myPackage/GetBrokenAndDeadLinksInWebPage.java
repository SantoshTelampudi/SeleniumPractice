package myPackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetBrokenAndDeadLinksInWebPage {

	public static void main(String[] args) throws IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		options.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("");

		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int ValidLink = 0;
		int BrokenLink = 0;

		for (WebElement link : links) {
			String url = link.getAttribute("href");

			if (url == null || url.isEmpty()) {

				System.out.println(link.getText() + " is not contains any URL");
				continue;

			}
			URL converturl = new URL(url);
			try {
				HttpURLConnection connect = (HttpURLConnection) converturl.openConnection();
				connect.connect();
				if (connect.getResponseCode() >= 400) {
					System.out.println(converturl + " its a broken link ");
					BrokenLink++;
				} else {
					System.out.println(converturl + " its a Valid link ");
					ValidLink++;
				}
			} catch (Exception e) {

			}

		}
		System.out.println("total valid links are " + ValidLink);
		System.out.println("total invalid links are " + BrokenLink);

	}

}
