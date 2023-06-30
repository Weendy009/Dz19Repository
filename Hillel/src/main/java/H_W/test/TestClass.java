package H_W.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestClass {
    @BeforeSuite
    public static void beforeSuite() {
        System.out.println("BeforeSuite method");
    }

    @Test(priority = 100)
    public static void testMethod1() {
        System.out.println("Test method 1");
    }

    @Test(priority = 200)
    public static void testMethod2() {
        System.out.println("Test method 2");
    }

    @Test(priority = 300)
    public static void testMethod3() {
        System.out.println("Test method 3");
    }

    @AfterSuite
    public static void afterSuite() {
        System.out.println("AfterSuite method");
    }
}
