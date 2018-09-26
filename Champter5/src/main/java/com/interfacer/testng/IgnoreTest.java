package com.interfacer.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test(enabled = true)
    public void test1(){
        System.out.println("test1()运行了111111");
    }

    @Test(enabled = false)
    public void test2(){
        System.out.println("test2()运行了222222");
    }

    @Test
    public void test3(){
        System.out.println("test3()运行了333333");
    }
}
