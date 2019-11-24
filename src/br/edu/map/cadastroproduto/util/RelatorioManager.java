/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.cadastroproduto.util;

import br.edu.map.cadastroproduto.model.Produto;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Pichau
 */
public class RelatorioManager {
    
    public static String path = 
            RelatorioManager.class.getClassLoader().getResource("").getPath() + "/jasper";
    
    public static JasperPrint gerarRelatorioClientes(List<Produto> produtos) throws JRException{
        JasperReport report = JasperCompileManager.compileReport(path + "/clientes.jrxml");

        return JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(produtos));
    }
}
