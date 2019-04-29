package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListingPage {

    WebDriver driver;

    public ProductListingPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectCategory(String category){
        driver.findElement(By.linkText(category)).click();
    }

    public void selectProduct(String productSelected)
    {
        driver.findElement(By.linkText(productSelected)).click();
    }

    public void clickPagination(String pageNavigationLink)
    {
        driver.findElement(By.linkText(pageNavigationLink)).click();
    }
}