package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductListingPage;
import pages.ShoppingCartPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SpreeAppTest extends BaseTest{

    @Test
    public void testLogin()
    {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("spree@example.com", "spree123");
        assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
        System.out.println("Success for Login");
    }

    @Test
    public void testProductListingPage()
    {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("spree@example.com","spree123");
        ProductListingPage plp = new ProductListingPage(driver);
        plp.selectCategory("Mugs");
         plp.selectProduct("Ruby on Rails Mug");
        //plp.clickPagination("2");
        assertTrue(driver.findElement(By.id("add-to-cart-button")).isDisplayed());
        System.out.println("Success on displaying Products Listing Page");

    }

    @Test
    public void testProductDetailPage()
    {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("spree@example.com","spree123");
        ProductListingPage plp = new ProductListingPage(driver);
        plp.selectCategory("Mugs");
        plp.selectProduct("Ruby on Rails Mug");
        ProductDetailsPage pdp = new ProductDetailsPage(driver);
        pdp.changeQuantity("4");
        pdp.clickAddToCart();
        assertTrue(driver.findElement(By.id("cart-detail")).findElement(By.linkText("Ruby on Rails Bag")).isDisplayed());
        System.out.println("Success on adding product to the Add to Cart Page");
    }

    @Test
    public void testShoppingCartAndCheckOut()
    {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("spree@example.com","spree123");
        ProductListingPage plp = new ProductListingPage(driver);
        plp.selectCategory("Mugs");
        plp.selectProduct("Ruby on Rails Mug");
        ProductDetailsPage pdp = new ProductDetailsPage(driver);
        pdp.changeQuantity("4");
        pdp.clickAddToCart();
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        cartPage.deleteProduct("Ruby on Rails Mug");


        /*assertTrue(driver.findElement(By.name("checkout")).isDisplayed());
        cartPage.clickCheckOut();
        System.out.println("Success on navigating to the CheckOut Page");*/

    }


    @Test
    public void testDeliveryProcess(){
        navigateToURL();
        login("spree@example.com","spree123" );
        selectProduct("Mugs","Ruby on Rails Mug");
        clickAddToCart();
        clickCheckOut();
    }

    private void clickCheckOut() {
        driver.findElement(By.id("checkout-link")).click();
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

      public void clickAddToCart()
      {
          driver.findElement(By.id("add-to-cart-button")).click();
      }







}
