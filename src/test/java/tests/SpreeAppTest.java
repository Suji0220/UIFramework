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
        loginpage.login("spree@example.com","spree123").selectCategory_Product
                ("Mugs","Ruby on Rails Mug" );
        assertTrue(driver.findElement(By.id("add-to-cart-button")).isDisplayed());
        System.out.println("Success on displaying Products Listing Page");
    }

    @Test
    public void testProductDetailPage()
    {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("spree@example.com","spree123").selectCategory_Product
                ("Mugs","Ruby on Rails Mug" ).clickAddToCart();
        assertTrue(driver.findElement(By.id("cart-detail")).findElement(By.linkText("Ruby on Rails Bag")).isDisplayed());
        System.out.println("Success on adding product to the Add to Cart Page");
    }

    @Test
    public void testShoppingAddressCartAndCheckOut()
    {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("spree@example.com","spree123").selectCategory_Product
                ("Mugs","Ruby on Rails Mug" ).clickAddToCart().clickCheckOut();
        assertTrue(driver.findElement(By.xpath("//a[text()='Address']")).isDisplayed());
        System.out.println("Success of adding the product to the CheckOut");
    }

    @Test
    public void checkOutAsGuestUser(){
        ProductListingPage plp = new ProductListingPage(driver);
        plp.selectCategory_Product("Mugs","Ruby on Rails Mug").clickAddToCart().clickCheckOut();
    }


    @Test
    public void testDeliveryProcess(){
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("spree@example.com","spree123").selectCategory_Product
                ("Mugs","Ruby on Rails Mug" ).clickAddToCart().clickCheckOut();
    }














}
