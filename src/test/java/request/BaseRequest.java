package request;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Classe responsável por encapsular todas as chamadas HTTP do framework.
 *
 * Responsabilidade:
 * - Executar requisições HTTP (GET, POST, PUT e DELETE).
 *
 * NÃO é responsabilidade dela:
 * - Regras de negócio.
 * - Validações.
 * - Montagem de massa de testes.
 *
 * Atua como o "motor HTTP" do framework.
 *
 * Arquitetura:
 *
 * Service
 * ↓
 * BaseRequest
 * ↓
 * RestAssured
 * ↓
 * API
 */
public final class BaseRequest {

    /**
     * Impede instanciação da classe.
     */
    private BaseRequest() {
    }

    /**
     * Executa uma requisição GET.
     *
     * @param endpoint caminho do recurso.
     * @return resposta da API.
     */
    public static Response get(String endpoint) {

        return RestAssured
                .given()
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    /**
     * Executa uma requisição POST.
     *
     * @param endpoint caminho do recurso.
     * @param body     objeto enviado no corpo da requisição.
     * @return resposta da API.
     */
    public static Response post(String endpoint, Object body) {

        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint);
    }

    /**
     * Executa uma requisição PUT.
     *
     * @param endpoint caminho do recurso.
     * @param body     objeto enviado para atualização.
     * @return resposta da API.
     */
    public static Response put(String endpoint, Object body) {

        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put(endpoint);
    }

    /**
     * Executa uma requisição DELETE.
     *
     * @param endpoint caminho do recurso.
     * @return resposta da API.
     */
    public static Response delete(String endpoint) {

        return RestAssured
                .given()
                .when()
                .delete(endpoint);
    }

}