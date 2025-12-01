/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author bela
 */
public class Animal {
    private int id;
    private String nome;
    private Especie especie;
    private int idEspecie;
    private Viveiro viveiro;
    private int idViveiro;
    private String sexo;
    private int idade;
    
    
    public Animal(String nome, int idade, String sexo, int idEspecie, int idViveiro){
        //this.id = id;
        this.nome = nome;
        this.idEspecie = idEspecie;
        this.idViveiro = idViveiro;
        this.sexo = sexo;
        this.idade = idade;
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
     * @return the especie
     */
    public Especie getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    /**
     * @return the idEspecie
     */
    public int getIdEspecie() {
        return idEspecie;
    }

    /**
     * @param idEspecie the idEspecie to set
     */
    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    /**
     * @return the viveiro
     */
    public Viveiro getViveiro() {
        return viveiro;
    }

    /**
     * @param viveiro the viveiro to set
     */
    public void setViveiro(Viveiro viveiro) {
        this.viveiro = viveiro;
    }

    /**
     * @return the idViveiro
     */
    public int getIdViveiro() {
        return idViveiro;
    }

    /**
     * @param idViveiro the idViveiro to set
     */
    public void setIdViveiro(int idViveiro) {
        this.idViveiro = idViveiro;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        
        sb.append("ID: ").append(getId())
          .append("\nNome: ").append(nome)
          .append("\nIdade: ").append(idade)
          .append("\nSexo: ").append(sexo)
          .append("\nID da Especie: ").append(idEspecie)
          .append("\nID do Viveiro: ").append(idViveiro);
        
        if(especie != null){
            sb.append(especie.toString());
        }
        
        if(viveiro != null){
            sb.append(viveiro.toString());
            
        }
        
        return sb.toString();
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
}
