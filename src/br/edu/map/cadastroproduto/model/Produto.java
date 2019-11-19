/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.cadastroproduto.model;

/**
 *
 * @author Pichau
 */
public class Produto{
    
    private int codigo;
    private String nome;
    private float preco;
    private Especificacao Espc;
    
    
    public Produto(){
        
        Espc = new Especificacao();
    }

    
    public int getCodigo() {
        return codigo;
    }

    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Especificacao getEspc() {
        return Espc;
    }

    public void setEspc(Especificacao Espc) {
        this.Espc = Espc;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(codigo)
                .append(" - ")
                .append(nome)
                .append(" - ")
                .append(preco)
                .append(" - ")
                .append(Espc);

        return sb.toString();
    }
    
    
}
