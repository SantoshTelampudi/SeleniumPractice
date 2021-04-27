package myPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javascriptutil {
	
	public static void drawboarder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static String getTitle(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title:").toString();
		return title;
	}
	
	public static void click(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void generatealert(String message, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('"+message+"')", driver);
	}
	
	

}
