package com.grupo9.misiontic2022.tiendasadi.BO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo9.misiontic2022.tiendasadi.DAO.ProveedorDAO;
import com.grupo9.misiontic2022.tiendasadi.DTO.ProveedorVO;


@RestController
public class ProveedorController {
	/*
	 * @GetMapping obtener o buscar
	 * @PostMapping insertar o agregar
	 * @PutMapping modificar o actualizar
	 * @DeleteMapping eliminar o borrar
	 * */

	@PostMapping("/registrarproveedor")
	public void registrarProveedor(ProveedorVO provee) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.registrarProveedor(provee);
	}

	@GetMapping("/consultarproveedor")
	public ArrayList<ProveedorVO> consultarProveedores(String proveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		return Dao.consultarProveedor(proveedor);
	}

	@GetMapping("/listarproveedores")
	public ArrayList<ProveedorVO> listaDeProveedores() {
		ProveedorDAO Dao = new ProveedorDAO();
		return Dao.listaDeProveedores();
	}
	
	@DeleteMapping("/eliminarproveedor")
	public void eliminarProveedor(Integer nit_proveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.eliminarProveedor(nit_proveedor);
	}
	
	@PutMapping("/actualizarproveedores")
	public void actualizarProveedor(ProveedorVO provee) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.actualizarProveedor(provee);
	}
	
	

}