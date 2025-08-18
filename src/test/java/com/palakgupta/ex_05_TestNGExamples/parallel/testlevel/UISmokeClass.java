package com.palakgupta.ex_05_TestNGExamples.parallel.testlevel;

import org.testng.annotations.Test;

public class UISmokeClass {

    @Test
    public void test_UI_Smoke(){
        System.out.println(Thread.currentThread().getId());
    }
}
