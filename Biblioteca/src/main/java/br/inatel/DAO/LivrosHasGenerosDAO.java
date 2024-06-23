package br.inatel.DAO;

import br.inatel.Model.LivrosHasGeneros;

import java.sql.SQLException;
import java.util.ArrayList;

public class LivrosHasGenerosDAO extends ConnectionDAO {
    private boolean sucesso;

    // INSERT
    public boolean insertLivrosHasGeneros(int livrosTombo, String livrosEditoraNomeEditora, String generosNomeGenero) {
        connectToDB();
        String sql = "INSERT INTO livros_has_generos (livros_tombo, livros_editora_nomeeditora, generos_nomegenero) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, livrosTombo);
            pst.setString(2, livrosEditoraNomeEditora);
            pst.setString(3, generosNomeGenero);
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
    public ArrayList<LivrosHasGeneros> selectLivrosHasGeneros() {
        ArrayList<LivrosHasGeneros> livrosHasGeneros = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM livros_has_generos";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                LivrosHasGeneros livrosHasGenerosAux = new LivrosHasGeneros(rs.getInt("livros_tombo"), rs.getString("livros_editora_nomeeditora"), rs.getString("generos_nomegenero"));
                livrosHasGeneros.add(livrosHasGenerosAux);
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
        return livrosHasGeneros;
    }

    // DELETE
    public boolean deleteLivrosHasGeneros(int livrosTombo, String livrosEditoraNomeEditora, String generosNomeGenero) {
        connectToDB();
        String sql = "DELETE FROM livros_has_generos WHERE livros_tombo=? AND livros_editora_nomeeditora=? AND generos_nomegenero=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, livrosTombo);
            pst.setString(2, livrosEditoraNomeEditora);
            pst.setString(3, generosNomeGenero);
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

