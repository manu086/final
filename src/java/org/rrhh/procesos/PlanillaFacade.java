/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rrhh.procesos;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.rrhh.entidades.Empleado;
import org.rrhh.entidades.Planilla;


/**
 *
 * @author admin
 */
@Stateless
public class PlanillaFacade extends AbstractFacade<Planilla> {
    @EJB
    private EmpleadoFacade empleadoFacade;
    @PersistenceContext(unitName = "RecursosPU")
    private EntityManager em;
    private double planilla;
    List<Planilla> datosPlanilla=null;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanillaFacade() {
        super(Planilla.class);
    }
    
    public List<Empleado> getLstEmpPlanilla(){
        List<Empleado> lisEmpPlani=null;
        Query q = em.createNamedQuery("EmpleadoActivo2");
        lisEmpPlani = q.getResultList();
        
        return lisEmpPlani;
    }

    
    public List<Empleado> getListaEmpleado(){
        List<Empleado> listaEmpleado=null;
        Query q = em.createNamedQuery("EmpleadoActivo");
        listaEmpleado = q.getResultList();
        
        return listaEmpleado;
    }
    
     public List<Empleado> getListarTodos(){
        List<Empleado> listaEmpleado=null;
        Query q = em.createNamedQuery("Empleado.findAll");
        listaEmpleado = q.getResultList();
        
        return listaEmpleado;
    }
    
    public List<Empleado> getListaEmpleadoInactivos(){
        List<Empleado> listaEmpleadoInactivo=null;
        Query q = em.createNamedQuery("EmpleadoInactivo");
        listaEmpleadoInactivo = q.getResultList();
                
        return listaEmpleadoInactivo;
    } 
     
    public List<Planilla> getListaPlanilla(){
        List<Planilla> listaplanilla=null;
        Query q = em.createNamedQuery("Planilla.findAll");
        listaplanilla = q.getResultList();
        
        return listaplanilla;
    } 

    
    public List<Planilla> getDatosPlanilla(){        
        List<Empleado> datosEmpleados = getListaEmpleado();
        datosPlanilla=getListaPlanilla();        
        double calculoRenta;
        double calculoAfp;
        double calculoIsss;
        
        for(int i=0; i< datosEmpleados.size(); i++){
            calculoAfp = datosEmpleados.get(i).getSueldo() * 0.0625;
            calculoIsss = datosEmpleados.get(i).getSueldo() * 0.03;
            calculoRenta = (datosEmpleados.get(i).getSueldo()- (calculoIsss + calculoAfp)) * 0.10; 
            
            datosPlanilla.get(i).setEmpleadoIdempleado(datosEmpleados.get(i));
            datosPlanilla.get(i).setIsss(calculoIsss);
            datosPlanilla.get(i).setAfp(calculoAfp);
            datosPlanilla.get(i).setRenta(calculoRenta);
            datosPlanilla.get(i).setSueldo(datosEmpleados.get(i).getSueldo());
        }
        
        
        return datosPlanilla;
    }
    
    
    public double datoAfpPlanilla(){
        double salario = 800.00;
        double datoAfp = salario * 0.0625;
        
        return datoAfp;
    }
    
        public double datoIsssPlanilla(){
        double salario = 800.00;
        double datoIsss = salario * 0.03;
        
        return datoIsss;
    }

        public double datoRentaPlanilla(){
        double salario = 800.00 - datoIsssPlanilla() - datoAfpPlanilla();
        double datoRenta = salario * 0.20;
        
        return datoRenta;
    }

    
}
