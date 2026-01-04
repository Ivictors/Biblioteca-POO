# Sistema de Gerenciamento de Biblioteca

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

### **Organização**
O projeto está dividido em pacotes para melhor organização:
- `Model`: Contém as classes principais (`Biblioteca`, `Livro`, `Usuario`).
- `Service`: Centraliza as exceções personalizadas (`LivroException`, `UsuarioException`, etc).
- `Test`: Contém testes unitarios (`BibliotecaTest.java`, `LivroTest.java`, `UsuarioTest.java`)

---

## Lógica 

### 1. Modelagem de Dados (Classes Core)

* **Classe `Livro`**: Atua como a entidade de informação.
  * **Identificação**: Utiliza o `ISBN` como critério único de identificação.
  * **Ordenação Nativa**: Implementa a interface `Comparable`, permitindo que livros sejam automaticamente ordenados por ISBN em coleções.
  * **Consistência**: Sobrescreve `equals` e `hashCode` para evitar que o mesmo livro seja tratado como objetos diferentes na memória.

* **Classe `Usuario`**: Representa o cliente do sistema.
  * **Segurança de Dados**: Utiliza a classe `SecureRandom` para gerar IDs únicos entre 1.000 e 10.000, simulando um sistema de segurança real.
  * **Gestão de Empréstimos**: Armazena livros em um `HashSet`, garantindo que um usuário não possa possuir duas cópias idênticas do mesmo livro simultaneamente.

---

### 2. O "Cérebro" do Sistema (Classe `Biblioteca`)

A classe `Biblioteca` gerencia as **Regras de Negócio** através de coleções `TreeSet`, escolhidas pela sua performance de busca e garantia de não duplicidade.

* **Fluxo de Empréstimo**:
  1. Verifica se o livro e o usuário estão devidamente cadastrados no sistema.
  2. Valida o estoque real do livro (`numeroExemplares > 0`).
  3. Caso as condições falhem, o sistema interrompe o fluxo lançando **Exceções Personalizadas**, em vez de apenas retornar valores falsos. Isso torna o sistema mais rastreável.

* **Fluxo de Devolução**:
  1. Remove o livro do acervo pessoal do usuário.
  2. Localiza o livro no acervo da biblioteca e incrementa o estoque, mantendo a sincronia dos dados.

---

### 3. Tratamento de Erros e Robustez

O sistema não "quebra" diante de entradas inválidas. Foram criadas exceções específicas no pacote `service`:
- `LivroException`: Para falhas de estoque ou buscas frustradas.
- `UsuarioException`: Para erros de identificação ou usuários não encontrados.
- `BibliotecaLivrosException`: Para inconsistências no acervo geral.

---

### 4. Garantia de Qualidade (Testes)

A lógica foi validada através de uma suíte de testes com **JUnit 5**, cobrindo:
* **Cenários de Sucesso**: Empréstimos e devoluções válidas.
* **Cenários de Erro**: Tentativa de empréstimo de livros com estoque zero, remoção de usuários inexistentes e validação de IDs aleatórios.

---

### **Como Usar (Demonstração)**
Para ver o sistema em funcionamento, execute a classe `Main.java`. Ela contém um fluxo pré-configurado que:
1. Instancia a biblioteca.
2. Cadastra livros e usuários.
3. Simula tentativas de empréstimo (incluindo casos de erro para demonstrar a robustez).
4. Exibe os relatórios no console.

---

## Como rodar o projeto em sua máquina
Siga os passos abaixo para baixar e executar o projeto localmente:

### 1. Pré-requisitos
Antes de começar, você precisará ter instalado em sua máquina:
* [Java JDK 17](https://www.oracle.com/java/technologies/downloads/) ou superior.
* [Git](https://git-scm.com/) (opcional, você pode baixar o ZIP).

### 2. Clonando o Repositório
Abra o seu terminal (Git Bash, CMD ou Terminal do Mac/Linux) e digite:
```bash
git clone git@github.com:Ivictors/Biblioteca-POO.git