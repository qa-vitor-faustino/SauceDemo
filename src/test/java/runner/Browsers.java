package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.DriversFactory;

public class Browsers extends DriversFactory {

	/**
	 * Abre o navegador especificado no modo de visualização especificado.
	 *
	 * @param browser  O navegador a ser aberto (Google Chrome ou Microsoft Edge).
	 * @param viewMode O modo de visualização (fullscreen ou minimized).
	 */
	public static void openBrowser(String browser, String viewMode) {
		driver = initializeDriver(browser, viewMode);
	}

	/**
	 * Fecha o navegador.
	 */
	public static void closeBrowser() {
		if (driver != null) {
			driver.quit();
		} else {
			System.out.println("No browser is open.");
		}
	}

	/**
	 * Fecha a aba atual do navegador.
	 */
	public static void closeTab() {
		if (driver != null) {
			driver.close();
		} else {
			System.out.println("No browser is open.");
		}
	}

	/**
	 * Abre um site específico no navegador.
	 *
	 * @param url A URL do site a ser aberto.
	 */
	public static void openSite(String url) {
		if (driver != null) {
			driver.get(url);
		} else {
			System.out.println("No browser is open.");
		}
	}

	// Método privado para inicializar o driver conforme o navegador e modo de
	// visualização especificados.
	private static WebDriver initializeDriver(String browser, String viewMode) {
		WebDriverManager manager = null;
		if (browser.equalsIgnoreCase("Google Chrome") || browser.equalsIgnoreCase("chrome")) {
			manager = WebDriverManager.chromedriver();
		} else if (browser.equalsIgnoreCase("Microsoft Edge") || browser.equalsIgnoreCase("Edge")) {
			manager = WebDriverManager.edgedriver();
		} else {
			System.out.println("Select one browser: Google Chrome or Microsoft Edge");
			return null;
		}

		manager.setup();
		WebDriver driver = createDriver(browser, viewMode);
		return driver;
	}

	// Método privado para criar o driver de acordo com o navegador e modo de
	// visualização.
	private static WebDriver createDriver(String browser, String viewMode) {
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("Google Chrome") || browser.equalsIgnoreCase("chrome")) {
			driver = createChromeDriver(viewMode);
		} else if (browser.equalsIgnoreCase("Microsoft Edge") || browser.equalsIgnoreCase("Edge")) {
			driver = createEdgeDriver(viewMode);
		}
		return driver;
	}

	// Método privado para criar o driver do Chrome com as opções de visualização
	// apropriadas.
	private static WebDriver createChromeDriver(String viewMode) {
		ChromeOptions options = new ChromeOptions();
		if (viewMode.equalsIgnoreCase("fullscreen")) {
			options.addArguments("--start-maximized");
			return new ChromeDriver(options);
		} else if (viewMode.equalsIgnoreCase("minimized") || viewMode.equalsIgnoreCase("Minimized Screen")) {
			options.addArguments("--headless", "--disable-gpu", "--window-size=1400,800");
			return new ChromeDriver(options);
		} else {
			System.out.println("Select one view mode: Fullscreen or Minimized");
			return null;
		}
	}

	// Método privado para criar o driver do Microsoft Edge com as opções de
	// visualização apropriadas.
	private static WebDriver createEdgeDriver(String viewMode) {
		EdgeOptions options = new EdgeOptions();
		if (viewMode.equalsIgnoreCase("fullscreen")) {
			options.addArguments("--start-maximized");
			return new EdgeDriver(options);
		} else if (viewMode.equalsIgnoreCase("minimized") || viewMode.equalsIgnoreCase("Minimized Screen")) {
			options.addArguments("--headless", "--disable-gpu", "--window-size=1400,800");
			return new EdgeDriver(options);
		} else {
			System.out.println("Select one view mode: Fullscreen or Minimized");
			return null;
		}
	}
}