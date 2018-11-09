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
@Table(name = "c_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CEstado.findAll", query = "SELECT c FROM CEstado c")
    , @NamedQuery(name = "CEstado.findByCEstadoId", query = "SELECT c FROM CEstado c WHERE c.cEstadoId = :cEstadoId")
    , @NamedQuery(name = "CEstado.findByCEstadoDes", query = "SELECT c FROM CEstado c WHERE c.cEstadoDes = :cEstadoDes")})
public class CEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEstadoId")
    private Integer cEstadoId;
    @Size(max = 45)
    @Column(name = "CEstadoDes")
    private String cEstadoDes;
    @OneToMany(mappedBy = "cEstadoId")
    private Collection<Diagnostico> diagnosticoCollection;

    public CEstado() {
    }

    public CEstado(Integer cEstadoId) {
        this.cEstadoId = cEstadoId;
    }

    public Integer getCEstadoId() {
        return cEstadoId;
    }

    public void setCEstadoId(Integer cEstadoId) {
        this.cEstadoId = cEstadoId;
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
        hash += (cEstadoId != null ? cEstadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CEstado)) {
            return false;
        }
        CEstado other = (CEstado) object;
        if ((this.cEstadoId == null && other.cEstadoId != null) || (this.cEstadoId != null && !this.cEstadoId.equals(other.cEstadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.CEstado[ cEstadoId=" + cEstadoId + " ]";
    }
    
}
