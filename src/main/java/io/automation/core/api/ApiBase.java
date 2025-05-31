package io.automation.core.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.automation.core.config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;
import java.util.Map;


public class ApiBase {

    Logger LOGGER = LogManager.getLogger(ApiBase.class);
    ConfigManager config = ConfigManager.getInstance();

    public Response getApiWithHeaders(String resource, Map<String,String> headers){
       RestAssured.baseURI = config.getConfig().getApiConfig().getBaseURI();
        LOGGER.info("");
       return given().basePath(resource)
               .headers(headers)
               .when().get().then()
               .extract().response();
    }

    public Response getApiWithHeadersAndQueryParams(String resource, Map<String,String> headers, Map<String,String> queryParams){
        RestAssured.baseURI = config.getConfig().getApiConfig().getBaseURI();
        return given().basePath(resource)
                .headers(headers)
                .queryParams(queryParams)
                .when().get().then()
                .extract().response();
    }

    public Response postApiWithHeaders(String resource, Map<String,String> headers){
        RestAssured.baseURI = config.getConfig().getApiConfig().getBaseURI();
        return given().basePath(resource)
                .headers(headers)
                .when().get().then()
                .extract().response();
    }

    public Response postApiWithHeadersAndReqBody(String resource, Map<String,String> headers, ObjectMapper mapper){
        RestAssured.baseURI = config.getConfig().getApiConfig().getBaseURI();
        return given().basePath(resource)
                .headers(headers)
                .body(mapper)
                .when().post()
                .then()
                .extract().response();
    }

    public Response putApiWithHeadersAndReqBody(String resource, Map<String,String> headers, ObjectMapper mapper){
        RestAssured.baseURI = config.getConfig().getApiConfig().getBaseURI();
        return given().basePath(resource)
                .headers(headers)
                .body(mapper)
                .when().put()
                .then()
                .extract().response();
    }







}
