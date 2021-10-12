package com.grupo9.misiontic2022.tiendasadi.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.grupo9.misiontic2022.tiendasadi.DTO.VentaVO;

public class VentaDAO {
	public void registrarVenta(VentaVO vent) {
		//llama y crea una instancia de la clase encargada de hacer la conexión
		Conexion conex = new Conexion();

		try {
			//sentencia que se ejecutara en la base de datos
			Statement estatuto = conex.getConnection().createStatement();
			
			//String que contiene la sentencia insert a ejecutar
			String sentencia = "INSERT INTO ventas VALUES(" 
					+ vent.getCodigo_venta() + "," 
					+ vent.getCedula_cliente() + ","
					+ vent.getCedula_usuario() + ",'" 
					+ vent.getIvaventa()+ "'," 
					+ vent.getTotal_venta() + "," 
				    + vent.getValor_venta() + "" 
					+ ");";
			
			//se ejecuta la sentencia en la base de datos
			estatuto.executeUpdate(sentencia);
			//impresión en consola para verificación 
			System.out.println("Registrado " + sentencia);
			//cerrando la sentencia y la conexión
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

	public ArrayList<VentaVO> consultarVenta(Integer vent) {	
		//lista que contendra las ventas obtenidos
		ArrayList<VentaVO> listaventas = new ArrayList<VentaVO>();		
		//instancia de la conexión
		Conexion conex = new Conexion();
		try {
			//prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM ventas where codigo_venta = ? ");		
			// se cambia el comodin ? por el dato que ha llegado en el parametro de la funcion
			consulta.setInt(1, vent);			
			//ejecute la sentencia
			ResultSet res = consulta.executeQuery();			
			//cree un objeto basado en la clase entidad con los datos encontrados
			if (res.next()) {
				VentaVO newventa = new VentaVO();
				newventa.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
				newventa.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				newventa.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
				newventa.setIvaventa(Double.parseDouble(res.getString("ivaventa")));
				newventa.setTotal_venta(Double.parseDouble(res.getString("total_venta")));
				newventa.setValor_venta(Double.parseDouble(res.getString("valor_venta")));

				listaventas.add(newventa);
			}
			//cerrar resultado, sentencia y conexión
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listaventas;
	}
	
	public ArrayList<VentaVO> listaDeVentas() {
		//lista que contendra las ventas obtenidas
		ArrayList<VentaVO> listaventas = new ArrayList<VentaVO>();
		
		//instancia de la conexión
		Conexion conex = new Conexion();

		try {
			//prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas");
			
			//ejecute la sentencia
			ResultSet res = consulta.executeQuery();
			
			//cree un objeto para cada encontrado en la base de datos basado en la clase entidad con los datos encontrados
			while (res.next()) {
				VentaVO newventa = new VentaVO();
				newventa.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
				newventa.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				newventa.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
				newventa.setIvaventa(Double.parseDouble(res.getString("ivaventa")));
				newventa.setTotal_venta(Double.parseDouble(res.getString("total_venta")));
				newventa.setValor_venta(Double.parseDouble(res.getString("valor_venta")));

				listaventas.add(newventa);
			}
			
			//cerrar resultado, sentencia y conexión
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todas las ventas");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todas las ventas");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return listaventas;
	}
	
public void eliminarVenta(Integer codigo_venta) {
		
		//instancia de la conexion
		Conexion conex = new Conexion();

		try {
			//sentencia inicializada
			Statement consulta = conex.getConnection().createStatement();
			
			//preparando sentencia a realizar
			String sentencia = "delete from ventas where codigo_venta=" + codigo_venta + ";";
			
			//impresion de verificación
			System.out.println("Registrado " + sentencia);
			
			//ejecutando la sentencia en la base de datos
			consulta.execute(sentencia);
			
			//cerrando sentencia y conexión
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

	public void actualizarVenta(VentaVO vent) {
		
		//instancia de conexion
		Conexion conex = new Conexion();

		try {
			//inicializando sentencia
			Statement estatuto = conex.getConnection().createStatement();
			
			//String con la sentencia a ejecutar
			String sentencia = "UPDATE ventas "
					+ "SET ivaventa = "+vent.getIvaventa()+","
					+ "cedula_usuario = '"+vent.getCedula_usuario()+"',"
					+ "cedula_cliente = "+vent.getCedula_cliente()+","
					+ "total_venta = "+vent.getTotal_venta()+","
					+ "valor_venta = "+vent.getValor_venta()+""
					+ "WHERE codigo_venta = "+vent.getCodigo_venta()+";";
			
			//ejecuta la sentencia 
			estatuto.executeUpdate(sentencia);
			
			//verificación por consola de la sentencia
			System.out.println("Registrado " + sentencia);
			
			//cerrando sentencia y conexión
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo actualizar  la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}
	
}
