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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bela
 */
public class ViveiroDAO {
    
    public static void criarViveiro(Viveiro v, Connection con) throws SQLException {
        PreparedStatement st = null;

        try {
            st = con.prepareStatement(
                "INSERT INTO Viveiros (capacidade, area, id_bioma) VALUES (?, ?, ?)"
            );

            st.setInt(1, v.getCapacidade());
            st.setInt(2, v.getArea());
            st.setInt(3, v.getIdBioma());

            st.executeUpdate();

        } finally {
            if (st != null) st.close();
        }
    }
    
    public static void removerViveiro(int id, Connection con) throws SQLException {
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("DELETE FROM Viveiros WHERE id_viveiro = ?");
            st.setInt(1, id);
            st.executeUpdate();

        } finally {
            if (st != null) st.close();
        }
    }
    
    public static HashSet<Viveiro> listAll(Connection con) throws SQLException {
        Statement st = null;
        ResultSet result = null;
        HashSet<Viveiro> list = new HashSet<>();

        try {
            st = con.createStatement();
            String sql = "SELECT id_viveiro, capacidade, area, id_bioma FROM Viveiros";
            result = st.executeQuery(sql);

            while (result.next()) {
                Viveiro v = new Viveiro(
                    result.getInt("capacidade"),
                    result.getInt("area"),
                    result.getInt("id_bioma")
                );
                
                v.setId(result.getInt("id_viveiro"));

                list.add(v);
            }

        } finally {
            if (result != null) result.close();
            if (st != null) st.close();
        }

        return list;
    }

    public static int getUltimoId(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT currval(pg_get_serial_sequence('viveiros','id_viveiro'))"
        );

        rs.next();
        return rs.getInt(1);
    }
}
