package com.palakgupta.ex_05_TestNGExamples.parallel.Class_Level_cross_browser_testing;

import org.testng.annotations.Test;

public class FireFox {

    @Test
    public void test_firefox(){
        System.out.println("2");
        System.out.println("firefox - Thread" + Thread.currentThread().getId());
    }
}
