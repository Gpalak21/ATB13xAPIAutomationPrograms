package com.palakgupta.ex_04_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab012_PUT_NonBDD {

    //token and booking id

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_PUT_NonBDD(){
        String bookingId="1769";
        String token="d90df7bb74e508f";
        String payload ="{\n" +
                "    \"firstname\" : \"lipi\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingId);
        r.contentType(ContentType.JSON);
       // r.header("Cookie","token="+token);
        r.cookie("token",token);
        r.body(payload).log().all();


        response=r.when().log().all().put();

        vr=response.then().log().all().statusCode(200);

    }
}
