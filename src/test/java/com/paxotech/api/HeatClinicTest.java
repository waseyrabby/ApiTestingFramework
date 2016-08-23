package com.paxotech.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.Constant.*;
import static com.paxovision.api.heatclinick.HeatAppConstant.*;
import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.XmlPath.from;
import static org.hamcrest.Matchers.hasXPath;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

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
    @Test
    public void test2(){
        //http://qa1.paxotech.com:80/heatclinic/api/v1/catalog/search/products?q=hot&pageSize=5&page=1

        given()
                .log().all()
                .param("q", "hot")
                .param("pageSize", 5)
                .param("page", 1)
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
                .when()
                .get("/catalog/search/products")
                .then()
                .log().body()
                .statusCode(200);

    }

    @Test
    public void test3(){
        given()
                .log().all()
                .param("q", "hot")
                .param("pageSize", 5)
                .param("page", 1)
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
                .when()
                .get("/catalog/search/products")
                .then()
                .log().body()
                .statusCode(200)
                .body(hasXPath("/searchResults/totalResults",containsString("14")))
                .body(hasXPath("/searchResults/pageSize",equalToIgnoringCase("5")))
                .body(hasXPath("/searchResults/products/product[1]/id",equalToIgnoringCase("13")));

    }

    @Test
    public void test4(){

        RequestSpecification request = given()
                .param("q", "hot")
                .param("pageSize", 5)
                .param("page", 1)
                .contentType(ContentType.XML)
                .accept(ContentType.XML);

        Response response = request.when().get("/catalog/search/products");

        String body = response.asString();

        System.out.println(body);


        List<String> products =  from(body).getList("searchResults.products.product.name");

        System.out.println("Product Count: " + products.size());

        for(String item : products){
            System.out.println(item);
        }

        String[] actualProductNames = new String[products.size()];
        actualProductNames = products.toArray(actualProductNames);

        String[] expectedProductNames = {"Bull Snort Smokin' Toncils Hot Sauce",
                "Hoppin' Hot Sauce",
                "Roasted Garlic Hot Sauce",
                "Scotch Bonnet Hot Sauce",
                "Hurtin' Jalepeno Hot Sauce"};

        Assert.assertEquals(expectedProductNames,actualProductNames);



    }

    @Test
    public void test5(){

        RequestSpecification request = given()
                .log().all()
                .param("q", "hot")
                .param("pageSize", 5)
                .param("page", 1)
                .contentType(ContentType.XML)
                .accept(ContentType.XML);

        Response response = request.when().get("/catalog/search/products");

        ValidatableResponse responseToValidate = response.then();

        responseToValidate.body(hasXPath("/searchResults/totalResults",containsString("14")));
        responseToValidate.body(hasXPath("/searchResults/products/product/id[text()='13']"));
        responseToValidate.body(hasXPath("/searchResults/products/product[1]/id",equalToIgnoringCase("13")));
        responseToValidate.body(hasXPath("/searchResults/products/product[1]/name",equalToIgnoringCase("Bull Snort Smokin' Toncils Hot Sauce")));

    }

    @Test
    public void testJson1(){
        //http://qa1.paxotech.com:80/heatclinic/api/v1/catalog/search/products?q=hot&pageSize=5&page=1

        given()
                .log().all()
                .param("q", "hot")
                .param("pageSize", 5)
                .param("page", 1)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("/catalog/search/products")
                .then()
                .log().body()
                .statusCode(200);

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
