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

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptexecutoorr {

	public static void main(String[] args) throws IOException {
	
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		//options.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.dominos.co.in/");
		
		WebElement logo = driver.findElement(By.xpath("//a[@class=\"logo-image\"]//img"));
		javascriptutil.drawboarder(logo, driver);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("./SeleniumInterview/src/main/java/myPackage/screenshots/boarder.png");
		FileUtils.copyFile(src, trg);
		driver.quit();
	}

}
