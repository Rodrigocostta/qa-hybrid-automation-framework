package request;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Classe responsável por encapsular todas as chamadas HTTP do framework.
 *
 * Responsabilidade:
 * - Executar requisições HTTP (GET, POST, PUT, DELETE)
 *
 * NÃO é responsabilidade dela:
 * - Regras de negócio
 * - Validações
 * - Montagem de dados de teste
 *
 * Ela atua como:
 * - "Motor HTTP" do framework
 *
 * Arquitetura:
 * Service → BaseRequest → RestAssured → API
 */
public class BaseRequest {

    public static Response get(String endpoint) {

        return RestAssured
                .given()

                // Registra todas as informações da requisição
                .log().all()

                .when()
                .get(endpoint)

                // Registra todas as informações da resposta
                .then()
                .log().all()

                // Retorna novamente um objeto Response
                .extract()
                .response();
    }

    /**
     * Executa requisição POST
     *
     * @param endpoint caminho do recurso
     * @param body     objeto que será enviado no corpo da requisição
     */
    public static Response post(String endpoint, Object body) {

        return RestAssured
                .given()
                // define padrão de comunicação JSON
                .header("Content-Type", "application/json")
                // corpo da requisição (payload)
                .body(body)
                .when()
                .post(endpoint);
    }

    /**
     * Executa requisição PUT
     *
     * @param endpoint caminho do recurso
     * @param body     objeto que será atualizado
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
     * Executa requisição DELETE
     *
     * @param endpoint recurso a ser removido
     */
    public static Response delete(String endpoint) {

        return RestAssured
                .given()
                .when()
                .delete(endpoint);
    }

}