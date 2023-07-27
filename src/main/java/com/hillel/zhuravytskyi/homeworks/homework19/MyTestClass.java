package com.hillel.zhuravytskyi.homeworks.homework19;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MyTestClass {  @BeforeSuite
public static void setUp() {
    System.out.println("BeforeSuite method");
}

    @AfterSuite
    public static void tearDown() {
        System.out.println("AfterSuite method");
    }

    @Test(priority = 1)
    public static void testMethod1() {
        System.out.println("Test method 1");
    }

    @Test(priority = 5)
    public static void testMethod2() {
        System.out.println("Test method 2");
    }

    @Test(priority = 10)
    public static void testMethod3() {
        System.out.println("Test method 3");
    }

    public static void someOtherMethod() {
        System.out.println("Some other method");
    }
}
