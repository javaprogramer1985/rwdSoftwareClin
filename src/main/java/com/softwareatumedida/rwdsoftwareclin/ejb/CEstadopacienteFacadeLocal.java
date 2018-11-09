/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.ejb;

import com.softwareatumedida.rwdsoftwareclin.entity.CEstadopaciente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author a
 */
@Local
public interface CEstadopacienteFacadeLocal {

    void create(CEstadopaciente cEstadopaciente);

    void edit(CEstadopaciente cEstadopaciente);

    void remove(CEstadopaciente cEstadopaciente);

    CEstadopaciente find(Object id);

    List<CEstadopaciente> findAll();

    List<CEstadopaciente> findRange(int[] range);

    int count();
    
}
