package myPackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver.WindowType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotMultipleFormats {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		// options.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("https://www.dominos.co.in/");

		/*driver.switchTo().WindowType(WindowType.TAB);
		driver.switchTo().WindowTtype(WindowType.WINDOW); */
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File fs =  ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\SeleniumInterview\\src\\main\\java\\myPackage\\screenshots\\"+"DomniosHomePage"+".png");
		FileUtils.copyFile(fs, trg);
		
		WebElement info = driver.findElement(By.xpath("//div[@class=\"seo-content\"]"));
		File src = info.getScreenshotAs(OutputType.FILE);
		File Target = new File(".\\SeleniumInterview\\src\\main\\java\\myPackage\\screenshots\\"+"info"+".png");
		FileUtils.copyFile(src, Target);
		
		driver.quit();
	}

}
