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
public class Zelador extends Funcionario{
    
    public Zelador(String nome, String cpf, int salario, String cidade){
        super(nome, cpf, "zelador", salario, cidade);
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        
        sb.append("ID: ").append(id)
          .append("\nNome: ").append(nome)
          .append("\nCPF: ").append(getCpf())
          .append("\nCargo: ").append(cargo)
          .append("\nSalario: ").append(salario)
          .append("\nCidade: ").append(cidade);
        
        return sb.toString();
    }
}
