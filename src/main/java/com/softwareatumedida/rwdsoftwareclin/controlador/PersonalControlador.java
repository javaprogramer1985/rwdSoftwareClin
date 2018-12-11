package com.softwareatumedida.rwdsoftwareclin.controlador;

import com.softwareatumedida.rwdsoftwareclin.ejb.PersonalFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.ejb.UsuariosFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.entity.Personal;
import com.softwareatumedida.rwdsoftwareclin.entity.Usuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class PersonalControlador implements Serializable{
    
    @EJB
    PersonalFacadeLocal personalFacadeLocal;
    
    private List<Personal> personal;
    private Personal personalSeleccionado;
    private int ROWS_DATATABLE;
    
    private String titleHeader;
    
    @PostConstruct
    public void init(){
        personal = new ArrayList<>();
        personalSeleccionado = new Personal();
        ROWS_DATATABLE = 10;
        listar();
    }
    
    public void listar(){
        personal= personalFacadeLocal.findAll();
    }
    
    public void modificarHeader(){
        titleHeader = "MODIFIQUE LOS DATOS NECESARIOS";
    }
    
    
    public void nuevoHeader(){
        titleHeader = "NUEVO USUARIO";
    }

    public List<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(List<Personal> personal) {
        this.personal = personal;
    }

    public Personal getPersonalSeleccionado() {
        return personalSeleccionado;
    }

    public void setPersonalSeleccionado(Personal personalSeleccionado) {
        this.personalSeleccionado = personalSeleccionado;
    }
    
    public int getROWS_DATATABLE() {
        return ROWS_DATATABLE;
    }

    public void setROWS_DATATABLE(int ROWS_DATATABLE) {
        this.ROWS_DATATABLE = ROWS_DATATABLE;
    }

    public String getTitleHeader() {
        return titleHeader;
    }

    public void setTitleHeader(String titleHeader) {
        this.titleHeader = titleHeader;
    }
    
    public void onRowSelectItemUsuario(SelectEvent event){
        System.err.println("com.softwareatumedida.rwdsoftwareclin.controlador.UsuarioControlador.onRowSelectItemUsuario()");
    }
    
}
