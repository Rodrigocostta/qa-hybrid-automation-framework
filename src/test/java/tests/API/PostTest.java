package tests.API;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import base.BaseApiTest;
import io.restassured.response.Response;
import models.Post;
import service.PostService;

/**
 * Classe responsável pelos testes do recurso Posts.
 *
 * Objetivo:
 * Validar o comportamento da API utilizando o framework construído.
 */
public class PostTest extends BaseApiTest {

    @Test
    public void deveBuscarPostComSucesso() {

        // Executa a requisição através da camada Service.
        Response response = PostService.getPostById(1);

        // Converte o JSON retornado pela API em um objeto Java.
        Post post = response.as(Post.class);

        // Valida o status da resposta.
        assertEquals(200, response.getStatusCode());

        // Valida o objeto desserializado.
        assertEquals(1, post.getId());

        assertEquals(1, post.getUserId());

        assertFalse(post.getTitle().isBlank());

        assertFalse(post.getBody().isBlank());
    }

}