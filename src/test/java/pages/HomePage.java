package pages;

import org.openqa.selenium.By;

import methods.TestMethods;
import utils.DriversFactory;
import utils.WebUrls;

public class HomePage extends DriversFactory {
	TestMethods mtd = new TestMethods();
	WebUrls url = new WebUrls();

	// Elementos da página
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By btnLogin = By.id("login-button");
	private By msgErro = By.xpath("//h3[@data-test='error']");

	/**
     * Efetua login no site.
     *
     * @param username      O nome de usuário.
     * @param password      A senha.
     * @param urlExpected   A URL esperada após o login.
     */
	public void login(String username, String password, String urlExpected) {
		mtd.write(this.username, username, "Enter username");
		mtd.write(this.password, password, "Enter password");
		mtd.click(btnLogin, "Click login button");
		mtd.validateUrl(urlExpected, "Validate URL after login");
	}

	/**
     * Efetua login no site e válida a mensagem de erro.
     *
     * @param username      O nome de usuário.
     * @param password      A senha.
     * @param urlExpected   A URL esperada após o login.
     * @param msgErroText   A mensagem de erro esperada.
     */
	public void loginErro(String username, String password, String urlExpected, String msgErroText) {
		mtd.write(this.username, username, "Enter username");
		mtd.write(this.password, password, "Enter password");
		mtd.click(btnLogin, "Click login button");
		mtd.validateUrl(urlExpected, "Validate URL after login");
		mtd.validateText(this.msgErro, msgErroText, "Validate error message");
	}
}
