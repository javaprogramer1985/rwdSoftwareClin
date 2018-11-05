/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.rwdsoftwareclin.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@ManagedBean
@RequestScoped
public class LoginBean implements Serializable{
  @Size(min=4, max=10)
  @NotEmpty
  private String username;
 
  @Size(min=4, max=10)
  @NotEmpty
  private String password;
 
 
  public void setUsername(String name) {
    this.username = name;
  }
 
  public String getUsername() {
    return username;
  }
 
 
  public String getPassword() {
    return password;
  }
 
 
  public void setPassword(String password) {
    this.password = password;
  }
 
  public void login() {
    if ("BootsFaces".equalsIgnoreCase(username) && "rocks!".equalsIgnoreCase(password)) {
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Congratulations! You've successfully logged in.");
      FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
 
    } else {
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "That's the wrong password. Hint: BootsFaces rocks!");
      FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
    }
  }
 
  public void forgotPassword() {
    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default user name: BootsFaces");
    FacesContext.getCurrentInstance().addMessage("loginForm:username", msg);
    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default password: rocks!");
    FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
  }
}