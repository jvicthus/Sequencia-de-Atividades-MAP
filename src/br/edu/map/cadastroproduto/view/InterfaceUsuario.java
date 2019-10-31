/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.cadastroproduto.view;

import br.edu.map.cadastroproduto.dao.ProdutoDAO;
import br.edu.map.cadastroproduto.model.Especificacao;
import br.edu.map.cadastroproduto.model.Produto;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Pichau
 */
public class InterfaceUsuario {
    public static void main(String[] args) throws Exception{
        
        Scanner input = new Scanner(System.in);
        String op;
        ProdutoDAO dao = new ProdutoDAO();
        Produto p;
        
        System.out.println("----- CADASTRO DE PRODUTOS -----");

        do {
            
            System.out.println("---- MENU ----");
            System.out.println("1 - CADASTRAR");
            System.out.println("2 - EDITAR");
            System.out.println("3 - EXCLUIR");
            System.out.println("4 - CONSULTAR");
            System.out.println("0 - SAIR");

            op = input.nextLine();

            System.out.println("Opção selecionada: " + op);
            
            if(op.equals("1")){
                
                System.out.println("--- CADASTRAR PRODUTO ----");
                
                p = new Produto();
                
                System.out.println("Nome: ");
                p.setNome(input.nextLine());
                
                System.out.println("Preço: ");
                p.setPreco(Float.parseFloat(input.nextLine()));
                
                System.out.println("Fabricante: ");
                p.getEspc().setFabricante(input.nextLine());
                
                System.out.println("Cor: ");
                p.getEspc().setCor(input.nextLine());
                
                System.out.println("Sistema: ");
                p.getEspc().setSistema(input.nextLine());
                
                System.out.println("Detalhes: ");
                p.getEspc().setDetalhes(input.nextLine());
                
                
                dao.inserirProduto(p);
                
                System.out.println("Registro salvo com sucesso!");
            }
            
            else if(op.equals("2")){
                
                System.out.println("---- EDITAR PRODUTO ----");
                
                System.out.println("Informe o código: ");
                int codigo = Integer.parseInt(input.nextLine());
                
                p = dao.buscarProduto(codigo);
                
                if(p != null){
                    
                    System.out.println("Novo Nome: ");
                    p.setNome(input.nextLine());
                
                    System.out.println("Novo Preço: ");
                    p.setPreco(Float.parseFloat(input.nextLine()));
                
                    System.out.println("Novo Fabricante: ");
                    p.getEspc().setFabricante(input.nextLine());
                
                    System.out.println("Nova Cor: ");
                    p.getEspc().setCor(input.nextLine());
                
                    System.out.println("Novo Sistema: ");
                    p.getEspc().setSistema(input.nextLine());
                
                    System.out.println("Novos Detalhes: ");
                    p.getEspc().setDetalhes(input.nextLine());
                    
                    dao.editarProduto(p);
                    
                    System.out.println("Produto editado com sucesso!");
                }
                else{
                    
                    System.out.println("Produto não encontrado!");
                }
            }
            
            else if(op.equals("3")){
                
                System.out.println("---- EXCLUIR PRODUTO ----");
                
                System.out.println("Informe o código: ");
                int codigo = Integer.parseInt(input.nextLine());
                
                p = dao.buscarProduto(codigo);
                
                if(p != null){
                    dao.removerProduto(p);
                    System.out.println("Registro excluido com sucesso!");
                }
                else{
                    System.out.println("Registro não encontrado!");
                }
            }
            
            else if(op.equals("4")){
                
                System.out.println("---- CONSULTAR PRODUTO ----");
                
                List<Produto> produtos = dao.listarProdutos();
                for(Produto pl : produtos){
                    System.out.println(pl);
                }
            }
        } while (!op.equals("0"));

    }
        
}