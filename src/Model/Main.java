package Model;

public class Main {

    private static class Classes {
        Biblioteca biblioteca;
        Livro livro1;
        Livro livro2;
        Usuario usuario;
    }
    public static void main(String[] args) {

        Classes classes = instancias();
        adicionarElementosPrimarios(classes);
        sistemaEmprestimoBiblioteca(classes);
        livrosCadastrados(classes);
        livrosEmprestados(classes);
        buscaLivrosPorAutor(classes);
    }

    private static Classes instancias(){
        Classes c = new Classes();
        c.biblioteca= new Biblioteca();
        c.livro1 = new Livro("Java: Como Programar", "Deitel", "123", 2017, 0);
        c.livro2 = new Livro("C: Como Programar", "Deitel", "321", 2015, 3);
        c.usuario = new Usuario("Victor");
        return c;
    }

    private static void adicionarElementosPrimarios(Classes c){
        c.biblioteca.adicionaLivro(c.livro1);
        c.biblioteca.adicionaLivro(c.livro2);
        c.biblioteca.adicionaUsuario(c.usuario);
    }
    private static void sistemaEmprestimoBiblioteca(Classes c){
        System.out.println("--- Sistema de Biblioteca ---");
        try {
            System.out.println("Realizando emprestimo...");
            c.biblioteca.realizarEmprestimo(c.livro1, c.usuario);
            System.out.println("Exemplares restantes: " + c.biblioteca.quantidadeExemplares(c.livro1.getTitulo()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente.");
            c.biblioteca.realizarEmprestimo(c.livro2, c.usuario);
            System.out.println("Exemplares restantes: " + c.biblioteca.quantidadeExemplares(c.livro2.getTitulo()));
        }
    }

    private static void livrosEmprestados (Classes c){
        System.out.println("\nLivros com o usuário:");
        try {
            c.usuario.listaLivrosEmprestados();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void livrosCadastrados(Classes c){
        System.out.println("\nExibir livros cadastrados");
        try {
            c.biblioteca.exibirTodosOsLivros();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscaLivrosPorAutor(Classes c){
        System.out.println("\nBuscando livro por autor");
        try {
            c.biblioteca.buscarLivroPorAutor("Jose augusto");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente.");
            System.out.println(c.biblioteca.buscarLivroPorAutor(c.livro1.getAutor()));
        }
    }
}

