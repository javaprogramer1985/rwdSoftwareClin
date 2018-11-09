/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.ejb;

import com.softwareatumedida.rwdsoftwareclin.entity.CTipoingreso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author a
 */
@Local
public interface CTipoingresoFacadeLocal {

    void create(CTipoingreso cTipoingreso);

    void edit(CTipoingreso cTipoingreso);

    void remove(CTipoingreso cTipoingreso);

    CTipoingreso find(Object id);

    List<CTipoingreso> findAll();

    List<CTipoingreso> findRange(int[] range);

    int count();
    
}
