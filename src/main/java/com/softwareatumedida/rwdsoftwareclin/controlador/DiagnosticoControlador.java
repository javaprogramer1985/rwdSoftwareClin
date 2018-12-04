package com.softwareatumedida.rwdsoftwareclin.controlador;

import com.softwareatumedida.rwdsoftwareclin.ejb.CEstadoFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.ejb.CEstadopacienteFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.ejb.CPrioridadFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.ejb.CTipoingresoFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.ejb.DiagnosticoFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.ejb.ExpedienteFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.ejb.PersonalFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.entity.CEstado;
import com.softwareatumedida.rwdsoftwareclin.entity.CEstadopaciente;
import com.softwareatumedida.rwdsoftwareclin.entity.CPrioridad;
import com.softwareatumedida.rwdsoftwareclin.entity.CTipoingreso;
import com.softwareatumedida.rwdsoftwareclin.entity.Diagnostico;
import com.softwareatumedida.rwdsoftwareclin.entity.Expediente;
import com.softwareatumedida.rwdsoftwareclin.entity.Personal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import net.bootsfaces.utils.FacesMessages;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class DiagnosticoControlador implements Serializable {

    @EJB
    DiagnosticoFacadeLocal diagnosticoFacadeLocal;
    @EJB
    PersonalFacadeLocal personalFacadeLocal;
    @EJB
    ExpedienteFacadeLocal expedienteFacadeLocal;
    @EJB
    CTipoingresoFacadeLocal cTipoingresoFacadeLocal;
    @EJB
    CPrioridadFacadeLocal triagePrioridadFacadeLocal;
    @EJB
    CEstadopacienteFacadeLocal estadoPacienteFacadeLocal;
    @EJB
    CEstadoFacadeLocal estadoFacadeLocal;

    List<Diagnostico> diagnosticos;
    List<Diagnostico> diagnosticosSeleccionados;
    List<Diagnostico> diagnosticosFiltrados;
    Diagnostico diagnostico;
    Diagnostico diagnosticoSeleccionado;

    List<Personal> listPersonal;
    Personal personal;
    Personal personalSeleccionado; //Medico responsable del diagnostico

    List<Expediente> expedientes;
    Expediente expediente;
    Expediente expedienteSeleccionado; //Paciente diagnosticado

    List<CPrioridad> triagePrioridades;
    CPrioridad prioridadTriage;
    CPrioridad prioridadTriageSeleccionada; //Prioridad de urgencia del paciente

    List<CEstadopaciente> listEstadoPaciente;
    CEstadopaciente estadoPaciente;
    CEstadopaciente estadoPacienteSeleccionado; //Estado del paciente

    List<CEstado> listEstado;
    CEstado estado;
    CEstado estadoSeleccionado; //Estado del paciente en el hospital

    List<CTipoingreso> cTipoIngreso;
    List<CTipoingreso> listTipoIngreso;
    CTipoingreso tipoIngreso;

    String titleHeader;
    String medicoResponsable;
    String pacienteDiagnosticado;

    CTipoingreso tipoIngresoSeleccionadoResumen;
    int selectTipoIngresoId;
    CPrioridad prioridadSeleccionadaResumen;
    int selectPrioridadTriage;
    CEstadopaciente estadoPacienteSeleccionadoResumen;
    int selectEstadoPacienteId;
    CEstado estadoSeleccionadoResumen;
    int selectEstadoId;

    private boolean skip;

    @PostConstruct
    public void init() {
        diagnosticosSeleccionados = new ArrayList<>();
        diagnosticosFiltrados = new ArrayList<>();
        diagnostico = new Diagnostico();
        mostrarUsuarios();
        mostrarPacientes();
        catalogoTipoIngreso();
        catalogoPrioridadesTriage();
        catalogoEstadoPaciente();
        catalogoEstados();
        listar();
    }

    public void catalogoEstados() {
        listEstado = estadoFacadeLocal.findAll();
    }

    public void catalogoEstadoPaciente() {
        listEstadoPaciente = estadoPacienteFacadeLocal.findAll();
    }

    public void catalogoPrioridadesTriage() {
        triagePrioridades = triagePrioridadFacadeLocal.findAll();
    }

    public void catalogoTipoIngreso() {
        listTipoIngreso = cTipoingresoFacadeLocal.findAll();
    }

    public void mostrarUsuarios() {
        listPersonal = personalFacadeLocal.findAll();
    }

    public void mostrarPacientes() {
        expedientes = expedienteFacadeLocal.findAll();
    }

    public void listar() {
        diagnosticos = diagnosticoFacadeLocal.findAll();
    }

    public void nuevo() {
        try {

            diagnostico.setPacienteId(expedienteSeleccionado);
            diagnostico.setUsuarioUsr(personalSeleccionado);
            diagnostico.setCTipoIngresoId(tipoIngresoSeleccionadoResumen);
            diagnostico.setCPrioridadId(prioridadSeleccionadaResumen);
            diagnostico.setCEstadoPacienteId(estadoPacienteSeleccionadoResumen);
            diagnostico.setCEstadoId(estadoSeleccionadoResumen);

            diagnosticoFacadeLocal.create(diagnostico);
            listar();
            FacesMessages.info("Aviso", "se ha generado el diagnostico de " + diagnostico.getPacienteId().getPacienteNombre() + " " + diagnostico.getPacienteId().getPacientePApellido() + " " + diagnostico.getPacienteId().getPacienteSApellido());
            //diagnostico = new Diagnostico(); Descomentar si se requiere que limpie los controles del formulario
        } catch (Exception e) {
            FacesMessages.fatal("Error de Sistema! ", "Favor de avisar al desarrollador del sistema");
        }

    }

    public void verHeader() {
        titleHeader = "DATOS GENERALES";
    }

    public void eliminarHeader() {
        titleHeader = "DEBE CONFIRMAR LA ELIMINACIÒN";
    }

    public void nuevoHeader() {
        titleHeader = "ASISTENTE DE DIAGNOSTICO";
        expedienteSeleccionado = new Expediente();
        personalSeleccionado = new Personal();
    }

    public void modificarHeader() {
        titleHeader = "MODIFIQUE LOS DATOS NECESARIOS";
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

    public String getTitleHeader() {
        return titleHeader;
    }

    public void setTitleHeader(String titleHeader) {
        this.titleHeader = titleHeader;
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

    public List<Personal> getListPersonal() {
        return listPersonal;
    }

    public void setListPersonal(List<Personal> listPersonal) {
        this.listPersonal = listPersonal;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public List<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(List<Expediente> expedientes) {
        this.expedientes = expedientes;
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

    public String getMedicoResponsable() {
        return medicoResponsable;
    }

    public void setMedicoResponsable(String medicoResponsable) {
        this.medicoResponsable = medicoResponsable;
    }

    public Personal getPersonalSeleccionado() {
        return personalSeleccionado;
    }

    public void setPersonalSeleccionado(Personal personalSeleccionado) {
        this.personalSeleccionado = personalSeleccionado;
    }

    public List<CTipoingreso> getListTipoIngreso() {
        return listTipoIngreso;
    }

    public void setListTipoIngreso(List<CTipoingreso> listTipoIngreso) {
        this.listTipoIngreso = listTipoIngreso;
    }

    public CTipoingreso getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(CTipoingreso tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public int getSelectTipoIngresoId() {
        return selectTipoIngresoId;
    }

    public void setSelectTipoIngresoId(int selectTipoIngresoId) {
        this.selectTipoIngresoId = selectTipoIngresoId;
    }

    public List<CPrioridad> getTriagePrioridades() {
        return triagePrioridades;
    }

    public void setTriagePrioridades(List<CPrioridad> triagePrioridades) {
        this.triagePrioridades = triagePrioridades;
    }

    public CPrioridad getPrioridadTriage() {
        return prioridadTriage;
    }

    public void setPrioridadTriage(CPrioridad prioridadTriage) {
        this.prioridadTriage = prioridadTriage;
    }

    public CPrioridad getPrioridadTriageSeleccionada() {
        return prioridadTriageSeleccionada;
    }

    public void setPrioridadTriageSeleccionada(CPrioridad prioridadTriageSeleccionada) {
        this.prioridadTriageSeleccionada = prioridadTriageSeleccionada;
    }

    public int getSelectPrioridadTriage() {
        return selectPrioridadTriage;
    }

    public void setSelectPrioridadTriage(int selectPrioridadTriage) {
        this.selectPrioridadTriage = selectPrioridadTriage;
    }

    public List<CEstadopaciente> getListEstadoPaciente() {
        return listEstadoPaciente;
    }

    public void setListEstadoPaciente(List<CEstadopaciente> listEstadoPaciente) {
        this.listEstadoPaciente = listEstadoPaciente;
    }

    public CEstadopaciente getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(CEstadopaciente estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
    }

    public CEstadopaciente getEstadoPacienteSeleccionado() {
        return estadoPacienteSeleccionado;
    }

    public void setEstadoPacienteSeleccionado(CEstadopaciente estadoPacienteSeleccionado) {
        this.estadoPacienteSeleccionado = estadoPacienteSeleccionado;
    }

    public int getSelectEstadoPacienteId() {
        return selectEstadoPacienteId;
    }

    public void setSelectEstadoPacienteId(int selectEstadoPacienteId) {
        this.selectEstadoPacienteId = selectEstadoPacienteId;
    }

    public String getPacienteDiagnosticado() {
        return pacienteDiagnosticado;
    }

    public void setPacienteDiagnosticado(String pacienteDiagnosticado) {
        this.pacienteDiagnosticado = pacienteDiagnosticado;
    }

    public CEstadopacienteFacadeLocal getEstadoPacienteFacadeLocal() {
        return estadoPacienteFacadeLocal;
    }

    public void setEstadoPacienteFacadeLocal(CEstadopacienteFacadeLocal estadoPacienteFacadeLocal) {
        this.estadoPacienteFacadeLocal = estadoPacienteFacadeLocal;
    }

    public List<CEstado> getListEstado() {
        return listEstado;
    }

    public void setListEstado(List<CEstado> listEstado) {
        this.listEstado = listEstado;
    }

    public CEstado getEstado() {
        return estado;
    }

    public void setEstado(CEstado estado) {
        this.estado = estado;
    }

    public CEstado getEstadoSeleccionado() {
        return estadoSeleccionado;
    }

    public void setEstadoSeleccionado(CEstado estadoSeleccionado) {
        this.estadoSeleccionado = estadoSeleccionado;
    }

    public int getSelectEstadoId() {
        return selectEstadoId;
    }

    public void setSelectEstadoId(int selectEstadoId) {
        this.selectEstadoId = selectEstadoId;
    }

    public CTipoingreso getTipoIngresoSeleccionadoResumen() {
        return tipoIngresoSeleccionadoResumen;
    }

    public void setTipoIngresoSeleccionadoResumen(CTipoingreso tipoIngresoSeleccionadoResumen) {
        this.tipoIngresoSeleccionadoResumen = tipoIngresoSeleccionadoResumen;
    }

    public CPrioridad getPrioridadSeleccionadaResumen() {
        return prioridadSeleccionadaResumen;
    }

    public void setPrioridadSeleccionadaResumen(CPrioridad prioridadSeleccionadaResumen) {
        this.prioridadSeleccionadaResumen = prioridadSeleccionadaResumen;
    }

    public CEstadopaciente getEstadoPacienteSeleccionadoResumen() {
        return estadoPacienteSeleccionadoResumen;
    }

    public void setEstadoPacienteSeleccionadoResumen(CEstadopaciente estadoPacienteSeleccionadoResumen) {
        this.estadoPacienteSeleccionadoResumen = estadoPacienteSeleccionadoResumen;
    }

    public CEstado getEstadoSeleccionadoResumen() {
        return estadoSeleccionadoResumen;
    }

    public void setEstadoSeleccionadoResumen(CEstado estadoSeleccionadoResumen) {
        this.estadoSeleccionadoResumen = estadoSeleccionadoResumen;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {

        System.out.println("event.getNewStep(): " + event.getNewStep());

        if (event.getNewStep().equals("paciente") && personalSeleccionado == null) {
            skip = false;
            FacesMessages.error("¡Error!", "Debe seleccionar un responsable porfavor.");
            return "medico";

        } else if (event.getNewStep().equals("diagnostico") && expedienteSeleccionado == null) {
            skip = false;
            FacesMessages.error("¡Error!", "Debe seleccionar un paciente porfavor.");
            return "paciente";
        }
        if (event.getNewStep().equals("resumen")) {
            tipoIngresoSeleccionadoResumen = cTipoingresoFacadeLocal.find(selectTipoIngresoId);
            prioridadSeleccionadaResumen = triagePrioridadFacadeLocal.find(selectPrioridadTriage);
            estadoPacienteSeleccionadoResumen = estadoPacienteFacadeLocal.find(selectEstadoPacienteId);
            estadoSeleccionadoResumen = estadoFacadeLocal.find(selectEstadoId);
        }
        if (skip) {
            skip = false;   //reset in case user goes back
            return "resumen";
        } else {
            return event.getNewStep();
        }
//        }
    }

    public void onRowSelect(SelectEvent event) {
        medicoResponsable = personalSeleccionado.getUsuarioNombre() + " " + personalSeleccionado.getUsuarioApellido();
    }

    public void onRowSelectItemPaciente(SelectEvent event) {
        pacienteDiagnosticado = expedienteSeleccionado.getPacienteNombre() + " " + expedienteSeleccionado.getPacientePApellido() + " " + expedienteSeleccionado.getPacienteSApellido();
    }

}
