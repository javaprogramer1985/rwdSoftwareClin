/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a
 */
@Entity
@Table(name = "c_estadopaciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CEstadopaciente.findAll", query = "SELECT c FROM CEstadopaciente c")
    , @NamedQuery(name = "CEstadopaciente.findByCEstadoPacienteId", query = "SELECT c FROM CEstadopaciente c WHERE c.cEstadoPacienteId = :cEstadoPacienteId")
    , @NamedQuery(name = "CEstadopaciente.findByCEstadoDes", query = "SELECT c FROM CEstadopaciente c WHERE c.cEstadoDes = :cEstadoDes")})
public class CEstadopaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEstadoPacienteId")
    private Integer cEstadoPacienteId;
    @Size(max = 45)
    @Column(name = "CEstadoDes")
    private String cEstadoDes;
    @OneToMany(mappedBy = "cEstadoPacienteId")
    private Collection<Diagnostico> diagnosticoCollection;

    public CEstadopaciente() {
    }

    public CEstadopaciente(Integer cEstadoPacienteId) {
        this.cEstadoPacienteId = cEstadoPacienteId;
    }

    public Integer getCEstadoPacienteId() {
        return cEstadoPacienteId;
    }

    public void setCEstadoPacienteId(Integer cEstadoPacienteId) {
        this.cEstadoPacienteId = cEstadoPacienteId;
    }

    public String getCEstadoDes() {
        return cEstadoDes;
    }

    public void setCEstadoDes(String cEstadoDes) {
        this.cEstadoDes = cEstadoDes;
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
        hash += (cEstadoPacienteId != null ? cEstadoPacienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CEstadopaciente)) {
            return false;
        }
        CEstadopaciente other = (CEstadopaciente) object;
        if ((this.cEstadoPacienteId == null && other.cEstadoPacienteId != null) || (this.cEstadoPacienteId != null && !this.cEstadoPacienteId.equals(other.cEstadoPacienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.CEstadopaciente[ cEstadoPacienteId=" + cEstadoPacienteId + " ]";
    }
    
}
