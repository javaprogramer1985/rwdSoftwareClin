/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author a
 */
@Embeddable
public class EspecialidadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UsuarioUsr")
    private String usuarioUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EspecialidadId")
    private String especialidadId;

    public EspecialidadPK() {
    }

    public EspecialidadPK(String usuarioUsr, String especialidadId) {
        this.usuarioUsr = usuarioUsr;
        this.especialidadId = especialidadId;
    }

    public String getUsuarioUsr() {
        return usuarioUsr;
    }

    public void setUsuarioUsr(String usuarioUsr) {
        this.usuarioUsr = usuarioUsr;
    }

    public String getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(String especialidadId) {
        this.especialidadId = especialidadId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioUsr != null ? usuarioUsr.hashCode() : 0);
        hash += (especialidadId != null ? especialidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecialidadPK)) {
            return false;
        }
        EspecialidadPK other = (EspecialidadPK) object;
        if ((this.usuarioUsr == null && other.usuarioUsr != null) || (this.usuarioUsr != null && !this.usuarioUsr.equals(other.usuarioUsr))) {
            return false;
        }
        if ((this.especialidadId == null && other.especialidadId != null) || (this.especialidadId != null && !this.especialidadId.equals(other.especialidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.EspecialidadPK[ usuarioUsr=" + usuarioUsr + ", especialidadId=" + especialidadId + " ]";
    }
    
}
