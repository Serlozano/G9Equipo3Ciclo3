package com.grupo9.misiontic2022.tiendasadi.DTO;

import java.io.Serializable;

//todas las clases entidad deben ser serializables, y deben estar encapsuladas
public class ClienteVO implements Serializable{

	//identificador unico de las clases entidad
		private static final long serialVersionUID = 1L;
		
		private Integer cedula_cliente;
		private String email_cliente;
		private String nombre_cliente;
		private String password;
		private String cliente;
		
		
		/**
		 * Metodo que permite ver el valor de la cedula
		 * @return the cedula_cliente
		 */
		public Integer getCedula_cliente() {
			return cedula_cliente;
		}
		/**
		 * Metodo que permite el cambio de la cedula
		 * @param cedula_cliente the cedula_cliente to set
		 */
		public void setCedula_cliente(Integer cedula_cliente) {
			this.cedula_cliente = cedula_cliente;
		}
		/**
		 * @return the email_cliente
		 */
		public String getEmail_cliente() {
			return email_cliente;
		}
		/**
		 * @param email_cliente the email_cliente to set
		 */
		public void setEmail_cliente(String email_cliente) {
			this.email_cliente = email_cliente;
		}
		/**
		 * @return the nombre_cliente
		 */
		public String getNombre_cliente() {
			return nombre_cliente;
		}
		/**
		 * @param nombre_usuario the nombre_cliente to set
		 */
		public void setNombre_cliente(String nombre_cliente) {
			this.nombre_cliente = nombre_cliente;
		}
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * @return the cliente
		 */
		public String getCliente() {
			return cliente;
		}
		/**
		 * @param cliente the clienteto set
		 */
		public void setCliente(String cliente) {
			this.cliente = cliente;
		}
		
		
		

	}