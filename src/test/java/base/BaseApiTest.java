package base;

import org.junit.Before;

import config.ApiConfig;

/**
 * Classe base para todos os testes de API.
 *
 * Responsabilidades:
 * - Preparar o ambiente antes da execução dos testes.
 * - Centralizar configurações comuns da camada de API.
 *
 * Arquitetura atual:
 *
 * Teste
 * ↓
 * BaseApiTest
 * ↓
 * ApiConfig
 * ↓
 * RestAssured
 * ↓
 * Servidor
 */
public class BaseApiTest {

    /**
     * Executado antes de cada teste.
     *
     * Responsável por inicializar as configurações da API
     * definidas na classe ApiConfig.
     */
    @Before
    public void setup() {
        ApiConfig.configurar();
    }

}