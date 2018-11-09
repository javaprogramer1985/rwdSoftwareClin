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
@Table(name = "c_tipoingreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTipoingreso.findAll", query = "SELECT c FROM CTipoingreso c")
    , @NamedQuery(name = "CTipoingreso.findByCTipoIngresoId", query = "SELECT c FROM CTipoingreso c WHERE c.cTipoIngresoId = :cTipoIngresoId")
    , @NamedQuery(name = "CTipoingreso.findByCTipoIngresoDes", query = "SELECT c FROM CTipoingreso c WHERE c.cTipoIngresoDes = :cTipoIngresoDes")})
public class CTipoingreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTipoIngresoId")
    private Integer cTipoIngresoId;
    @Size(max = 100)
    @Column(name = "CTipoIngresoDes")
    private String cTipoIngresoDes;
    @OneToMany(mappedBy = "cTipoIngresoId")
    private Collection<Diagnostico> diagnosticoCollection;

    public CTipoingreso() {
    }

    public CTipoingreso(Integer cTipoIngresoId) {
        this.cTipoIngresoId = cTipoIngresoId;
    }

    public Integer getCTipoIngresoId() {
        return cTipoIngresoId;
    }

    public void setCTipoIngresoId(Integer cTipoIngresoId) {
        this.cTipoIngresoId = cTipoIngresoId;
    }

    public String getCTipoIngresoDes() {
        return cTipoIngresoDes;
    }

    public void setCTipoIngresoDes(String cTipoIngresoDes) {
        this.cTipoIngresoDes = cTipoIngresoDes;
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
        hash += (cTipoIngresoId != null ? cTipoIngresoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTipoingreso)) {
            return false;
        }
        CTipoingreso other = (CTipoingreso) object;
        if ((this.cTipoIngresoId == null && other.cTipoIngresoId != null) || (this.cTipoIngresoId != null && !this.cTipoIngresoId.equals(other.cTipoIngresoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.CTipoingreso[ cTipoIngresoId=" + cTipoIngresoId + " ]";
    }
    
}
