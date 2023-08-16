package steps;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pages.HomePage;
import runner.Browsers;
import utils.TestMass;
import utils.WebUrls;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePageTests extends Browsers {
	WebUrls url = new WebUrls();
	TestMass testMass = new TestMass();
	HomePage page = new HomePage();

	@Before
	public void setUp() throws Exception {
		openBrowser("Chrome", "minimized");
		openSite(url.HomePage);
	}

	@After
	public void tearDown() throws Exception {
		closeBrowser();
	}

	@Test
	public void test01_LoginValid() {
		page.login(testMass.usernameValid, testMass.passswordValid, url.ProductsPage);
	}

	@Test
	public void test02_LoginUserBloq() {
		page.loginErro(testMass.userBloq, testMass.passswordValid, url.HomePage,
				"Epic sadface: Sorry, this user has been locked out.");
	}

	@Test
	public void test03_UsernameBlank() {
		page.loginErro("", testMass.passswordValid, url.HomePage, "Epic sadface: Username is required");
	}

	@Test
	public void test04_PasswordBlank() {
		page.loginErro(testMass.usernameValid, "", url.HomePage, "Epic sadface: Password is required");
	}

	@Test
	public void test05_PasswordBlankAndUsernameBlank() {
		page.loginErro("", "", url.HomePage, "Epic sadface: Username is required");
	}
}
