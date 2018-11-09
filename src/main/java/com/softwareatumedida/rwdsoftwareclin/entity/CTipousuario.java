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
@Table(name = "c_tipousuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTipousuario.findAll", query = "SELECT c FROM CTipousuario c")
    , @NamedQuery(name = "CTipousuario.findByCTusuarioId", query = "SELECT c FROM CTipousuario c WHERE c.cTusuarioId = :cTusuarioId")
    , @NamedQuery(name = "CTipousuario.findByCTusuarioDes", query = "SELECT c FROM CTipousuario c WHERE c.cTusuarioDes = :cTusuarioDes")})
public class CTipousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTusuarioId")
    private Integer cTusuarioId;
    @Size(max = 100)
    @Column(name = "CTusuarioDes")
    private String cTusuarioDes;
    @OneToMany(mappedBy = "cTusuarioId")
    private Collection<Personal> personalCollection;

    public CTipousuario() {
    }

    public CTipousuario(Integer cTusuarioId) {
        this.cTusuarioId = cTusuarioId;
    }

    public Integer getCTusuarioId() {
        return cTusuarioId;
    }

    public void setCTusuarioId(Integer cTusuarioId) {
        this.cTusuarioId = cTusuarioId;
    }

    public String getCTusuarioDes() {
        return cTusuarioDes;
    }

    public void setCTusuarioDes(String cTusuarioDes) {
        this.cTusuarioDes = cTusuarioDes;
    }

    @XmlTransient
    public Collection<Personal> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Collection<Personal> personalCollection) {
        this.personalCollection = personalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTusuarioId != null ? cTusuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTipousuario)) {
            return false;
        }
        CTipousuario other = (CTipousuario) object;
        if ((this.cTusuarioId == null && other.cTusuarioId != null) || (this.cTusuarioId != null && !this.cTusuarioId.equals(other.cTusuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.CTipousuario[ cTusuarioId=" + cTusuarioId + " ]";
    }
    
}
