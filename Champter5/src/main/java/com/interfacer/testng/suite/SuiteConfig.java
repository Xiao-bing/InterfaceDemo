package com.interfacer.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite()运行了");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite（）运行了");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beroreTest()运行了");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest()运行了");
    }
}
