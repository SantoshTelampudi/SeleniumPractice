package myPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.xpath("//*[contains(text(),'OrangeHRM, Inc')]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> s1 = windowHandles.iterator();
		System.out.println(windowHandles.size());
		
		List<String> wdhandles = new ArrayList(windowHandles);
		
		
		for (int i=0;i<windowHandles.size();i++)
		{
			//System.out.println(wdhandles.get(i));
			driver.switchTo().window(wdhandles.get(i));
			System.out.println(driver.getTitle());
		//	System.out.println(s1.next());
		}
		
		
		
		driver.quit();
	}

}
