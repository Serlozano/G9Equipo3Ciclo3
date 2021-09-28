package com.grupo9.misiontic2022.tiendasadi.DTO;

import java.io.Serializable;

//todas las clases entidad deben ser serializables, y deben estar encapsuladas
public class ProveedorVO implements Serializable {

	//identificador unico de las clases entidad
			private static final long serialVersionUID = 1L;
			
			private Integer nit_proveedor;
			private String ciudad_proveedor;
			private String nombre_proveedor;
			private String direccion_proveedor;
			private String telefono_proveedor;
			
			
			/**
			 * Metodo que permite ver el valor del nit
			 * @return the cedula_cliente
			 */
			public Integer getNit_proveedor() {
				return nit_proveedor;
			}
			/**
			 * Metodo que permite el cambio del nit
			 * @param nit_proveedor the nit_proveedor to set
			 */
			public void setNit_proveedor(Integer nit_proveedor) {
				this.nit_proveedor = nit_proveedor;
			}
			/**
			 * @return the ciudad_proveedor
			 */
			public String getCiudad_proveedor() {
				return ciudad_proveedor;
			}
			/**
			 * @param ciudad_proveedor the ciudad_proveedor to set
			 */
			public void setCiudad_proveedor(String ciudad_proveedor) {
				this.ciudad_proveedor = ciudad_proveedor;
			}
			/**
			 * @return the nombre_proveedor
			 */
			public String getNombre_proveedor() {
				return nombre_proveedor;
			}
			/**
			 * @param nombre_proveedor the nombre_proveedor to set
			 */
			public void setNombre_proveedor(String nombre_proveedor) {
				this.nombre_proveedor = nombre_proveedor;
			}
			/**
			 * @return the nombre
			 */
			public String getTelefono_proveedor() {
				return telefono_proveedor;
			}
			/**
			 * @param telefono the telefono to set
			 */
			public void setTelefono_proveedor(String telefono_proveedor) {
				this.telefono_proveedor = telefono_proveedor;
			}
			/**
			 * @return the telefono
			 */
			public String getDireccion_proveedor() {
				return direccion_proveedor;
			}
			/**
			 * @param direccion the direccion  to set
			 */
			public void setDireccion_proveedor(String direccion_proveedor) {
				this.direccion_proveedor = direccion_proveedor;
			}
			
			
			

		}