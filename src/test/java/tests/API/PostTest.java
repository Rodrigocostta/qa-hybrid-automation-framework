package tests.API;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import base.BaseApiTest;
import io.restassured.response.Response;
import models.CreatePostRequest;
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

    @Test
    public void deveCriarPostComSucesso() {

        CreatePostRequest request = new CreatePostRequest();

        request.setTitle("Primeiro Post");

        request.setBody("Criado pelo Framework");

        request.setUserId(1);

        Response response = PostService.createPost(request);

        Post post = response.as(Post.class);

        assertEquals(201, response.getStatusCode());

        assertEquals("Primeiro Post", post.getTitle());

        assertEquals("Criado pelo Framework", post.getBody());

        assertEquals(1, post.getUserId());
    }

    @Test
    public void deveAtualizarPostComSucesso() {

        // Arrange
        CreatePostRequest request = new CreatePostRequest();

        request.setTitle("Título Atualizado");
        request.setBody("Conteúdo Atualizado");
        request.setUserId(1);

        // Act
        Response response = PostService.updatePost(1, request);

        Post post = response.as(Post.class);

        // Assert
        assertEquals(200, response.getStatusCode());

        assertEquals(1, post.getId());

        assertEquals("Título Atualizado", post.getTitle());

        assertEquals("Conteúdo Atualizado", post.getBody());

        assertEquals(1, post.getUserId());

    }
}