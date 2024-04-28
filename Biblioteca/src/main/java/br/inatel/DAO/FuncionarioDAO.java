package br.inatel.DAO;

import br.inatel.Model.Funcionario;

import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertFuncionario(Funcionario funcionario) {

        connectToDB();

        String sql = "INSERT INTO funcionarios (matriculaFuncionario, nomeFuncionario, enderecoFuncionario, telefoneFuncionario, emailFuncionario) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,funcionario.getMatriculaFuncionario());
            pst.setString(2, funcionario.getNomeFuncionario());
            pst.setString(3, funcionario.getEnderecoFuncionario());
            pst.setString(4, funcionario.getTelefoneFuncionario());
            pst.setString(5, funcionario.getEmailFuncionario());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //UPDATE
    public boolean updateFuncionarioNome(int matriculaFuncionario, String nomeFuncionario) {
        connectToDB();
        String sql = "UPDATE Funcionarios SET nomeFuncionario=? where matriculaFuncionario=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nomeFuncionario);
            pst.setInt(2, matriculaFuncionario);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //DELETE
    public boolean deleteFuncionario(int matriculaFuncionario) {
        connectToDB();
        String sql = "DELETE FROM Funcionarios where matriculaFuncionario=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, matriculaFuncionario);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //SELECT
    public ArrayList<Funcionario> selectFuncionario() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Funcionarios";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Funcionários: ");

            while (rs.next()) {

                Funcionario funcionarioAux = new Funcionario(rs.getInt("matricula"), rs.getString("nome"), rs.getString("endereço"), rs.getString("telefone"), rs.getString("email"));

                System.out.println("matricula = " + funcionarioAux.getMatriculaFuncionario());
                System.out.println("nome = " + funcionarioAux.getNomeFuncionario());
                System.out.println("endereço = " + funcionarioAux.getEnderecoFuncionario());
                System.out.println("telefone = " + funcionarioAux.getTelefoneFuncionario());
                System.out.println("Email = " + funcionarioAux.getEmailFuncionario());
                System.out.println("--------------------------------");

                funcionarios.add(funcionarioAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return funcionarios;
    }
}
