/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.*;
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
public class SistemaZoologico {
    
    //VISUALIZACAO DE TABELAS
    
    public void listarTudo(Connection con) throws SQLException {
        listarAnimais(con);
        listarVisitantes(con);
        listarAtendentes(con);
        listarZeladores(con);
        listarEspecies(con);
        listarBiomas(con);
        listarViveiros(con);
        listarIngressos(con);
        listarManejos(con);
    }
    
    public void listarAnimais(Connection con) throws SQLException{
        System.out.println("\n=== ANIMAIS ===");
        for (Animal a : AnimalDAO.listAll(con)) {
            System.out.println(a);
            System.out.println("------------------------------");
        }
    }
    
    public void listarBiomas(Connection con) throws SQLException{
        System.out.println("\n=== BIOMAS ===");
        for (Bioma b : BiomaDAO.listAll(con)) {
            System.out.println(b);
            System.out.println("------------------------------");
        }
    }
    
    public void listarAtendentes(Connection con) throws SQLException{
        System.out.println("\n=== ATENDENTES ===");
        for (Atendente a : AtendenteDAO.listAll(con)) {
            System.out.println(a);
            System.out.println("------------------------------");
        }
    }
    
    public void listarVisitantes(Connection con) throws SQLException{
        System.out.println("\n=== VISITANTES ===");
        for (Visitante v : VisitanteDAO.listAll(con)) {
            System.out.println(v);
            System.out.println("------------------------------");
        }
    }
    
    public void listarZeladores(Connection con) throws SQLException{
        System.out.println("\n=== ZELADORES ===");
        for (Zelador z : ZeladorDAO.listAll(con)) {
            System.out.println(z);
            System.out.println("------------------------------");
        }
    }
    
    public void listarViveiros(Connection con) throws SQLException{
        System.out.println("\n=== VIVEIROS ===");
        for (Viveiro v : ViveiroDAO.listAll(con)) {
            System.out.println(v);
            System.out.println("------------------------------");
        }
    }
    
    public void listarEspecies(Connection con) throws SQLException{
        System.out.println("\n=== ESPECIES ===");
        for (Especie e : EspecieDAO.listAll(con)) {
            System.out.println(e);
            System.out.println("------------------------------");
        }
    }
    
    public void listarIngressos(Connection con) throws SQLException{
        System.out.println("\n=== INGRESSOS ===");
        for (Ingresso i : IngressoDAO.listAll(con)) {
            System.out.println(i);
            System.out.println("------------------------------");
        }
    }
    
    public void listarManejos(Connection con) throws SQLException{
        System.out.println("\n=== MANEJO ===");
        for (String m : ManejoDAO.listAll(con)) {
            System.out.println(m);
            System.out.println("------------------------------");
        }
    }
    
    public void listarAnimaisEmBioma(String nome, Connection con) throws SQLException{
        System.out.println("\n=== ANIMAIS EM VIVEIROS COM BIOMA: " + nome + " ===");
        for(Animal a : AnimalDAO.listByBioma(nome, con)){
            System.out.println(a);
            System.out.println("------------------------------");
        }
    }
    
    public void listarAnimaisDeEspecie(String nome, Connection con) throws SQLException{
        System.out.println("\n=== ANIMAIS DA ESPECIE: " + nome + " ===");
        for(Animal a : AnimalDAO.listByEspecie(nome, con)){
            System.out.println(a);
            System.out.println("------------------------------");
        }
    }
    
    public void listarZeladoresPorCidade(String nomeCidade, Connection con) throws SQLException{
        System.out.println("\n=== ZELADORES DA CIDADE: " + nomeCidade + " ===");
        for(Zelador z : ZeladorDAO.listAllWithCidade(nomeCidade, con)){
            System.out.println(z);
            System.out.println("------------------------------");
        }
    }
    
    public void listarIngressosCompradosPorVisitante(String nomeVisitante, Connection con) throws SQLException{
        
        System.out.println("\n=== INGRESSOS COMPRADOS PELO VISITANTE: "+ nomeVisitante + " ===");
        for(Ingresso i : IngressoDAO.listByVisitanteNome(nomeVisitante, con)){
            System.out.println(i);
            System.out.println("------------------------------");
        }
    }
    
    //CADASTROS
    
    public void cadastrarIngresso(int idVisitante, int idVendedor, String dataVisita, int preco, String tipo, Connection con) throws SQLException{
        Ingresso i = new Ingresso(idVisitante, idVendedor, dataVisita, preco, tipo);
        
        IngressoDAO.criarIngresso(i, con);
    }
    
    public void cadastrarAtendente(String nome, String cpf, int salario, String cidade, Connection con) throws SQLException{
        Atendente a = new Atendente(nome, cpf, salario, cidade);
        
        AtendenteDAO.criarAtendente(a, con);
    }
    
    public void cadastrarZelador(String nome, String cpf, int salario, String cidade, Connection con) throws SQLException{
        Zelador z = new Zelador(nome, cpf, salario, cidade);
        
        ZeladorDAO.criarZelador(z, con);
    }
    
    public void cadastrarAnimal(String nome, int idade, String sexo, int idEspecie, int idViveiro, Connection con) throws SQLException{
        Animal a = new Animal(nome, idade, sexo, idEspecie, idViveiro);
        
        AnimalDAO.criarAnimal(a, con);
    }
    
    public void cadastrarEspecie(String nome, String dieta, Connection con) throws SQLException{
        Especie e = new Especie(nome, dieta);
        
        EspecieDAO.criarEspecie(e, con);
    }
    
    public void cadastrarViveiro(int capacidade, int area, int idBioma, int idZelador, Connection con) throws SQLException{
        Viveiro v = new Viveiro(capacidade, area, idBioma);
        
        ViveiroDAO.criarViveiro(v, con);
        
        int idViveiroCadastrado = ViveiroDAO.getUltimoId(con);
        
        ManejoDAO.criarManejo(idZelador, idViveiroCadastrado, con);
        
    }
    
    public void cadastrarBioma(String nome, String temperatura, Connection con) throws SQLException{
        Bioma b = new Bioma(nome, temperatura);
        
        BiomaDAO.criarBioma(b, con);
    }
    
    public void cadastrarVisitante(String nome, String cpf, String celular, String email, String cidade, Connection con) throws SQLException{
        Visitante v = new Visitante(nome, cpf, celular, email, cidade);
        
        VisitanteDAO.criarVisitante(v, con);
    }
    
    public void removerCadastroBioma(int id, Connection con) throws SQLException{
        BiomaDAO.removerBioma(id, con);
    }
    
    public void removerCadastroIngresso(int id, Connection con) throws SQLException{
        IngressoDAO.removerIngresso(id, con);
    }
    
    public void removerCadastroEspecie(int id, Connection con) throws SQLException{
        EspecieDAO.removerEspecie(id, con);
    }
    
    public void removerCadastroAnimal(int id, Connection con) throws SQLException{
        AnimalDAO.removerAnimal(id, con);
    }
    
    public void removerCadastroViveiro(int id, Connection con) throws SQLException{
        ViveiroDAO.removerViveiro(id, con);
    }
    
    public void removerCadastroAtendente(int id, Connection con) throws SQLException{
        AtendenteDAO.removerAtendente(id, con);
    }
    
    public void removerCadastroZelador(int id, Connection con) throws SQLException{
        ZeladorDAO.removerZelador(id, con);
    }
    
    public void removerCadastroVisitante(int id, Connection con) throws SQLException{
        VisitanteDAO.removerVisitante(id, con);
    }
}
