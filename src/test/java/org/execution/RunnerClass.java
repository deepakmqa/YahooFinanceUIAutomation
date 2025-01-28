package org.execution;

import java.util.concurrent.TimeUnit;

import org.pojo.PojoClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.utilityClass.HelperOrUtilityClass;

public class RunnerClass extends HelperOrUtilityClass {

	PojoClass p = new PojoClass();

	@BeforeClass
	private void browserLaunch() {
		// Launching browser
		launchBrowser();
		// Open Url
		passUrl("https://finance.yahoo.com/");
		// maximize window
		maxWindow();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = -1)
	private void verifyTheCurrentUrl() {
		checkCurrentUrl();
	}

	@Test(priority = 0)
	private void verifyTheTitle() {
		checkTitle();
	}

	@Test(priority = 1)
	private void toTestWhetherUserAbleToSearchTheStockSymbolTeslaOnTheYahooFinanceHomePage() {
		p = new PojoClass();
		passingValues(p.getSerachTextBox(), "TSLA");

	}

	@Test(priority = 2)
	private void verifyTheAutoSuggestUponTypingTheTSLA() throws InterruptedException {
		p = new PojoClass();
		clickOnElement(p.getTeslaDropDownValue());
	}

	@Test(priority = 3)

	private void validateTheTeslaStockPage() throws InterruptedException {
		p = new PojoClass();
		String text = p.getTeslaIncText().getText();
		Assert.assertTrue(text.contains("Tesla, Inc."));
	}

	@Test(priority = 4)
	private void verifyTesleStockPriceandVerifyThatTheStockPriceIsGreaterThan$200() {
		try {
			p.mouseMoveToElement(p.getTeslaStockPrice());
			String currentPrice = p.getTeslaStockPrice().getText();
			System.out.println("Tesla Stock Price : " + currentPrice);
			double stockPrice = Double.parseDouble(currentPrice);
			Assert.assertTrue(stockPrice > 200, "Stock price is below $200");
		} catch (Exception e) {
			Assert.fail("Failed to retrive stock price" + e.getMessage());
		}
	}

	@Test(priority = 5)
	private void verifyUserAbleTocaptueAdditionalInformationlikePreviousCloseAndVolumeFromTheStockDetailsPage() {
		try {
			// Scroll to Previous Close
			scrollToElement(p.getPreviousCloseText());
			String previousValue = p.getPreviousCloseValue().getText();
			System.out.println("Previous close value : " + previousValue);

			// Scroll to volume
			scrollToElement(p.getValoumeValue());
			String volumeValue = p.getValoumeValue().getText();
			System.out.println("volume value is : " + volumeValue);
		} catch (Exception e) {
			Assert.fail("Unable to capture additional Information" + e.getMessage());
		}

	}
	@AfterClass
	private void tearDown() {
		browserClose();

	}

}
