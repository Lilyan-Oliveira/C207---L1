import br.inatel.DAO.FuncionarioDAO;
import br.inatel.Model.Funcionario;

public class Main {
    public static void main(String[] args) {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        Funcionario f1 = new Funcionario(1792,"Lilyan","Santa rits","12345687", "lilyan.inatel.br");
        Funcionario f2 = new Funcionario(2,"Eric","Santa Santa rita","12363636", "Eric.inatel.br");

        funcionarioDAO.insertFuncionario(f1);
        funcionarioDAO.insertFuncionario(f2);

        funcionarioDAO.selectFuncionario();

        funcionarioDAO.updateFuncionarioNome(1792, "Leciane");

        funcionarioDAO.selectFuncionario();

        funcionarioDAO.deleteFuncionario(2);
    }
}
