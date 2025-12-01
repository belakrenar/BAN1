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
public class ZeladorDAO {
    public static void criarZelador(Zelador z, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO Zeladores (nome, cpf, salario, cidade) VALUES (?, ?, ?, ?)");
        st.setString(1, z.getNome());
        st.setString(2, z.getCpf()); //eh long na classe
        st.setInt(3, z.getSalario()); //eh int na classe
        st.setString(4, z.getCidade());
        
        st.execute();
        st.close();
        
    }
    
    public static void removerZelador(int id, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("DELETE FROM Zeladores WHERE id_funcionario = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } finally {
            if (st != null) st.close();
        }                                       
    }
    
    public static HashSet<Zelador> listAllWithCidade(String cidade, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        HashSet<Zelador> list = new HashSet<>();

        try {
            st = con.prepareStatement(
                "SELECT id_funcionario, nome, cpf, salario, cidade FROM Zeladores WHERE cidade = ?"
            );
            st.setString(1, cidade);
            result = st.executeQuery();

            while (result.next()) {
                Zelador z = new Zelador(result.getString("nome"),result.getString("cpf"),result.getInt("salario"),result.getString("cidade"));
                
                z.setId(result.getInt("id_funcionario"));
                
                
                list.add(z);
            }

        } finally {
            if (result != null) result.close();
            if (st != null) st.close();
        }

        return list;
    }

    
    public static HashSet<Zelador> listAll(Connection con) throws SQLException {
        Statement st;
        HashSet<Zelador> list = new HashSet<>();
            st = con.createStatement();
            String sql = "SELECT id_funcionario, nome, cpf, salario, cidade FROM Zeladores";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                Zelador z = new Zelador(result.getString("nome"),result.getString("cpf"),result.getInt("salario"),result.getString("cidade"));
                
                z.setId(result.getInt("id_funcionario"));
                
                list.add(z);
            }
        return list;
    }
    
                                        
}
