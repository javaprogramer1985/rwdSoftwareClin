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
@Table(name = "c_especialidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CEspecialidad.findAll", query = "SELECT c FROM CEspecialidad c")
    , @NamedQuery(name = "CEspecialidad.findByCEspecialidadId", query = "SELECT c FROM CEspecialidad c WHERE c.cEspecialidadId = :cEspecialidadId")
    , @NamedQuery(name = "CEspecialidad.findByCEspecialidadIdDes", query = "SELECT c FROM CEspecialidad c WHERE c.cEspecialidadIdDes = :cEspecialidadIdDes")})
public class CEspecialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEspecialidadId")
    private Integer cEspecialidadId;
    @Size(max = 100)
    @Column(name = "CEspecialidadIdDes")
    private String cEspecialidadIdDes;
    @OneToMany(mappedBy = "cEspecialidadId")
    private Collection<Especialidad> especialidadCollection;

    public CEspecialidad() {
    }

    public CEspecialidad(Integer cEspecialidadId) {
        this.cEspecialidadId = cEspecialidadId;
    }

    public Integer getCEspecialidadId() {
        return cEspecialidadId;
    }

    public void setCEspecialidadId(Integer cEspecialidadId) {
        this.cEspecialidadId = cEspecialidadId;
    }

    public String getCEspecialidadIdDes() {
        return cEspecialidadIdDes;
    }

    public void setCEspecialidadIdDes(String cEspecialidadIdDes) {
        this.cEspecialidadIdDes = cEspecialidadIdDes;
    }

    @XmlTransient
    public Collection<Especialidad> getEspecialidadCollection() {
        return especialidadCollection;
    }

    public void setEspecialidadCollection(Collection<Especialidad> especialidadCollection) {
        this.especialidadCollection = especialidadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cEspecialidadId != null ? cEspecialidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CEspecialidad)) {
            return false;
        }
        CEspecialidad other = (CEspecialidad) object;
        if ((this.cEspecialidadId == null && other.cEspecialidadId != null) || (this.cEspecialidadId != null && !this.cEspecialidadId.equals(other.cEspecialidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.CEspecialidad[ cEspecialidadId=" + cEspecialidadId + " ]";
    }
    
}
