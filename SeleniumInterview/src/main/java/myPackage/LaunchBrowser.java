package myPackage;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		//options.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.testandquiz.com/selenium/testing.html");
		
		/* Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]")));
		action.build().perform();
		Thread.sleep(5000);
		
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		/*for(WebElement link : links)
		{
			System.out.println(link.getText() + " - " + link.getAttribute("href"));
		}
		
		Dimension size  = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight(); */
        

		Select select = new Select(driver.findElement(By.xpath("//select[@id=\"testingDropdown\"]")));
		select.selectByVisibleText("Manual Testing");
		select.selectByValue(null);
		
		//driver.quit();
	}

}
