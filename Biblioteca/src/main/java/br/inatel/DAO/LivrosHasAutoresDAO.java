package br.inatel.DAO;

import br.inatel.Model.LivrosHasAutores;

import java.sql.SQLException;
import java.util.ArrayList;

public class LivrosHasAutoresDAO extends ConnectionDAO {
    private boolean sucesso;

    // INSERT
    public boolean insertLivrosHasAutores(int livrosTombo, String autoresNomeAutor) {
        connectToDB();
        String sql = "INSERT INTO livros_has_autores (livros_tombo, autores_nomeautor) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, livrosTombo);
            pst.setString(2, autoresNomeAutor);
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

    // SELECT
    public ArrayList<LivrosHasAutores> selectLivrosHasAutores() {
        ArrayList<LivrosHasAutores> livrosHasAutores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM livros_has_autores";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                LivrosHasAutores livrosHasAutoresAux = new LivrosHasAutores(rs.getInt("livros_tombo"), rs.getString("autores_nomeautor"));
                livrosHasAutores.add(livrosHasAutoresAux);
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
        return livrosHasAutores;
    }

    // DELETE
    public boolean deleteLivrosHasAutores(int livrosTombo, String autoresNomeAutor) {
        connectToDB();
        String sql = "DELETE FROM livros_has_autores WHERE livros_tombo=? AND autores_nomeautor=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, livrosTombo);
            pst.setString(2, autoresNomeAutor);
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

