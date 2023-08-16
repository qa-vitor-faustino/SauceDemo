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

	/**
	 * Clica no elemento especificado.
	 *
	 * @param element O elemento a ser clicado.
	 * @param step    A etapa descritiva para relatórios de erro.
	 */
	public void click(By element, String step) {
		try {
			WebElement webElement = waitForElementAndPerformAction(element);
			webElement.click();
		} catch (Exception e) {
			System.err.println("Error in step " + step + ": " + e.getMessage());
		}
	}
	
	public void clickByText(String attribute, String text, String step) {
		try {
			By locator = By.xpath("//" + attribute + "[text()='" + text + "']");
			WebElement webElement = waitForElementAndPerformAction(locator);
			webElement.click();
		} catch (Exception e) {
			System.err.println("Error in step " + step + ": " + e.getMessage());
		}
	}
	

	/**
	 * Insere o texto especificado no elemento.
	 *
	 * @param element O elemento onde o texto será inserido.
	 * @param text    O texto a ser inserido.
	 * @param step    A etapa descritiva para relatórios de erro.
	 */
	public void write(By element, String text, String step) {
		try {
			WebElement webElement = waitForElementAndPerformAction(element);
			webElement.sendKeys(text);
		} catch (Exception e) {
			System.err.println("Error in step " + step + ": " + e.getMessage());
		}
	}

	/**
	 * Obtém o texto de um elemento.
	 *
	 * @param element O elemento do qual o texto será obtido.
	 * @param step    A etapa descritiva para relatórios de erro.
	 */
	public void getText(By element, String step) {
		try {
			driver.findElement(element).getText();
		} catch (Exception e) {
			System.err.println("Error in step " + step + ": " + e.getMessage());
		}
	}

	/**
	 * Valida o texto esperado em um elemento.
	 *
	 * @param element      O elemento que deve conter o texto esperado.
	 * @param textExpected O texto esperado.
	 * @param step         A etapa descritiva para relatórios de erro.
	 */
	public void validateText(By element, String textExpected, String step) {
		try {
			WebElement webElement = waitForElementAndPerformAction(element);
			assertEquals(textExpected, webElement.getText());
		} catch (Exception e) {
			System.err.println("Error in step " + step + ": " + e.getMessage());
		}
	}

	/**
	 * Valida o título da página.
	 *
	 * @param titleExpected O título esperado da página.
	 * @param step          A etapa descritiva para relatórios de erro.
	 */
	public void validateTitle(String titleExpected, String step) {
		try {
			assertEquals(titleExpected, driver.getTitle());
		} catch (Exception e) {
			System.err.println("Error in step " + step + ": " + e.getMessage());
		}
	}

	/**
	 * Válida a URL atual.
	 *
	 * @param urlExpected A URL esperada.
	 * @param step        A etapa descritiva para relatórios de erro.
	 */
	public void validateUrl(String urlExpected, String step) {
		try {
			assertEquals(urlExpected, driver.getCurrentUrl());
		} catch (Exception e) {
			System.err.println("Error in step " + step + ": " + e.getMessage());
		}
	}

	/**
	 * Modifica um seletor CSS removendo o By.cssSlector e substituindo um número específico.
	 *
	 * @param selector   O seletor CSS original.
	 * @param numberItem O número a ser substituído no seletor.
	 * @return O novo seletor CSS modificado.
	 */
	public By modifyCssSelector(By selector, int numberItem) {
		String itemNumber = Integer.toString(numberItem);
		String modifiedSelector = selector.toString().replace("By.cssSelector: ", "").replace("1", itemNumber);
		return By.cssSelector(modifiedSelector);
	}

	/**
	 * Aguarda a visibilidade de um elemento e realiza uma ação.
	 *
	 * @param element O elemento a ser aguardado.
	 * @return O elemento visível.
	 */
	private WebElement waitForElementAndPerformAction(By element) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
}
