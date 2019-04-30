package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class DataProviderPractice extends BaseTest {

    @Test (dataProvider = "getInvalidUsernameAndPassword")
    public void testInvalidLogin(String username, String password){
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(username);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();
        assertTrue(driver.findElement(By.className("alert-error")).isDisplayed());

    }

    @DataProvider(name="getInvalidUsernameAndPassword")
    public Object[][] getInvalidUsernameAndPassword(){
        return new Object[][]
        {
                {"spree@yahoo.com", "password1"},
                {"wrong@yahoo.com","wrongpassword"}

        };
    }
}
