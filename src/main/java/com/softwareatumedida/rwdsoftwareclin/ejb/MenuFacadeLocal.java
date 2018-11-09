/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.ejb;

import com.softwareatumedida.rwdsoftwareclin.entity.Menu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author a
 */
@Local
public interface MenuFacadeLocal {

    void create(Menu menu);

    void edit(Menu menu);

    void remove(Menu menu);

    Menu find(Object id);

    List<Menu> findAll();

    List<Menu> findRange(int[] range);

    int count();
    
}
