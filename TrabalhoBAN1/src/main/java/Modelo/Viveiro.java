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
public class Viveiro {
    private int id;
    private int capacidade;
    private int area;
    private int idBioma;
    private Bioma bioma;
        
    public Viveiro(int capacidade, int area, int idBioma){
        this.capacidade = capacidade;
        this.area = area;
        this.idBioma = idBioma;
    }
    
    

    /**
     * @return the capacidade
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * @return the area
     */
    public int getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(int area) {
        this.area = area;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        
        sb.append("ID: ").append(getId())
          .append("\nCapacidade: ").append(capacidade)
          .append("\nArea: ").append(area)
          .append("\nID do Bioma: ").append(getIdBioma());
        
        if(bioma != null){
            sb.append(bioma.toString());
        }
        
        return sb.toString();
    }



    /**
     * @return the idBioma
     */
    public int getIdBioma() {
        return idBioma;
    }

    /**
     * @param idBioma the idBioma to set
     */
    public void setIdBioma(int idBioma) {
        this.idBioma = idBioma;
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
     * @return the bioma
     */
    public Bioma getBioma() {
        return bioma;
    }

    /**
     * @param bioma the bioma to set
     */
    public void setBioma(Bioma bioma) {
        this.bioma = bioma;
    }
        
}
