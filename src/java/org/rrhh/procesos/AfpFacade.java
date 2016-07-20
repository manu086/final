/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rrhh.procesos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.rrhh.entidades.Afp;

/**
 *
 * @author admin
 */
@Stateless
public class AfpFacade extends AbstractFacade<Afp> {
    @PersistenceContext(unitName = "RecursosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AfpFacade() {
        super(Afp.class);
    }
    
      public List<Afp> getlistaAFP(){
      List<Afp> listaAFP = null;
      //Query q = em.createNamedQuery("Afp.findAll");
      Query q = em.createNamedQuery("Afp.findAll");
      listaAFP = q.getResultList();
      return listaAFP;
    }
}
