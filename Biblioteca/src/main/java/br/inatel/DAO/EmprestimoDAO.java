package br.inatel.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import br.inatel.Model.Emprestimos;

public class EmprestimoDAO extends ConnectionDAO {
    private boolean sucesso;

    // INSERT
    public boolean insertEmprestimo(Emprestimos emprestimo) {
        connectToDB();
        String sql = "INSERT INTO emprestimos (numemprestimo, livro_tombo, leitor_matriculaleitores, dataemprestimo, datadevolucao) VALUES (?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, emprestimo.getIdEmprestimos());
            pst.setInt(2, emprestimo.getTomboEmprestimo());
            pst.setInt(3, emprestimo.getLeitor());
            pst.setDate(4, Date.valueOf(String.valueOf(emprestimo.getDataEmprestimo())));
            pst.setDate(5, Date.valueOf(String.valueOf(emprestimo.getDataRetorno())));
            pst.executeUpdate(); // Use executeUpdate() for INSERT statements
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

    // SELECT
    public ArrayList<Emprestimos> selectEmprestimos() {
        ArrayList<Emprestimos> emprestimos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM emprestimos";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Emprestimos emprestimo = new Emprestimos(
                        rs.getInt("numemprestimo"),
                        rs.getInt("livro_tombo"),
                        rs.getDate("dataemprestimo").toLocalDate(),
                        rs.getDate("datadevolucao").toLocalDate(),
                        rs.getInt("leitor_matriculaleitores"),
                        rs.getInt("funcionario") // Ajuste conforme seus campos no banco
                );
                emprestimos.add(emprestimo);
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
        return emprestimos;
    }

    // DELETE
    public boolean deleteEmprestimo(int numEmprestimo) {
        connectToDB();
        String sql = "DELETE FROM emprestimos WHERE numemprestimo=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, numEmprestimo);
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
}
