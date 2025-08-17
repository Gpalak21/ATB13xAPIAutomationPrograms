package com.palakgupta.ex_04_HTTP_Methods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab014_DELETE_NonBDD {


    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_DELETE_NonBDD() {
        String bookingId = "1769";
        String token = "d90df7bb74e508f";


        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingId);
        r.contentType(ContentType.JSON);
        // r.header("Cookie","token="+token);
        r.cookie("token", token);



        response = r.when().log().all().delete();

        vr = response.then().log().all().statusCode(201);
    }
}
