package com.palakgupta.ex_05_TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab019_ParameterPassing {

    @Test
    @Parameters("browser")
    public void demo1(String value) {
        System.out.println("Hi I am demo");
        System.out.println("You are running this param: " + value);

        if (value.equalsIgnoreCase("firefox")) {
            System.out.println("Start the firefox");
        }

        if (value.equalsIgnoreCase("chrome")) {
            System.out.println("Start the chrome!");
        }
    }

}
