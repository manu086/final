/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rrhh.controladores;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import org.rrhh.procesos.PlanillaFacade;

/**
 *
 * @author admin
 */
@Named(value = "reporte1Controller")
@SessionScoped
public class Reporte1Controller implements Serializable {
    @EJB
    private PlanillaFacade planillaFacade;

    /**
     * Creates a new instance of Reporte1Controller
     */
    public Reporte1Controller() {
    }
    
    
    
public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException {
    Map<String, Object> parametros = new HashMap<String, Object>();
    File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("C:\\Users\\Manuel\\Documents\\NetBeansProjects\\itca\\Reportes\\src\\reportes\\Cargos.jasper"));
    /////JRBeanArrayDataSource ds = (JRBeanArrayDataSource) em.listarTodos();
        JRBeanArrayDataSource ds;
    ds = new JRBeanArrayDataSource(planillaFacade.getListarTodos().toArray());
    byte[] bytesReportes = JasperRunManager
    .runReportToPdf(jasper.getPath(), parametros, ds);
    HttpServletResponse response = (HttpServletResponse) FacesContext
    .getCurrentInstance().getExternalContext().getResponse();
    response.addHeader("Content-disposition", "filename=jsfReporte.pdf"); //SI
    ServletOutputStream stream = response.getOutputStream();
    stream.write(bytesReportes, 0, bytesReportes.length);
    stream.flush();
    stream.close();
    FacesContext.getCurrentInstance().responseComplete();
    }

}
