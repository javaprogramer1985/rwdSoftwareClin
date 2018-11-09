/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "expediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expediente.findAll", query = "SELECT e FROM Expediente e")
    , @NamedQuery(name = "Expediente.findByPacienteId", query = "SELECT e FROM Expediente e WHERE e.pacienteId = :pacienteId")
    , @NamedQuery(name = "Expediente.findByPacienteNombre", query = "SELECT e FROM Expediente e WHERE e.pacienteNombre = :pacienteNombre")
    , @NamedQuery(name = "Expediente.findByPacientePApellido", query = "SELECT e FROM Expediente e WHERE e.pacientePApellido = :pacientePApellido")
    , @NamedQuery(name = "Expediente.findByPacienteSApellido", query = "SELECT e FROM Expediente e WHERE e.pacienteSApellido = :pacienteSApellido")
    , @NamedQuery(name = "Expediente.findByPacienteCurp", query = "SELECT e FROM Expediente e WHERE e.pacienteCurp = :pacienteCurp")
    , @NamedQuery(name = "Expediente.findByPacienteRFC", query = "SELECT e FROM Expediente e WHERE e.pacienteRFC = :pacienteRFC")
    , @NamedQuery(name = "Expediente.findByPacienteEmail", query = "SELECT e FROM Expediente e WHERE e.pacienteEmail = :pacienteEmail")
    , @NamedQuery(name = "Expediente.findByPacienteFNacimiento", query = "SELECT e FROM Expediente e WHERE e.pacienteFNacimiento = :pacienteFNacimiento")
    , @NamedQuery(name = "Expediente.findByPacienteSexo", query = "SELECT e FROM Expediente e WHERE e.pacienteSexo = :pacienteSexo")
    , @NamedQuery(name = "Expediente.findByPacienteECivil", query = "SELECT e FROM Expediente e WHERE e.pacienteECivil = :pacienteECivil")
    , @NamedQuery(name = "Expediente.findByPacienteTelCel", query = "SELECT e FROM Expediente e WHERE e.pacienteTelCel = :pacienteTelCel")
    , @NamedQuery(name = "Expediente.findByPacienteTelFijo", query = "SELECT e FROM Expediente e WHERE e.pacienteTelFijo = :pacienteTelFijo")
    , @NamedQuery(name = "Expediente.findByPacienteLNacimiento", query = "SELECT e FROM Expediente e WHERE e.pacienteLNacimiento = :pacienteLNacimiento")
    , @NamedQuery(name = "Expediente.findByPacienteRadica", query = "SELECT e FROM Expediente e WHERE e.pacienteRadica = :pacienteRadica")
    , @NamedQuery(name = "Expediente.findByExpedienteFecAlta", query = "SELECT e FROM Expediente e WHERE e.expedienteFecAlta = :expedienteFecAlta")})
public class Expediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PacienteId")
    private Integer pacienteId;
    @Size(max = 100)
    @Column(name = "PacienteNombre")
    private String pacienteNombre;
    @Size(max = 100)
    @Column(name = "PacientePApellido")
    private String pacientePApellido;
    @Size(max = 100)
    @Column(name = "PacienteSApellido")
    private String pacienteSApellido;
    @Size(max = 45)
    @Column(name = "PacienteCurp")
    private String pacienteCurp;
    @Size(max = 45)
    @Column(name = "PacienteRFC")
    private String pacienteRFC;
    @Size(max = 45)
    @Column(name = "PacienteEmail")
    private String pacienteEmail;
    @Column(name = "PacienteFNacimiento")
    @Temporal(TemporalType.DATE)
    private Date pacienteFNacimiento;
    @Column(name = "PacienteSexo")
    private Character pacienteSexo;
    @Size(max = 10)
    @Column(name = "PacienteECivil")
    private String pacienteECivil;
    @Size(max = 45)
    @Column(name = "PacienteTelCel")
    private String pacienteTelCel;
    @Size(max = 45)
    @Column(name = "PacienteTelFijo")
    private String pacienteTelFijo;
    @Size(max = 100)
    @Column(name = "PacienteLNacimiento")
    private String pacienteLNacimiento;
    @Size(max = 100)
    @Column(name = "PacienteRadica")
    private String pacienteRadica;
    @Column(name = "ExpedienteFecAlta")
    @Temporal(TemporalType.DATE)
    private Date expedienteFecAlta;
    @OneToMany(mappedBy = "pacienteId")
    private Collection<Diagnostico> diagnosticoCollection;

    public Expediente() {
    }

    public Expediente(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Integer getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }

    public String getPacientePApellido() {
        return pacientePApellido;
    }

    public void setPacientePApellido(String pacientePApellido) {
        this.pacientePApellido = pacientePApellido;
    }

    public String getPacienteSApellido() {
        return pacienteSApellido;
    }

    public void setPacienteSApellido(String pacienteSApellido) {
        this.pacienteSApellido = pacienteSApellido;
    }

    public String getPacienteCurp() {
        return pacienteCurp;
    }

    public void setPacienteCurp(String pacienteCurp) {
        this.pacienteCurp = pacienteCurp;
    }

    public String getPacienteRFC() {
        return pacienteRFC;
    }

    public void setPacienteRFC(String pacienteRFC) {
        this.pacienteRFC = pacienteRFC;
    }

    public String getPacienteEmail() {
        return pacienteEmail;
    }

    public void setPacienteEmail(String pacienteEmail) {
        this.pacienteEmail = pacienteEmail;
    }

    public Date getPacienteFNacimiento() {
        return pacienteFNacimiento;
    }

    public void setPacienteFNacimiento(Date pacienteFNacimiento) {
        this.pacienteFNacimiento = pacienteFNacimiento;
    }

    public Character getPacienteSexo() {
        return pacienteSexo;
    }

    public void setPacienteSexo(Character pacienteSexo) {
        this.pacienteSexo = pacienteSexo;
    }

    public String getPacienteECivil() {
        return pacienteECivil;
    }

    public void setPacienteECivil(String pacienteECivil) {
        this.pacienteECivil = pacienteECivil;
    }

    public String getPacienteTelCel() {
        return pacienteTelCel;
    }

    public void setPacienteTelCel(String pacienteTelCel) {
        this.pacienteTelCel = pacienteTelCel;
    }

    public String getPacienteTelFijo() {
        return pacienteTelFijo;
    }

    public void setPacienteTelFijo(String pacienteTelFijo) {
        this.pacienteTelFijo = pacienteTelFijo;
    }

    public String getPacienteLNacimiento() {
        return pacienteLNacimiento;
    }

    public void setPacienteLNacimiento(String pacienteLNacimiento) {
        this.pacienteLNacimiento = pacienteLNacimiento;
    }

    public String getPacienteRadica() {
        return pacienteRadica;
    }

    public void setPacienteRadica(String pacienteRadica) {
        this.pacienteRadica = pacienteRadica;
    }

    public Date getExpedienteFecAlta() {
        return expedienteFecAlta;
    }

    public void setExpedienteFecAlta(Date expedienteFecAlta) {
        this.expedienteFecAlta = expedienteFecAlta;
    }

    @XmlTransient
    public Collection<Diagnostico> getDiagnosticoCollection() {
        return diagnosticoCollection;
    }

    public void setDiagnosticoCollection(Collection<Diagnostico> diagnosticoCollection) {
        this.diagnosticoCollection = diagnosticoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacienteId != null ? pacienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.pacienteId == null && other.pacienteId != null) || (this.pacienteId != null && !this.pacienteId.equals(other.pacienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.Expediente[ pacienteId=" + pacienteId + " ]";
    }
    
}
