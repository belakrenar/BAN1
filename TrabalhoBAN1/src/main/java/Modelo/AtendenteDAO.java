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
public class AtendenteDAO {
    
    public static void criarAtendente(Atendente a, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO Atendentes (nome, cpf, salario, cidade) VALUES (?, ?, ?, ?)");
        st.setString(1, a.getNome());
        st.setString(2, a.getCpf()); //eh long na classe
        st.setInt(3, a.getSalario()); //eh int na classe
        st.setString(4, a.getCidade());
        
        st.execute();
        st.close();
        
    }
    
    public static void removerAtendente(int id, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("DELETE FROM Atendentes WHERE id_funcionario = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } finally {
            if (st != null) st.close();
        }                                       
    }

    
    public static HashSet<Atendente> listAll(Connection con) throws SQLException {
        Statement st;
        HashSet<Atendente> list = new HashSet<>();
            st = con.createStatement();
            String sql = "SELECT id_funcionario, nome, cpf, salario, cidade FROM Atendentes";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                Atendente a = new Atendente(result.getString("nome"),result.getString("cpf"),result.getInt("salario"),result.getString("cidade"));
                
                a.setId(result.getInt("id_funcionario"));
                
                list.add(a);
                
            }
        return list;
    }
}
