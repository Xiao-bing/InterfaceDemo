package com.interfacer.testng.muluthread;

import org.testng.annotations.Test;

public class TimeoutTest {

    @Test(timeOut = 3000)
    public void timeoutTest1() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 900)
    public void test3() throws InterruptedException {
        Thread.sleep(4000);
    }
}
