package methods;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import utils.DriversFactory;

public class TestMethods extends DriversFactory {

	public void click(By element) {
		WebElement webElement = waitForElementAndPerformAction(element);
		webElement.click();
	}

	public void write(By element, String text) {
		WebElement webElement = waitForElementAndPerformAction(element);
		webElement.sendKeys(text);
	}

	public void getText(By element) {
		driver.findElement(element).getText();
	}

	public void validateText(By element, String textExpected) {
		WebElement webElement = waitForElementAndPerformAction(element);
		assertEquals(textExpected, webElement.getText());
	}

	public void validateTitle(String titleExpected) {
		assertEquals(titleExpected, driver.getTitle());
	}

	public void validateUrl(String urlExpected) {
		assertEquals(urlExpected, driver.getCurrentUrl());
	}

	public By modifyCssSelector(By selector, int numberItem) {
		String itemNumber = Integer.toString(numberItem);
		String modifiedSelector = selector.toString().replace("By.cssSelector: ", "").replace("1", itemNumber);
		return By.cssSelector(modifiedSelector);
	}

	private WebElement waitForElementAndPerformAction(By elementId) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(elementId));
	}
}
