/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByEmpresaId", query = "SELECT e FROM Empresa e WHERE e.empresaId = :empresaId")
    , @NamedQuery(name = "Empresa.findByEmpresaNombre", query = "SELECT e FROM Empresa e WHERE e.empresaNombre = :empresaNombre")
    , @NamedQuery(name = "Empresa.findByEmpresaRFC", query = "SELECT e FROM Empresa e WHERE e.empresaRFC = :empresaRFC")
    , @NamedQuery(name = "Empresa.findByEmpresaFecConstitucion", query = "SELECT e FROM Empresa e WHERE e.empresaFecConstitucion = :empresaFecConstitucion")
    , @NamedQuery(name = "Empresa.findByEmpresaDomicilio", query = "SELECT e FROM Empresa e WHERE e.empresaDomicilio = :empresaDomicilio")
    , @NamedQuery(name = "Empresa.findByEmpresaMision", query = "SELECT e FROM Empresa e WHERE e.empresaMision = :empresaMision")
    , @NamedQuery(name = "Empresa.findByEmpresaVision", query = "SELECT e FROM Empresa e WHERE e.empresaVision = :empresaVision")
    , @NamedQuery(name = "Empresa.findByEmpresaEntidadFed", query = "SELECT e FROM Empresa e WHERE e.empresaEntidadFed = :empresaEntidadFed")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmpresaId")
    private Integer empresaId;
    @Size(max = 100)
    @Column(name = "EmpresaNombre")
    private String empresaNombre;
    @Size(max = 45)
    @Column(name = "EmpresaRFC")
    private String empresaRFC;
    @Column(name = "EmpresaFecConstitucion")
    @Temporal(TemporalType.DATE)
    private Date empresaFecConstitucion;
    @Size(max = 100)
    @Column(name = "EmpresaDomicilio")
    private String empresaDomicilio;
    @Size(max = 200)
    @Column(name = "EmpresaMision")
    private String empresaMision;
    @Size(max = 200)
    @Column(name = "EmpresaVision")
    private String empresaVision;
    @Size(max = 100)
    @Column(name = "EmpresaEntidadFed")
    private String empresaEntidadFed;
    @OneToMany(mappedBy = "empresaId")
    private Collection<Personal> personalCollection;

    public Empresa() {
    }

    public Empresa(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public String getEmpresaNombre() {
        return empresaNombre;
    }

    public void setEmpresaNombre(String empresaNombre) {
        this.empresaNombre = empresaNombre;
    }

    public String getEmpresaRFC() {
        return empresaRFC;
    }

    public void setEmpresaRFC(String empresaRFC) {
        this.empresaRFC = empresaRFC;
    }

    public Date getEmpresaFecConstitucion() {
        return empresaFecConstitucion;
    }

    public void setEmpresaFecConstitucion(Date empresaFecConstitucion) {
        this.empresaFecConstitucion = empresaFecConstitucion;
    }

    public String getEmpresaDomicilio() {
        return empresaDomicilio;
    }

    public void setEmpresaDomicilio(String empresaDomicilio) {
        this.empresaDomicilio = empresaDomicilio;
    }

    public String getEmpresaMision() {
        return empresaMision;
    }

    public void setEmpresaMision(String empresaMision) {
        this.empresaMision = empresaMision;
    }

    public String getEmpresaVision() {
        return empresaVision;
    }

    public void setEmpresaVision(String empresaVision) {
        this.empresaVision = empresaVision;
    }

    public String getEmpresaEntidadFed() {
        return empresaEntidadFed;
    }

    public void setEmpresaEntidadFed(String empresaEntidadFed) {
        this.empresaEntidadFed = empresaEntidadFed;
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
        hash += (empresaId != null ? empresaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.empresaId == null && other.empresaId != null) || (this.empresaId != null && !this.empresaId.equals(other.empresaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.Empresa[ empresaId=" + empresaId + " ]";
    }
    
}
