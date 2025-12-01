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
public class EspecieDAO {
    public static void criarEspecie(Especie e, Connection con) throws SQLException{
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO Especies (nome, dieta) VALUES (?, ?)");
        st.setString(1, e.getNome());
        st.setString(2, e.getDieta());
        
        st.execute();
        st.close();
    }
    
    public static void removerEspecie(int id, Connection con) throws SQLException{
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("DELETE FROM Especies WHERE id_especie = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } finally {
            if (st != null) st.close();
        }
    }
    
    public static HashSet<Especie> listAll(Connection con) throws SQLException{
        Statement st;
        HashSet<Especie> list = new HashSet<>();
            st = con.createStatement();
            String sql = "SELECT id_especie, nome, dieta FROM Especies";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                Especie e = new Especie(result.getString(2), result.getString(3));
                
                e.setId(result.getInt(1));
                
                
                list.add(e);
                
            }
        
        return list;
    }
    
}
