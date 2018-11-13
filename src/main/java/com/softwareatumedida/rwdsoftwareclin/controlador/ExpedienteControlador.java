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
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ExpedienteControlador implements Serializable {

    @EJB
    ExpedienteFacadeLocal expedienteFacadeLocal;
    Expediente expediente;
    List<Expediente> listaExpediente;
    List<Expediente> listaExpedienteSelect;
    Expediente expedienteSeleccionado;

    @PostConstruct
    public void init() {
        expediente = new Expediente();
        expedienteSeleccionado = new Expediente();
        listar();
    }

    public void nuevo() {
        try {
            expedienteFacadeLocal.create(expediente);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se creo el expediente de " + expediente.getPacienteNombre() + " " + expediente.getPacientePApellido() + " " + expediente.getPacienteSApellido());
            FacesContext.getCurrentInstance().addMessage("altaPacienteForm:pacienteRadica", msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Ocurrio un problema en el almacenamiento del expediente");
            FacesContext.getCurrentInstance().addMessage("altaPacienteForm:pacienteRadica", msg);
        }

    }

    public void modificar() {
        expedienteFacadeLocal.edit(expediente);
    }

    public void eliminar(Expediente expe) {   
//        try {
//            expedienteFacadeLocal.remove(expe);
//            listar();
//            FacesMessage msg = new FacesMessage("Aviso", "Se elimino el expediente de " + expe.getPacienteNombre() + " " + expe.getPacientePApellido() + " " + expe.getPacienteSApellido());
//            FacesContext.getCurrentInstance().addMessage("formPaciente:message", msg);
//        } catch (Exception e) {
//            FacesMessage msg = new FacesMessage("Aviso", "Ocurrio un problema en el almacenamiento del expediente");           
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//           
//        }
        FacesMessage msg = new FacesMessage("Aviso", "Ocurrio un problema en el almacenamiento del expediente");           
        FacesContext.getCurrentInstance().addMessage(null, msg);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }

    public void listar() {
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

    public Expediente getExpedienteSeleccionado() {
        return expedienteSeleccionado;
    }

    public void setExpedienteSeleccionado(Expediente expedienteSeleccionado) {
        this.expedienteSeleccionado = expedienteSeleccionado;
    }

    
    public List<Expediente> getCurrentlySelectedExpedientes() {
        return listaExpedienteSelect;
    }

    public void onSelect(Expediente expediente, String typeOfSelection, String indexes) {
        System.out.println("OnSelect:" + expediente + " typeOfSelection: " + typeOfSelection + " indexes: " + indexes);
        if (null != expediente) {
            getCurrentlySelectedExpedientes().add(expediente);
        } else if (null != indexes) {
            String[] indexArray = indexes.split(",");
            for (String index : indexArray) {
                int i = Integer.valueOf(index);
                Expediente newCar = listaExpediente.get(i);
                if (!listaExpedienteSelect.contains(newCar)) {
                    getCurrentlySelectedExpedientes().add(newCar);
                }
            }
        }
    }

}
