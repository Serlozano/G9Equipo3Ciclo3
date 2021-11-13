package com.equipo6.misiontic2022.tiendasgenericas.ekotiendas.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "usuarios")
public class Usuario {
	@Id
	private String id;
	
	private String username;
	private String password;
	private String nombrecompleto;
	private String emailusuario;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	


	public Usuario(String username, String password, String nombrecompleto, String emailusuario) {
		super();
		this.username = username;
		this.password = password;
		this.nombrecompleto = nombrecompleto;
		this.emailusuario = emailusuario;
	}





	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	public String getEmailusuario() {
		return emailusuario;
	}
	public void setEmailusuario(String emailusuario) {
		this.emailusuario = emailusuario;
	}
	
}