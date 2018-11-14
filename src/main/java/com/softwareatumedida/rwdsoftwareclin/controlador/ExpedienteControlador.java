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
import net.bootsfaces.utils.FacesMessages;

@ManagedBean
@RequestScoped
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
            FacesMessages.info("Aviso ", "Se creo el expediente de " + expediente.getPacienteNombre() + " " + expediente.getPacientePApellido() + " " + expediente.getPacienteSApellido());
        } catch (Exception e) {
            FacesMessages.error("Error ", "Ocurrio un problema en el almacenamiento del expediente");
        }

    }

    public void modificar() {
        try {
            expedienteFacadeLocal.edit(expediente);
            FacesMessages.info("Aviso ", "Se modifico el expediente de " + expediente.getPacienteNombre() + " " + expediente.getPacientePApellido() + " " + expediente.getPacienteSApellido());
        } catch (Exception e) {
            FacesMessages.error("Error ", "Ocurrio un problema en modificación del expediente");
        }
        
    }

    public void eliminar(Expediente expe) {
        try {
            expedienteFacadeLocal.remove(expe);
            listar();
            FacesMessages.info("Aviso", "¡Se elimino el registro correctamente!");
        } catch (Exception e) {
            FacesMessages.error("Error ", "¡Ocurrio un error al tratar de eliminar el registro!");
        }
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
