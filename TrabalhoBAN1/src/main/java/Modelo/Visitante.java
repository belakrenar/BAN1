/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bela
 */
public class Visitante {
    private int id;
    private String nome;
    private String cpf;
    private String celular;
    private String email;
    private String cidade;
    
    public Visitante(String nome, String cpf, String celular, String email, String cidade){
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
        this.cidade = cidade;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        
        sb.append("ID: ").append(id)
          .append("\nNome: ").append(nome)
          .append("\nCPF: ").append(cpf)
          .append("\nCelular: ").append(celular)
          .append("\nEmail: ").append(email)
          .append("\nCidade: ").append(cidade);
        
        return sb.toString();
    }
    
}
