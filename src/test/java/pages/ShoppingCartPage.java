package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickUpdate()
    {
        driver.findElement(By.id("update-button")).click();
    }

    public void clickCheckOut()
    {
        driver.findElement(By.id("checkout-link")).click();
    }

    public void deleteProduct(String product)
    {
        driver.findElement(By.id(product)).findElement(By.xpath("//td[@class='cart-item-delete']")).click();

    }
}
