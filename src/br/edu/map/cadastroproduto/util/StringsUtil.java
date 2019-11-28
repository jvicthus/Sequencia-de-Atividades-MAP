/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.cadastroproduto.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Pichau
 */
public class StringsUtil {
    
    public static final Locale LOCALE_PT_BR = new Locale("pt", "BR");
    public static final Locale LOCALE_EN_US = new Locale("en", "US");
    public static final Locale LOCALE_ES_ES = new Locale("es", "ES");
    
    private static ResourceBundle bundle = ResourceBundle.getBundle("mensagens", LOCALE_PT_BR);
    
    public static final String TITULO_PRODUTO = "titulo.produtos";
    public static final String COLUNA_CODIGO = "coluna.codigo";
    public static final String COLUNA_NOME = "coluna.nome";
    public static final String COLUNA_PRECO = "coluna.preco";
    public static final String COLUNA_FABRICANTE = "coluna.fabricante";
    public static final String COLUNA_SISTEMA = "coluna.sistema";
    public static final String COLUNA_COR = "coluna.cor";
    public static final String COLUNA_DETALHES = "coluna.detalhes";
    public static final String BOTAO_NOVO = "botao.novo";
    public static final String BOTAO_EDITAR = "botao.editar";
    public static final String BOTAO_EXCLUIR = "botao.excluir";
    public static final String BOTAO_SAIR = "botao.sair";
    public static final String MENU_IDIOMA = "menu.linguagem";
    public static final String MENU_RELATORIO = "menu.relatorio";
    public static final String MENUITEM_RELATORIOGERAL = "menuitem.relatoriogeral";
    public static final String MENUITEM_RELATORIOPRECOMIL = "menuitem.relatorioprecomil";
    public static final String MENUITEM_RELATORIOCORPRETA = "menuitem.relatoriocorpreta";
    public static final String AVISO_SELECPRODUTO = "aviso.selecproduto";
    public static final String AVISO_EXCLUIR = "aviso.excluir";
    public static final String TITULO_NOVOPRODUTO = "titulo.novoproduto";
    public static final String LABEL_NOME = "label.nome";
    public static final String LABEL_PRECO = "label.preco";
    public static final String LABEL_COR = "label.cor";
    public static final String LABEL_SISTEMA = "label.sistema";
    public static final String LABEL_FABRICANTE = "label.fabricante";
    public static final String LABEL_DETALHES = "label.detalhes";
    public static final String BOTAO_SALVAR = "botao.salvar";
    public static final String BOTAO_CANCELAR = "botao.cancelar";
    public static final String AVISO_PREENCHER = "aviso.preencher";
    public static final String TITULO_EDITARPRODUTO = "titulo.editarproduto";
    public static final String ERRO_ERROSALVAR = "erro.salvar";
    
    public static String getString(String key){

        return bundle.getString(key);
    }

    public static void setLocale(Locale locale){

        bundle = ResourceBundle.getBundle("mensagens", locale);
    }
}
