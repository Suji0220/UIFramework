package tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGPractice {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Executing the Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Executing the After Test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Executing the Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Executing the After Method");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Executing the Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Executing the After Class");
    }

    @Test
    public void testCase1()
    {
        System.out.println("Executing Test Case1");

    }

    @Test
    public  void testCase2()
    {
        System.out.println("Executing Test Case2");
    }

    @BeforeSuite
    public void beforeSuite(){        System.out.println("Executing the Before Suite");

    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Executing the After Suite");
    }




}
