package myPackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownCollectionsArrayList {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		//options.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.dominos.co.in/");

		driver.findElement(By.xpath("//*[contains(text(),'STORE FINDER')]")).click();
		driver.findElement(By.xpath("//*[contains(@href,'advsear')]")).click();
		ArrayList states = new ArrayList();
		ArrayList cities = new ArrayList();
		ArrayList streets = new ArrayList();

		WebElement dropdown = driver.findElement(By.xpath("//*[@id='advanced-search-block-state']"));

		Select drpdown = new Select(dropdown);
		List<WebElement> list1 = drpdown.getOptions();
		for (WebElement list : list1) {
			//System.out.println(list.getText());
			states.add(list.getText());
			String state = "Chandigarh";
			if (!list.getText().equals(state))
			{
				list.click();
				WebElement State = driver.findElement(By.xpath("//*[@id='advanced-search-block-city']"));
				Select statedrpdown = new Select(State);
				List<WebElement> stateList = statedrpdown.getOptions();
				for (WebElement statelist : stateList) {

					//System.out.println(statelist.getText());
					statelist.click();
					cities.add(statelist.getText());
					WebElement city = driver.findElement(By.xpath("//*[@id='advanced-search-block-locality']"));
					Select citydrpdown = new Select(city);
					List<WebElement> citylist = citydrpdown.getOptions();
					for (WebElement cityList : citylist) {
						streets.add(cityList.getText());
					}
				}
			}
			// System.out.println(list.getText());
		}
		System.out.println(states);
		Collections.sort(states);
		Collections.reverse(states);
		System.out.println(states);
		
		ArrayList<Integer> numbers = new ArrayList();
		numbers.add(1, 10);
		 
		//ArrayList<Object> sampletext = new ArrayList();
		Collections.swap(states, 1, 4);
		
		driver.quit();

	}
}
