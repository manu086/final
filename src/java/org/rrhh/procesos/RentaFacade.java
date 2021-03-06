/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rrhh.procesos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.rrhh.entidades.Renta;

/**
 *
 * @author admin
 */
@Stateless
public class RentaFacade extends AbstractFacade<Renta> {
    @PersistenceContext(unitName = "RecursosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RentaFacade() {
        super(Renta.class);
    }
    
}
