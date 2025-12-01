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
public class BiomaDAO {
    
    public static void criarBioma(Bioma b, Connection con) throws SQLException{
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO Biomas (nome, temperatura) VALUES (?, ?)");
        st.setString(1, b.getNome());
        st.setString(2, b.getTemperatura());
        
        st.execute();
        st.close();
    }
    
    public static void removerBioma(int id, Connection con) throws SQLException{
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("DELETE FROM Biomas WHERE id_bioma = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } finally {
            if (st != null) st.close();
        }
    }
    
    public static HashSet<Bioma> listAll(Connection con) throws SQLException{
        Statement st;
        HashSet<Bioma> list = new HashSet<>();
            st = con.createStatement();
            String sql = "SELECT id_bioma, nome, temperatura FROM Biomas";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                Bioma b = new Bioma(result.getString(2), result.getString(3));
                
                b.setId(result.getInt(1));
                
                list.add(b);
            }
        
        return list;
    }
    
    public static HashSet listAllWithNome(String nome, Connection con) throws SQLException{
        PreparedStatement st = null;
        ResultSet result = null;
        HashSet list = new HashSet();
        try{
            st = con.prepareStatement("SELECT id_bioma, nome, temperatura FROM Biomas WHERE nome = ?");
            st.setString(1, nome);
            result = st.executeQuery();
            
            while(result.next()){
                Bioma b = new Bioma(result.getString("nome"), result.getString("temperatura"));
                
                b.setId(result.getInt("id_bioma"));
                
                list.add(b);
            }
        } finally{
            if (result != null) result.close();
            if (st != null) st.close();
        }
        
        return list;
    }
  
}
