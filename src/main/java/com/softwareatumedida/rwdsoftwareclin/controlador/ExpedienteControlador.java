package com.softwareatumedida.rwdsoftwareclin.controlador;

import com.softwareatumedida.rwdsoftwareclin.ejb.ExpedienteFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.entity.Expediente;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ExpedienteControlador implements Serializable{
    
    @EJB
    ExpedienteFacadeLocal expedienteFacadeLocal;
    Expediente expediente;
    
    @PostConstruct
    public void init(){
        expediente = new Expediente();
    }
    
    public void nuevo(){
        expedienteFacadeLocal.create(expediente);
    }
    
    public void modificar(){
        expedienteFacadeLocal.edit(expediente);
    }
    
    public void eliminar(){
        expedienteFacadeLocal.remove(expediente);
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

        
    
}
