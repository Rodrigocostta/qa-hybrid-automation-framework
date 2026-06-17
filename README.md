# QA Hybrid Automation Framework

Framework de automação de testes desenvolvido para consolidar conhecimentos em Quality Assurance Automation, aplicando boas práticas de mercado, arquitetura escalável e evolução contínua.

O projeto está sendo construído de forma incremental, iniciando pela camada de automação Web (UI) e evoluindo para uma arquitetura híbrida contemplando testes de API, relatórios avançados e integração contínua.

---

# Objetivo do Projeto

Construir um framework híbrido de automação capaz de suportar:

* Testes Web (UI)
* Testes de API
* Relatórios de execução
* Evidências automatizadas
* Integração Contínua (CI/CD)

Além do aspecto técnico, o projeto tem como objetivo servir como portfólio profissional e laboratório de aprendizado para evolução em QA Automation.

---

# Aplicação Utilizada

Automação Web realizada sobre a aplicação de testes:

https://www.demoblaze.com

---

# Tecnologias Implementadas

### Linguagem

* Java 21

### Automação Web

* Selenium WebDriver 4

### Framework de Testes

* JUnit 4

### Gerenciamento de Dependências

* Maven

### Gerenciamento de Drivers

* WebDriverManager

---

# Tecnologias Planejadas

* Rest Assured
* Allure Reports
* GitHub Actions
* Pipeline CI/CD
* Integração UI + API

## Implementado

- Selenium
- JUnit 4
- Extent Reports
- ScreenshotUtils

## Roadmap

- Rest Assured
- GitHub Actions
- CI/CD

---

# Estrutura do Projeto

```text
qa-hybrid-automation-framework

├── docs
│   ├── 01-escopo-do-projeto.md
│   ├── 02-estrategia-de-testes.md
│   ├── 03-cenarios-de-teste.md
│   ├── 04-matriz-de-rastreabilidade.md
│   ├── 05-casos-de-teste.md
│   └── 06-decisoes-tecnicas.md
│
├── src
│   └── test
│       └── java
│           ├── base
│           ├── config
│           ├── data
│           ├── pages
│           ├── tests
│           └── utils
│
├── pom.xml
└── README.md
```

---

# Descrição dos Pacotes

## base

Classes base reutilizáveis do framework.

* BaseTest
* BasePage

Responsáveis pela inicialização do WebDriver, configuração do ambiente e reutilização de comportamentos comuns.

---

## config

Centralização das configurações da aplicação.

* Config

---

## data

Centralização dos dados utilizados durante os testes.

* TestData

---

## pages

Implementação do padrão Page Object Model (POM).

* HomePage
* LoginPage
* ProductPage
* CartPage
* CheckoutPage

Cada página encapsula seus elementos e comportamentos.

---

## tests

Contém os cenários automatizados.

* HomePageTest
* LoginTest
* ProductTest
* CartTest
* CheckoutTest

---

## utils

Classes utilitárias reutilizáveis.

* WaitUtils
* LogUtils
* ScreenshotUtils

---

# Funcionalidades Automatizadas

## Página Inicial

* Validação da abertura da aplicação

## Login

* Abertura do modal de login
* Login com credenciais válidas
* Validação do usuário autenticado

## Produtos

* Seleção de produto

## Carrinho

* Adição de produto
* Validação do produto no carrinho
* Remoção de produto

## Checkout

* Abertura do modal de compra
* Preenchimento do formulário
* Finalização da compra
* Validação da mensagem de sucesso

---

# Padrões Utilizados

* Page Object Model (POM)
* Separação de responsabilidades
* Centralização de dados
* Reutilização de componentes
* Encapsulamento de ações
* Boas práticas de automação Web

---

# Documentação

A documentação do projeto está disponível na pasta:

```text
docs/
```

Contendo:

| Documento                 | Objetivo                                       |
| ------------------------- | ---------------------------------------------- |
| Escopo do Projeto         | Definição dos objetivos e visão do framework   |
| Estratégia de Testes      | Abordagem adotada para automação               |
| Cenários de Teste         | Cenários funcionais mapeados                   |
| Matriz de Rastreabilidade | Relação entre requisitos, cenários e automação |
| Casos de Teste            | Detalhamento dos testes                        |
| Decisões Técnicas         | Registro das decisões arquiteturais            |

---

# Como Executar

Clone o repositório:

```bash
git clone git@github.com:Rodrigocostta/qa-hybrid-automation-framework.git
```

Acesse a pasta do projeto:

```bash
cd qa-hybrid-automation-framework
```

Execute os testes:

```bash
mvn test
```

---

# Status Atual do Projeto

## Concluído

* Estrutura base do framework
* Configuração Selenium
* Configuração Maven
* Page Object Model
* Fluxo de Login
* Fluxo de Produto
* Fluxo de Carrinho
* Fluxo de Checkout
* Documentação inicial do projeto

---

## Em Desenvolvimento

* Relatórios HTML
* Evidências de execução

---

## Planejado

* Automação de API com Rest Assured
* Integração UI + API
* Pipeline CI/CD
* Relatórios avançados
* Framework híbrido completo

---

# Roadmap

### Fase 1 - UI Automation

✅ Concluída

---

### Fase 2 - Relatórios e Evidências

✅ Relatórios HTML Extent Reports

✅ Logs de execução

✅ Evidências automáticas

✅ Screenshots em falha

---

### Fase 3 - Integração Contínua

⏳ Planejada

---

### Fase 4 - API Automation

⏳ Planejada

---

### Fase 5 - Framework Híbrido

⏳ Planejada

---

# Autor

Rodrigo Costa

Projeto desenvolvido para evolução profissional em QA Automation, construção de portfólio técnico e aplicação de boas práticas de engenharia de testes.
