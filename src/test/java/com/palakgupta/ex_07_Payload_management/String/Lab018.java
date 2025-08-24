package com.palakgupta.ex_07_Payload_management.String;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;



public class Lab018 {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;
    int bookingId;

    @Test
    public void Test_POST(){
        String payload = "{\n" +
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

    }

}
