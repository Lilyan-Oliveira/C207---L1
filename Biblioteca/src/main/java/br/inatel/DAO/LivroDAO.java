package br.inatel.DAO;

import br.inatel.Model.Livros;

import java.sql.SQLException;
import java.util.ArrayList;

public class LivroDAO extends ConnectionDAO {
    private boolean sucesso;

    // INSERT
    public boolean insertLivro(Livros livro) {
        connectToDB();
        String sql = "INSERT INTO livros (tombo, titulo, autor, editora_nomeeditora, isbn, genero) values(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, livro.getTombo());
            pst.setString(2, livro.getTitulo());
            pst.setString(3, livro.getAutor());
            pst.setString(4, livro.getEditora());
            pst.setString(5, livro.getIsbn());
            pst.setString(6, livro.getGenero());
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
    public ArrayList<Livros> selectLivros() {
        ArrayList<Livros> livros = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM livros";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Livros livro = new Livros(rs.getInt("tombo"), rs.getString("titulo"), rs.getString("autor"), rs.getString("editora_nomeeditora"), rs.getString("isbn"), rs.getString("genero"));
                livros.add(livro);
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
        return livros;
    }

    // UPDATE
    public boolean updateLivroTitulo(int tombo, String titulo) {
        connectToDB();
        String sql = "UPDATE livros SET titulo=? WHERE tombo=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, titulo);
            pst.setInt(2, tombo);
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

    // DELETE
    public boolean deleteLivro(int tombo) {
        connectToDB();
        String sql = "DELETE FROM livros WHERE tombo=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, tombo);
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

