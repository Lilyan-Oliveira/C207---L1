package br.inatel.DAO;

import br.inatel.Model.Reserva;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReservaDAO extends ConnectionDAO {
    private boolean sucesso;

    // INSERT
    public boolean insertReserva(Reserva reserva) {
        connectToDB();
        String sql = "INSERT INTO reserva (idreserva, tomboreserva, funcionario, leitores_matriculaleitores, datareserva) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, reserva.getIdReserva());
            pst.setInt(2, reserva.getTomboReserva());
            pst.setString(3, String.valueOf(reserva.getFuncionario()));
            pst.setInt(4, reserva.getLeitoresMatricula());
            pst.setDate(5, java.sql.Date.valueOf(reserva.getDataReserva()));
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
    public ArrayList<Reserva> selectReservas() {
        ArrayList<Reserva> reservas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM reserva";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Reserva reserva = new Reserva(rs.getInt("idreserva"), rs.getInt("tomboreserva"), rs.getString("funcionario"), rs.getInt("leitores_matriculaleitores"), rs.getDate("datareserva").toLocalDate());
                reservas.add(reserva);
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
        return reservas;
    }

    // DELETE
    public boolean deleteReserva(int idReserva) {
        connectToDB();
        String sql = "DELETE FROM reserva WHERE idreserva=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idReserva);
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
