package br.inatel.DAO;

import br.inatel.Model.Autores;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutoresDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertAutor(Autores autor) {

        connectToDB();

        String sql = "INSERT INTO autores (nomeautor, nacionalidade) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,autor.getNomeautor());
            pst.setString(2, autor.getNacionalidade());
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
    public boolean updateAutorNome(String nomeautor, String novoautor) {
        connectToDB();
        String sql = "UPDATE Autores SET nomeautor=? where nomeautor=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, novoautor);
            pst.setString(2, nomeautor);
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
    public boolean deleteAutor(String nomeautor) {
        connectToDB();
        String sql = "DELETE FROM autores where nomeautor=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nomeautor);
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

    //ler
    public ArrayList<Autores> selectAutores() {
        ArrayList<Autores> autores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM autores";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de autores: ");

            while (rs.next()) {

                Autores autorAux = new Autores(rs.getString("nomeautor"), rs.getString("nacionalidade"));

                System.out.println("nome do autor = " + autorAux.getNomeautor());
                System.out.println("nacionalidade = " + autorAux.getNacionalidade());
                System.out.println("--------------------------------");

                autores.add(autorAux);
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
        return autores;
    }
}
