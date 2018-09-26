package com.interfacer.testng.muluthread;

import org.testng.annotations.Test;

public class MulithreadOnAnnotion {

    @Test(invocationCount = 10,threadPoolSize = 5)
    public  void test(){
        System.out.println(1);
        System.out.printf("ThreadID:%s%n",Thread.currentThread().getId());
    }
}
