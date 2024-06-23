package br.inatel.DAO;

import br.inatel.Model.Leitor;

import java.sql.SQLException;
import java.util.ArrayList;

public class LeitorDAO extends ConnectionDAO {

    boolean sucesso = false;

    public boolean insertLeitor(Leitor leitor) {
        connectToDB();

        String sql = "INSERT INTO leitores (matriculaleitores, nomeleitores, telefoneleitores, emailleitores) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, leitor.getMatriculaleitores());
            pst.setString(2, leitor.getNomeleitores());
            pst.setString(3, leitor.getTelefoneleitores());
            pst.setString(4, leitor.getEmailleitores());
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

    public ArrayList<Leitor> selectLeitores() {
        ArrayList<Leitor> leitores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM leitores";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Leitores: ");

            while (rs.next()) {
                Leitor leitorAux = new Leitor(rs.getInt("matriculaleitores"), rs.getString("nomeleitores"), rs.getString("telefoneleitores"), rs.getString("emailleitores"));

                System.out.println("matricula = " + leitorAux.getMatriculaleitores());
                System.out.println("nome = " + leitorAux.getNomeleitores());
                System.out.println("telefone = " + leitorAux.getTelefoneleitores());
                System.out.println("email = " + leitorAux.getEmailleitores());
                System.out.println("--------------------------------");

                leitores.add(leitorAux);
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
        return leitores;
    }
}

