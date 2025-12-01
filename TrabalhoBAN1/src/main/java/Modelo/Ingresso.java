/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author bela
 */
public class Ingresso{
    private int id;
    private Visitante comprador; //visitante que comprou o ingresso
    private int idVisitante;
    private Atendente vendedor; //atendente que vendeu o ingresso
    private int idVendedor;
    private String dataVisita;
    private int preco;
    private String tipo; //inteira ou meia
    private String horarioEntrada; //opcional (nem sempre as pessoas usam os ingressos
    private String horarioSaida; //opcional
    
    public Ingresso(int idVisitante, int idVendedor, String dataVisita, int preco, String tipo){
        this.idVisitante = idVisitante;
        this.idVendedor = idVendedor;
        this.dataVisita = dataVisita;
        this.preco = preco;
        this.tipo = tipo;
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
     * @return the comprador
     */
    public Visitante getComprador() {
        return comprador;
    }

    /**
     * @param comprador the comprador to set
     */
    public void setComprador(Visitante comprador) {
        this.comprador = comprador;
    }

    /**
     * @return the idVisitante
     */
    public int getIdVisitante() {
        return idVisitante;
    }

    /**
     * @param idVisitante the idVisitante to set
     */
    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
    }

    /**
     * @return the vendedor
     */
    public Atendente getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(Atendente vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the idVendedor
     */
    public int getIdVendedor() {
        return idVendedor;
    }

    /**
     * @param idVendedor the idVendedor to set
     */
    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    /**
     * @return the dataVisita
     */
    public String getDataVisita() {
        return dataVisita;
    }

    /**
     * @param dataVisita the dataVisita to set
     */
    public void setDataVisita(String dataVisita) {
        this.dataVisita = dataVisita;
    }

    /**
     * @return the preco
     */
    public int getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(int preco) {
        this.preco = preco;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the horarioEntrada
     */
    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    /**
     * @param horarioEntrada the horarioEntrada to set
     */
    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    /**
     * @return the horarioSaida
     */
    public String getHorarioSaida() {
        return horarioSaida;
    }

    /**
     * @param horarioSaida the horarioSaida to set
     */
    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        
        sb.append("ID: ").append(id)
          .append("\nPreco: ").append(preco)
          .append("\nTipo de Ingresso: ").append(tipo)
          .append("\nData da Visita: ").append(dataVisita)
          .append("\nHorario de Entrada: ").append(horarioEntrada)
          .append("\nHorario de Saida: ").append(horarioSaida)
          .append("\nID do Visitante: ").append(idVisitante)
          .append("\nID do Vendedor: ").append(idVendedor);
        
        if(comprador != null)
            sb.append(comprador.toString());
                
        if(vendedor != null){
            sb.append(vendedor.toString());
        }

        return sb.toString();
    }  
}
