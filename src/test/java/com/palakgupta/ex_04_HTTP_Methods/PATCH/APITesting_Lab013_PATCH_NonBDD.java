package com.palakgupta.ex_04_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab013_PATCH_NonBDD {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_PATCH_NonBDD() {
        String bookingId = "1769";
        String token = "d90df7bb74e508f";
        String payload = "{\n" +
                "    \"firstname\" : \"Palak\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingId);
        r.contentType(ContentType.JSON);
        // r.header("Cookie","token="+token);
        r.cookie("token", token);
        r.body(payload).log().all();


        response = r.when().log().all().patch();

        vr = response.then().log().all().statusCode(200);
    }
}
