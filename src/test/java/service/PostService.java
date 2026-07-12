package service;

import io.restassured.response.Response;
import models.CreatePostRequest;
import request.BaseRequest;

/**
 * Service responsável pelas operações relacionadas ao recurso Posts.
 *
 * Responsabilidades:
 * - Buscar Posts.
 * - Criar Posts.
 * - Atualizar Posts.
 * - Remover Posts.
 *
 * Esta classe representa a camada de negócio da API.
 *
 * Arquitetura:
 *
 * Teste
 * ↓
 * PostService
 * ↓
 * BaseRequest
 * ↓
 * RestAssured
 * ↓
 * API
 */
public final class PostService {

    /**
     * Impede instanciação da classe.
     */
    private PostService() {
    }

    /**
     * Busca um Post pelo identificador.
     *
     * @param id identificador do Post.
     * @return resposta da API.
     */
    public static Response getPostById(int id) {

        return BaseRequest.get("/posts/" + id);

    }

    /**
     * Cria um novo Post.
     *
     * @param request dados enviados para criação.
     * @return resposta da API.
     */
    public static Response createPost(CreatePostRequest request) {

        return BaseRequest.post("/posts", request);

    }

    /**
     * Atualiza um Post existente.
     *
     * @param id      identificador do Post.
     * @param request dados atualizados.
     * @return resposta da API.
     */
    public static Response updatePost(int id, CreatePostRequest request) {

        return BaseRequest.put("/posts/" + id, request);

    }

    /**
     * Remove um Post existente.
     *
     * @param id identificador do Post.
     * @return resposta da API.
     */
    public static Response deletePost(int id) {

        return BaseRequest.delete("/posts/" + id);

    }

}