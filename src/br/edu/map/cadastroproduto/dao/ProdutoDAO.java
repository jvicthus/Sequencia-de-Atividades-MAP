/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.cadastroproduto.dao;

import br.edu.map.cadastroproduto.util.ConnectionFactory;
import br.edu.map.cadastroproduto.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pichau
 */
public class ProdutoDAO {
    
    private Connection con;
    private String sql;
    private PreparedStatement st;
    private ResultSet rs;
    
    public void inserirProduto(Produto produto) throws Exception{
        
        con = ConnectionFactory.getConnection();
        
        sql = "insert into especificacao (fabricante, cor, sistema, detalhes) values (?, ?, ?, ?)";
        
        st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        st.setString(1, produto.getEspc().getFabricante());
        st.setString(2, produto.getEspc().getCor());
        st.setString(3, produto.getEspc().getSistema());
        st.setString(4, produto.getEspc().getDetalhes());
        
        st.executeUpdate();
        
        rs = st.getGeneratedKeys();
        
        int codigoEspec = 0;
        
        if(rs.next()){
            
            codigoEspec = rs.getInt(1);
        }
        
        sql = "insert into produtos (nome, preco, cod_especificacao) values (?, ?, ?)";
        
        st = con.prepareStatement(sql);
        
        st.setString(1, produto.getNome());
        st.setFloat(2, produto.getPreco());
        st.setInt(3, codigoEspec);
        
        st.executeUpdate();
        
        con.close();
    }
    
    public void editarProduto(Produto produto) throws SQLException{
        
        con = ConnectionFactory.getConnection();
        
        sql = "update produtos set nome = ?, preco = ? where codigo = ?; update especificacao set fabricante = ?, cor = ?, sistema = ?, detalhes = ? where codigo = ?;";
        
        st = con.prepareStatement(sql);
        
        st.setString(1, produto.getNome());
        st.setFloat(2, produto.getPreco());
        st.setInt(3, produto.getCodigo());
        st.setString(4, produto.getEspc().getFabricante());
        st.setString(5, produto.getEspc().getCor());
        st.setString(6, produto.getEspc().getSistema());
        st.setString(7, produto.getEspc().getDetalhes());
        st.setInt(8, produto.getCodigo());
        
        st.executeUpdate();
        
        con.close();
    }
    
    public void removerProduto(Produto produto) throws SQLException{
        
        con = ConnectionFactory.getConnection();
        
        sql = "delete from produtos where codigo = ?; delete from especificacao where codigo = ?;";
        
        st = con.prepareStatement(sql);
        
        st.setInt(1, produto.getCodigo());
        st.setInt(2, produto.getCodigo());
        
        st.executeUpdate();
        
        con.close();
    }
    
    public List<Produto> listarProdutos() throws Exception{
        
        List<Produto> produtos = new ArrayList<>();
        
        con = ConnectionFactory.getConnection();
        
        sql = "select p.*, e.* from produtos p, especificacao e where p.cod_especificacao = e.codigo";
        
        st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){
            
            int codigo = rs.getInt(1);
            String nome = rs.getString("nome");
            float preco = rs.getFloat("preco");
            int codigoEspc = rs.getInt("cod_especificacao");
            String fabricante = rs.getString("fabricante");
            String cor = rs.getString("cor");
            String sistema = rs.getString("sistema");
            String detalhes = rs.getString("detalhes");
            
            Produto p = new Produto();
            
            p.setCodigo(codigo);
            p.setNome(nome);
            p.setPreco(preco);
            p.getEspc().setCodigo(codigoEspc);
            p.getEspc().setFabricante(fabricante);
            p.getEspc().setCor(cor);
            p.getEspc().setSistema(sistema);
            p.getEspc().setDetalhes(detalhes);
            
            produtos.add(p);
        }
        con.close();
        return produtos;
    }
    
    public List<Produto> listarProdutosMilMais() throws Exception{
        
        List<Produto> produtos = new ArrayList<>();
        
        con = ConnectionFactory.getConnection();
        
        sql = "select p.*, e.* from produtos p, especificacao e where p.cod_especificacao = e.codigo and p.preco >= 1000";
        
        st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){
            
            int codigo = rs.getInt(1);
            String nome = rs.getString("nome");
            float preco = rs.getFloat("preco");
            int codigoEspc = rs.getInt("cod_especificacao");
            String fabricante = rs.getString("fabricante");
            String cor = rs.getString("cor");
            String sistema = rs.getString("sistema");
            String detalhes = rs.getString("detalhes");
            
            Produto p = new Produto();
            
            p.setCodigo(codigo);
            p.setNome(nome);
            p.setPreco(preco);
            p.getEspc().setCodigo(codigoEspc);
            p.getEspc().setFabricante(fabricante);
            p.getEspc().setCor(cor);
            p.getEspc().setSistema(sistema);
            p.getEspc().setDetalhes(detalhes);
            
            produtos.add(p);
        }
        con.close();
        return produtos;
    }
    
    public List<Produto> listarProdutosCorPreta() throws Exception{
        
        List<Produto> produtos = new ArrayList<>();
        
        con = ConnectionFactory.getConnection();
        
        sql = "select p.*, e.* from produtos p, especificacao e where p.cod_especificacao = e.codigo and e.cor ilike 'Preto'";
        
        st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){
            
            int codigo = rs.getInt(1);
            String nome = rs.getString("nome");
            float preco = rs.getFloat("preco");
            int codigoEspc = rs.getInt("cod_especificacao");
            String fabricante = rs.getString("fabricante");
            String cor = rs.getString("cor");
            String sistema = rs.getString("sistema");
            String detalhes = rs.getString("detalhes");
            
            Produto p = new Produto();
            
            p.setCodigo(codigo);
            p.setNome(nome);
            p.setPreco(preco);
            p.getEspc().setCodigo(codigoEspc);
            p.getEspc().setFabricante(fabricante);
            p.getEspc().setCor(cor);
            p.getEspc().setSistema(sistema);
            p.getEspc().setDetalhes(detalhes);
            
            produtos.add(p);
        }
        con.close();
        return produtos;
    }
    
    public Produto buscarProduto(int codigo) throws Exception{
        
        Produto p = null;
        
        con = ConnectionFactory.getConnection();
        
        sql = "select p.*, e.* from produtos p, especificacao e where p.codigo = ? and p.cod_especificacao = e.codigo";
        
        st = con.prepareStatement(sql);
        st.setInt(1, codigo);
        ResultSet rs = st.executeQuery();
        
        if(rs.next()){
            
            String nome = rs.getString("nome");
            float preco = rs.getFloat("preco");
            int codigoEspc = rs.getInt("cod_especificacao");
            String fabricante = rs.getString("fabricante");
            String cor = rs.getString("cor");
            String sistema = rs.getString("sistema");
            String detalhes = rs.getString("detalhes");
            
            p = new Produto();
            
            p.setCodigo(codigo);
            p.setNome(nome);
            p.setPreco(preco);
            p.getEspc().setCodigo(codigoEspc);
            p.getEspc().setFabricante(fabricante);
            p.getEspc().setCor(cor);
            p.getEspc().setSistema(sistema);
            p.getEspc().setDetalhes(detalhes);
        }
        con.close();
        return p;
    }
    
    public List<Produto> buscarProduto(String query) throws Exception{
        List<Produto> produtos = new ArrayList<>();
        con = ConnectionFactory.getConnection();
        sql = "select p.*, e.* from produtos p, especificacao e where p.cod_especificacao = e.codigo and p.nome ilike ?";
        st = con.prepareStatement(sql);
        st.setString(1, query + '%');
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            int codigo = rs.getInt(1);
            String nome = rs.getString("nome");
            float preco = rs.getFloat("preco");
            String fabricante = rs.getString("fabricante");
            String cor = rs.getString("cor");
            String sistema = rs.getString("sistema");
            String detalhes = rs.getString("detalhes");
            int codigoEspc = rs.getInt("cod_especificacao");
            
            Produto p = new Produto();
            
            p.setCodigo(codigo);
            p.setNome(nome);
            p.setPreco(preco);
            p.getEspc().setCodigo(codigoEspc);
            p.getEspc().setFabricante(fabricante);
            p.getEspc().setCor(cor);
            p.getEspc().setSistema(sistema);
            p.getEspc().setDetalhes(detalhes);
            
            produtos.add(p);
        }
        con.close();
        return produtos;
    }
    
}
