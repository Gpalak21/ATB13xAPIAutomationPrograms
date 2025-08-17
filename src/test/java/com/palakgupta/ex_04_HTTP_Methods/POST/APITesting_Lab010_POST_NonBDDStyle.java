package com.palakgupta.ex_04_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab010_POST_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;




    @Test
    public void test_POST_NonBDD_CreateToken(){

        String payload =" {\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


        System.out.println("-----part1--------");

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        System.out.println("-------part2-------");

        response=r.when().log().all().post();

        System.out.println("----------part3----------");

        vr=response.then().log().all();
        vr.statusCode(200);




    }
}
