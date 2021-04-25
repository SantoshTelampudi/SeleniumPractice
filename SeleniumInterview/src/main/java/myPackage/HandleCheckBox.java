package myPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//1) How To Select specific Check box?
			//	2) How to select all the check boxes?
				//3) How to select multiple check boxes by choice?
				//How to select last N check boxes?
				//5) How to select first N check boxes?

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		//options.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	

		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	//	driver.findElement(By.xpath("//input[@id='monday']")).click();
		
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		
		for (WebElement CheckBox :checkbox)
		{
			String s1 = CheckBox.getAttribute("id");
			if(s1.equals("saturday"))
				CheckBox.click();
			Thread.sleep(2000);
		}
		
		// to select last 2 check boxes
		for (int i = checkbox.size() -2 ; i< checkbox.size();i++)
		{
			checkbox.get(i).click();
		}
		
		driver.quit();
		
	}

}
