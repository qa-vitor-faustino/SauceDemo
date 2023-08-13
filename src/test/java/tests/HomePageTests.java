package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pages.HomePage;
import runner.Browsers;
import utils.WebUrls;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePageTests extends Browsers {
	WebUrls url = new WebUrls();
	HomePage page = new HomePage();

	private String usernameValid = "standard_user";
	private String userBloq = "locked_out_user";
	private String passswordValid = "secret_sauce";

	@Before
	public void setUp() throws Exception {
		openBrowser("Chrome", "Fullscreen");
		openSite(url.HomePage);
	}

	@After
	public void tearDown() throws Exception {
		closeBrowser();
	}

	@Test
	public void test01_LoginValid() {
		page.login(usernameValid, passswordValid, url.ProductsPage);
	}

	@Test
	public void test02_LoginUserBloq() {
		page.loginErro(userBloq, passswordValid, url.HomePage, "Epic sadface: Sorry, this user has been locked out.");
	}

	@Test
	public void test03_UsernameBlank() {
		page.loginErro("", passswordValid, url.HomePage, "Epic sadface: Username is required");
	}

	@Test
	public void test04_PasswordBlank() {
		page.loginErro(usernameValid, "", url.HomePage, "Epic sadface: Password is required");
	}

	@Test
	public void test05_PasswordBlankAndUsernameBlank() {
		page.loginErro("", "", url.HomePage, "Epic sadface: Username is required");
	}
}
