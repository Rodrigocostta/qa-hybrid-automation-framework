package tests.API;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import base.BaseApiTest;
import service.PostService;

public class PostTest extends BaseApiTest {

    @Test
    public void deveBuscarPostComSucesso() {

        Response response = PostService.getPostById(1);

        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());
    }
}