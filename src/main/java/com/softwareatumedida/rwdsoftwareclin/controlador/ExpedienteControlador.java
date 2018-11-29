package com.softwareatumedida.rwdsoftwareclin.controlador;

import com.softwareatumedida.rwdsoftwareclin.ejb.ExpedienteFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.entity.Expediente;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import net.bootsfaces.utils.FacesMessages;

@ManagedBean
@ViewScoped
public class ExpedienteControlador implements Serializable {

    @EJB
    ExpedienteFacadeLocal expedienteFacadeLocal;
    Expediente expediente;
    List<Expediente> listaExpediente;
    List<Expediente> listaExpedienteSelect;
    Expediente expedienteSeleccionado;
    boolean botonNuevo;
    boolean botonGuardar;
    boolean botonModificar;
    boolean botonEliminar;
    boolean botonCancelar;
    boolean panelDisabled;
    String titleHeader;

    @PostConstruct
    public void init() {
        expediente = new Expediente();
        expedienteSeleccionado = new Expediente();
        listaExpedienteSelect=new ArrayList<>();
        panelDisabled = false;
        botonNuevo=false;
        botonGuardar=true;
        botonModificar=true;
        botonEliminar=true;
        botonCancelar=false;
        panelDisabled=true;
        listar();
    }
    
    public void verHeader(){
        titleHeader = "DATOS DEL EXPEDIENTE";
    }
    public void eliminarHeader(){
        titleHeader = "DEBE CONFIRMAR LA ELIMINACION";
    }
    public void nuevoHeader(){
        titleHeader = "INGRESE LOS DATOS DEL NUEVO EXPEDIENTE";
    }
    
    public void onClickNuevo(){
        botonNuevo=true;
        botonGuardar=false;
        botonModificar=true;
        botonEliminar=true;
        botonCancelar=false;
        panelDisabled=false;
        expedienteSeleccionado = new Expediente();
    }
    
    public void onClickCancelar(){
        botonNuevo=false;
        botonGuardar=true;
        botonModificar=true;
        botonEliminar=true;
        botonCancelar=false;
        panelDisabled=true;
    }
    
    
    public void nuevo() {
        try {
            expedienteFacadeLocal.create(expedienteSeleccionado);
            listar();
            FacesMessages.info("Aviso ", "Se creo el expediente de " + expedienteSeleccionado.getPacienteNombre() + " " + expedienteSeleccionado.getPacientePApellido() + " " + expedienteSeleccionado.getPacienteSApellido());
            expedienteSeleccionado = new Expediente();            
        } catch (Exception e) {
            FacesMessages.error("Error ", "Ocurrio un problema en el almacenamiento del expediente");
        }

    }

    public void modificar() {
        try {
            expedienteFacadeLocal.edit(expedienteSeleccionado);
            expedienteSeleccionado.getPacienteSexo();
            FacesMessages.info("Aviso ", "se modifico el expediente de " + expedienteSeleccionado.getPacienteNombre() + " " + expedienteSeleccionado.getPacientePApellido() + " " + expedienteSeleccionado.getPacienteSApellido());
        } catch (Exception e) {
            FacesMessages.error("Error ", "ocurrio un problema en modificación del expediente");
        }
        
    }

    public void eliminar() {
        try {
            expedienteFacadeLocal.remove(expedienteSeleccionado);
            listar();
            FacesMessages.info("Aviso", "¡Se elimino el registro correctamente!");
            expedienteSeleccionado = new Expediente();   
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

    public boolean isPanelDisabled() {
        return panelDisabled;
    }

    public void setPanelDisabled(boolean panelDisabled) {
        this.panelDisabled = panelDisabled;
    }
      
    public boolean isBotonNuevo() {
        return botonNuevo;
    }

    public void setBotonNuevo(boolean botonNuevo) {
        this.botonNuevo = botonNuevo;
    }

    public boolean isBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonGuardar(boolean botonGuardar) {
        this.botonGuardar = botonGuardar;
    }

    public boolean isBotonModificar() {
        return botonModificar;
    }

    public void setBotonModificar(boolean botonModificar) {
        this.botonModificar = botonModificar;
    }

    public boolean isBotonEliminar() {
        return botonEliminar;
    }

    public void setBotonEliminar(boolean botonEliminar) {
        this.botonEliminar = botonEliminar;
    }

    public boolean isBotonCancelar() {
        return botonCancelar;
    }

    public void setBotonCancelar(boolean botonCancelar) {
        this.botonCancelar = botonCancelar;
    }    

    public String getTitleHeader() {
        return titleHeader;
    }

    public void setTitleHeader(String titleHeader) {
        this.titleHeader = titleHeader;
    }
    
    
    public List<Expediente> getCurrentlySelectedExpedientes() {
        return listaExpedienteSelect;
    }

    public void toggle(ActionEvent event){
        panelDisabled = false;        
    }
    public void onSelect(Expediente expediente, String typeOfSelection, String indexes) {
        System.out.println("OnSelect:" + expediente);
        expedienteSeleccionado = null;
        expedienteSeleccionado = expediente;
        
        botonNuevo=true;
        botonGuardar=true;
        botonModificar=false;
        botonEliminar=false;
        botonCancelar=false;
        panelDisabled=false;
    }

}
