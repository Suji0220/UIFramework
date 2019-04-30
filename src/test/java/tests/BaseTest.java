package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    ChromeDriver driver;

    //@BeforeMethod (groups={"smoke"})
    @BeforeMethod (alwaysRun=true)
    public void setUp() {
        String currentUsersWorkingDir = System.getProperty("user.dir");
        System.out.println("Dir is " + currentUsersWorkingDir);
        System.setProperty("webdriver.chrome.driver", currentUsersWorkingDir + "/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://spree-vapasi.herokuapp.com");
    }
    @AfterMethod(alwaysRun=true)
   // @AfterMethod(groups={"smoke"})
    public void tearDown()
    {
       driver.close();
        driver.quit();
    }

}
