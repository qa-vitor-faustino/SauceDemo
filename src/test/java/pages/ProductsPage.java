package pages;

import org.openqa.selenium.By;

import methods.TestMethods;
import runner.Browsers;
import utils.WebUrls;

public class ProductsPage extends Browsers {
	TestMethods mtd = new TestMethods();
	WebUrls url = new WebUrls();

	private By btnAddToCard = By.cssSelector(".inventory_item:nth-of-type(1) .pricebar .btn_primary");
	private By btnItemMenu = By.cssSelector(".bm-menu > .bm-item-list > .menu-item:nth-of-type(1)");
	private By btnMenu = By.cssSelector(".bm-burger-button");
	private By cartBadge = By.cssSelector(".shopping_cart_badge");
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By btnLogin = By.id("login-button");

	public void selectProducts(int startItemNumber, int finalItemNumber) {
		if (startItemNumber >= 1 && finalItemNumber <= 6) {
			for (int i = startItemNumber; i <= finalItemNumber; i++) {
				By modifiedBtnAddToCard = mtd.modifyCssSelector(btnAddToCard, i);
				mtd.click(modifiedBtnAddToCard);
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

	public void login() {
		mtd.write(username, "standard_user");
		mtd.write(password, "secret_sauce");
		mtd.click(btnLogin);
	}
}
