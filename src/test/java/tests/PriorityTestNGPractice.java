package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PriorityTestNGPractice {

    ChromeDriver driver;

    @Test(priority = 1)
    public void launchBrowser(){
        String currentUsersWorkingDir = System.getProperty("user.dir");
        System.out.println("Dir is " + currentUsersWorkingDir);
        System.setProperty("webdriver.chrome.driver", currentUsersWorkingDir + "/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test (priority = 2)
    public void verifyGoogleTitle() {
        driver.get("https://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
    }
    @Test (priority = 3)
    public void verifyYahooTitle() {
        driver.get("https://in.yahoo.com/");
        Assert.assertEquals("Yahoo", driver.getTitle());
    }
    @Test(priority = 4)
    public void verifySpreeTitle() {
        driver.get("https://spree-vapasi.herokuapp.com");
        Assert.assertEquals("Spree Demo Site", driver.getTitle());
    }
    @Test(priority = 5)
    public void closeBrowser() {
        driver.close();
    }
    }
