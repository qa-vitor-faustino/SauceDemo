package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import methods.TestMethods;
import runner.Browsers;
import utils.WebUrls;

public class ProductsPage extends Browsers {
	private TestMethods mtd = new TestMethods();
	private WebUrls url = new WebUrls();

	// Products
	private By inventoryItemName = By
			.cssSelector(".inventory_item:nth-of-type(1) .inventory_item_label .inventory_item_name");
	private By btnAddToCart = By.cssSelector(".inventory_item:nth-of-type(1) .pricebar .btn_primary");
	private By cartBadge = By.cssSelector(".shopping_cart_badge");
	private By btnMenu = By.cssSelector(".bm-burger-button");
	private By btnItemMenu = By.cssSelector(".bm-menu > .bm-item-list > .menu-item:nth-of-type(1)");

	// Login
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By btnLogin = By.id("login-button");

	public void validateSelectProducts(int startItemNumber, int finalItemNumber) {
		if (startItemNumber >= 1 && finalItemNumber <= 6) {
			for (int i = startItemNumber; i <= finalItemNumber; i++) {
				By modifiedBtnAddToCart = mtd.modifyCssSelector(btnAddToCart, i);
				mtd.click(modifiedBtnAddToCart);
			}
			String stringFinalItemNumber = Integer.toString(finalItemNumber);
			mtd.validateText(cartBadge, stringFinalItemNumber);
		} else {
			throw new IllegalArgumentException("Choose from 1 to 6 products.");
		}
	}

	public void validateMenuLinks(int startLinkNumber, int finalLinkNumber) {
		String[] webUrls = { url.ProductsPage, url.aboutPage, url.HomePage };
		if (startLinkNumber >= 1 && finalLinkNumber <= 3) {
			mtd.click(btnMenu);
			for (int i = startLinkNumber; i <= finalLinkNumber; i++) {
				By modifiedBtnItemMenu = mtd.modifyCssSelector(btnItemMenu, i);
				mtd.click(modifiedBtnItemMenu);
				mtd.validateUrl(webUrls[i - 1]);
				if (i < 3) {
					openSite(url.ProductsPage);
					mtd.click(btnMenu);
				}
			}
		} else {
			throw new IllegalArgumentException("Choose from 1 to 3 links.");
		}
	}

	public void selectSorting(int option) {
		String[] selectOptions = { "Name (A to Z)", "Name (Z to A)", "Price (low to high)", "Price (high to low)" };
		WebElement sortSelector = driver.findElement(By.cssSelector(".product_sort_container"));
		Select select = new Select(sortSelector);
		select.selectByVisibleText(selectOptions[option - 1]);

		switch (option) {
			case 1:
				validateSortingOption("Sauce Labs Backpack");
				break;
			case 2:
				validateSortingOption("Test.allTheThings() T-Shirt (Red)");
				break;
			case 3:
				validateSortingOption("Sauce Labs Onesie");
				break;
			case 4:
				validateSortingOption("Sauce Labs Fleece Jacket");
				break;
			default:
				break;
		}
	}

	private void validateSortingOption(String expectedItemName) {
		mtd.getText(inventoryItemName);
		mtd.validateText(inventoryItemName, expectedItemName);
	}

	public void login() {
		mtd.write(username, "standard_user");
		mtd.write(password, "secret_sauce");
		mtd.click(btnLogin);
	}
}
