package br.inatel.DAO;

import br.inatel.Model.LivrosHasReserva;

import java.sql.SQLException;
import java.util.ArrayList;

public class LivrosHasReservaDAO extends ConnectionDAO {
    private boolean sucesso;

    // INSERT
    public boolean insertLivrosHasReserva(int livrosTombo, String livrosEditoraNomeEditora, int reservaIdReserva) {
        connectToDB();
        String sql = "INSERT INTO livros_has_reserva (livros_tombo, livros_editora_nomeeditora, reserva_idreserva) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, livrosTombo);
            pst.setString(2, livrosEditoraNomeEditora);
            pst.setInt(3, reservaIdReserva);
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
    public ArrayList<LivrosHasReserva> selectLivrosHasReserva() {
        ArrayList<LivrosHasReserva> livrosHasReserva = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM livros_has_reserva";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                LivrosHasReserva livrosHasReservaAux = new LivrosHasReserva(rs.getInt("livros_tombo"), rs.getString("livros_editora_nomeeditora"), rs.getInt("reserva_idreserva"));
                livrosHasReserva.add(livrosHasReservaAux);
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
        return livrosHasReserva;
    }

    // DELETE
    public boolean deleteLivrosHasReserva(int livrosTombo, String livrosEditoraNomeEditora, int reservaIdReserva) {
        connectToDB();
        String sql = "DELETE FROM livros_has_reserva WHERE livros_tombo=? AND livros_editora_nomeeditora=? AND reserva_idreserva=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, livrosTombo);
            pst.setString(2, livrosEditoraNomeEditora);
            pst.setInt(3, reservaIdReserva);
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
