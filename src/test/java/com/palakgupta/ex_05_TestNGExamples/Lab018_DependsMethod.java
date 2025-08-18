package com.palakgupta.ex_05_TestNGExamples;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class Lab018_DependsMethod {

    @Test
    public void serverStartedOk(){
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void test1(){
        System.out.println("method1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void test2(){
        System.out.println("method2");
        Assert.assertTrue(true);
    }
}
