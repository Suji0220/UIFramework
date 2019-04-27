package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SimpleLoginTest extends BaseTest{

    @Test(groups = {"smoke"})
    public void testLogin() {
        navigateToURL();
        login("spree@example.com","spree123" );
        assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
    }
    @Test
    public void testAddToCart()
    {
        navigateToURL();
        login("spree@example.com","spree123" );
        selectProduct("Mugs","Ruby on Rails Tote");

    }


    public void navigateToURL()
    {
        driver.navigate().to("https://spree-vapasi.herokuapp.com");
    }

    public void login(String username, String password)
    {
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(username);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }

      /*WebElement myAccountElement = driver.findElement(By.linkText("My Account"));
        assertEquals("My Account", myAccountElement.getText());*/

      public void selectProduct(String category, String productSelected){
          driver.findElement(By.linkText(category)).click();
          driver.findElement(By.linkText(productSelected)).click();
      }







}
