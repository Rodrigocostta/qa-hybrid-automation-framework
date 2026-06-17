# Casos de Teste

## CT001 - Abrir Página Inicial

### Objetivo

Validar que a página inicial do Demoblaze é carregada corretamente.

### Pré-condição

* Navegador disponível.
* Aplicação acessível.

### Passos

1. Acessar a URL da aplicação.
2. Aguardar carregamento da página.

### Resultado Esperado

* Página inicial exibida.
* Título correto apresentado ao usuário.

---

## CT002 - Abrir Modal de Login

### Objetivo

Validar a abertura do modal de autenticação.

### Pré-condição

* Usuário na página inicial.

### Passos

1. Clicar em "Log in".

### Resultado Esperado

* Modal de login exibido.

---

## CT003 - Realizar Login com Sucesso

### Objetivo

Validar autenticação com credenciais válidas.

### Pré-condição

* Modal de login aberto.

### Passos

1. Informar usuário válido.
2. Informar senha válida.
3. Clicar em Login.

### Resultado Esperado

* Usuário autenticado.
* Nome do usuário exibido na barra superior.

---

## CT004 - Adicionar Produto ao Carrinho

### Objetivo

Validar inclusão de produto no carrinho.

### Pré-condição

* Usuário na página inicial.

### Passos

1. Selecionar produto Samsung Galaxy S6.
2. Clicar em Add to Cart.
3. Confirmar alerta.

### Resultado Esperado

* Produto adicionado ao carrinho com sucesso.

---

## CT005 - Remover Produto do Carrinho

### Objetivo

Validar remoção de produto do carrinho.

### Pré-condição

* Produto adicionado ao carrinho.

### Passos

1. Acessar carrinho.
2. Validar presença do produto.
3. Clicar em Delete.

### Resultado Esperado

* Produto removido do carrinho.

---

## CT006 - Finalizar Compra

### Objetivo

Validar fluxo completo de checkout.

### Pré-condição

* Produto presente no carrinho.

### Passos

1. Acessar carrinho.
2. Clicar em Place Order.
3. Preencher formulário.
4. Confirmar compra.

### Resultado Esperado

* Mensagem "Thank you for your purchase!" exibida.
* Compra concluída com sucesso.
