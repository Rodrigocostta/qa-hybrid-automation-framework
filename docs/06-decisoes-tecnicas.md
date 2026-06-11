# Decisões Técnicas do Projeto

## Captura Automática de Screenshots

### Objetivo

Implementar captura automática de screenshots quando um teste falhasse, utilizando JUnit 4 e TestWatcher.

### Abordagem Tentada

Foi implementado um TestWatcher na classe BaseTest para interceptar falhas de testes e acionar automaticamente o ScreenshotUtils.

Exemplo:

* Teste falha
* Método failed() do TestWatcher é executado
* ScreenshotUtils é acionado
* Evidência deveria ser salva automaticamente

### Problema Encontrado

Durante a execução, o Selenium retornou a exceção:

org.openqa.selenium.NoSuchSessionException

Mensagem:

Session ID is null. Using WebDriver after calling quit()?

O WebDriver já não possuía uma sessão válida no momento da tentativa de captura.

### Decisão Adotada

Optou-se por utilizar capturas manuais de evidência nos pontos mais importantes do fluxo de negócio:

* Login realizado com sucesso
* Produto adicionado ao carrinho
* Produto removido do carrinho
* Compra finalizada

A classe ScreenshotUtils foi mantida no projeto para geração de evidências.

### Possível Evolução Futura

Avaliar integração com:

* Allure Reports
* Extent Reports
* TestNG Listeners
* JUnit 5 Extensions

para implementação de captura automática de screenshots de forma mais robusta.
