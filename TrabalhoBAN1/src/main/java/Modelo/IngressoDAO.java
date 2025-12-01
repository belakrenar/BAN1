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
public class IngressoDAO {
    public static void criarIngresso(Ingresso i, Connection con) throws SQLException {
        PreparedStatement st = null;

        try {
            st = con.prepareStatement(
                "INSERT INTO Ingressos " +
                "(dataVisita, preco, tipo, id_visitante, id_atendente, horarioEntrada, horarioSaida) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            st.setString(1, i.getDataVisita());
            st.setInt(2, i.getPreco());
            st.setString(3, i.getTipo());
            st.setInt(4, i.getIdVisitante());
            st.setInt(5, i.getIdVendedor());
            st.setString(6, i.getHorarioEntrada());
            st.setString(7, i.getHorarioSaida());

            st.executeUpdate();

        } finally {
            if (st != null) st.close();
        }
    }
    
    public static void removerIngresso(int id, Connection con) throws SQLException {
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("DELETE FROM Ingressos WHERE id_ingresso = ?");
            st.setInt(1, id);
            st.executeUpdate();

        } finally {
            if (st != null) st.close();
        }
    }
    
    public static HashSet<Ingresso> listAll(Connection con) throws SQLException {
        Statement st = null;
        ResultSet result = null;
        HashSet<Ingresso> list = new HashSet<>();

        try {
            st = con.createStatement();
            String sql = "SELECT id_ingresso, id_visitante, id_atendente, dataVisita, preco, tipo, horarioEntrada, horarioSaida FROM Ingressos";
            result = st.executeQuery(sql);

            while (result.next()) {
                Ingresso i = new Ingresso(
                    result.getInt("id_visitante"),
                    result.getInt("id_atendente"),
                    result.getString("dataVisita"),
                    result.getInt("preco"),
                    result.getString("tipo")
                );
                
                i.setId(result.getInt("id_ingresso"));
                i.setHorarioEntrada(result.getString("horarioEntrada"));
                i.setHorarioSaida(result.getString("horarioSaida"));

                list.add(i);
            }

        } finally {
            if (result != null) result.close();
            if (st != null) st.close();
        }

        return list;
    }
    
    public static HashSet<Ingresso> listByVisitanteNome(String nomeVisitante, Connection con) throws SQLException {
    PreparedStatement st = null;
    ResultSet rs = null;
    HashSet<Ingresso> lista = new HashSet<>();

    try {
        String sql =
            "SELECT i.id_ingresso, i.dataVisita, i.preco, i.tipo, i.horarioEntrada, i.horarioSaida, i.id_atendente" +
            "       v.id_visitante, v.nome AS nome_vis, v.cpf AS cpf_vis, v.celular, v.email, v.cidade " +
            "FROM Ingressos i " +
            "JOIN Visitantes v ON i.id_visitante = v.id_visitante " +
            "WHERE v.nome = ?";

        st = con.prepareStatement(sql);
        st.setString(1, nomeVisitante);

        rs = st.executeQuery();

        while (rs.next()) {

            Ingresso ing = new Ingresso(
                rs.getInt("id_visitante"),
                rs.getInt("id_atendente"),
                rs.getString("dataVisita"),
                rs.getInt("preco"),
                rs.getString("tipo")
            );

            ing.setId(rs.getInt("id_ingresso"));
            ing.setHorarioEntrada(rs.getString("horarioEntrada"));
            ing.setHorarioSaida(rs.getString("horarioSaida"));

            Visitante comprador = new Visitante(
                rs.getString("nome_vis"),
                rs.getString("cpf_vis"),
                rs.getString("celular"),
                rs.getString("email"),
                rs.getString("cidade")
            );
            
            comprador.setId(rs.getInt("id_visitante"));
            ing.setComprador(comprador);

            lista.add(ing);
        }

    } finally {
        if (rs != null) rs.close();
        if (st != null) st.close();
    }

    return lista;
}



}
