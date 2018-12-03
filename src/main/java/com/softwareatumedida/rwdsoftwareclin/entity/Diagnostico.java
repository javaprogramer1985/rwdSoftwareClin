/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a
 */
@Entity
@Table(name = "diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d")
    , @NamedQuery(name = "Diagnostico.findByRxId", query = "SELECT d FROM Diagnostico d WHERE d.rxId = :rxId")
    , @NamedQuery(name = "Diagnostico.findByRxFecHora", query = "SELECT d FROM Diagnostico d WHERE d.rxFecHora = :rxFecHora")
    , @NamedQuery(name = "Diagnostico.findByRxPacienteAcompa\u00f1ante", query = "SELECT d FROM Diagnostico d WHERE d.rxPacienteAcompa\u00f1ante = :rxPacienteAcompa\u00f1ante")
    , @NamedQuery(name = "Diagnostico.findByRxParentesco", query = "SELECT d FROM Diagnostico d WHERE d.rxParentesco = :rxParentesco")
    , @NamedQuery(name = "Diagnostico.findByRxMConsulta", query = "SELECT d FROM Diagnostico d WHERE d.rxMConsulta = :rxMConsulta")
    , @NamedQuery(name = "Diagnostico.findByRxFC", query = "SELECT d FROM Diagnostico d WHERE d.rxFC = :rxFC")
    , @NamedQuery(name = "Diagnostico.findByRxFR", query = "SELECT d FROM Diagnostico d WHERE d.rxFR = :rxFR")
    , @NamedQuery(name = "Diagnostico.findByRxTemp", query = "SELECT d FROM Diagnostico d WHERE d.rxTemp = :rxTemp")
    , @NamedQuery(name = "Diagnostico.findByRxInterconsulta", query = "SELECT d FROM Diagnostico d WHERE d.rxInterconsulta = :rxInterconsulta")
    , @NamedQuery(name = "Diagnostico.findByRxExploracionFisica", query = "SELECT d FROM Diagnostico d WHERE d.rxExploracionFisica = :rxExploracionFisica")
    , @NamedQuery(name = "Diagnostico.findByRxDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.rxDiagnostico = :rxDiagnostico")
    , @NamedQuery(name = "Diagnostico.findByRxIndicacionesMedicas", query = "SELECT d FROM Diagnostico d WHERE d.rxIndicacionesMedicas = :rxIndicacionesMedicas")
    , @NamedQuery(name = "Diagnostico.findByRxFechaEgreso", query = "SELECT d FROM Diagnostico d WHERE d.rxFechaEgreso = :rxFechaEgreso")})
public class Diagnostico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RxId")
    private Integer rxId;
    @Column(name = "RxFecHora")
    @Temporal(TemporalType.DATE)
    private Date rxFecHora;
    @Size(max = 100)
    @Column(name = "RxPacienteAcompa\u00f1ante")
    private String rxPacienteAcompañante;
    @Size(max = 45)
    @Column(name = "RxParentesco")
    private String rxParentesco;
    @Size(max = 250)
    @Column(name = "RxMConsulta")
    private String rxMConsulta;
    @Size(max = 40)
    @Column(name = "RxFC")
    private String rxFC;
    @Size(max = 40)
    @Column(name = "RxFR")
    private String rxFR;
    @Size(max = 10)
    @Column(name = "RxTemp")
    private String rxTemp;
    @Size(max = 100)
    @Column(name = "RxInterconsulta")
    private String rxInterconsulta;
    @Size(max = 200)
    @Column(name = "RxExploracionFisica")
    private String rxExploracionFisica;
    @Size(max = 200)
    @Column(name = "RxDiagnostico")
    private String rxDiagnostico;
    @Size(max = 200)
    @Column(name = "RxIndicacionesMedicas")
    private String rxIndicacionesMedicas;
    @Column(name = "RxFechaEgreso")
    @Temporal(TemporalType.DATE)
    private Date rxFechaEgreso;
    @OneToMany(mappedBy = "rxId")
    private Collection<Receta> recetaCollection;
    @JoinColumn(name = "CEstadoPacienteId", referencedColumnName = "CEstadoPacienteId")
    @ManyToOne
    private CEstadopaciente cEstadoPacienteId;
    @JoinColumn(name = "CEstadoId", referencedColumnName = "CEstadoId")
    @ManyToOne
    private CEstado cEstadoId;
    @JoinColumn(name = "PacienteId", referencedColumnName = "PacienteId")
    @ManyToOne
    private Expediente pacienteId;
    @JoinColumn(name = "UsuarioUsr", referencedColumnName = "UsuarioUsr")
    @ManyToOne
    private Personal usuarioUsr;
    @JoinColumn(name = "CPrioridadId", referencedColumnName = "CPrioridadId")
    @ManyToOne
    private CPrioridad cPrioridadId;
    @JoinColumn(name = "CTipoIngresoId", referencedColumnName = "CTipoIngresoId")
    @ManyToOne
    private CTipoingreso cTipoIngresoId;

    public Diagnostico() {
        rxFecHora = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    }

    public Diagnostico(Integer rxId) {
        this.rxId = rxId;
    }

    public Integer getRxId() {
        return rxId;
    }

    public void setRxId(Integer rxId) {
        this.rxId = rxId;
    }

    public Date getRxFecHora() {
        return rxFecHora;
    }

    public void setRxFecHora(Date rxFecHora) {
        this.rxFecHora = rxFecHora;
    }

    public String getRxPacienteAcompañante() {
        return rxPacienteAcompañante;
    }

    public void setRxPacienteAcompañante(String rxPacienteAcompañante) {
        this.rxPacienteAcompañante = rxPacienteAcompañante;
    }

    public String getRxParentesco() {
        return rxParentesco;
    }

    public void setRxParentesco(String rxParentesco) {
        this.rxParentesco = rxParentesco;
    }

    public String getRxMConsulta() {
        return rxMConsulta;
    }

    public void setRxMConsulta(String rxMConsulta) {
        this.rxMConsulta = rxMConsulta;
    }

    public String getRxFC() {
        return rxFC;
    }

    public void setRxFC(String rxFC) {
        this.rxFC = rxFC;
    }

    public String getRxFR() {
        return rxFR;
    }

    public void setRxFR(String rxFR) {
        this.rxFR = rxFR;
    }

    public String getRxTemp() {
        return rxTemp;
    }

    public void setRxTemp(String rxTemp) {
        this.rxTemp = rxTemp;
    }

    public String getRxInterconsulta() {
        return rxInterconsulta;
    }

    public void setRxInterconsulta(String rxInterconsulta) {
        this.rxInterconsulta = rxInterconsulta;
    }

    public String getRxExploracionFisica() {
        return rxExploracionFisica;
    }

    public void setRxExploracionFisica(String rxExploracionFisica) {
        this.rxExploracionFisica = rxExploracionFisica;
    }

    public String getRxDiagnostico() {
        return rxDiagnostico;
    }

    public void setRxDiagnostico(String rxDiagnostico) {
        this.rxDiagnostico = rxDiagnostico;
    }

    public String getRxIndicacionesMedicas() {
        return rxIndicacionesMedicas;
    }

    public void setRxIndicacionesMedicas(String rxIndicacionesMedicas) {
        this.rxIndicacionesMedicas = rxIndicacionesMedicas;
    }

    public Date getRxFechaEgreso() {
        return rxFechaEgreso;
    }

    public void setRxFechaEgreso(Date rxFechaEgreso) {
        this.rxFechaEgreso = rxFechaEgreso;
    }

    @XmlTransient
    public Collection<Receta> getRecetaCollection() {
        return recetaCollection;
    }

    public void setRecetaCollection(Collection<Receta> recetaCollection) {
        this.recetaCollection = recetaCollection;
    }

    public CEstadopaciente getCEstadoPacienteId() {
        return cEstadoPacienteId;
    }

    public void setCEstadoPacienteId(CEstadopaciente cEstadoPacienteId) {
        this.cEstadoPacienteId = cEstadoPacienteId;
    }

    public CEstado getCEstadoId() {
        return cEstadoId;
    }

    public void setCEstadoId(CEstado cEstadoId) {
        this.cEstadoId = cEstadoId;
    }

    public Expediente getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Expediente pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Personal getUsuarioUsr() {
        return usuarioUsr;
    }

    public void setUsuarioUsr(Personal usuarioUsr) {
        this.usuarioUsr = usuarioUsr;
    }

    public CPrioridad getCPrioridadId() {
        return cPrioridadId;
    }

    public void setCPrioridadId(CPrioridad cPrioridadId) {
        this.cPrioridadId = cPrioridadId;
    }

    public CTipoingreso getCTipoIngresoId() {
        return cTipoIngresoId;
    }

    public void setCTipoIngresoId(CTipoingreso cTipoIngresoId) {
        this.cTipoIngresoId = cTipoIngresoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rxId != null ? rxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.rxId == null && other.rxId != null) || (this.rxId != null && !this.rxId.equals(other.rxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.Diagnostico[ rxId=" + rxId + " ]";
    }
    
}
