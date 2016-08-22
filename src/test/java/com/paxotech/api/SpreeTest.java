package com.paxotech.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.Constant.OK;
import static com.paxovision.api.spree.SpreeAppConstant.*;
import static io.restassured.RestAssured.given;

/**
 * Created by wasey on 8/21/16.
 */
public class SpreeTest {

    @BeforeMethod
    public void beforeMethod(){
        RestAssured.baseURI = SpreeURL;
        RestAssured.port = SpreePort;
        RestAssured.basePath = SpreeBase;
        given()
                .header(SpreeToken, SpreeKey)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("/products");
    }

    @Test
    public void chqconnectiontest(){
        given()
                .then()
                .statusCode(OK);
    }

}
