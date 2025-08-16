package com.palakgupta.ex_03_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab06_TestCase {

    String pincode;

    //282004
    @Test
    public void test_tc1_pincode_valid(){
        pincode = "282004";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/"+pincode)
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(200);

    }

    @Test
    //@
    public void test_tc2_pincode_invalid(){

        pincode ="@";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/"+pincode)
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(200);
    }

    @Test
    //' ' blank
    public void test_tc13_pincode_invalid(){
        pincode=" ";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/"+pincode)
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(200);

    }
}

