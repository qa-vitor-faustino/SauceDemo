package pages;

import org.openqa.selenium.By;

import methods.TestMethods;
import utils.DriversFactory;
import utils.WebUrls;

public class HomePage extends DriversFactory {
	TestMethods mtd = new TestMethods();
	WebUrls url = new WebUrls();

	private By username = By.id("user-name");
	private By password = By.id("password");
	private By btnLogin = By.id("login-button");
	private By msgErro = By.xpath("//h3[@data-test='error']");

	public void login(String username, String password, String urlExpected) {
		mtd.write(this.username, username);
		mtd.write(this.password, password);
		mtd.click(btnLogin);
		mtd.validateUrl(urlExpected);
	}

	public void loginErro(String username, String password, String urlExpected, String msgErro) {
		mtd.write(this.username, username);
		mtd.write(this.password, password);
		mtd.click(btnLogin);
		mtd.validateUrl(urlExpected);
		mtd.validateText(this.msgErro, msgErro);
	}
}
