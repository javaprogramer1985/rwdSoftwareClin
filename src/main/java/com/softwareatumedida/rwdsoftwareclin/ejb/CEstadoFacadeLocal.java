/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.ejb;

import com.softwareatumedida.rwdsoftwareclin.entity.CEstado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author a
 */
@Local
public interface CEstadoFacadeLocal {

    void create(CEstado cEstado);

    void edit(CEstado cEstado);

    void remove(CEstado cEstado);

    CEstado find(Object id);

    List<CEstado> findAll();

    List<CEstado> findRange(int[] range);

    int count();
    
}
