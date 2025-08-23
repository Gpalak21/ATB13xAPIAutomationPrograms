package com.palakgupta.RestFull_Booker_E2E_Testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestCases {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    int bookingId;
    String baseUrl ="https://restful-booker.herokuapp.com";
    String token;

    @Test(priority = 1)
    public void create_AuthToken(){

        System.out.println("------------Create Auth Token------------");
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r=RestAssured.given().baseUri(baseUrl).basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response=r.when().log().all().post();
        token=response.jsonPath().get("token");
        vr=response.then().statusCode(200).log().all();
        System.out.println("------------Create Auth Token Done------------");

    }

   @Test(priority = 1)
   public void test_CreateBooking(){

       System.out.println("------------Create Booking------------");
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

       r=RestAssured.given();
       r.baseUri(baseUrl);
       r.basePath("/booking");
       r.contentType(ContentType.JSON);
       r.body(payload);
       r.log().all();

       response = r.when().log().all().post();
       vr= response.then().log().all();
       vr.statusCode(200);

       bookingId = response.jsonPath().getInt("bookingid");

       System.out.println("------------Create Booking Done------------");

   }




    @Test(priority = 2)
    public void test_UpdateBookingById(){

        System.out.println("------------Update Booking------------");
       String payload="{\n" +
               "    \"firstname\" : \"Abhinav\",\n" +
               "    \"lastname\" : \"Mishra\",\n" +
               "    \"totalprice\" : 500,\n" +
               "    \"depositpaid\" : true,\n" +
               "    \"bookingdates\" : {\n" +
               "        \"checkin\" : \"2025-11-27\",\n" +
               "        \"checkout\" : \"2025-12-01\"\n" +
               "    },\n" +
               "    \"additionalneeds\" : \"Breakfast\"\n" +
               "}";
       r=RestAssured.given();
       r.baseUri(baseUrl);
       r.basePath("/booking/"+bookingId);
       r.cookie("token",token);
       r.body(payload);
       r.contentType(ContentType.JSON);
       r.log().all();

       response=r.when().log().all().put();

       vr=response.then().statusCode(200);
       vr.log().all();

        System.out.println("------------Update Booking------------");
    }

    @Test(priority = 3)
    public void getSingleBookingId(){

        System.out.println("------------Get Booking By Id------------");

        r = RestAssured.given();
        r.baseUri(baseUrl);
        r.basePath("/booking/" + bookingId);

        response = r.when().log().all().get();


        vr = response.then().log().all();
        vr.statusCode(200);
//        firstname.equalsIgnoreCase("Gutur");

        System.out.println("------------Get Booking By Id Done------------");
    }

    @Test(priority = 4)
    public void test_DeleteBookingById(){
        System.out.println("------------Delete Booking------------");
       r=RestAssured.given().baseUri(baseUrl).basePath("/booking/"+bookingId);
       r.cookie("token",token);
       r.log().all();

       response=r.when().log().all().delete();

       vr=response.then().statusCode(201).log().all();

        System.out.println("------------Delete Booking Done------------");
    }


}
