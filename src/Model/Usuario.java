package Model;

import service.LivroException;
import service.UsuarioException;

import java.security.SecureRandom;
import java.util.*;

public class Usuario implements Comparable <Usuario> {
    private String nome;
    private final Long usuarioID;
    private Set<Livro>livrosEmprestados = new HashSet<>();

    public Usuario(String nome) {
        this.nome = nome;
        this.usuarioID = geradorId();
    }

    private Long geradorId() {
        SecureRandom secureRandom = new SecureRandom();
        long id = secureRandom.nextLong(1000, 1_0000);
        return id;
    }

    public void listaLivrosEmprestados() {
        if (livrosEmprestados.isEmpty()) throw new UsuarioException("Você não pegou nenhum livro emprestado no momento!");
        for (Livro livros : livrosEmprestados){
            System.out.println(livros.getTitulo());
        }
    }

    public boolean pegarLivroEmprestado(Livro livro) {
        return this.livrosEmprestados.add(livro);
    }

    public boolean devolverLivro(Livro livro) {
        if (!livrosEmprestados.contains(livro)) throw new UsuarioException("Livro não encontrado no acervo do usuario!");
        return this.livrosEmprestados.remove(livro);
    }

    @Override
    public int compareTo(Usuario o) {
        return this.usuarioID.compareTo(o.usuarioID);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getUsuarioID() {
        return usuarioID;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Usuario usuario = (Usuario) object;
        return usuarioID == usuario.usuarioID && Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, usuarioID);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", usuarioID=" + usuarioID +
                '}';
    }
}
