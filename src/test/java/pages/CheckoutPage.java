package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By modalPlaceOrder = By.id("orderModal");
    private final By campoNome = By.id("name");
    private final By campoPais = By.id("country");
    private final By campoCidade = By.id("city");
    private final By campoCartao = By.id("card");
    private final By campoMes = By.id("month");
    private final By campoAno = By.id("year");
    private final By botaoPurchase = By.xpath("//button[text()='Purchase']");
    private final By mensagemSucesso = By.cssSelector(".sweet-alert h2");
    private final By botaoOk = By.cssSelector(".confirm");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean modalEstaVisivel() {
        return isDisplayed(modalPlaceOrder);
    }

    public void preencherNome(String nome) {
        type(campoNome, nome);
    }

    public void preencherPais(String pais) {
        type(campoPais, pais);
    }

    public void preencherCidade(String cidade) {
        type(campoCidade, cidade);
    }

    public void preencherCartao(String cartao) {
        type(campoCartao, cartao);
    }

    public void preencherMes(String mes) {
        type(campoMes, mes);
    }

    public void preencherAno(String ano) {
        type(campoAno, ano);
    }

    public void clicarPurchase() {
        click(botaoPurchase);
    }

    public void preencherFormularioCompra(
            String nome,
            String pais,
            String cidade,
            String cartao,
            String mes,
            String ano) {

        preencherNome(nome);
        preencherPais(pais);
        preencherCidade(cidade);
        preencherCartao(cartao);
        preencherMes(mes);
        preencherAno(ano);
    }

    public String obterMensagemSucesso() {
        return getText(mensagemSucesso);
    }

    public void clicarOk() {
        click(botaoOk);
    }
}