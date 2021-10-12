package com.grupo9.misiontic2022.tiendasadi.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.grupo9.misiontic2022.tiendasadi.DTO.Detalle_ventaVO;
import com.grupo9.misiontic2022.tiendasadi.DTO.VentaVO;

public class Detalle_ventaDAO {
	public void registrarDetalle_venta(Detalle_ventaVO deta) {
	//llama y crea una instancia de la clase encargada de hacer la conexión
	Conexion conex = new Conexion();

	try {
		//sentencia que se ejecutara en la base de datos
		Statement estatuto = conex.getConnection().createStatement();
		
		//String que contiene la sentencia insert a ejecutar
		String sentencia = "INSERT INTO detalle_ventas VALUES(" 
				+ deta.getCodigo_detalle_venta() + "," 
				+ deta.getCantidad_producto() + ","
				+ deta.getCodigo_producto() + "," 
				+ deta.getCodigo_venta() + ",'" 
				+ deta.getValor_total()+ "'," 
				+ deta.getValor_venta() + "," 
				+ deta.getValoriva() + "" 
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
		System.out.println("No se pudo insertar el detalle de la venta");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		//si hay cualquier otro error mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo insertar el detalle de la venta");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}

}

public ArrayList<Detalle_ventaVO> consultarDetalle_venta(Integer detall) {	
	//lista que contendra las ventas obtenidos
	ArrayList<Detalle_ventaVO> listadetalle_ventas = new ArrayList<Detalle_ventaVO>();		
	//instancia de la conexión
	Conexion conex = new Conexion();
	try {
		//prepare la sentencia en la base de datos
		PreparedStatement consulta = conex.getConnection()
				.prepareStatement("SELECT * FROM detalle_ventas where codigo_detalle_venta = ? ");		
		// se cambia el comodin ? por el dato que ha llegado en el parametro de la funcion
		consulta.setInt(1, detall);			
		//ejecute la sentencia
		ResultSet res = consulta.executeQuery();			
		//cree un objeto basado en la clase entidad con los datos encontrados
		if (res.next()) {
			Detalle_ventaVO newdetalle_venta = new Detalle_ventaVO();
			newdetalle_venta.setCodigo_detalle_venta(Integer.parseInt(res.getString("codigo_detalle_venta")));
			newdetalle_venta.setCantidad_producto(Integer.parseInt(res.getString("cantidad_producto")));
			newdetalle_venta.setCodigo_producto(Integer.parseInt(res.getString("codigo_producto")));
			newdetalle_venta.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
			newdetalle_venta.setValor_total(Double.parseDouble(res.getString("valor_total")));
			newdetalle_venta.setValor_venta(Double.parseDouble(res.getString("valor_venta")));
			newdetalle_venta.setValoriva(Double.parseDouble(res.getString("valoriva")));

			listadetalle_ventas.add(newdetalle_venta);
		}
		//cerrar resultado, sentencia y conexión
		res.close();
		consulta.close();
		conex.desconectar();

	} catch (SQLException e) {
		//si hay un error en el sql mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar el detalle de la venta");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		//si hay cualquier otro error mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar el detalle de la venta");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}
	return listadetalle_ventas;
}

public ArrayList<Detalle_ventaVO> listaDeDetalle_ventas() {
	//lista que contendra las ventas obtenidas
	ArrayList<Detalle_ventaVO> listadetalle_ventas = new ArrayList<Detalle_ventaVO>();
	
	//instancia de la conexión
	Conexion conex = new Conexion();

	try {
		//prepare la sentencia en la base de datos
		PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM detalle_ventas ");
		
		//ejecute la sentencia
		ResultSet res = consulta.executeQuery();
		
		//cree un objeto para cada encontrado en la base de datos basado en la clase entidad con los datos encontrados
		while (res.next()) {
			Detalle_ventaVO newdetalle_venta = new Detalle_ventaVO();
			newdetalle_venta.setCodigo_detalle_venta(Integer.parseInt(res.getString("codigo_detalle_venta")));
			newdetalle_venta.setCantidad_producto(Integer.parseInt(res.getString("cantidad_producto")));
			newdetalle_venta.setCodigo_producto(Integer.parseInt(res.getString("codigo_producto")));
			newdetalle_venta.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
			newdetalle_venta.setValor_total(Double.parseDouble(res.getString("valor_total")));
			newdetalle_venta.setValor_venta(Double.parseDouble(res.getString("valor_venta")));
			newdetalle_venta.setValoriva(Double.parseDouble(res.getString("valoriva")));

			listadetalle_ventas.add(newdetalle_venta);
		}
		
		//cerrar resultado, sentencia y conexión
		res.close();
		consulta.close();
		conex.desconectar();

	} catch (SQLException e) {
		//si hay un error en el sql mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar todos los detalles de las ventas");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		//si hay cualquier otro error mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar todos los detalles de las ventas");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}

	return listadetalle_ventas;
}

}