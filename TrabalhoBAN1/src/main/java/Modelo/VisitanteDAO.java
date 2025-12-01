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
public class VisitanteDAO {
    public static void criarVisitante(Visitante v, Connection con) throws SQLException {
        PreparedStatement st = null;

        try {
            st = con.prepareStatement(
                "INSERT INTO Visitantes (nome, cpf, celular, email, cidade) VALUES (?, ?, ?, ?, ?)"
            );

            st.setString(1, v.getNome());
            st.setString(2, v.getCpf()); 
            st.setString(3, v.getCelular());
            st.setString(4, v.getEmail());
            st.setString(5, v.getCidade());

            st.executeUpdate();

        } finally {
            if (st != null) st.close();
        }
    }
    
    public static void removerVisitante(int id, Connection con) throws SQLException {
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("DELETE FROM Visitantes WHERE id_visitante = ?");
            st.setInt(1, id);
            st.executeUpdate();

        } finally {
            if (st != null) st.close();
        }
    }
    
    public static HashSet<Visitante> listAll(Connection con) throws SQLException {
        Statement st = null;
        ResultSet result = null;
        HashSet<Visitante> list = new HashSet<>();

        try {
            st = con.createStatement();
            String sql = "SELECT id_visitante, nome, cpf, celular, email, cidade FROM Visitantes";
            result = st.executeQuery(sql);

            while (result.next()) {
                Visitante v = new Visitante(
                    result.getString("nome"),
                    result.getString("cpf"),
                    result.getString("celular"),
                    result.getString("email"),
                    result.getString("cidade")
                );
                
                v.setId(result.getInt("id_visitante"));

                list.add(v);
            }

        } finally {
            if (result != null) result.close();
            if (st != null) st.close();
        }

        return list;
    }

}
