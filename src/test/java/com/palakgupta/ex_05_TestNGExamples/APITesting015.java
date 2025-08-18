package com.palakgupta.ex_05_TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting015 {
    //PUT Request

    @BeforeTest
    public void get_Token(){
        System.out.println("Before GET Token");
    }

    @BeforeTest
    public void getBookingID(){
        System.out.println("Before GET Booking");
    }

    @Test
    public void test_PUT(){
        System.out.println("PUT Request");
    }

    @AfterTest
    public void closeAllThings(){
        System.out.println("Close");
    }
}
