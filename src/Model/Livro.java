package Model;

import java.util.Objects;

public class Livro implements Comparable <Livro> {
    private String titulo;
    private String autor;
    private final String ISBN;
    private int anoPublicacao;
    private int numeroExemplares;

    public Livro(String titulo, String autor, String ISBN, int anoPublicacao, int numeroExemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.anoPublicacao = anoPublicacao;
        this.numeroExemplares = numeroExemplares;
    }

    @Override
    public int compareTo(Livro o) {
        return this.ISBN.compareTo(o.ISBN);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumeroExemplares() {
        return numeroExemplares;
    }

    public void setNumeroExemplares(int numeroExemplares) {
        this.numeroExemplares = numeroExemplares;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Livro livro = (Livro) object;
        return Objects.equals(titulo, livro.titulo) && Objects.equals(autor, livro.autor) && Objects.equals(ISBN, livro.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, ISBN);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", numeroExemplares=" + numeroExemplares +
                '}';
    }
}
