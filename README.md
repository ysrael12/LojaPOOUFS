# Loja, POO UFS
Mini Projeto - Sistema de Loja com Emissão de Nota de Compra


# Sistema de Loja com Emissão de Nota de Compra

---

## 🚀 Visão Geral do Projeto

Este projeto consiste em um sistema de gerenciamento simples para uma pequena loja, desenvolvido em **Java**. O objetivo principal é informatizar o processo de vendas, permitindo o cadastro de produtos e clientes, e a emissão de notas de compra detalhadas. O sistema é construído com base nos pilares da **Programação Orientada a Objetos (POO)**: **encapsulamento**, **herança** e **polimorfismo**, garantindo um código modular, reutilizável e de fácil manutenção.

---

## ✨ Funcionalidades

O sistema, operado via **interface de linha de comando (CLI)**, oferece as seguintes funcionalidades:

* **Cadastro de Produtos:**
    * Criação de produtos com **código único**, nome, preço base e controle de estoque.
    * Diferenciação entre tipos de produtos: **Físicos**, **Digitais** e **Perecíveis**, cada um com suas características e lógicas de precificação e validade específicas (utilizando herança).
    * Listagem, atualização de preço e estoque de produtos.
* **Cadastro de Clientes:**
    * Registro de clientes com **identificador único**, nome, endereço e telefone.
    * Diferenciação entre tipos de clientes: **Pessoa Física** (com CPF e data de nascimento) e **Pessoa Jurídica** (com CNPJ, razão social e nome fantasia), também utilizando herança.
    * Listagem e atualização de informações de clientes.
* **Emissão de Notas de Compra:**
    * Seleção de cliente já cadastrado.
    * Adição de itens à nota (produto + quantidade), com **validação de estoque**.
    * Cálculo automático de subtotal e valor total da nota.
    * Geração de **número/ID único** e data/hora da nota.
    * Exibição de um resumo formatado da nota de compra.

---

## 🛠️ Tecnologias Utilizadas

* **Java 17+**: Linguagem de programação principal.
* **`java.time` (LocalDate, LocalDateTime)**: Para manipulação robusta de datas e horas.
* **`java.math.BigDecimal`**: Essencial para lidar com valores monetários e evitar problemas de precisão inerentes a tipos `double` e `float`.
* **Programação Orientada a Objetos (POO)**: Encapsulamento, Herança e Polimorfismo aplicados na modelagem do domínio.

---

## 📂 Estrutura do Projeto

O projeto segue uma estrutura de pacotes organizada para separar as responsabilidades:
* loja/
* ├── Main.java               # Ponto de entrada do sistema.              
* │   ├── cliente/            # Classes relacionadas a clientes.
* │   │   ├── Cliente.java        # Classe base abstrata para todos os tipos de clientes.
* │   │   ├── PessoaFisica.java   # Subclasse para clientes pessoa física.
* │   │   └── PessoaJuridica.java # Subclasse para clientes pessoa jurídica.
* │   ├── nota/               # Classes relacionadas a notas de compra.
* │   │   ├── Nota.java           # Representa a nota fiscal de compra.
* │   │   └── ItemNota.java       # Representa um item (produto + quantidade) dentro de uma nota.
* │   └── produto/            # Classes relacionadas a produtos.
* │       ├── Produto.java        # Classe base abstrata para todos os tipos de produtos.
* │       ├── ProdutoDigital.java # Subclasse para produtos digitais.
* │       ├── ProdutoFisico.java  # Subclasse para produtos físicos.
* │       └── ProdutoPerecivel.java # Subclasse para produtos perecíveis (provavelmente estende ProdutoFisico).
* └── ui/                     # Contém as classes responsáveis pela interação com o usuário (Interface de Usuário).
*    ├── ConsoleMenu.java    # Lógica para exibir menus e interagir com o usuário via console.
*    └── InputUtils.java     # Utilitários para facilitar a leitura de diferentes tipos de entrada do usuário.
## 🚀 Como Executar o Projeto

1.  **Clone o Repositório:**
    ```bash
    git clone https://github.com/ysrael12/LojaPOOUFS.git
    cd LojaPOOUFS
    ```
2.  **Configure o Ambiente:**
    * Certifique-se de ter o **Java Development Kit (JDK) 17 ou superior** instalado em sua máquina.
3.  **Compile e Execute:**
    * **Via IDE (Eclipse/IntelliJ):** Clique com o botão direito no arquivo `Main.java` e selecione "Run As" > "Java Application".
    * **Via Terminal:**

        
        ```
	        javac Main.java
	        java Main
        ```