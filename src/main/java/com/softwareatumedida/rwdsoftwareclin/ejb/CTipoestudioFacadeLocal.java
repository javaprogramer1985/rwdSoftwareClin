/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.ejb;

import com.softwareatumedida.rwdsoftwareclin.entity.CTipoestudio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author a
 */
@Local
public interface CTipoestudioFacadeLocal {

    void create(CTipoestudio cTipoestudio);

    void edit(CTipoestudio cTipoestudio);

    void remove(CTipoestudio cTipoestudio);

    CTipoestudio find(Object id);

    List<CTipoestudio> findAll();

    List<CTipoestudio> findRange(int[] range);

    int count();
    
}
