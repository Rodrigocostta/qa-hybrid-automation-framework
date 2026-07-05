package config;

import io.restassured.RestAssured;

/**
 * Classe responsável por centralizar a configuração base da API.
 *
 * Responsabilidade única:
 * - Definir o endpoint base (baseURI) usado por todas as requisições.
 *
 * Equivalente na arquitetura UI:
 * - DriverFactory (configuração do navegador)
 *
 * Benefício:
 * - Evita repetição de URL em múltiplos testes ou services
 * - Facilita mudança de ambiente (dev, qa, prod futuramente)
 */
public class ApiConfig {

    /**
     * Método responsável por configurar o RestAssured.
     *
     * Observação:
     * - Método estático porque a configuração é global
     * - Não faz sentido instanciar essa classe
     */
    public static void configurar() {

        // Define a URL base da API
        // Todas as requests irão herdar essa configuração automaticamente
        RestAssured.baseURI = "https://api.demoblaze.com";
    }
}
