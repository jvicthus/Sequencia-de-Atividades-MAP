/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.cadastroproduto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pichau
 */
public class ConnectionFactory {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/MAP - Cadastro Produto";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "admin";
    
    public static Connection getConnection(){
        
        try{
            
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }catch(Exception e){
            
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    
    /* TESTE DE CONEXAO */
    public static void main(String[] args) throws SQLException {
        
        if(ConnectionFactory.getConnection() != null){
            
            System.out.println("ok!");
        }else{
            
            System.out.println("deu pau!");
        }
    }
}
