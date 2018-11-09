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
@Table(name = "c_prioridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPrioridad.findAll", query = "SELECT c FROM CPrioridad c")
    , @NamedQuery(name = "CPrioridad.findByCPrioridadId", query = "SELECT c FROM CPrioridad c WHERE c.cPrioridadId = :cPrioridadId")
    , @NamedQuery(name = "CPrioridad.findByCPrioridadDes", query = "SELECT c FROM CPrioridad c WHERE c.cPrioridadDes = :cPrioridadDes")})
public class CPrioridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CPrioridadId")
    private Integer cPrioridadId;
    @Size(max = 100)
    @Column(name = "CPrioridadDes")
    private String cPrioridadDes;
    @OneToMany(mappedBy = "cPrioridadId")
    private Collection<Diagnostico> diagnosticoCollection;

    public CPrioridad() {
    }

    public CPrioridad(Integer cPrioridadId) {
        this.cPrioridadId = cPrioridadId;
    }

    public Integer getCPrioridadId() {
        return cPrioridadId;
    }

    public void setCPrioridadId(Integer cPrioridadId) {
        this.cPrioridadId = cPrioridadId;
    }

    public String getCPrioridadDes() {
        return cPrioridadDes;
    }

    public void setCPrioridadDes(String cPrioridadDes) {
        this.cPrioridadDes = cPrioridadDes;
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
        hash += (cPrioridadId != null ? cPrioridadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPrioridad)) {
            return false;
        }
        CPrioridad other = (CPrioridad) object;
        if ((this.cPrioridadId == null && other.cPrioridadId != null) || (this.cPrioridadId != null && !this.cPrioridadId.equals(other.cPrioridadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.CPrioridad[ cPrioridadId=" + cPrioridadId + " ]";
    }
    
}
