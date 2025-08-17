package com.palakgupta.ex_04_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab09_GET_NonBDD {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String pincode;


    @Test
    public void test_GET_NonBDD(){
         pincode ="560048";

        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("IN/"+pincode);

        //part2
        response = r.when().log().all().get();

        //part3
        vr=response.then().log().all();
        vr.statusCode(200);

    }

    @Test
    public void test_GET_NonBDD_Negative(){
        pincode ="@";
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("IN/"+pincode);

        //part2
        response = r.when().log().all().get();

        //part3
        vr=response.then().log().all();
        vr.statusCode(200);

    }
}
