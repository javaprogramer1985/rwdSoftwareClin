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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "prescripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescripcion.findAll", query = "SELECT p FROM Prescripcion p")
    , @NamedQuery(name = "Prescripcion.findByPrescripcionId", query = "SELECT p FROM Prescripcion p WHERE p.prescripcionId = :prescripcionId")
    , @NamedQuery(name = "Prescripcion.findByPrescripcionMedicamento", query = "SELECT p FROM Prescripcion p WHERE p.prescripcionMedicamento = :prescripcionMedicamento")
    , @NamedQuery(name = "Prescripcion.findByPrescripcionFrecDuracion", query = "SELECT p FROM Prescripcion p WHERE p.prescripcionFrecDuracion = :prescripcionFrecDuracion")
    , @NamedQuery(name = "Prescripcion.findByPrescripcionInstrucciones", query = "SELECT p FROM Prescripcion p WHERE p.prescripcionInstrucciones = :prescripcionInstrucciones")})
public class Prescripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrescripcionId")
    private Integer prescripcionId;
    @Size(max = 100)
    @Column(name = "PrescripcionMedicamento")
    private String prescripcionMedicamento;
    @Size(max = 100)
    @Column(name = "PrescripcionFrecDuracion")
    private String prescripcionFrecDuracion;
    @Size(max = 250)
    @Column(name = "PrescripcionInstrucciones")
    private String prescripcionInstrucciones;
    @JoinColumn(name = "RecetaId", referencedColumnName = "RecetaId")
    @ManyToOne
    private Receta recetaId;

    public Prescripcion() {
    }

    public Prescripcion(Integer prescripcionId) {
        this.prescripcionId = prescripcionId;
    }

    public Integer getPrescripcionId() {
        return prescripcionId;
    }

    public void setPrescripcionId(Integer prescripcionId) {
        this.prescripcionId = prescripcionId;
    }

    public String getPrescripcionMedicamento() {
        return prescripcionMedicamento;
    }

    public void setPrescripcionMedicamento(String prescripcionMedicamento) {
        this.prescripcionMedicamento = prescripcionMedicamento;
    }

    public String getPrescripcionFrecDuracion() {
        return prescripcionFrecDuracion;
    }

    public void setPrescripcionFrecDuracion(String prescripcionFrecDuracion) {
        this.prescripcionFrecDuracion = prescripcionFrecDuracion;
    }

    public String getPrescripcionInstrucciones() {
        return prescripcionInstrucciones;
    }

    public void setPrescripcionInstrucciones(String prescripcionInstrucciones) {
        this.prescripcionInstrucciones = prescripcionInstrucciones;
    }

    public Receta getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(Receta recetaId) {
        this.recetaId = recetaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prescripcionId != null ? prescripcionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescripcion)) {
            return false;
        }
        Prescripcion other = (Prescripcion) object;
        if ((this.prescripcionId == null && other.prescripcionId != null) || (this.prescripcionId != null && !this.prescripcionId.equals(other.prescripcionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.Prescripcion[ prescripcionId=" + prescripcionId + " ]";
    }
    
}
