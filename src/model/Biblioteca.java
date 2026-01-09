package model;


import service.BibliotecaLivrosException;
import service.LivroException;
import service.UsuarioException;
import java.util.Set;
import java.util.TreeSet;

public class Biblioteca {

    Set<Usuario> usuariosSet = new TreeSet<>();
    Set<Livro> livrosSet = new TreeSet<>();

    public Biblioteca() {
        this.usuariosSet = new TreeSet<>();
        this.livrosSet = new TreeSet<>();
    }

    public boolean adicionaUsuario(Usuario usuario) {
        return this.usuariosSet.add(usuario);
    }

    public void removeUsuario(Usuario usuario) {
        if (!usuariosSet.contains(usuario)) throw new UsuarioException("Usuario não encontrado!");
        this.usuariosSet.remove(usuario);
    }

    public void listaUsuarios(){
        if (usuariosSet.isEmpty()) throw new UsuarioException("Nenhum usuario cadastrado!");
        for (Usuario usuarios: usuariosSet){
            System.out.println(usuarios.getNome());
        }
    }

    public boolean adicionaLivro(Livro livro) {
        return this.livrosSet.add(livro);
    }

    public boolean removeLivro(Livro livro) {
        if (!livrosSet.contains(livro)) throw new BibliotecaLivrosException("Livro não encontrado na biblioteca");
        return this.livrosSet.remove(livro);
    }

    public void realizarEmprestimo(Livro livro, Usuario usuario) {
        if (!livrosSet.contains(livro))throw new BibliotecaLivrosException("Livro não encontrado na biblioteca");
        if (!usuariosSet.contains(usuario)) throw new UsuarioException("Usuario não cadastrado no sistema!");
        if (livro.getNumeroExemplares() <= 0) throw new LivroException("Não há exemplares disponíveis!");

        livro.setNumeroExemplares(livro.getNumeroExemplares()-1);
        usuario.pegarLivroEmprestado(livro);
        System.out.println("Emprestimo concluido com sucesso!");
    }

    public void receberDevolucaoLivro(Livro livro,Usuario usuario) {
        usuario.devolverLivro(livro);
        if (!livrosSet.contains(livro)){
            adicionaLivro(livro);
        }
        livro.setNumeroExemplares(livro.getNumeroExemplares()+1);
        System.out.println("Devolução concluida com sucesso!");
    }

    public String buscarLivroPorISBN(String buscarISBN) {
        for (Livro livro : livrosSet) {
            if (livro.getISBN().equals(buscarISBN)) {
                return livro.toString();
            }
        }
        throw new LivroException("Erro. O ISBN inserido não esta associado a nenhum livro!");
    }

    public String buscarLivroPorAutor(String nomeAutor) {
        for (Livro livro : livrosSet) {
            if (livro.getAutor().equals(nomeAutor)) {
                return livro.getAutor();
            }
        }
        throw new LivroException("Erro. O autor não esta associado a nenhum livro!");
    }

    public void exibirTodosOsLivros() {
        if (livrosSet.isEmpty()) throw new BibliotecaLivrosException("Nenhum livro cadastrado!");
        for (Livro livro : livrosSet) {
            System.out.println(livro.getTitulo());
        }
    }

    public int quantidadeExemplares(String tituloLivro) {
        if (livrosSet.isEmpty())throw new BibliotecaLivrosException("Nenhum livro encontrado");
        for (Livro livro : livrosSet) {
            if (livro.getTitulo().equals(tituloLivro)) {
                return livro.getNumeroExemplares();
            }
        }
        return 0;
    }

    public int totalLivrosCadastrados(){
        return this.livrosSet.size();
    }
}
