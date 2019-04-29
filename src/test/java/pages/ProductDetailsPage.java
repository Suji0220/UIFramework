package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage {
    WebDriver driver;

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public void changeQuantity(String quantity)
    {

         WebElement numQuantity  = driver.findElement(By.id("quantity"));
         numQuantity.clear();
         numQuantity.sendKeys(quantity);

    }
    public void clickAddToCart()
    {
        driver.findElement(By.id("add-to-cart-button")).click();
    }
}
