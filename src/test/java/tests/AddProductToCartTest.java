package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class AddProductToCartTest extends BaseTest{


    @Test
    public void selectProductToCart()  {
        driver.navigate().to("https://spree-vapasi.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement productSelect = driver.findElement(By.linkText("Ruby Baseball Jersey"));
        //  WebElement productSelect = driver.findElement(By.xpath("//span[contains(text(),'Ruby Baseball Jersey')]"));
        productSelect.click();
        driver.findElement(By.name("button")).click();
      //  assertTrue(driver.findElement(By.linkText("Ruby Baseball Jersey")).isDisplayed());
        assertTrue(driver.findElement(By.id("cart-detail")).findElement(By.linkText("Ruby Baseball Jersey")).isDisplayed());
       // assertTrue(driver.findElement(By.xpath("//table[@id='cart-detail']//a[1]")).isDisplayed());

        List<WebElement> itemsInCart = driver.findElements(By.xpath("//tr[@class='line-item']"));

        System.out.println(itemsInCart.size());

        /*for (Iterator<WebElement> productIterator = itemsInCart.iterator(); productIterator.hasNext(); ) {
            WebElement product = productIterator.next();

        }*/

        assertTrue(itemsInCart.size() == 1);
    }



}
