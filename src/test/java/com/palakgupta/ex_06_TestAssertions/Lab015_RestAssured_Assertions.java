package com.palakgupta.ex_06_TestAssertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab015_RestAssured_Assertions {

    @Test
    public void test_CreateBooking_POST(){
        RequestSpecification r;
        Response response;
        ValidatableResponse vr;
        String token;
        int bookingId;

        String payload="{\n" +
                "    \"firstname\" : \"Palak\",\n" +
                "    \"lastname\" : \"Gupta\",\n" +
                "    \"totalprice\" : 450,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-11-01\",\n" +
                "        \"checkout\" : \"2025-12-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response = r.when().log().all().post();

        vr= response.then().log().all();

        //Rest Assured Assertions
        vr.statusCode(200);

        //Booking Id !=null, firstname == Palak

//        System.out.println(response.asString());
        vr.body("bookingid", Matchers.notNullValue());
        vr.body("booking.firstname",Matchers.equalTo("Palak"));
        vr.body("booking.lastname",Matchers.equalTo("Gupta"));


    }
}
