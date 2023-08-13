package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pages.ProductsPage;
import runner.Browsers;
import utils.WebUrls;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductsPageTest extends Browsers {
	WebUrls url = new WebUrls();
	ProductsPage page = new ProductsPage();

	@Before
	public void setUp() throws Exception {
		openBrowser("Chrome", "Fullscreen");
		openSite(url.HomePage);
		page.login();
	}

	@After
	public void tearDown() throws Exception {
		closeBrowser();
	}

	@Test
	public void test01_maximumNumberOfSelectedProducts() {
		page.selectProducts(1, 6);
	}

	@Test
	public void test02_minimumNumberOfSelectedProducts() {
		page.selectProducts(1, 1);
	}

	@Test
	public void test03_validateMenuLinks() {
		page.validateMenuLinks(1, 3);
	}

}
