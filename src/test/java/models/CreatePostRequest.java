package models;

/**
 * Modelo responsável pelo corpo da requisição de criação de Posts.
 *
 * O RestAssured utilizará esta classe para serializar automaticamente
 * o objeto Java em JSON.
 */
public class CreatePostRequest {

    // Título do post
    private String title;

    // Conteúdo do post
    private String body;

    // Identificador do usuário
    private int userId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}