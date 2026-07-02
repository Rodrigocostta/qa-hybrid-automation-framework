package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

import base.BaseTest;
import utils.LoggerUtils;
import utils.WaitUtils;

public class ProductTest extends BaseTest {

        @Test
        public void deveAdicionarProdutoAoCarrinho() {

                /*
                 * Arrange
                 * Nesta etapa preparamos o cenário do teste.
                 * Aqui registramos informações iniciais e garantimos que tudo
                 * esteja pronto antes de executar a ação que será validada.
                 */
                LoggerUtils.info(
                                test,
                                "CT004 - Adicionar Produto ao Carrinho");

                LoggerUtils.info(
                                test,
                                "Preparando seleção do produto");

                /*
                 * Act
                 * Nesta etapa executamos a ação principal do teste.
                 * O objetivo é realizar apenas a operação que será validada,
                 * sem incluir verificações ou asserts.
                 */
                pages.homePage()
                                .clicarProduto("Samsung galaxy s6");

                Assert.assertEquals(
                                "Nome do produto incorreto",
                                "Samsung galaxy s6",
                                pages.productPage().obterNomeProduto());

                LoggerUtils.info(
                                test,
                                "Adicionando produto ao carrinho");

                pages.productPage()
                                .adicionarAoCarrinho();

                Alert alerta = WaitUtils.esperarAlerta(driver);

                String mensagem = alerta.getText();

                /*
                 * Assert
                 * Nesta etapa verificamos se o resultado obtido corresponde
                 * ao esperado. Também registramos evidências e o resultado
                 * da execução no relatório.
                 */
                Assert.assertEquals(
                                "Mensagem de produto adicionado incorreta",
                                "Product added",
                                mensagem);

                LoggerUtils.sucesso(
                                test,
                                "Produto adicionado ao carrinho com sucesso");

                alerta.accept();

                capturarEvidencia(
                                "produto_adicionado");
        }

}