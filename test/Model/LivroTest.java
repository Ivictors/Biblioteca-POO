package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LivroTest {
    private Livro livro1;
    private Livro livro2;

    @BeforeEach
    void setUp() {
        // Criando instâncias para teste baseadas na estrutura da classe
        livro1 = new Livro("Java POO", "Autor A", "111", 2024, 5);
        livro2 = new Livro("Java POO", "Autor A", "111", 2024, 5);
    }

    @Test
    @DisplayName("Deve considerar livros iguais se possuírem o mesmo título, autor e ISBN")
    void testEquals() {
        // O metodo equals usa título, autor e ISBN
        assertEquals(livro1, livro2, "Livros com dados idênticos devem ser iguais");
    }

    @Test
    @DisplayName("Deve gerar o mesmo HashCode para livros iguais")
    void testHashCode() {
        assertEquals(livro1.hashCode(), livro2.hashCode());
    }

    @Test
    @DisplayName("Deve comparar livros corretamente pelo ISBN")
    void compareTo() {
        Livro livroB = new Livro("Outro", "Autor", "222", 2024, 1);
        // livro1 (ISBN 111) vem antes de livroB (ISBN 222)
        assertTrue(livro1.compareTo(livroB) < 0);
    }

    @Test
    @DisplayName("Deve atualizar o número de exemplares corretamente")
    void setNumeroExemplares() {
        livro1.setNumeroExemplares(10);
        assertEquals(10, livro1.getNumeroExemplares());
    }
}