package com.palakgupta.ex_05_TestNGExamples.parallel.testlevel;

import org.testng.annotations.Test;

public class APISmoke {

    @Test
    public void test_API_Smoke(){
        System.out.println(Thread.currentThread().getId());
    }
}
