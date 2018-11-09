/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.ejb;

import com.softwareatumedida.rwdsoftwareclin.entity.CTipousuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author a
 */
@Local
public interface CTipousuarioFacadeLocal {

    void create(CTipousuario cTipousuario);

    void edit(CTipousuario cTipousuario);

    void remove(CTipousuario cTipousuario);

    CTipousuario find(Object id);

    List<CTipousuario> findAll();

    List<CTipousuario> findRange(int[] range);

    int count();
    
}
