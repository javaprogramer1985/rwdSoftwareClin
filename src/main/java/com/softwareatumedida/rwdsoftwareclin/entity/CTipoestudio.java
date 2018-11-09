/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a
 */
@Entity
@Table(name = "c_tipoestudio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTipoestudio.findAll", query = "SELECT c FROM CTipoestudio c")
    , @NamedQuery(name = "CTipoestudio.findByCTipoEstudioId", query = "SELECT c FROM CTipoestudio c WHERE c.cTipoEstudioId = :cTipoEstudioId")
    , @NamedQuery(name = "CTipoestudio.findByCTipoDes", query = "SELECT c FROM CTipoestudio c WHERE c.cTipoDes = :cTipoDes")})
public class CTipoestudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTipoEstudioId")
    private Integer cTipoEstudioId;
    @Size(max = 45)
    @Column(name = "CTipoDes")
    private String cTipoDes;

    public CTipoestudio() {
    }

    public CTipoestudio(Integer cTipoEstudioId) {
        this.cTipoEstudioId = cTipoEstudioId;
    }

    public Integer getCTipoEstudioId() {
        return cTipoEstudioId;
    }

    public void setCTipoEstudioId(Integer cTipoEstudioId) {
        this.cTipoEstudioId = cTipoEstudioId;
    }

    public String getCTipoDes() {
        return cTipoDes;
    }

    public void setCTipoDes(String cTipoDes) {
        this.cTipoDes = cTipoDes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTipoEstudioId != null ? cTipoEstudioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTipoestudio)) {
            return false;
        }
        CTipoestudio other = (CTipoestudio) object;
        if ((this.cTipoEstudioId == null && other.cTipoEstudioId != null) || (this.cTipoEstudioId != null && !this.cTipoEstudioId.equals(other.cTipoEstudioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.CTipoestudio[ cTipoEstudioId=" + cTipoEstudioId + " ]";
    }
    
}
