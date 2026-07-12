package config;

import io.restassured.RestAssured;

/**
 * Classe responsável por centralizar a configuração base da API.
 *
 * Responsabilidade única:
 * - Configurar o endpoint base utilizado por todas as requisições.
 *
 * Equivalente na arquitetura UI:
 * - DriverFactory (configuração do WebDriver)
 *
 * Benefícios:
 * - Evita repetição da URL base.
 * - Centraliza a configuração da API.
 * - Facilita futuras alterações de ambiente.
 */
public final class ApiConfig {

    private ApiConfig() {
        // Impede instanciação
    }

    /**
     * Configura o RestAssured para utilização nos testes.
     */
    public static void configurar() {


        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

    }

}