# Cenários de Teste

## SCN001 - Acesso à Página Inicial

**Dado** que o usuário acessa a aplicação

**Quando** a página é carregada

**Então** a página inicial deve ser exibida corretamente

---

## SCN002 - Abertura do Modal de Login

**Dado** que o usuário está na página inicial

**Quando** clicar em Log in

**Então** o modal de login deve ser exibido

---

## SCN003 - Login com Credenciais Válidas

**Dado** que o modal de login está aberto

**Quando** informar usuário e senha válidos

**Então** o login deve ser realizado com sucesso

---

## SCN004 - Adicionar Produto ao Carrinho

**Dado** que o usuário está navegando na aplicação

**Quando** selecionar um produto e adicioná-lo ao carrinho

**Então** o produto deve ser incluído com sucesso

---

## SCN005 - Remover Produto do Carrinho

**Dado** que existe um produto no carrinho

**Quando** o usuário remover o item

**Então** o produto não deve mais aparecer no carrinho

---

## SCN006 - Finalizar Compra

**Dado** que existe um produto no carrinho

**Quando** o usuário concluir o checkout

**Então** a compra deve ser realizada com sucesso
