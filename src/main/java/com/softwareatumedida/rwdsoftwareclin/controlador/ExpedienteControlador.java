package com.softwareatumedida.rwdsoftwareclin.controlador;

import com.softwareatumedida.rwdsoftwareclin.ejb.ExpedienteFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.entity.Expediente;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ExpedienteControlador implements Serializable{
    
    @EJB
    ExpedienteFacadeLocal expedienteFacadeLocal;
    Expediente expediente;
    List<Expediente> listaExpediente;
    @PostConstruct
    public void init(){
        expediente = new Expediente();
        listar();
    }
    
    public void nuevo(){
        try {
            expedienteFacadeLocal.create(expediente);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se creo el expediente de " + expediente.getPacienteNombre() + " " + expediente.getPacientePApellido() + " " + expediente.getPacienteSApellido());
            FacesContext.getCurrentInstance().addMessage("altaPacienteForm:pacienteRadica", msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Ocurrio un problema en el almacenamiento del expediente");
            FacesContext.getCurrentInstance().addMessage("altaPacienteForm:pacienteRadica", msg);
        }
        
    }
    
    public void modificar(){
        expedienteFacadeLocal.edit(expediente);
    }
    
    public void eliminar(){
        expedienteFacadeLocal.remove(expediente);
    }

    public void listar(){
        listaExpediente = expedienteFacadeLocal.findAll();
    }

    public List<Expediente> getListaExpediente() {
        return listaExpediente;
    }

    public void setListaExpediente(List<Expediente> listaExpediente) {
        this.listaExpediente = listaExpediente;
    }
    
    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

        
    
}
