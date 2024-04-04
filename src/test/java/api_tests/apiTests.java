package api_tests;

import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static   io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class apiTests {

    @Test
    public void getWithSucess(){
        baseURI = "https://jsonplaceholder.typicode.com/";
        given()
            .contentType(ContentType.JSON)
            .when()
                .get("/posts")
            .then()
                .assertThat()
                .statusCode(200)
                .body("[0].id",equalTo(1))
                .body("[0].title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }

    @Test
    public void postWithSucess(){
        baseURI = "https://jsonplaceholder.typicode.com/";
        given()
                .contentType(ContentType.JSON)
                .body("{ \n" +
                        "  \"title\": \"automation test\",\n" +
                        "  \"body\": \"automation test\"\n" +
                        "}")
            .when()
                .post("/posts")
            .then()
                .assertThat()
                .statusCode(201)
                .log()
                .all();
    }

    @Test
    public void putSuccessful(){
        baseURI = "https://jsonplaceholder.typicode.com/";
        given()
                .contentType(ContentType.JSON)
                .body("{   \n" +
                        "  \"title\": \"automation test QA\",\n" +
                        "  \"body\": \"automation test QA\"\n" +
                        "}")
        .when()
                .put("/posts/1")
        .then()
                .assertThat()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void deleteSuccessful(){
        baseURI = "https://jsonplaceholder.typicode.com/";
        given()
                .contentType(ContentType.JSON)
        .when()
                .put("/posts/1")
        .then()
                .assertThat()
                .statusCode(200)
                .log()
                .all();
    }

}
