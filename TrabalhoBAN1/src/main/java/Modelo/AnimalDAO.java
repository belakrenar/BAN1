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
public class AnimalDAO {
    public static void criarAnimal(Animal a, Connection con) throws SQLException{
        PreparedStatement st;
        
        st = con.prepareStatement("INSERT INTO Animais (nome, idade, sexo, id_especie, id_viveiro) VALUES (?,?,?,?,?)");
        st.setString(1, a.getNome());
        st.setInt(2, a.getIdade());
        st.setString(3, a.getSexo());
        st.setInt(4, a.getIdEspecie());
        st.setInt(5, a.getIdViveiro());
        
        st.execute();
        st.close();
    }
    
    public static void removerAnimal(int id, Connection con) throws SQLException {
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("DELETE FROM Animais WHERE id_animal = ?");
            st.setInt(1, id);
            st.executeUpdate();

        } finally {
            if (st != null) st.close();
        }
    }
    
    public static HashSet<Animal> listAll(Connection con) throws SQLException {
        Statement st = null;
        ResultSet result = null;
        HashSet<Animal> list = new HashSet<>();

        try {
            st = con.createStatement();
            String sql = "SELECT id_animal, nome, idade, sexo, id_especie, id_viveiro FROM Animais";
            result = st.executeQuery(sql);

            while (result.next()) {
                Animal a = new Animal(
                    result.getString("nome"),
                    result.getInt("idade"),
                    result.getString("sexo"),
                    result.getInt("id_especie"),
                    result.getInt("id_viveiro")
                );

                a.setId(result.getInt("id_animal"));
                list.add(a);
            }

        } finally {
            if (result != null) result.close();
            if (st != null) st.close();
        }

        return list;
    }

    public static HashSet<Animal> listByEspecie(String nomeEspecie, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        HashSet<Animal> list = new HashSet<>();

        try {
            String sql =
                "SELECT a.id_animal, a.nome, a.idade, a.sexo, a.id_especie, a.id_viveiro, " +
                "       e.nome AS especie_nome, e.dieta AS especie_dieta " +
                "FROM Animais a " +
                "JOIN Especies e ON a.id_especie = e.id_especie " +
                "WHERE e.nome = ?";

            st = con.prepareStatement(sql);
            st.setString(1, nomeEspecie);

            result = st.executeQuery();

            while (result.next()) {

                Animal a = new Animal(
                    result.getString("nome"),
                    result.getInt("idade"),
                    result.getString("sexo"),
                    result.getInt("id_especie"),
                    result.getInt("id_viveiro")
                );
                a.setId(result.getInt("id_animal"));

                Especie esp = new Especie(
                    result.getString("especie_nome"),
                    result.getString("especie_dieta")
                );
                esp.setId(result.getInt("id_especie"));

                a.setEspecie(esp);

                list.add(a);
            }

        } finally {
            if (result != null) result.close();
            if (st != null) st.close();
        }

        return list;
    }

    public static HashSet<Animal> listByBioma(String nomeBioma, Connection con) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        HashSet<Animal> lista = new HashSet<>();

        try {
            String sql =
                "SELECT a.id_animal, a.nome AS animal_nome, a.idade, a.sexo, a.id_especie, a.id_viveiro, " +
                "       v.capacidade, v.area, v.id_bioma, " +
                "       b.nome AS bioma_nome, b.temperatura " +
                "FROM Animais a " +
                "JOIN Viveiros v ON a.id_viveiro = v.id_viveiro " +
                "JOIN Biomas b ON v.id_bioma = b.id_bioma " +
                "WHERE b.nome = ?";

            st = con.prepareStatement(sql);
            st.setString(1, nomeBioma);

            rs = st.executeQuery();

            while (rs.next()) {

                Animal animal = new Animal(
                    rs.getString("animal_nome"),
                    rs.getInt("idade"),
                    rs.getString("sexo"),
                    rs.getInt("id_especie"),
                    rs.getInt("id_viveiro")
                );
                animal.setId(rs.getInt("id_animal"));

                Bioma bioma = new Bioma(
                    rs.getString("bioma_nome"),
                    rs.getString("temperatura")
                );
                bioma.setId(rs.getInt("id_bioma"));

                Viveiro viveiro = new Viveiro(
                    rs.getInt("capacidade"),
                    rs.getInt("area"),
                    rs.getInt("id_bioma")
                );
                viveiro.setId(rs.getInt("id_viveiro"));
                viveiro.setBioma(bioma);

                
                animal.setViveiro(viveiro);

                lista.add(animal);
            }

        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
        }

        return lista;
    }

}
