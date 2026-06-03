# Escopo do Projeto

## Nome do Projeto

QA Hybrid Automation Framework

---

## Objetivo

Desenvolver um framework híbrido de automação de testes combinando testes de Interface (UI) e API utilizando:

- Java
- Selenium WebDriver
- JUnit
- Rest Assured
- Maven
- GitHub Actions
- Allure Reports

O objetivo do projeto é simular o fluxo de trabalho de um Analista de QA Automação, desde o planejamento dos testes até a execução automatizada.

---

## Sistema Testado

DemoBlaze

https://www.demoblaze.com

---

## Fluxo Principal de Negócio

O fluxo principal automatizado será:

Login
→ Selecionar Produto
→ Adicionar ao Carrinho
→ Validar Carrinho
→ Finalizar Compra
→ Confirmar Pedido
→ Logout

---

## Funcionalidades Dentro do Escopo

### Testes de Interface (UI)

- Página Inicial
- Login
- Seleção de Produto
- Adição ao Carrinho
- Validação do Carrinho
- Finalização da Compra
- Logout

### Testes de API

- Consulta de Produtos
- Consulta de Detalhes de Produtos
- Validação de Respostas da API

---

## Funcionalidades Fora do Escopo

Não serão automatizados:

- Cadastro de Usuário
- Recuperação de Senha
- Formulário de Contato
- Testes de Performance
- Testes de Segurança
- Testes Mobile

---

## Critérios de Sucesso

O projeto será considerado concluído quando:

- Testes UI estiverem automatizados
- Testes API estiverem automatizados
- Relatórios forem gerados automaticamente
- Logs forem gerados automaticamente
- Pipeline CI/CD estiver configurado
- Execução automática via GitHub Actions estiver funcionando