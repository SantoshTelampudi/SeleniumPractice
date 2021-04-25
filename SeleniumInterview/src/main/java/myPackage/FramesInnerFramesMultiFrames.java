package myPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesInnerFramesMultiFrames {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
	//	options.setHeadless(true);
		WebDriverManager.chromedriver().setup();
	/*	WebDriver driver = new ChromeDriver(options);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/package-summary.html");
		
		driver.switchTo().frame("packageListFrame");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'org.openqa.selenium.devtools.idealized.browser.mod')]")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("packageFrame");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='BrowserContextID']")).click();
		driver.switchTo().defaultContent();
		
		
		driver.switchTo().frame("classFrame");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Deprecated']")).click();
		driver.switchTo().defaultContent();
		
		driver.quit(); */
		
		WebDriver driver1 = new ChromeDriver(options);
		
		driver1.manage().deleteAllCookies();
		driver1.manage().window().maximize();

		
		driver1.get("http://demo.automationtesting.in/Frames.html");

		driver1.findElement(By.xpath("//a[normalize-space()=\"Iframe with in an Iframe\"]")).click();
		
		WebElement frame = driver1.findElement(By.xpath("//iframe[@src=\"MultipleFrames.html\"]"));
		driver1.switchTo().frame(frame);
		
		WebElement fram1 = driver1.findElement(By.xpath("//iframe[normalize-space()=\"<p>Your browser does not support iframes.</p>\"]"));
		driver1.switchTo().frame(fram1);
		
		driver1.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Hello");
		Thread.sleep(2000);
		
		driver1.quit();
		
		
		
		
		
		
		
		


	}

}
