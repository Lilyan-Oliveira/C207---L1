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
            pst.setInt(1,funcionario.getMatriculafuncionario());
            pst.setString(2, funcionario.getNomefuncionario());
            pst.setString(3, funcionario.getEnderecofuncionario());
            pst.setString(4, funcionario.getTelefonefuncionario());
            pst.setString(5, funcionario.getEmailfuncionario());
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
    public boolean updateFuncionarioNome(int matriculafuncionario, String nomefuncionario) {
        connectToDB();
        String sql = "UPDATE Funcionarios SET nomeFuncionario=? where matriculaFuncionario=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nomefuncionario);
            pst.setInt(2, matriculafuncionario);
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
    public boolean deleteFuncionario(int matriculafuncionario) {
        connectToDB();
        String sql = "DELETE FROM funcionarios where matriculafuncionario=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, matriculafuncionario);
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
        String sql = "SELECT * FROM funcionarios";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Funcionários: ");

            while (rs.next()) {

                Funcionario funcionarioAux = new Funcionario(rs.getInt("matriculafuncionario"), rs.getString("nomefuncionario"), rs.getString("enderecofuncionario"), rs.getString("telefonefuncionario"), rs.getString("emailfuncionario"));

                System.out.println("matricula = " + funcionarioAux.getMatriculafuncionario());
                System.out.println("nome = " + funcionarioAux.getNomefuncionario());
                System.out.println("endereço = " + funcionarioAux.getEnderecofuncionario());
                System.out.println("telefone = " + funcionarioAux.getTelefonefuncionario());
                System.out.println("email = " + funcionarioAux.getEmailfuncionario());
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
