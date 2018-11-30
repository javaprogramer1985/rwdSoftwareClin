package com.softwareatumedida.rwdsoftwareclin.controlador;

import com.softwareatumedida.rwdsoftwareclin.ejb.DiagnosticoFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.entity.Diagnostico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.behavior.FacesBehavior;
import javax.faces.event.FacesEvent;
import net.bootsfaces.utils.FacesMessages;

@ManagedBean
@SessionScoped
public class DiagnosticoControlador implements Serializable {

    @EJB
    DiagnosticoFacadeLocal diagnosticoFacadeLocal;

    List<Diagnostico> diagnosticos;
    List<Diagnostico> diagnosticosSeleccionados;
    List<Diagnostico> diagnosticosFiltrados;
    Diagnostico diagnostico;
    Diagnostico diagnosticoSeleccionado;

    @PostConstruct
    public void init() {
        diagnosticosSeleccionados = new ArrayList<>();
        diagnosticosFiltrados = new ArrayList<>();
        diagnostico = new Diagnostico();
        listar();
    }

    public void listar() {
        diagnosticos = diagnosticoFacadeLocal.findAll();
    }

    public void nuevo() {
        try {
            diagnosticoFacadeLocal.create(diagnostico);
            FacesMessages.info("Aviso", "se ha generado el diagnostico de " + diagnostico.getPacienteId().getPacienteNombre() + " " + diagnostico.getPacienteId().getPacientePApellido() + " " + diagnostico.getPacienteId().getPacienteSApellido());
            //diagnostico = new Diagnostico(); Descomentar si se requiere que limpie los controles del formulario
        } catch (Exception e) {
            FacesMessages.fatal("Error de Sistema! ", "Favor de avisar al desarrollador del sistema");
        }

    }

    public List<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<Diagnostico> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public List<Diagnostico> getDiagnosticosSeleccionados() {
        return diagnosticosSeleccionados;
    }

    public void setDiagnosticosSeleccionados(List<Diagnostico> diagnosticosSeleccionados) {
        this.diagnosticosSeleccionados = diagnosticosSeleccionados;
    }

    public Diagnostico getDiagnosticoSeleccionado() {
        return diagnosticoSeleccionado;
    }

    public void setDiagnosticoSeleccionado(Diagnostico diagnosticoSeleccionado) {
        this.diagnosticoSeleccionado = diagnosticoSeleccionado;
    }

    

    public List<Diagnostico> getDiagnosticosFiltrados() {
        return diagnosticosFiltrados;
    }

    public void setDiagnosticosFiltrados(List<Diagnostico> diagnosticosFiltrados) {
        this.diagnosticosFiltrados = diagnosticosFiltrados;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    
}
