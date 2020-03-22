/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Pedido;
import Facades.PedidoFacade;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



@Named (value = "reporteControlador")
@SessionScoped
public class reporteControlador implements Serializable{
    
    @EJB
    PedidoFacade pedidoFacade;
    
    
    private List<Pedido> listaPedidos = new ArrayList<>();
    JasperPrint jasperPrint;

    public reporteControlador() {

    }
    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
    public List<Pedido> listarPedidos(){
        listaPedidos = pedidoFacade.findAll();
        return listaPedidos;
    }
    
    public void generarPDF(ActionEvent actionEvent) throws JRException, IOException {
        //Generar un Hash Map para generar los parametros del reporte
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("txtUsuario", "CandyGlobal S.A.S");
        parametros.put("txtContacto", "SurtiExpress2020@gmail.com");
        
        //Lista para cargar los fields de reportes
        listarPedidos();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaPedidos, false);
        
        //Obtener la ruta del Jasper
        String ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//reportes//");
        
           
        //Generar el reporte
        jasperPrint = JasperFillManager.fillReport(ruta + "//ReportePedido.jasper", parametros , beanCollectionDataSource);
        
        //Codigo para que el navegador, pueda leer el reporte y lo descargue
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content=disposition", "attachment; filename=reporteDiarioPedidos.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
       
        
        
    }
    


   
}
