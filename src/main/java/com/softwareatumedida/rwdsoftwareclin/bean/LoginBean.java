/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.bean;

import com.softwareatumedida.rwdsoftwareclin.ejb.PersonalFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.ejb.UsuariosFacadeLocal;
import com.softwareatumedida.rwdsoftwareclin.entity.Personal;
import com.softwareatumedida.rwdsoftwareclin.entity.Usuarios;
import com.softwareatumedida.rwdsoftwareclin.util.Codificador;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {

    @EJB
    PersonalFacadeLocal usuariosFacadeLocal;
    Personal usuario;

    @PostConstruct
    public void init() {
        usuario = new Personal();
    }
    
    public void login() {
        Codificador cod = new Codificador();
        /*Codificamos la clave para buscarla en la base de datos*/
        String clavecodificada = cod.CODIDECO(usuario.getUsuarioPass(), 1);
        
        System.out.println("Clave Introducida Codificada: " + clavecodificada);
        
        usuario.setUsuarioPass(clavecodificada);
        
        Personal us=null;
        String redireccion=null;
        
        try {            
            us = usuariosFacadeLocal.find(usuario.getUsuarioUsr());
            if (us!=null){
                
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Congratulations! You've successfully logged in.");
                FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);    
                //Almacenar session de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SessionUsuario", us);  
                FacesContext.getCurrentInstance().getExternalContext().redirect("app/principal.softwareatumedida");
                redireccion="/dashboard/principal?faces-redirect=true";
            
            }else{
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "El nombre de usuario o contraseña son incorrectos");
                FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
            }            
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Algun error ocurrio al intentar buscar las credenciales");
            FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
        }
    }

    public void forgotPassword() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default user name: BootsFaces");
        FacesContext.getCurrentInstance().addMessage("loginForm:username", msg);
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default password: rocks!");
        FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
    }

    public Personal getUsuario() {
        return usuario;
    }

    public void setUsuario(Personal usuario) {
        this.usuario = usuario;
    }
    
}
