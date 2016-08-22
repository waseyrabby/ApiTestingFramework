package com.paxotech.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.Constant.ConnecTionMsg;
import static com.Constant.EndMsg;
import static com.Constant.OK;
import static com.paxovision.api.heatclinick.HeatAppConstant.HeatBase;
import static com.paxovision.api.heatclinick.HeatAppConstant.HeatPort;
import static com.paxovision.api.heatclinick.HeatAppConstant.HeatURL;
import static io.restassured.RestAssured.given;

/**
 * Created by wasey on 8/21/16.
 */
public class HeatClinicTest  {


    @Test
public void chqconnectiontest(){

        given()
              .param("q", "hot")
                .param("pageSize", 5)
                .param("page", 1)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("/catalog/search/products")
                .then()
                .statusCode(OK);

}

    @BeforeMethod
    public  void beforeMethod(){
        System.out.println(ConnecTionMsg);
        RestAssured.baseURI = HeatURL;
        RestAssured.port = HeatPort;
        RestAssured.basePath = HeatBase;

    }

    @AfterMethod
    public void afterMethod(){
        System.out.println(EndMsg);
    }

}
