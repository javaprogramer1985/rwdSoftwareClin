/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "receta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receta.findAll", query = "SELECT r FROM Receta r")
    , @NamedQuery(name = "Receta.findByRecetaId", query = "SELECT r FROM Receta r WHERE r.recetaId = :recetaId")
    , @NamedQuery(name = "Receta.findByRecetaFecExpedicion", query = "SELECT r FROM Receta r WHERE r.recetaFecExpedicion = :recetaFecExpedicion")
    , @NamedQuery(name = "Receta.findByRecetaTa", query = "SELECT r FROM Receta r WHERE r.recetaTa = :recetaTa")
    , @NamedQuery(name = "Receta.findByRecetaPeso", query = "SELECT r FROM Receta r WHERE r.recetaPeso = :recetaPeso")
    , @NamedQuery(name = "Receta.findByRecetaTalla", query = "SELECT r FROM Receta r WHERE r.recetaTalla = :recetaTalla")
    , @NamedQuery(name = "Receta.findByRecetaImc", query = "SELECT r FROM Receta r WHERE r.recetaImc = :recetaImc")})
public class Receta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RecetaId")
    private Integer recetaId;
    @Column(name = "RecetaFecExpedicion")
    @Temporal(TemporalType.DATE)
    private Date recetaFecExpedicion;
    @Size(max = 45)
    @Column(name = "RecetaTa")
    private String recetaTa;
    @Size(max = 45)
    @Column(name = "RecetaPeso")
    private String recetaPeso;
    @Size(max = 45)
    @Column(name = "RecetaTalla")
    private String recetaTalla;
    @Size(max = 45)
    @Column(name = "RecetaImc")
    private String recetaImc;
    @JoinColumn(name = "RxId", referencedColumnName = "RxId")
    @ManyToOne
    private Diagnostico rxId;
    @JoinColumn(name = "UsuarioUsr", referencedColumnName = "UsuarioUsr")
    @ManyToOne
    private Personal usuarioUsr;
    @OneToMany(mappedBy = "recetaId")
    private Collection<Prescripcion> prescripcionCollection;

    public Receta() {      
        recetaFecExpedicion = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    }

    public Receta(Integer recetaId) {
        this.recetaId = recetaId;
    }

    public Integer getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(Integer recetaId) {
        this.recetaId = recetaId;
    }

    public Date getRecetaFecExpedicion() {
        return recetaFecExpedicion;
    }

    public void setRecetaFecExpedicion(Date recetaFecExpedicion) {
        this.recetaFecExpedicion = recetaFecExpedicion;
    }

    public String getRecetaTa() {
        return recetaTa;
    }

    public void setRecetaTa(String recetaTa) {
        this.recetaTa = recetaTa;
    }

    public String getRecetaPeso() {
        return recetaPeso;
    }

    public void setRecetaPeso(String recetaPeso) {
        this.recetaPeso = recetaPeso;
    }

    public String getRecetaTalla() {
        return recetaTalla;
    }

    public void setRecetaTalla(String recetaTalla) {
        this.recetaTalla = recetaTalla;
    }

    public String getRecetaImc() {
        return recetaImc;
    }

    public void setRecetaImc(String recetaImc) {
        this.recetaImc = recetaImc;
    }

    public Diagnostico getRxId() {
        return rxId;
    }

    public void setRxId(Diagnostico rxId) {
        this.rxId = rxId;
    }

    public Personal getUsuarioUsr() {
        return usuarioUsr;
    }

    public void setUsuarioUsr(Personal usuarioUsr) {
        this.usuarioUsr = usuarioUsr;
    }

    @XmlTransient
    public Collection<Prescripcion> getPrescripcionCollection() {
        return prescripcionCollection;
    }

    public void setPrescripcionCollection(Collection<Prescripcion> prescripcionCollection) {
        this.prescripcionCollection = prescripcionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recetaId != null ? recetaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receta)) {
            return false;
        }
        Receta other = (Receta) object;
        if ((this.recetaId == null && other.recetaId != null) || (this.recetaId != null && !this.recetaId.equals(other.recetaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.Receta[ recetaId=" + recetaId + " ]";
    }
    
}
