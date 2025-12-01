/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author bela
 */
public class Especie {
    private int id;
    private String nome;
    private String dieta;
    
    public Especie(String nome, String dieta){
        this.nome = nome;
        this.dieta = dieta;
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
     * @return the dieta
     */
    public String getDieta() {
        return dieta;
    }

    /**
     * @param dieta the dieta to set
     */
    public void setDieta(String dieta) {
        this.dieta = dieta;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        
        sb.append("ID: ").append(id)
          .append("\nNome: ").append(nome)
          .append("\nDieta: ").append(dieta);
        
        return sb.toString();
    }
}
