package base;

import org.junit.jupiter.api.BeforeEach;

import config.ApiConfig;

/**
 * Classe base para todos os testes de API.
 *
 * Responsabilidades:
 * - Preparar o ambiente antes da execução de cada teste.
 * - Centralizar configurações comuns da camada de API.
 *
 * Arquitetura:
 *
 * Teste
 * ↓
 * BaseApiTest
 * ↓
 * ApiConfig
 * ↓
 * BaseRequest
 * ↓
 * RestAssured
 */
public class BaseApiTest {

    /**
     * Executado antes de cada teste.
     *
     * Responsável por configurar a baseURI utilizada pelo RestAssured.
     */
    @BeforeEach
    public void setup() {

        // Configura a URL base da API.
        ApiConfig.configurar();

    }

}