package com.palakgupta.ex_06_TestAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab016_TestNGAssertions {

    @Test
    public void test_hardAssertionExample(){
        System.out.println("Start of the program");
        Assert.assertEquals("palak","Palak");
        System.out.println("End of the program");
    }

    @Test
    public void test_softAssertionExample(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("palak","Palak");
        System.out.println("End of the program");
        softAssert.assertAll();
    }
}
