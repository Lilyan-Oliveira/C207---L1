import br.inatel.DAO.FuncionarioDAO;
import br.inatel.DAO.LivroDAO;
import br.inatel.Model.Funcionario;
import br.inatel.Model.Livros;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println(" ");
            System.out.println("Bem-vindo ao sistema da biblioteca do INATEL! Para acessar, escolha: ");
            System.out.println("1 - Acessar como Funcionário");
            System.out.println("2 - Acessar como Aluno");
            System.out.println("0 - Sair");
            int userType = sc.nextInt();
            sc.nextLine();

            switch (userType) {
                case 1:
                    menuFuncionario(sc);
                    break;
                case 2:
                    menuAluno(sc);
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
        }
        sc.close();
    }
    private static void menuFuncionario(Scanner sc) {
        boolean flag = true;

        while (flag) {
            System.out.println(" ");
            System.out.println("Menu Funcionário:");
            System.out.println("1 - Inserir, atualizar, deletar ou listar livros");
            System.out.println("2 - Inserir, atualizar, deletar ou listar funcionários");
            System.out.println("3 - Ver reservas");
            System.out.println("4 - Ver empréstimos");
            System.out.println("5 - Lista de leitores");
            System.out.println("0 - Voltar ao menu principal");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    crudLivro(sc);
                    break;
                case 2:
                    crudFuncionario(sc);
                    break;
                case 3:
                    System.out.println("Ver todas as reservas");
                    break;
                case 4:
                    System.out.println("Lista de empréstimos");
                    break;
                case 5:
                    System.out.println("Lista de leitores");
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
        }
    }

    private static void crudLivro(Scanner sc){
        boolean flag = true;

        while (flag){
            System.out.println(" ");
            System.out.println("1 - Inserir novo livro");
            System.out.println("2 - Atualizar dados de livro existente");
            System.out.println("3 - Deletar livro");
            System.out.println("4 - Lista de livros");
            System.out.println("0 - Voltar ao menu anterior");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1:
                    cadastrarNovoLivro(sc);
                    break;
                case 2:
                    atualizarLivro(sc);
                    break;
                case 3:
                    deletarLivro(sc);
                    break;
                case 4:
                    mostrarLivrosDisponiveis();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
        }
    }

    private static void crudFuncionario(Scanner sc){
        boolean flag = true;

        while (flag){
            System.out.println(" ");
            System.out.println("1 - Inserir novo funcionário");
            System.out.println("2 - Atualizar dados de um funcionário existente");
            System.out.println("3 - Deletar funcionário");
            System.out.println("4 - Lista de funcionários");
            System.out.println("0 - Voltar ao menu anterior");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1:
                    cadastrarNovoFuncionario(sc);
                    break;
                case 2:
                    atualizarFuncionario(sc);
                    break;
                case 3:
                    deletarFuncionario(sc);
                    break;
                case 4:
                    mostrarFuncionariosDisponiveis();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
        }
    }

    private static void menuAluno(Scanner sc) {
        boolean flag = true;

        while (flag) {
            System.out.println(" ");
            System.out.println("Menu Aluno:");
            System.out.println("1 - Lista de livros disponíveis");
            System.out.println("2 - Fazer uma reserva");
            System.out.println("3 - Meus empréstimos");
            System.out.println("0 - Voltar ao menu principal");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    mostrarLivrosDisponiveis();
                    break;
                case 2:
                    System.out.println("Aluno fará uma reserva");
                    break;
                case 3:
                    System.out.println("Lista dos empréstimos");
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
        }
    }

    private static void mostrarLivrosDisponiveis() {
        LivroDAO livroDAO = new LivroDAO();
        ArrayList<Livros> listaLivros = livroDAO.selectLivros();

        if (listaLivros.isEmpty()) {
            System.out.println("Nenhum livro disponível.");
        } else {
            for (Livros livro : listaLivros) {
                System.out.println(" ");
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Tombo: " + livro.getTombo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Editora: " + livro.getEditora());
                System.out.println("ISBN: " + livro.getIsbn());
                System.out.println("Gênero: " + livro.getGenero());
                System.out.println("------------------------");
            }
        }
    }

    private static void cadastrarNovoLivro(Scanner sc) {
        System.out.println("Digite o tombo:");
        int tombo = sc.nextInt();
        sc.nextLine(); // Consome a quebra de linha
        System.out.println("Digite o título:");
        String titulo = sc.nextLine();
        System.out.println("Digite o autor:");
        String autor = sc.nextLine();
        System.out.println("Digite a editora:");
        String editora = sc.nextLine();
        System.out.println("Digite o ISBN:");
        String isbn = sc.nextLine();
        System.out.println("Digite o gênero:");
        String genero = sc.nextLine();

        Livros novoLivro = new Livros(tombo, titulo, autor, editora, isbn, genero);
        LivroDAO livroDAO = new LivroDAO();
        if (livroDAO.insertLivro(novoLivro)) {
            System.out.println("Livro cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar livro.");
        }
    }

    private static void atualizarLivro(Scanner sc) {
        System.out.println("Digite o tombo do livro que deseja atualizar:");
        int tombo = sc.nextInt();
        sc.nextLine(); // Consome a quebra de linha
        System.out.println("Digite o novo título:");
        String titulo = sc.nextLine();

        LivroDAO livroDAO = new LivroDAO();
        if (livroDAO.updateLivroTitulo(tombo, titulo)) {
            System.out.println("Livro atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar livro.");
        }
    }

    private static void deletarLivro(Scanner sc) {
        System.out.println("Digite o tombo do livro que deseja deletar:");
        int tombo = sc.nextInt();

        LivroDAO livroDAO = new LivroDAO();
        if (livroDAO.deleteLivro(tombo)) {
            System.out.println("Livro deletado com sucesso!");
        } else {
            System.out.println("Erro ao deletar livro.");
        }
    }

    private static void cadastrarNovoFuncionario(Scanner sc) {
        System.out.println("Digite a matrícula:");
        int matricula = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o nome:");
        String nome = sc.nextLine();
        System.out.println("Digite o endereço:");
        String endereco = sc.nextLine();
        System.out.println("Digite o telefone:");
        String telefone = sc.nextLine();
        System.out.println("Digite o email:");
        String email = sc.nextLine();

        Funcionario novoFuncionario = new Funcionario(matricula, nome, endereco, telefone, email);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        if (funcionarioDAO.insertFuncionario(novoFuncionario)) {
            System.out.println("Funcionário cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar funcionário.");
        }
    }

    private static void atualizarFuncionario(Scanner sc) {
        System.out.println("Digite a matrícula do funcionário que deseja atualizar:");
        int matricula = sc.nextInt();
        sc.nextLine(); // Consome a quebra de linha
        System.out.println("Digite o novo nome:");
        String nome = sc.nextLine();

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        if (funcionarioDAO.updateFuncionarioNome(matricula, nome)) {
            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar funcionário.");
        }
    }

    private static void deletarFuncionario(Scanner sc) {
        System.out.println("Digite a matrícula do funcionário que deseja deletar:");
        int matricula = sc.nextInt();

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        if (funcionarioDAO.deleteFuncionario(matricula)) {
            System.out.println("Funcionário deletado com sucesso!");
        } else {
            System.out.println("Erro ao deletar funcionário.");
        }
    }

    private static void mostrarFuncionariosDisponiveis() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        ArrayList<Funcionario> listaFuncionarios = funcionarioDAO.selectFuncionario();

        if (listaFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionário disponível.");
        } else {
            for (Funcionario funcionario : listaFuncionarios) {
                System.out.println(" ");
                System.out.println("Nome: " + funcionario.getNomefuncionario());
                System.out.println("Matrícula: " + funcionario.getMatriculafuncionario());
                System.out.println("Endereço: " + funcionario.getEnderecofuncionario());
                System.out.println("Telefone: " + funcionario.getTelefonefuncionario());
                System.out.println("Email: " + funcionario.getEmailfuncionario());
                System.out.println("------------------------");
            }
        }
    }
}
