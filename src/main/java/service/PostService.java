package service;

import io.restassured.response.Response;
import request.BaseRequest;

/**
 * Service de exemplo usando JSONPlaceholder.
 * Simula operações de API para estrutura do framework.
 */
public class PostService {

    public static Response getPostById(int id) {

        return BaseRequest.get("/posts/" + id);
    }
}