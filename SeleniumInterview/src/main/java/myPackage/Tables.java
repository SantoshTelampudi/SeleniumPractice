package myPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		options.setHeadless(true);
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://github.com/serenity-bdd/serenity-core");

		for (int i = 2; i <= 60; i++) {
			for (int j = 2; j <= 4; j++) {
				
						if(j==3)
						{
							System.out.print("----------");
						}
						System.out.print(driver.findElement(By.xpath("//*[@id=\"repo-content-pjax-container\"]/div/div[2]/div[1]/div[2]/div[3]/div[1]/div["
								+ i + "]/div[" + j + "]")).getText());
				        if(j==3)
				        {
				        	System.out.print("-------------");
				        }
			}
			System.out.println();
		}


		/*
		 * for(WebElement li : list1) { System.out.println(li.getText()); }
		 */
		// System.out.println(driver.findElement(By.xpath("//*[@id=\"repo-content-pjax-container\"]/div/div[2]/div[1]/div[2]/div[3]/div[1]/div[6]/div[2]")).getText());
		// List<WebElement> list =
		// driver.findElements(By.xpath("//*[@id=\"repo-content-pjax-container\"]/div/div[2]/div[1]/div[2]/div[3]/div[1]/div"));

		// System.out.println(list.size());

	}

}
