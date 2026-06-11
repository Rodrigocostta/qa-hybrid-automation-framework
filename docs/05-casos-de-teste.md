# Casos de Teste

# Status
Automatizado

---

# TC-001

## Título

Validar carregamento da página inicial

## Cenário Relacionado

SCN-001

## Pré-condição

Sistema disponível

## Passos

1. Acessar DemoBlaze

## Resultado Esperado

Página inicial carregada com sucesso

---

# TC-002

## Título

Validar abertura do modal de login

## Cenário Relacionado

SCN-002

## Pré-condição

Usuário na página inicial

## Passos

1. Acessar DemoBlaze
2. Clicar em Login

## Resultado Esperado

Modal de login exibido

---

# TC-003

## Título

Validar login com credenciais válidas

## Cenário Relacionado

SCN-003

## Pré-condição

Usuário cadastrado

## Passos

1. Acessar DemoBlaze
2. Clicar em Login
3. Informar usuário válido
4. Informar senha válida
5. Clicar em Login

## Resultado Esperado

Usuário autenticado

---

# TC-004

## Título

Validar seleção de produto

## Cenário Relacionado

SCN-004

## Pré-condição

Usuário autenticado

## Passos

1. Selecionar produto

## Resultado Esperado

Página de detalhes do produto exibida

---

# TC-005

## Título

Validar adição de produto ao carrinho

## Cenário Relacionado

SCN-005

## Pré-condição

Produto selecionado

## Passos

1. Selecionar produto
2. Clicar em Add to cart

## Resultado Esperado

Produto adicionado ao carrinho

---

# TC-006

## Título

Validar conteúdo do carrinho

## Cenário Relacionado

SCN-006

## Pré-condição

Produto adicionado

## Passos

1. Acessar carrinho

## Resultado Esperado

Produto exibido no carrinho

---

# TC-007

## Título

Validar finalização da compra

## Cenário Relacionado

SCN-007

## Pré-condição

Carrinho com produto

## Passos

1. Abrir carrinho
2. Clicar em Place Order
3. Preencher dados
4. Confirmar compra

## Resultado Esperado

Compra realizada com sucesso
