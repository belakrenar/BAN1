/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Apresentacao;

import Modelo.*;
import Controle.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author bela
 */
public class Principal {
    static Conexao c = new Conexao();
    static Connection con = c.getConnection();
    static Scanner sc = new Scanner(System.in);
    static SistemaZoologico sistema = new SistemaZoologico();

    public void menuCadastro(Connection con) throws SQLException {
        int opcao;

        System.out.println("\n=== MENU DE CADASTROS ===");
        System.out.println("1 - Cadastrar tupla");
        System.out.println("2 - Remover tupla");
        System.out.println("0 - Voltar");
        System.out.print("\nEscolha uma opção: ");

        opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1 -> menuCadastroTupla(con);
            case 2 -> menuRemocaoTupla(con);
            case 0 -> { return; }
            default -> System.out.println("Opcao invalida.");
        }
    }

    public void menuCadastroTupla(Connection con) throws SQLException {
        int opcao;

        System.out.println("\n=== CADASTRAR TUPLA ===");
        System.out.println("1 - Cadastrar Visitante");
        System.out.println("2 - Cadastrar Atendente");
        System.out.println("3 - Cadastrar Zelador");
        System.out.println("4 - Cadastrar Bioma");
        System.out.println("5 - Cadastrar Espécie");
        System.out.println("6 - Cadastrar Viveiro");
        System.out.println("7 - Cadastrar Animal");
        System.out.println("8 - Cadastrar Ingresso");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {

            case 1 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Celular: ");
                String cel = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Cidade: ");
                String cidade = sc.nextLine();
                sistema.cadastrarVisitante(nome, cpf, cel, email, cidade, con);
            }

            case 2 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Salário: ");
                int salario = sc.nextInt();
                sc.nextLine();
                System.out.print("Cidade: ");
                String cidade = sc.nextLine();
                sistema.cadastrarAtendente(nome, cpf, salario, cidade, con);
            }

            case 3 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Salário: ");
                int salario = sc.nextInt();
                sc.nextLine();
                System.out.print("Cidade: ");
                String cidade = sc.nextLine();
                sistema.cadastrarZelador(nome, cpf, salario, cidade, con);
            }

            case 4 -> {
                System.out.print("Nome do bioma: ");
                String nome = sc.nextLine();
                System.out.print("Temperatura: ");
                String temp = sc.nextLine();
                sistema.cadastrarBioma(nome, temp, con);
            }

            case 5 -> {
                System.out.print("Nome da espécie: ");
                String nome = sc.nextLine();
                System.out.print("Dieta: ");
                String dieta = sc.nextLine();
                sistema.cadastrarEspecie(nome, dieta, con);
            }

            case 6 -> {
                System.out.print("Capacidade: ");
                int capacidade = sc.nextInt();
                System.out.print("Área: ");
                int area = sc.nextInt();
                System.out.println("\nBiomas cadastrados:");
                sistema.listarBiomas(con);
                System.out.print("ID do Bioma: ");
                int idBioma = sc.nextInt();
                System.out.println("\nZeladores cadastrados:");
                sistema.listarZeladores(con);
                System.out.print("ID do Zelador responsável: ");
                int idZelador = sc.nextInt();
                sistema.cadastrarViveiro(capacidade, area, idBioma, idZelador, con);
            }

            case 7 -> {
                System.out.print("Nome do animal: ");
                String nome = sc.nextLine();
                System.out.print("Idade: ");
                int idade = sc.nextInt();
                sc.nextLine();
                System.out.print("Sexo (M/F): ");
                String sexo = sc.nextLine();
                sistema.listarEspecies(con);
                System.out.print("ID da espécie: ");
                int idEsp = sc.nextInt();
                sistema.listarViveiros(con);
                System.out.print("ID do viveiro: ");
                int idViv = sc.nextInt();
                sistema.cadastrarAnimal(nome, idade, sexo, idEsp, idViv, con);
            }

            case 8 -> {
                sistema.listarVisitantes(con);
                System.out.print("ID Visitante: ");
                int idVis = sc.nextInt();
                sistema.listarAtendentes(con);
                System.out.print("ID Atendente: ");
                int idAten = sc.nextInt();
                sc.nextLine();
                System.out.print("Data da visita: ");
                String data = sc.nextLine();
                System.out.print("Preço: ");
                int preco = sc.nextInt();
                sc.nextLine();
                System.out.print("Tipo (inteira/meia): ");
                String tipo = sc.nextLine();
                sistema.cadastrarIngresso(idVis, idAten, data, preco, tipo, con);
            }

            case 0 -> { return; }

            default -> System.out.println("Opcao invalida.");
        }
    }

    public void menuRemocaoTupla(Connection con) throws SQLException {
        int opcao;

        System.out.println("\n=== REMOVER TUPLA ===");
        System.out.println("1 - Remover Visitante");
        System.out.println("2 - Remover Atendente");
        System.out.println("3 - Remover Zelador");
        System.out.println("4 - Remover Bioma");
        System.out.println("5 - Remover Espécie");
        System.out.println("6 - Remover Viveiro");
        System.out.println("7 - Remover Animal");
        System.out.println("8 - Remover Ingresso");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        opcao = sc.nextInt();
        sc.nextLine();

        int id;

        switch (opcao) {

            case 1 -> {
                sistema.listarVisitantes(con);
                System.out.print("ID do visitante: ");
                id = sc.nextInt();
                sistema.removerCadastroVisitante(id, con);
            }

            case 2 -> {
                sistema.listarAtendentes(con);
                System.out.print("ID do atendente: ");
                id = sc.nextInt();
                sistema.removerCadastroAtendente(id, con);
            }

            case 3 -> {
                sistema.listarZeladores(con);
                System.out.print("ID do zelador: ");
                id = sc.nextInt();
                sistema.removerCadastroZelador(id, con);
            }

            case 4 -> {
                sistema.listarBiomas(con);
                System.out.print("ID do bioma: ");
                id = sc.nextInt();
                sistema.removerCadastroBioma(id, con);
            }

            case 5 -> {
                sistema.listarEspecies(con);
                System.out.print("ID da espécie: ");
                id = sc.nextInt();
                sistema.removerCadastroEspecie(id, con);
            }

            case 6 -> {
                sistema.listarViveiros(con);
                System.out.print("ID do viveiro: ");
                id = sc.nextInt();
                sistema.removerCadastroViveiro(id, con);
            }

            case 7 -> {
                sistema.listarAnimais(con);
                System.out.print("ID do animal: ");
                id = sc.nextInt();
                sistema.removerCadastroAnimal(id, con);
            }

            case 8 -> {
                sistema.listarIngressos(con);
                System.out.print("ID do ingresso: ");
                id = sc.nextInt();
                sistema.removerCadastroIngresso(id, con);
            }

            case 0 -> { return; }

            default -> System.out.println("Opcao invalida.");
        }
    }

    public void menuConsultas() throws SQLException {
        System.out.println("\n=== MENU DE CONSULTA DE TABELAS ===");
        System.out.println("1 - Mostrar todas as tabelas");
        System.out.println("2 - Listar animais em bioma");
        System.out.println("3 - Listar animais por espécie");
        System.out.println("4 - Listar zeladores por cidade");
        System.out.println("5 - Listar ingressos de um visitante");
        System.out.print("\nEscolha: ");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {

            case 1 -> sistema.listarTudo(con);

            case 2 -> {
                sistema.listarBiomas(con);
                System.out.print("Nome do bioma: ");
                String nomeBioma = sc.nextLine();
                sistema.listarAnimaisEmBioma(nomeBioma, con);
            }

            case 3 -> {
                sistema.listarEspecies(con);
                System.out.print("Nome da espécie: ");
                String nomeEspecie = sc.nextLine();
                sistema.listarAnimaisDeEspecie(nomeEspecie, con);
            }

            case 4 -> {
                System.out.print("Cidade: ");
                String cid = sc.nextLine();
                sistema.listarZeladoresPorCidade(cid, con);
            }

            case 5 -> {
                sistema.listarVisitantes(con);
                System.out.print("Nome do visitante: ");
                String nome = sc.nextLine();
                sistema.listarIngressosCompradosPorVisitante(nome, con);
            }
        }
    }
    
    public void menuPrincipal(Connection con) throws SQLException {
        int opcao;

        while (true) {
            System.out.println("\n=== SISTEMA DO ZOOLÓGICO ===");
            System.out.println("1 - Menu de Cadastros");
            System.out.println("2 - Menu de Remocoes");
            System.out.println("3 - Menu de Consultas");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    menuCadastroTupla(con);
                    break;

                case 2:
                    menuRemocaoTupla(con);
                    break;

                case 3:
                    menuConsultas();
                    break;

                case 0:
                    System.out.println("\nEncerrando o sistema...");
                    return;

                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }


    public static void main(String[] args) throws SQLException {
        Principal p = new Principal();
        p.menuPrincipal(con);
        
    }
    
    
}
