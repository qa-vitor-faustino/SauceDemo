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

    // Elementos da página
    private By inventoryItemName = By.cssSelector(".inventory_item:nth-of-type(1) .inventory_item_label .inventory_item_name");
    private By btnAddToCart = By.cssSelector(".inventory_item:nth-of-type(1) .pricebar .btn_primary");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By btnMenu = By.cssSelector(".bm-burger-button");
    private By btnItemMenu = By.cssSelector(".bm-menu .bm-item-list .menu-item:nth-of-type(1)");

    /**
     * Válida a seleção de produtos adicionando-os ao carrinho, e válida se eles foram realmente adicionados.
     *
     * @param startItemNumber  O número do item inicial.
     * @param finalItemNumber  O número do item final.
     */
    public void validateSelectProducts(int startItemNumber, int finalItemNumber) {
        if (startItemNumber >= 1 && finalItemNumber <= 6) {
            for (int i = startItemNumber; i <= finalItemNumber; i++) {
                By modifiedBtnAddToCart = mtd.modifyCssSelector(btnAddToCart, i);
                mtd.click(modifiedBtnAddToCart, "Click 'Add to Cart' button for item #" + i);
            }
            String stringFinalItemNumber = Integer.toString(finalItemNumber);
            mtd.validateText(cartBadge, stringFinalItemNumber, "Validate cart badge count");
        } else {
            throw new IllegalArgumentException("Choose from 1 to 6 products.");
        }
    }
    
    /**
     * Válida os links do menu principal.
     *
     * @param startLinkNumber  O número do link inicial.
     * @param finalLinkNumber  O número do link final.
     */
    public void validateMenuLinks(int startLinkNumber, int finalLinkNumber) {
        String[] webUrls = { url.ProductsPage, url.aboutPage, url.HomePage };
        
        if (startLinkNumber >= 1 && finalLinkNumber <= 3) {
            mtd.click(btnMenu, "Click menu button");
            for (int i = startLinkNumber; i <= finalLinkNumber; i++) {
                By modifiedBtnItemMenu = mtd.modifyCssSelector(btnItemMenu, i);
                mtd.click(modifiedBtnItemMenu, "Click menu item #" + i);
                mtd.validateUrl(webUrls[i - 1], "Validate URL after clicking menu item #" + i);
                if (i < 3) {
                    openSite(url.ProductsPage);
                    mtd.click(btnMenu, "Click menu button");
                }
            }
        } else {
            throw new IllegalArgumentException("Choose from 1 to 3 links.");
        }
    }

    /**
     * Seleciona uma opção de ordenação e válida a ordem dos produtos.
     *
     * @param option  A opção de ordenação (1 a 4).
     */
    public void selectSorting(int option) {
        String[] sortingOptions = { "Name (A to Z)", "Name (Z to A)", "Price (low to high)", "Price (high to low)" };
        
        WebElement sortSelector = driver.findElement(By.cssSelector(".product_sort_container"));
        Select select = new Select(sortSelector);
        select.selectByVisibleText(sortingOptions[option - 1]);

        switch (option) {
            case 1:
                validateSortOption("Sauce Labs Backpack");
                break;
            case 2:
                validateSortOption("Test.allTheThings() T-Shirt (Red)");
                break;
            case 3:
                validateSortOption("Sauce Labs Onesie");
                break;
            case 4:
                validateSortOption("Sauce Labs Fleece Jacket");
                break;
            default:
                break;
        }
    }

    // Obtém o texto do elemento de item do inventário e válida se o texto do elemento corresponde ao nome do item esperado.
    private void validateSortOption(String expectedItemName) {
        mtd.getText(inventoryItemName, "Gets the name of the specified product element");
        mtd.validateText(inventoryItemName, expectedItemName, "Validates the expected product name with the current one");
    }
}
