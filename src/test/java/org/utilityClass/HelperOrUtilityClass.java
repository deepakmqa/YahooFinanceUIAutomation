package org.utilityClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperOrUtilityClass {

	public static WebDriver driver;
	public static Select s;
	public static Actions a;

	public static void launchBrowser() {

		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Successfully launched Browser");

		} catch (Exception e) {
			System.out.println("Browser not launced successfully");
		}

	}

	public static void maxWindow() {
		try {
			driver.manage().window().maximize();

		} catch (Exception e) {
			System.out.println("Window not maximized");
		}

	}

	public static void clickOnElement(WebElement element) {
		try {

			element.click();
			System.out.println("Successfully clicked Element");
		} catch (Exception e) {
			System.out.println("Failed to click");
		}

	}

	public static void dropdownSelect(WebElement ele, String val) {
		try {
			s = new Select(ele);
			s.selectByValue(val);
			System.out.println("Sucessfully selected");
		} catch (Exception e) {
			System.out.println("Failed to select");

		}

	}

	public static void checkCurrentUrl() {
		try {

			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl + " Successfully Printing Current Url");
		} catch (Exception e) {
			System.out.println("Failed to print current url");
		}
	}

	public static void checkTitle() {
		try {
			String title = driver.getTitle();
			System.out.println(title + " Successfully Printing title");
		} catch (Exception e) {
			System.out.println("Failed to print title");
		}
	}

	public static void passUrl(String url) {
		try {
			driver.get(url);
			System.out.println("Launced Url Successfully");

		} catch (Exception e) {
			System.out.println("Failed to Lauch Url");
		}
	}

	public static void mouseMoveToElement(WebElement element) {
		try {
			a = new Actions(driver);
			a.moveToElement(element);
			System.out.println("Successfully moved to element");

		} catch (Exception e) {
			System.out.println("Failed to move successfully");
		}

	}

	public static void passingValues(WebElement element, String value) {
		try {
			element.sendKeys(value);

		} catch (Exception e) {
			System.out.println("Failed to pass values");
		}
	}

	public static void scrollToElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView('true')", ele);

	}

	public static  void browserClose() {
		driver.close();
	}

}
