# QA Hybrid Automation Framework

## Descrição

Framework híbrido de automação QA desenvolvido para validação E2E de fluxos web e API utilizando Selenium WebDriver, Rest Assured, TestNG e Java.

---

## Objetivo do Projeto

Automatizar o fluxo completo de compra da aplicação DemoBlaze através de testes UI e API.

---

## Fluxo Automatizado

O framework automatiza o seguinte fluxo:

1. Login
2. Seleção de produto
3. Adição ao carrinho
4. Checkout
5. Finalização da compra
6. Logout

---

## Tecnologias Utilizadas

### UI Automation

* Java
* Selenium WebDriver
* TestNG

### API Automation

* Rest Assured

### Build e Gerenciamento

* Maven

### Controle de Versão

* Git
* GitHub

---

## Arquitetura do Projeto

O projeto utiliza arquitetura híbrida E2E para validação integrada de frontend e backend.

---

## Estrutura Inicial do Projeto

```bash
src/
 ├── test/
 │    ├── java/
 │    │     ├── pages/
 │    │     ├── tests/
 │    │     │      ├── ui/
 │    │     │      └── api/
 │    │     ├── utils/
 │    │     ├── drivers/
 │    │     ├── factory/
 │    │     └── base/
 │
 └── resources/
       ├── config/
       ├── massa/
       └── payloads/
```

## Tipos de Testes

* Testes funcionais
* Testes E2E
* Testes UI
* Testes API

---

## Escopo Atual

### Incluído

* Fluxo principal de compra
* Automação UI
* Automação API

### Fora do Escopo

* Mobile
* Performance
* Segurança
* Docker
* Selenium Grid
* Cross-browser avançado
