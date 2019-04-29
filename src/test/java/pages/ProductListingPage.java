package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListingPage {

    WebDriver driver;

    public ProductListingPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductDetailsPage selectCategory_Product(String category, String productSelected){
        driver.findElement(By.linkText(category)).click();
        driver.findElement(By.linkText(productSelected)).click();
        return new ProductDetailsPage(driver);
    }

    public void clickPagination(String pageNavigationLink)
    {
        driver.findElement(By.linkText(pageNavigationLink)).click();
    }
}
