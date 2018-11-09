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
import javax.persistence.Lob;
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
@Table(name = "estudio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudio.findAll", query = "SELECT e FROM Estudio e")
    , @NamedQuery(name = "Estudio.findByEstudioId", query = "SELECT e FROM Estudio e WHERE e.estudioId = :estudioId")
    , @NamedQuery(name = "Estudio.findByRxId", query = "SELECT e FROM Estudio e WHERE e.rxId = :rxId")
    , @NamedQuery(name = "Estudio.findByUsuarioUsr", query = "SELECT e FROM Estudio e WHERE e.usuarioUsr = :usuarioUsr")
    , @NamedQuery(name = "Estudio.findByCTipoEstudioId", query = "SELECT e FROM Estudio e WHERE e.cTipoEstudioId = :cTipoEstudioId")
    , @NamedQuery(name = "Estudio.findByEstudioDescripcion", query = "SELECT e FROM Estudio e WHERE e.estudioDescripcion = :estudioDescripcion")})
public class Estudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EstudioId")
    private Integer estudioId;
    @Column(name = "RxId")
    private Integer rxId;
    @Column(name = "UsuarioUsr")
    private Integer usuarioUsr;
    @Column(name = "CTipoEstudioId")
    private Integer cTipoEstudioId;
    @Size(max = 100)
    @Column(name = "EstudioDescripcion")
    private String estudioDescripcion;
    @Lob
    @Column(name = "EstudioImagen")
    private byte[] estudioImagen;

    public Estudio() {
    }

    public Estudio(Integer estudioId) {
        this.estudioId = estudioId;
    }

    public Integer getEstudioId() {
        return estudioId;
    }

    public void setEstudioId(Integer estudioId) {
        this.estudioId = estudioId;
    }

    public Integer getRxId() {
        return rxId;
    }

    public void setRxId(Integer rxId) {
        this.rxId = rxId;
    }

    public Integer getUsuarioUsr() {
        return usuarioUsr;
    }

    public void setUsuarioUsr(Integer usuarioUsr) {
        this.usuarioUsr = usuarioUsr;
    }

    public Integer getCTipoEstudioId() {
        return cTipoEstudioId;
    }

    public void setCTipoEstudioId(Integer cTipoEstudioId) {
        this.cTipoEstudioId = cTipoEstudioId;
    }

    public String getEstudioDescripcion() {
        return estudioDescripcion;
    }

    public void setEstudioDescripcion(String estudioDescripcion) {
        this.estudioDescripcion = estudioDescripcion;
    }

    public byte[] getEstudioImagen() {
        return estudioImagen;
    }

    public void setEstudioImagen(byte[] estudioImagen) {
        this.estudioImagen = estudioImagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudioId != null ? estudioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudio)) {
            return false;
        }
        Estudio other = (Estudio) object;
        if ((this.estudioId == null && other.estudioId != null) || (this.estudioId != null && !this.estudioId.equals(other.estudioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.Estudio[ estudioId=" + estudioId + " ]";
    }
    
}
