/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rrhh.procesos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.rrhh.entidades.Tipopermiso;

/**
 *
 * @author admin
 */
@Stateless
public class TipopermisoFacade extends AbstractFacade<Tipopermiso> {
    @PersistenceContext(unitName = "RecursosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipopermisoFacade() {
        super(Tipopermiso.class);
    }
    
}
