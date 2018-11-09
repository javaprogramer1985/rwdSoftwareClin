/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.ejb;

import com.softwareatumedida.rwdsoftwareclin.entity.CPrioridad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author a
 */
@Stateless
public class CPrioridadFacade extends AbstractFacade<CPrioridad> implements CPrioridadFacadeLocal {

    @PersistenceContext(unitName = "ClinicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CPrioridadFacade() {
        super(CPrioridad.class);
    }
    
}
