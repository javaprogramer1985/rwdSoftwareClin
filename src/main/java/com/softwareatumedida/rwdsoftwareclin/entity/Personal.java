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
import javax.persistence.CascadeType;
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
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")
    , @NamedQuery(name = "Personal.findByUsuarioUsr", query = "SELECT p FROM Personal p WHERE p.usuarioUsr = :usuarioUsr")
    , @NamedQuery(name = "Personal.findByUsuarioPass", query = "SELECT p FROM Personal p WHERE p.usuarioPass = :usuarioPass")
    , @NamedQuery(name = "Personal.findByUsuarioNombre", query = "SELECT p FROM Personal p WHERE p.usuarioNombre = :usuarioNombre")
    , @NamedQuery(name = "Personal.findByUsuarioApellido", query = "SELECT p FROM Personal p WHERE p.usuarioApellido = :usuarioApellido")
    , @NamedQuery(name = "Personal.findByUsuarioFecAlta", query = "SELECT p FROM Personal p WHERE p.usuarioFecAlta = :usuarioFecAlta")
    , @NamedQuery(name = "Personal.findByUsuarioEstado", query = "SELECT p FROM Personal p WHERE p.usuarioEstado = :usuarioEstado")
    , @NamedQuery(name = "Personal.findByUsuarioFecBaja", query = "SELECT p FROM Personal p WHERE p.usuarioFecBaja = :usuarioFecBaja")
    , @NamedQuery(name = "Personal.findByUsuarioDomicilio", query = "SELECT p FROM Personal p WHERE p.usuarioDomicilio = :usuarioDomicilio")
    , @NamedQuery(name = "Personal.findByUsuaroEmail", query = "SELECT p FROM Personal p WHERE p.usuaroEmail = :usuaroEmail")
    , @NamedQuery(name = "Personal.findByUsuarioTel1", query = "SELECT p FROM Personal p WHERE p.usuarioTel1 = :usuarioTel1")
    , @NamedQuery(name = "Personal.findByUsuarioTel2", query = "SELECT p FROM Personal p WHERE p.usuarioTel2 = :usuarioTel2")
    , @NamedQuery(name = "Personal.findByUsuarioTel3", query = "SELECT p FROM Personal p WHERE p.usuarioTel3 = :usuarioTel3")
    , @NamedQuery(name = "Personal.findByUsuarioTel4", query = "SELECT p FROM Personal p WHERE p.usuarioTel4 = :usuarioTel4")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UsuarioUsr")
    private String usuarioUsr;
    @Size(max = 100)
    @Column(name = "UsuarioPass")
    private String usuarioPass;
    @Size(max = 100)
    @Column(name = "UsuarioNombre")
    private String usuarioNombre;
    @Size(max = 100)
    @Column(name = "UsuarioApellido")
    private String usuarioApellido;
    @Column(name = "UsuarioFecAlta")
    @Temporal(TemporalType.DATE)
    private Date usuarioFecAlta;
    @Column(name = "UsuarioEstado")
    private Short usuarioEstado;
    @Column(name = "UsuarioFecBaja")
    @Temporal(TemporalType.DATE)
    private Date usuarioFecBaja;
    @Size(max = 100)
    @Column(name = "UsuarioDomicilio")
    private String usuarioDomicilio;
    @Size(max = 100)
    @Column(name = "UsuaroEmail")
    private String usuaroEmail;
    @Size(max = 45)
    @Column(name = "UsuarioTel1")
    private String usuarioTel1;
    @Size(max = 45)
    @Column(name = "UsuarioTel2")
    private String usuarioTel2;
    @Size(max = 45)
    @Column(name = "UsuarioTel3")
    private String usuarioTel3;
    @Size(max = 45)
    @Column(name = "UsuarioTel4")
    private String usuarioTel4;
    @OneToMany(mappedBy = "usuarioUsr")
    private Collection<Receta> recetaCollection;
    @JoinColumn(name = "EmpresaId", referencedColumnName = "EmpresaId")
    @ManyToOne
    private Empresa empresaId;
    @JoinColumn(name = "CTusuarioId", referencedColumnName = "CTusuarioId")
    @ManyToOne
    private CTipousuario cTusuarioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal")
    private Collection<Especialidad> especialidadCollection;
    @OneToMany(mappedBy = "usuarioUsr")
    private Collection<Diagnostico> diagnosticoCollection;

    public Personal() {
    }

    public Personal(String usuarioUsr) {
        this.usuarioUsr = usuarioUsr;
    }

    public String getUsuarioUsr() {
        return usuarioUsr;
    }

    public void setUsuarioUsr(String usuarioUsr) {
        this.usuarioUsr = usuarioUsr;
    }

    public String getUsuarioPass() {
        return usuarioPass;
    }

    public void setUsuarioPass(String usuarioPass) {
        this.usuarioPass = usuarioPass;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioApellido() {
        return usuarioApellido;
    }

    public void setUsuarioApellido(String usuarioApellido) {
        this.usuarioApellido = usuarioApellido;
    }

    public Date getUsuarioFecAlta() {
        return usuarioFecAlta;
    }

    public void setUsuarioFecAlta(Date usuarioFecAlta) {
        this.usuarioFecAlta = usuarioFecAlta;
    }

    public Short getUsuarioEstado() {
        return usuarioEstado;
    }

    public void setUsuarioEstado(Short usuarioEstado) {
        this.usuarioEstado = usuarioEstado;
    }

    public Date getUsuarioFecBaja() {
        return usuarioFecBaja;
    }

    public void setUsuarioFecBaja(Date usuarioFecBaja) {
        this.usuarioFecBaja = usuarioFecBaja;
    }

    public String getUsuarioDomicilio() {
        return usuarioDomicilio;
    }

    public void setUsuarioDomicilio(String usuarioDomicilio) {
        this.usuarioDomicilio = usuarioDomicilio;
    }

    public String getUsuaroEmail() {
        return usuaroEmail;
    }

    public void setUsuaroEmail(String usuaroEmail) {
        this.usuaroEmail = usuaroEmail;
    }

    public String getUsuarioTel1() {
        return usuarioTel1;
    }

    public void setUsuarioTel1(String usuarioTel1) {
        this.usuarioTel1 = usuarioTel1;
    }

    public String getUsuarioTel2() {
        return usuarioTel2;
    }

    public void setUsuarioTel2(String usuarioTel2) {
        this.usuarioTel2 = usuarioTel2;
    }

    public String getUsuarioTel3() {
        return usuarioTel3;
    }

    public void setUsuarioTel3(String usuarioTel3) {
        this.usuarioTel3 = usuarioTel3;
    }

    public String getUsuarioTel4() {
        return usuarioTel4;
    }

    public void setUsuarioTel4(String usuarioTel4) {
        this.usuarioTel4 = usuarioTel4;
    }

    @XmlTransient
    public Collection<Receta> getRecetaCollection() {
        return recetaCollection;
    }

    public void setRecetaCollection(Collection<Receta> recetaCollection) {
        this.recetaCollection = recetaCollection;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    public CTipousuario getCTusuarioId() {
        return cTusuarioId;
    }

    public void setCTusuarioId(CTipousuario cTusuarioId) {
        this.cTusuarioId = cTusuarioId;
    }

    @XmlTransient
    public Collection<Especialidad> getEspecialidadCollection() {
        return especialidadCollection;
    }

    public void setEspecialidadCollection(Collection<Especialidad> especialidadCollection) {
        this.especialidadCollection = especialidadCollection;
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
        hash += (usuarioUsr != null ? usuarioUsr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.usuarioUsr == null && other.usuarioUsr != null) || (this.usuarioUsr != null && !this.usuarioUsr.equals(other.usuarioUsr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.rwdsoftwareclin.entity.Personal[ usuarioUsr=" + usuarioUsr + " ]";
    }
    
}
