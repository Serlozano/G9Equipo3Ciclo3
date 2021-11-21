package com.equipo6.misiontic2022.tiendasgenericas.ekotiendas.model;

public class Cliente {
	
	private String id;
	private Integer cedula;
	private String nombrecliente;
	private String direccion;
	private String telefono;
	private String correoelectronico;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(Integer cedula, String nombrecliente, String direccion, String telefono, String correoelectronico) {
		super();
		this.cedula = cedula;
		this.nombrecliente = nombrecliente;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoelectronico = correoelectronico;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public String getNombrecliente() {
		return nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoelectronico() {
		return correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}

	
	
	
}
