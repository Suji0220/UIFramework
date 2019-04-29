package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }

    public ShoppingCartPage clickUpdate()
    {
        driver.findElement(By.id("update-button")).click();
        return new ShoppingCartPage(driver);
    }

    public CheckOutPage clickCheckOut()
    {
        driver.findElement(By.id("checkout-link")).click();
        return new CheckOutPage(driver);
    }

    public void deleteProduct(String product)
    {
        driver.findElement(By.id(product)).findElement(By.xpath("//td[@class='cart-item-delete']")).click();

    }
}
