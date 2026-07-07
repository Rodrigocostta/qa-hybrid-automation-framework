package service;

import io.restassured.response.Response;
import models.CreatePostRequest;
import request.BaseRequest;

/**
 * Service de exemplo usando JSONPlaceholder.
 * Simula operações de API para estrutura do framework.
 */
public class PostService {

    public static Response getPostById(int id) {

        return BaseRequest.get("/posts/" + id);
    }

    public static Response createPost(CreatePostRequest request) {

        return BaseRequest.post("/posts", request);

    }

    /**
     * Atualiza um Post existente.
     *
     * @param id      Identificador do Post.
     * @param request Dados atualizados.
     * @return Resposta da API.
     */
    public static Response updatePost(int id, CreatePostRequest request) {

        return BaseRequest.put("/posts/" + id, request);

    }

    /**
     * Remove um Post existente.
     *
     * @param id Identificador do Post.
     * @return Resposta da API.
     */
    public static Response deletePost(int id) {

        return BaseRequest.delete("/posts/" + id);

    }
}