package tests.API;

import io.restassured.RestAssured;

public class PingTest {

    public static void main(String[] args) {

        RestAssured
            .given()
            .when()
            .get("https://jsonplaceholder.typicode.com/posts/1")
            .then()
            .log().all();
    }
}