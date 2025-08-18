package com.palakgupta.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab020_Enabled {
    @Test
    public void test() {
        System.out.println(1);
        Assert.assertTrue(true);

    }

    @Test(enabled = false)
    public void test02() {
        Assert.assertTrue(true);
        System.out.println(2);
    }

    @Test
    public void test03() {
        System.out.println(3);
        Assert.assertTrue(true);

    }
}
