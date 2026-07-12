package models;

/**
 * Modelo que representa o recurso Post retornado pela API.
 *
 * Responsabilidade:
 * Receber automaticamente os dados retornados pela API
 * através da desserialização realizada pelo Jackson/RestAssured.
 */
public class Post {

    /**
     * Identificador do usuário proprietário do Post.
     */
    private int userId;

    /**
     * Identificador único do Post.
     */
    private int id;

    /**
     * Título do Post.
     */
    private String title;

    /**
     * Conteúdo do Post.
     */
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

}