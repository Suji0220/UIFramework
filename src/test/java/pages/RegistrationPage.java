package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public void createNewAccount(String email, String password, String passwordConfirmation)
    {
        driver.findElement(By.id("spree_user_email")).sendKeys(email);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        driver.findElement(By.id("spree_user_password_confirmation")).sendKeys(passwordConfirmation);
        driver.findElement(By.xpath("//input[@value='Create']")).click();
    }
}