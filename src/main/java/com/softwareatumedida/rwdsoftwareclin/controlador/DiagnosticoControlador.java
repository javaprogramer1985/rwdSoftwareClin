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
    List<Diagnostico> diagnosticoSeleccionado;
    Diagnostico diagnostico;

    @PostConstruct
    public void init() {
        diagnosticoSeleccionado = new ArrayList<>();
        diagnostico = new Diagnostico();
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
}
