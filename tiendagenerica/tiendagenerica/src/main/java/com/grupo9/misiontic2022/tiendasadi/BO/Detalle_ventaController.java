package com.grupo9.misiontic2022.tiendasadi.BO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo9.misiontic2022.tiendasadi.DAO.Detalle_ventaDAO;
import com.grupo9.misiontic2022.tiendasadi.DAO.VentaDAO;
import com.grupo9.misiontic2022.tiendasadi.DTO.Detalle_ventaVO;
import com.grupo9.misiontic2022.tiendasadi.DTO.VentaVO;


@RestController
public class Detalle_ventaController {
	
	/*
	 * @GetMapping obtener o buscar
	 * @PostMapping insertar o agregar
	 * @PutMapping modificar o actualizar
	 * @DeleteMapping eliminar o borrar
	 * */

	@PostMapping("/registradetaller_venta")
	public void registrarVenta(Detalle_ventaVO detall) {
		Detalle_ventaDAO Dao = new Detalle_ventaDAO();
		Dao.registrarDetalle_venta(detall);
	}

	@GetMapping("/consultardetalle_venta")
	public ArrayList<Detalle_ventaVO> consultarDetalle_venta(Integer code) {
		Detalle_ventaDAO Dao = new Detalle_ventaDAO();
		return Dao.consultarDetalle_venta(code);
	}

	@GetMapping("/listardetalle_ventas")
	public ArrayList<Detalle_ventaVO> listaDeDetalle_ventas() {
		Detalle_ventaDAO Dao = new Detalle_ventaDAO();
		return Dao.listaDeDetalle_ventas();
	}
	
}
