/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.ejb;

import com.softwareatumedida.rwdsoftwareclin.entity.Estudio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author a
 */
@Local
public interface EstudioFacadeLocal {

    void create(Estudio estudio);

    void edit(Estudio estudio);

    void remove(Estudio estudio);

    Estudio find(Object id);

    List<Estudio> findAll();

    List<Estudio> findRange(int[] range);

    int count();
    
}
