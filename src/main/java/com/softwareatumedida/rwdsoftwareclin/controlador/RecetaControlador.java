package com.softwareatumedida.rwdsoftwareclin.controlador;

import com.softwareatumedida.rwdsoftwareclin.ejb.DiagnosticoFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.ejb.ExpedienteFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.ejb.RecetaFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.entity.Diagnostico;
import com.softwareatumedida.rwdsoftwareclin.entity.Especialidad;
import com.softwareatumedida.rwdsoftwareclin.entity.Expediente;
import com.softwareatumedida.rwdsoftwareclin.entity.Personal;
import com.softwareatumedida.rwdsoftwareclin.entity.Prescripcion;
import com.softwareatumedida.rwdsoftwareclin.entity.Receta;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class RecetaControlador implements Serializable {

    private int ROWS_DATATABLE;
    @EJB
    private RecetaFacadeLocal recetaFacadeLocal;
    @EJB
    private ExpedienteFacadeLocal expedienteFacadeLocal;    
    @EJB
    private DiagnosticoFacadeLocal diagnosticoFacadeLocal;
    
    private List<Receta> recetas;
    private Receta recetaSeleccionada;
    private Receta receta;
    
    private String nombreCompleto;
    private Personal usuarioLogueado;
    private Expediente expediente;
    private List<Expediente> expedientes;
    private Expediente expedienteSeleccionado;
    
    private Diagnostico diagnostico;
    private List<Diagnostico> diagnosticos;
    private List<Diagnostico> diagnosticosAux;
    private Diagnostico diagnosticoSeleccionado;
    
    private Prescripcion prescripcion;
    private Prescripcion prescripcionSeleccionada;
    private List<Prescripcion> prescripciones;
    
    
    private boolean skip;
    private String especialidad = "";
    private String certificado = "";
    private String cedulaprofesional = "";
    
    @PostConstruct
    public void init() {
        ROWS_DATATABLE = 10;
        recetaSeleccionada = new Receta();
        usuarioLogueado = (Personal)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("SessionUsuario");
        diagnosticoSeleccionado = new Diagnostico();        
        receta = new Receta();
        prescripciones = new ArrayList<>();
        prescripcion = new Prescripcion();
        
        List<Especialidad> especialidades = (List)usuarioLogueado.getEspecialidadCollection();
        if ( especialidades.size() > 1 ){
            for (Especialidad item : especialidades) {
                if (item != null)
                    especialidad = especialidad + " // " + item.getCEspecialidadId().getCEspecialidadIdDes();
            }
        }else
            especialidad = especialidades.get(0).getCEspecialidadId().getCEspecialidadIdDes();
        
        certificado = especialidades.get(especialidades.size()-1).getEspecialidadInstitucion();
        cedulaprofesional = especialidades.get(especialidades.size()-1).getEspecialidadCedula();
        
        listar();
    }
   
    public void listar() {
        recetas = recetaFacadeLocal.findAll();
        expedientes = expedienteFacadeLocal.findAll();  
        diagnosticosAux = diagnosticoFacadeLocal.findAll();
    }

    public int getROWS_DATATABLE() {
        return ROWS_DATATABLE;
    }

    public void setROWS_DATATABLE(int ROWS_DATATABLE) {
        this.ROWS_DATATABLE = ROWS_DATATABLE;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }

    public Receta getRecetaSeleccionada() {
        return recetaSeleccionada;
    }

    public void setRecetaSeleccionada(Receta recetaSeleccionada) {
        this.recetaSeleccionada = recetaSeleccionada;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Personal getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Personal usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getCedulaprofesional() {
        return cedulaprofesional;
    }

    public void setCedulaprofesional(String cedulaprofesional) {
        this.cedulaprofesional = cedulaprofesional;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public List<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(List<Expediente> expedientes) {
        this.expedientes = expedientes;
    }

    public Expediente getExpedienteSeleccionado() {
        return expedienteSeleccionado;
    }

    public void setExpedienteSeleccionado(Expediente expedienteSeleccionado) {
        this.expedienteSeleccionado = expedienteSeleccionado;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public List<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<Diagnostico> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public Diagnostico getDiagnosticoSeleccionado() {
        return diagnosticoSeleccionado;
    }

    public void setDiagnosticoSeleccionado(Diagnostico diagnosticoSeleccionado) {
        this.diagnosticoSeleccionado = diagnosticoSeleccionado;
    }

    public Prescripcion getPrescripcion() {
        return prescripcion;
    }

    public void setPrescripcion(Prescripcion prescripcion) {
        this.prescripcion = prescripcion;
    }

    public Prescripcion getPrescripcionSeleccionada() {
        return prescripcionSeleccionada;
    }

    public void setPrescripcionSeleccionada(Prescripcion prescripcionSeleccionada) {
        this.prescripcionSeleccionada = prescripcionSeleccionada;
    }

    public List<Prescripcion> getPrescripciones() {
        return prescripciones;
    }

    public void setPrescripciones(List<Prescripcion> prescripciones) {
        this.prescripciones = prescripciones;
    }
    
    
    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "resumen";
        } else {
            return event.getNewStep();
        }
    }
    public void onRecetaSelect(SelectEvent event) {
        
    }
    public void onPacienteSelect(SelectEvent event) {
        diagnosticoSeleccionado = new Diagnostico();
        diagnosticos = new ArrayList<>();
        diagnosticoSeleccionado = (Diagnostico) diagnosticoFacadeLocal.find(expedienteSeleccionado.getPacienteId());        
        for (Diagnostico item :diagnosticosAux) {
            if ( Objects.equals(expedienteSeleccionado.getPacienteId(), item.getPacienteId().getPacienteId()) ){
                diagnosticos.add(item);
            }
        }
    }
    public void agregar(){
        prescripcion.setPrescripcionId(prescripciones.size()+1);
        prescripciones.add(prescripcion);
        prescripcion = new Prescripcion();
    }
}
