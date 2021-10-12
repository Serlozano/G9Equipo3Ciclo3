package com.grupo9.misiontic2022.tiendasadi.BO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo9.misiontic2022.tiendasadi.DAO.VentaDAO;
import com.grupo9.misiontic2022.tiendasadi.DTO.VentaVO;


@RestController
public class VentaController {
	/*
	 * @GetMapping obtener o buscar
	 * @PostMapping insertar o agregar
	 * @PutMapping modificar o actualizar
	 * @DeleteMapping eliminar o borrar
	 * */

	@PostMapping("/registrarventa")
	public void registrarVenta(VentaVO vent) {
		VentaDAO Dao = new VentaDAO();
		Dao.registrarVenta(vent);
	}

	@GetMapping("/consultarventa")
	public ArrayList<VentaVO> consultarVenta(Integer code) {
		VentaDAO Dao = new VentaDAO();
		return Dao.consultarVenta(code);
	}

	@GetMapping("/listarventas")
	public ArrayList<VentaVO> listaDeVentas() {
		VentaDAO Dao = new VentaDAO();
		return Dao.listaDeVentas();
	}
	
	@DeleteMapping("/eliminarventa")
	public void eliminarVenta(Integer code) {
		VentaDAO Dao = new VentaDAO();
		Dao.eliminarVenta(code);
	}
	
	@PutMapping("/actualizarventa")
	public void actualizarVenta(VentaVO vent) {
		VentaDAO Dao = new VentaDAO();
		Dao.actualizarVenta(vent);
	}

}
