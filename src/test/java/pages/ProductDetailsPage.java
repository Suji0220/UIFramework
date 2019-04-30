package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

    @FindBy(id="quantity")
    private WebElement numQuantity;

    @FindBy(id="add-to-cart-button")
            private WebElement addToCartButton;

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductDetailsPage changeQuantity(String quantity)
    {
         numQuantity.clear();
         numQuantity.sendKeys(quantity);
         return new ProductDetailsPage(driver);
    }

    public ShoppingCartPage clickAddToCart()
    {
        addToCartButton.click();
        return new ShoppingCartPage(driver);
    }
}
