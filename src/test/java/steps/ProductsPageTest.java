package steps;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pages.HomePage;
import pages.ProductsPage;
import runner.Browsers;
import utils.TestMass;
import utils.WebUrls;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductsPageTest extends Browsers {
	WebUrls url = new WebUrls();
	TestMass testMass = new TestMass();
	ProductsPage page = new ProductsPage();
	HomePage home = new HomePage();

	@Before
	public void setUp() throws Exception {
		openBrowser("Chrome", "minimized");
		openSite(url.HomePage);
		home.login(testMass.usernameValid, testMass.passswordValid, url.ProductsPage);
	}

	@After
	public void tearDown() throws Exception {
		closeBrowser();
	}

	// Válida a seleção de produtos adicionando-os ao carrinho
	@Test
	public void test01_MaximumNumberOfSelectedProducts() {
		page.validateSelectProducts(1, 6);
	}

	@Test
	public void test02_MinimumNumberOfSelectedProducts() {
		page.validateSelectProducts(1, 1);
	}

	// Válida o menu hamburguer da página e seus links.
	@Test
	public void test03_ValidateMenuLinks() {
		page.validateMenuLinks(1, 3);
	}

	// Válida a opção de ordenação e válida a ordem dos produtos.
	@Test
	public void test04_ValidateSortNameZtoA() {
		page.selectSorting(1);
	}

	@Test
	public void test05_ValidateSortNameAtoZ() {
		page.selectSorting(2);
	}

	@Test
	public void test06_ValidateSortPriceTowToHigh() {
		page.selectSorting(3);
	}

	@Test
	public void test07_ValidateSortPriceHighToLow() {
		page.selectSorting(4);
	}
	
	// Válida se o link de cada produto está redirecionado certo
	@Test
	public void test08_ValidateAllProductsLinks() {
		page.validateProductsLink(1,6);
	}
}
