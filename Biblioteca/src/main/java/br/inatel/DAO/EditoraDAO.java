package br.inatel.DAO;

import br.inatel.Model.Editora;

import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.SQLException;
import java.util.ArrayList;

public class EditoraDAO extends ConnectionDAO {
    private boolean sucesso;

    // INSERT
    public boolean insertEditora(Editora editora) {
        connectToDB();
        String sql = "INSERT INTO editora (nomeeditora, enderecoeditora, telefoneeditora) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, editora.getNomeEditora());
            pst.setString(2, editora.getEnderecoEditora());
            pst.setString(3, editora.getTelefoneEditora());
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
    public ArrayList<Editora> selectEditoras() {
        ArrayList<Editora> editoras = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM editora";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Editora editora = new Editora(rs.getString("nomeeditora"), rs.getString("enderecoeditora"), rs.getString("telefoneeditora"));
                editoras.add(editora);
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
        return editoras;
    }

    // UPDATE
    public boolean updateEditoraEndereco(String nomeEditora, String enderecoEditora) {
        connectToDB();
        String sql = "UPDATE editora SET enderecoeditora=? WHERE nomeeditora=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, enderecoEditora);
            pst.setString(2, nomeEditora);
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
    public boolean deleteEditora(String nomeEditora) {
        connectToDB();
        String sql = "DELETE FROM editora WHERE nomeeditora=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nomeEditora);
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

