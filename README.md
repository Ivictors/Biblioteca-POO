# 📚 Sistema de Gerenciamento de Biblioteca

Este projeto é uma aplicação Java desenvolvida para demonstrar o uso prático de **Programação Orientada a Objetos (POO)**, estruturas de dados performáticas e a importância crítica de **Testes Unitários** no ciclo de desenvolvimento.

---

## Objetivo e Finalidade
O objetivo deste projeto foi construir um sistema de gerenciamento de biblioteca que vá além do básico. A finalidade principal é garantir a integridade dos dados (como estoque de livros e IDs de usuários) através de um design de software que utiliza:
- **Encapsulamento** para proteção de dados.
- **Tratamento de Exceções Personalizadas** para regras de negócio.
- **Coleções (TreeSet e HashSet)** para garantir ordenação e unicidade.

---

## O que a aplicação faz
A aplicação gerencia o fluxo completo de uma biblioteca, incluindo:
- **Cadastro de Livros e Usuários:** Garante que não haja duplicidade de ISBN ou IDs.
- **Buscas Avançadas:** Localização de títulos por ISBN ou Autor.
- **Sistema de Empréstimos:** - Valida se o livro existe no acervo.
    - Verifica a disponibilidade de exemplares (estoque).
    - Impede que um livro esgotado seja emprestado.
- **Sistema de Devolução:** Atualiza automaticamente o estoque da biblioteca e a lista pessoal do usuário.
- **Gestão de IDs Automática:** Uso de `SecureRandom` para gerar IDs únicos para novos usuários.

---

## Como a aplicação funciona (Arquitetura)

### **Lógica e Organização**
O projeto está dividido em pacotes para melhor organização:
- `Model`: Contém as classes principais (`Biblioteca`, `Livro`, `Usuario`).
- `Service`: Centraliza as exceções personalizadas (`LivroException`, `UsuarioException`, etc).
- `Test`: Contém testes unitarios (`BibliotecaTest.java`, `LivroTest.java`, `UsuarioTest.java`)

---

### **Como Usar (Demonstração)**
Para ver o sistema em funcionamento, execute a classe `Main.java`. Ela contém um fluxo pré-configurado que:
1. Instancia a biblioteca.
2. Cadastra livros e usuários.
3. Simula tentativas de empréstimo (incluindo casos de erro para demonstrar a robustez).
4. Exibe os relatórios no console.

---

## 🛠️ Como rodar o projeto em sua máquina
Siga os passos abaixo para baixar e executar o projeto localmente:

### 1. Pré-requisitos
Antes de começar, você precisará ter instalado em sua máquina:
* [Java JDK 17](https://www.oracle.com/java/technologies/downloads/) ou superior.
* [Git](https://git-scm.com/) (opcional, você pode baixar o ZIP).

### 2. Clonando o Repositório
Abra o seu terminal (Git Bash, CMD ou Terminal do Mac/Linux) e digite:
```bash
git clone git@github.com:Ivictors/Biblioteca-POO.git