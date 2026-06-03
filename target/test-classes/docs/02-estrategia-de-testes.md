# Estratégia de Testes

## Objetivo

Definir a abordagem de testes utilizada no projeto.

---

## Tipos de Teste

### Testes Funcionais

Validar se o sistema se comporta conforme esperado.

Exemplos:

- Login
- Seleção de Produto
- Compra de Produto

---

### Testes de Regressão

Garantir que novas alterações não afetem funcionalidades já existentes.

---

### Testes Automatizados de Interface

Ferramentas:

- Selenium WebDriver
- JUnit

---

### Testes Automatizados de API

Ferramentas:

- Rest Assured
- JUnit

---

## Níveis de Teste

### Teste End-to-End

Validar o fluxo completo do usuário.

Exemplo:

Login
→ Selecionar Produto
→ Comprar Produto
→ Logout

---

### Teste de API

Validar:

- Status Code
- Estrutura da Resposta
- Tempo de Resposta
- Conteúdo da Resposta

---

## Critérios de Entrada

Antes da execução dos testes:

- Sistema disponível
- Ambiente disponível
- Massa de teste disponível

---

## Critérios de Saída

Os testes serão considerados concluídos quando:

- Todos os cenários críticos forem executados
- Não existirem defeitos bloqueantes
- Relatórios forem gerados com sucesso