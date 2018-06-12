package it.clinic.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.clinic.facade.AdministratorFacade;
import it.clinic.model.Administrator;



@ManagedBean
@SessionScoped
public class AdministratorController {
	
	
	private Long id;
	private String name;
	private String surname;
	private String username;
	private String pwd;
	private Administrator administrator;
	private List<Administrator> administrators;
	private String loginErr;
	
	@EJB(beanName="aFacade")
	private AdministratorFacade administratorFacade;
	
	public String createAdministrator(){
		String nextPage = "/faces/successNewAdministrator";
		try{
			this.administrator = administratorFacade.createAdministrator(username, name, surname, pwd); 
		} catch (EJBTransactionRolledbackException e){ //DMBS ha già un amministratore con lo stesso username
			nextPage = "/faces/errorNewAdministrator";
			this.administrator = new Administrator(username, name, surname, pwd);
		}
		return nextPage;
	}
	
	public String verifyLogin() {
		if (this.administrator!=null)
			return "./admin.jsp";
		else
			return "./loginAdmin.jsp";
	}
	
	public String validate(){
		try {
			this.administrator = administratorFacade.validate(username, pwd);
		}catch (EJBException e) {
			this.loginErr = "Username o password errati";
			return "/faces/loginAdmin.jsp";
		} 
		return "/faces/admin.jsp";
	}
	
	public String logout() {
		this.administrator = null;
		return "./index.jsp";
	}
	
	
	//metodi setters e getters
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Administrator getAdministrator() {
		return administrator;
	}
	
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	
	public List<Administrator> getAdministrators() {
		return administrators;
	}
	
	public void setAdministrators(List<Administrator> administrators) {
		this.administrators = administrators;
	}
	
	public String getLoginErr() {
		return loginErr;
	}
	
	public void setLoginErr(String loginErr) {
		this.loginErr = loginErr;
	}

}

