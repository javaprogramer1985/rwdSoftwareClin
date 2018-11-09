/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.ejb;

import com.softwareatumedida.rwdsoftwareclin.entity.CPrioridad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author a
 */
@Local
public interface CPrioridadFacadeLocal {

    void create(CPrioridad cPrioridad);

    void edit(CPrioridad cPrioridad);

    void remove(CPrioridad cPrioridad);

    CPrioridad find(Object id);

    List<CPrioridad> findAll();

    List<CPrioridad> findRange(int[] range);

    int count();
    
}
