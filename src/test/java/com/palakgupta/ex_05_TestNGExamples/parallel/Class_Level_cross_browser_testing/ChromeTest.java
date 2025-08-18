package com.palakgupta.ex_05_TestNGExamples.parallel.Class_Level_cross_browser_testing;

import org.testng.annotations.Test;

public class ChromeTest {

    @Test
    public void test_chrome(){
        System.out.println("1");
        System.out.println("chrometest - Thread" + Thread.currentThread().getId());
    }
}
