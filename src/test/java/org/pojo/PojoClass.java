package org.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilityClass.HelperOrUtilityClass;

public class PojoClass extends HelperOrUtilityClass {

	public PojoClass() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='ybar-sbq']")
	private WebElement serachTextBox;

	@FindBy(xpath = "(//ul[@class='modules-module_list__hi5kT']//li[@data-id='result-quotes-0'])")

	private WebElement teslaDropDownValue;

	public WebElement getSerachTextBox() {
		return serachTextBox;
	}

	@FindBy(xpath = "//h1[text()='(TSLA)']")
	private WebElement teslaIncText;

	@FindBy(xpath = "//div[@class='container yf-1tejb6']//span[text()='397.15']")
	private WebElement teslaStockPrice;

	@FindBy(xpath = "//span[text()='Previous Close']")
	private WebElement previousCloseText;

	@FindBy(xpath = "//fin-streamer[text()='406.58']")
	private WebElement previousCloseValue;

	@FindBy(xpath = "//span[@title='Volume']")
	private WebElement volumeText;

	@FindBy(xpath = "//fin-streamer[text()='57,406,714']")
	private WebElement valumeValue;

	public WebElement getValoumeValue() {
		return valumeValue;
	}

	public WebElement getVolumeText() {
		return volumeText;
	}

	public WebElement getPreviousCloseValue() {
		return previousCloseValue;
	}

	public WebElement getPreviousCloseText() {
		return previousCloseText;
	}

	public WebElement getTeslaStockPrice() {
		return teslaStockPrice;
	}

	public WebElement getTeslaIncText() {
		return teslaIncText;
	}

	public WebElement getTeslaDropDownValue() {
		return teslaDropDownValue;
	}

}
