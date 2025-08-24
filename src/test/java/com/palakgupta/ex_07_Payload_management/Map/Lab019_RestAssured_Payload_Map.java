package com.palakgupta.ex_07_Payload_management.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lab019_RestAssured_Payload_Map {


    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;
    int bookingId;

    @Test
    public void test_POST(){
        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname","Palak");
        jsonBodyUsingMap.put("lastname","Gupta");
        jsonBodyUsingMap.put("totalprice",221);
        jsonBodyUsingMap.put("depositpaid","false");

        Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2025-12-01");//yyyy-mm-dd
        bookingDatesMap.put("checkout","2025-12-05");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds","Breakfast");

        System.out.println(jsonBodyUsingMap);

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(jsonBodyUsingMap).log().all();

        response = r.when().log().all().post();

        vr = response.then().log().all();

        /* Rest Assured Assertions */
        vr.statusCode(200);



    }


}
