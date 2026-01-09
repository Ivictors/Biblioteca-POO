package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.LivroException;
import service.UsuarioException;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    private Usuario usuario;
    private Livro livro;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Victor");
        livro = new Livro("Java", "Autor", "123", 2024, 5);
    }

    @Test
    @DisplayName("Deve lançar exceção ao listar livros se a lista estiver vazia")
    void listaLivrosEmprestadosVazia() {
        // Valida a regra de negócio do metodo listaLivrosEmprestados
        assertThrows(LivroException.class, () -> {
            usuario.listaLivrosEmprestados();
        }, "Deveria lançar LivroException quando não há livros");
    }

    @Test
    @DisplayName("Deve adicionar livro à lista de emprestados do usuário")
    void pegarLivroEmprestado() {
        assertTrue(usuario.pegarLivroEmprestado(livro));
        // Se a lista não estiver mais vazia, não deve lançar erro ao listar
        assertDoesNotThrow(() -> usuario.listaLivrosEmprestados());
    }

    @Test
    @DisplayName("Deve remover livro da lista do usuário na devolução")
    void devolverLivroSucesso() {
        usuario.pegarLivroEmprestado(livro);
        assertTrue(usuario.devolverLivro(livro), "O livro deve ser removido com sucesso");
    }

    @Test
    @DisplayName("Deve lançar exceção ao devolver livro que o usuário não possui")
    void devolverLivroErro() {
        // Valida o tratamento de erro do metodo devolverLivro
        assertThrows(UsuarioException.class, () -> {
            usuario.devolverLivro(livro);
        }, "Deveria lançar erro ao tentar devolver um livro não emprestado");
    }

    @Test
    @DisplayName("Deve garantir que cada usuário receba um ID único no construtor")
    void getUsuarioID() {
        Usuario outroUsuario = new Usuario("Maria");
        assertNotEquals(usuario.getUsuarioID(), outroUsuario.getUsuarioID());
    }
}