/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.ejb;

import com.softwareatumedida.rwdsoftwareclin.entity.CEspecialidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author a
 */
@Local
public interface CEspecialidadFacadeLocal {

    void create(CEspecialidad cEspecialidad);

    void edit(CEspecialidad cEspecialidad);

    void remove(CEspecialidad cEspecialidad);

    CEspecialidad find(Object id);

    List<CEspecialidad> findAll();

    List<CEspecialidad> findRange(int[] range);

    int count();
    
}
