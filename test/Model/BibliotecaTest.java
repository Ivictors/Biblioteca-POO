package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.LivroException;
import service.UsuarioException;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {
    private Biblioteca biblioteca;
    private Livro livro;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
        // Criamos um livro com 10 exemplares
        livro = new Livro("Java POO", "Autor Teste", "12345", 2024, 10);
        usuario = new Usuario("Victor");
    }

    @Test
    @DisplayName("Deve adicionar um usuário com sucesso")
    void adicionaUsuario() {
        assertTrue(biblioteca.adicionaUsuario(usuario));
    }

    @Test
    @DisplayName("Deve remover um usuário que existe")
    void removeUsuarioSucesso() {
        biblioteca.adicionaUsuario(usuario);
        assertDoesNotThrow(() -> biblioteca.removeUsuario(usuario));
    }

    @Test
    @DisplayName("Deve lançar exceção ao remover usuário inexistente")
    void removeUsuarioErro() {
        assertThrows(UsuarioException.class, () -> biblioteca.removeUsuario(usuario));
    }

    @Test
    @DisplayName("Deve reduzir o estoque ao realizar empréstimo")
    void realizarEmprestimoSucesso() {
        biblioteca.adicionaLivro(livro);
        biblioteca.adicionaUsuario(usuario);

        int estoqueAntes = livro.getNumeroExemplares();
        biblioteca.realizarEmprestimo(livro, usuario);

        assertEquals(estoqueAntes - 1, livro.getNumeroExemplares(), "O estoque deve diminuir em 1");
    }

    @Test
    @DisplayName("Deve lançar exceção se o livro não tiver exemplares")
    void realizarEmprestimoSemEstoque() {
        Livro livroEsgotado = new Livro("Esgotado", "Autor", "999", 2024, 0);
        biblioteca.adicionaLivro(livroEsgotado);
        biblioteca.adicionaUsuario(usuario);

        assertThrows(LivroException.class, () -> {
            biblioteca.realizarEmprestimo(livroEsgotado, usuario);
        });
    }

    @Test
    @DisplayName("Deve aumentar o estoque ao devolver um livro")
    void receberDevolucaoLivro() {
        biblioteca.adicionaLivro(livro);
        biblioteca.adicionaUsuario(usuario);
        biblioteca.realizarEmprestimo(livro, usuario); // Estoque vira 9

        biblioteca.receberDevolucaoLivro(livro, usuario);
        assertEquals(10, livro.getNumeroExemplares(), "O estoque deve voltar para 10 após devolução");
    }

    @Test
    @DisplayName("Deve buscar livro por ISBN corretamente")
    void buscarLivroPorISBN() {
        biblioteca.adicionaLivro(livro);
        String resultado = biblioteca.buscarLivroPorISBN("12345");

        assertNotNull(resultado);
        assertTrue(resultado.contains("Java POO"));
    }

    @Test
    @DisplayName("Deve lançar erro ao buscar ISBN inexistente")
    void buscarLivroPorISBNInexistente() {
        assertThrows(LivroException.class, () -> {
            biblioteca.buscarLivroPorISBN("99999");
        });
    }

    @Test
    @DisplayName("Deve retornar a quantidade correta de exemplares")
    void quantidadeExemplares() {
        biblioteca.adicionaLivro(livro);
        int qtd = biblioteca.quantidadeExemplares("Java POO");
        assertEquals(10, qtd);
    }
}