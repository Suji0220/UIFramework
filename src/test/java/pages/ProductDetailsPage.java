package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage {
    WebDriver driver;

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductDetailsPage changeQuantity(String quantity)
    {

         WebElement numQuantity  = driver.findElement(By.id("quantity"));
         numQuantity.clear();
         numQuantity.sendKeys(quantity);
         return new ProductDetailsPage(driver);

    }
    public ShoppingCartPage clickAddToCart()
    {
        driver.findElement(By.id("add-to-cart-button")).click();
        return new ShoppingCartPage(driver);
    }
}
