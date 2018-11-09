/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.ejb;

import com.softwareatumedida.rwdsoftwareclin.entity.CEstadopaciente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author a
 */
@Stateless
public class CEstadopacienteFacade extends AbstractFacade<CEstadopaciente> implements CEstadopacienteFacadeLocal {

    @PersistenceContext(unitName = "ClinicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CEstadopacienteFacade() {
        super(CEstadopaciente.class);
    }
    
}
