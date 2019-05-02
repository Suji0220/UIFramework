package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;

public class BaseTest {

    public static WebDriver driver;
    String browserName = null;

    //@BeforeMethod (groups={"smoke"})
    @BeforeMethod (alwaysRun=true)
    public void setUp() throws IOException {
        Properties prop = new Properties();
        String currentUsersWorkingDir = System.getProperty("user.dir");
        System.out.println("Dir is " + currentUsersWorkingDir);
        //this is to establish the connection
        FileInputStream ip = new FileInputStream( currentUsersWorkingDir + "/src/test/java/config/config.properties");

        //"/Users/vapasi/IdeaProjects/VapasiUiFramework/"
        ///Users/vapasi/IdeaProjects/VapasiUiFramework/src/test/resources/chromedriver
        prop.load(ip);

        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", currentUsersWorkingDir + "/src/test/resources/chromedriver");
            driver = new ChromeDriver();
            }
        else if(browserName.equals("firefox")){
            driver = new FirefoxDriver();

        }else if(browserName.equals("safari")){
            driver = new SafariDriver();
        }
        else{
            System.out.println("No browser value is given");
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

    public static void captureScreenshot(String testMethodName)   {
        File sourceFile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File("/Users/vapasi/IdeaProjects/VapasiUiFramework/screenshotsLogs/"+testMethodName+"_"+".jpg"));
        }catch(IOException e){
            e.printStackTrace();
        }

    /*    FileUtils.copyFile(source, new File("/Users/vapasi/IdeaProjects/VapasiUiFramework/src/test/java/screenshot/"
                + screenshotName + ".png"));*/
        }



    @AfterMethod(alwaysRun=true)
   // @AfterMethod(groups={"smoke"})
    public void tearDown()
    {
       driver.close();
        driver.quit();
    }

}



/*
To use “TakesScreenshot” interface, either we need to do up-casting or down casting depending upon reference of your browser driver class.
        If you write your browser driver class as below:
        ChromeDriver driver= new ChromeDriver();

        You need to up-cast your driver to TakesScreenshot as below:

        TakesScreenshot ts= driver;

        If you write your browser driver class as below:
        WebDriver  driver= new ChromeDriver();

        You need to down cast your driver to TakesScreenshot as shown below:

        TakesScreenshot ts= (TakesScreenshot)driver;*/
