# Terraform - QA Hybrid Automation Framework

## Visão Geral

Este módulo demonstra a utilização de **Infrastructure as Code (IaC)** através do Terraform dentro do projeto **QA Hybrid Automation Framework**.

O objetivo é aplicar conceitos fundamentais de Terraform utilizados em ambientes profissionais, demonstrando a capacidade de estruturar, versionar e validar infraestrutura através de código.

Este módulo não tem como objetivo provisionar uma infraestrutura cloud completa, mas sim demonstrar boas práticas e conhecimentos essenciais de IaC aplicados ao contexto de automação de testes.

---

# Objetivos

Com este módulo são demonstrados os seguintes conceitos:

* Estruturação de um projeto Terraform;
* Utilização de Providers;
* Declaração de Resources;
* Utilização de Variables;
* Utilização de Outputs;
* Inicialização do Terraform;
* Validação da configuração;
* Planejamento de mudanças de infraestrutura.

---

# Tecnologias Utilizadas

| Tecnologia               | Utilização                       |
| ------------------------ | -------------------------------- |
| Terraform                | Infrastructure as Code           |
| Terraform Local Provider | Gerenciamento de recursos locais |
| Git                      | Versionamento do código          |

---

# Estrutura do Projeto

```text
terraform/
│
├── provider.tf
├── variables.tf
├── main.tf
├── outputs.tf
├── README.md
└── .terraform.lock.hcl
```

---

# Arquitetura

O fluxo do Terraform neste projeto:

```text
Terraform Configuration
          |
          |
          v
Terraform Provider
          |
          |
          v
Local Resource
          |
          |
          v
Generated File
```

---

# Provider

O projeto utiliza o provider:

```text
hashicorp/local
```

O Local Provider permite criar e gerenciar recursos no ambiente local, evitando dependências externas como contas cloud ou credenciais.

Arquivo responsável:

```text
provider.tf
```

---

# Resource Criado

O recurso utilizado como demonstração é:

```text
local_file
```

Este recurso cria um arquivo local através do Terraform.

Arquivo gerado:

```text
test-report-info.txt
```

Conteúdo:

```text
QA Hybrid Automation Framework - Terraform
```

Arquivo responsável:

```text
main.tf
```

---

# Variables

O projeto utiliza variáveis Terraform para demonstrar a separação entre configuração e implementação.

Arquivo responsável:

```text
variables.tf
```

Benefícios:

* Maior organização;
* Reutilização;
* Facilidade de manutenção;
* Padrão utilizado em projetos profissionais.

---

# Outputs

Outputs permitem retornar informações importantes dos recursos criados.

Exemplo:

```text
file_created = test-report-info.txt
```

Arquivo responsável:

```text
outputs.tf
```

---

# Workflow Terraform

O fluxo utilizado neste projeto segue o ciclo padrão Terraform:

```text
terraform init
        |
        v
terraform validate
        |
        v
terraform plan
```

---

# Comandos Utilizados

## Inicializar Terraform

Baixa providers e prepara o ambiente:

```bash
terraform init
```

---

## Validar configuração

Verifica se os arquivos Terraform possuem uma configuração válida:

```bash
terraform validate
```

Resultado esperado:

```text
Success! The configuration is valid.
```

---

## Visualizar plano de execução

Exibe quais alterações serão realizadas:

```bash
terraform plan
```

Exemplo:

```text
Plan: 1 to add, 0 to change, 0 to destroy.
```

---

# Boas Práticas Aplicadas

Neste módulo foram aplicadas boas práticas:

✅ Infraestrutura versionada junto ao código
✅ Separação de responsabilidades por arquivos
✅ Uso de provider versionado
✅ Código declarativo
✅ Validação antes da execução
✅ Documentação da infraestrutura

---

# Integração com o Projeto QA Hybrid Automation Framework

O Terraform complementa o framework de automação demonstrando conhecimentos além da criação de testes.

Arquitetura geral:

```text
Automation Framework
        |
        |
        + Selenium WebDriver
        |
        + API Testing (RestAssured)
        |
        + JUnit
        |
        + ExtentReports
        |
        + GitHub Actions
        |
        + Terraform IaC
```

---

# Conclusão

Este módulo demonstra a aplicação dos principais conceitos de Terraform e Infrastructure as Code dentro de um projeto de automação de testes.

O objetivo é aproximar o framework de práticas utilizadas em ambientes profissionais, integrando qualidade de software, automação, CI/CD e conceitos de infraestrutura.
