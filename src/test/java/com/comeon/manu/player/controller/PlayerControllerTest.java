package com.comeon.manu.player.controller;

import com.comeon.manu.player.dto.PlayerRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerControllerTest {
    @LocalServerPort
    private int port;

    @Test
    public void testRegisterPlayer() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

        PlayerRequest playerRequest = new PlayerRequest(
                "test@example.com",
                "securePassword123",
                "John",
                "Doe"
        );

        given()
                .contentType(ContentType.JSON)
                .body(playerRequest)
                .when()
                .post("/api/players/register")
                .then()
                .statusCode(200)
                .body("email", equalTo("test@example.com"))
                .body("firstName", equalTo("John"))
                .body("lastName", equalTo("Doe"));
    }
}
