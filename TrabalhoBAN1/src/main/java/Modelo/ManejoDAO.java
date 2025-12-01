/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bela
 */
public class ManejoDAO {
    public static void criarManejo(int idZelador, int idViveiro, Connection con) throws SQLException {
        PreparedStatement st = null;

        try {
            st = con.prepareStatement(
                "INSERT INTO Manejo (id_funcionario, id_viveiro) VALUES (?, ?)"
            );

            st.setInt(1, idZelador);
            st.setInt(2, idViveiro);

            st.executeUpdate();

        } finally {
            if (st != null) st.close();
        }
    }
    
    //zelador deixa de cuidar de um viveiro
    public static void removerManejo(int idZelador, int idViveiro, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(
                "DELETE FROM Manejo WHERE id_funcionario = ? AND id_viveiro = ?"
            );
            st.setInt(1, idZelador);
            st.setInt(2, idViveiro);

            st.executeUpdate();

        } finally {
            if (st != null) st.close();
        }
    }
    
    public static HashSet<String> listAll(Connection con) throws SQLException {
        Statement st = null;
        ResultSet rs = null;
        HashSet<String> lista = new HashSet<>();

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT id_manejo, id_funcionario, id_viveiro FROM Manejo");

            while (rs.next()) {
                String entrada = 
                        "ID Manejo: " + rs.getInt("id_manejo") +
                        ", Zelador: " + rs.getInt("id_funcionario") +
                        ", Viveiro: " + rs.getInt("id_viveiro");

                lista.add(entrada);
            }

        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
        }

        return lista;
    }
    
}
