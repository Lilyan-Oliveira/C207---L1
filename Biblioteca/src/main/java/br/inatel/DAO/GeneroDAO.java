package br.inatel.DAO;

import br.inatel.Model.Generos;

import java.sql.SQLException;
import java.util.ArrayList;

public class GeneroDAO extends ConnectionDAO {
    private boolean sucesso;

    // INSERT
    public boolean insertGenero(Generos genero) {
        connectToDB();
        String sql = "INSERT INTO generos (nomegenero) values(?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, genero.getNomeGenero());
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
    public ArrayList<Generos> selectGeneros() {
        ArrayList<Generos> generos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM generos";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Generos genero = new Generos(rs.getString("nomegenero"));
                generos.add(genero);
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
        return generos;
    }

    // DELETE
    public boolean deleteGenero(String nomeGenero) {
        connectToDB();
        String sql = "DELETE FROM generos WHERE nomegenero=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nomeGenero);
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
