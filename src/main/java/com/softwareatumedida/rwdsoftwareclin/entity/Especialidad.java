/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a
 */
@Entity
@Table(name = "especialidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e")
    , @NamedQuery(name = "Especialidad.findByUsuarioUsr", query = "SELECT e FROM Especialidad e WHERE e.especialidadPK.usuarioUsr = :usuarioUsr")
    , @NamedQuery(name = "Especialidad.findByEspecialidadId", query = "SELECT e FROM Especialidad e WHERE e.especialidadPK.especialidadId = :especialidadId")
    , @NamedQuery(name = "Especialidad.findByEspecialidadCedula", query = "SELECT e FROM Especialidad e WHERE e.especialidadCedula = :especialidadCedula")
    , @NamedQuery(name = "Especialidad.findByEspecialidadInstitucion", query = "SELECT e FROM Especialidad e WHERE e.especialidadInstitucion = :especialidadInstitucion")
    , @NamedQuery(name = "Especialidad.findByEspecialidadInsDomicilio", query = "SELECT e FROM Especialidad e WHERE e.especialidadInsDomicilio = :especialidadInsDomicilio")
    , @NamedQuery(name = "Especialidad.findByEspecialidadInsTelefono", query = "SELECT e FROM Especialidad e WHERE e.especialidadInsTelefono = :especialidadInsTelefono")})
public class Especialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EspecialidadPK especialidadPK;
    @Size(max = 45)
    @Column(name = "EspecialidadCedula")
    private String especialidadCedula;
    @Size(max = 100)
    @Column(name = "EspecialidadInstitucion")
    private String especialidadInstitucion;
    @Size(max = 100)
    @Column(name = "EspecialidadInsDomicilio")
    private String especialidadInsDomicilio;
    @Size(max = 45)
    @Column(name = "EspecialidadInsTelefono")
    private String especialidadInsTelefono;
    @JoinColumn(name = "CEspecialidadId", referencedColumnName = "CEspecialidadId")
    @ManyToOne
    private CEspecialidad cEspecialidadId;
    @JoinColumn(name = "UsuarioUsr", referencedColumnName = "UsuarioUsr", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personal personal;

    public Especialidad() {
    }

    public Especialidad(EspecialidadPK especialidadPK) {
        this.especialidadPK = especialidadPK;
    }

    public Especialidad(String usuarioUsr, String especialidadId) {
        this.especialidadPK = new EspecialidadPK(usuarioUsr, especialidadId);
    }

    public EspecialidadPK getEspecialidadPK() {
        return especialidadPK;
    }

    public void setEspecialidadPK(EspecialidadPK especialidadPK) {
        this.especialidadPK = especialidadPK;
    }

    public String getEspecialidadCedula() {
        return especialidadCedula;
    }

    public void setEspecialidadCedula(String especialidadCedula) {
        this.especialidadCedula = especialidadCedula;
    }

    public String getEspecialidadInstitucion() {
        return especialidadInstitucion;
    }

    public void setEspecialidadInstitucion(String especialidadInstitucion) {
        this.especialidadInstitucion = especialidadInstitucion;
    }

    public String getEspecialidadInsDomicilio() {
        return especialidadInsDomicilio;
    }

    public void setEspecialidadInsDomicilio(String especialidadInsDomicilio) {
        this.especialidadInsDomicilio = especialidadInsDomicilio;
    }

    public String getEspecialidadInsTelefono() {
        return especialidadInsTelefono;
    }

    public void setEspecialidadInsTelefono(String especialidadInsTelefono) {
        this.especialidadInsTelefono = especialidadInsTelefono;
    }

    public CEspecialidad getCEspecialidadId() {
        return cEspecialidadId;
    }

    public void setCEspecialidadId(CEspecialidad cEspecialidadId) {
        this.cEspecialidadId = cEspecialidadId;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especialidadPK != null ? especialidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidad)) {
            return false;
        }
        Especialidad other = (Especialidad) object;
        if ((this.especialidadPK == null && other.especialidadPK != null) || (this.especialidadPK != null && !this.especialidadPK.equals(other.especialidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.Especialidad[ especialidadPK=" + especialidadPK + " ]";
    }
    
}
