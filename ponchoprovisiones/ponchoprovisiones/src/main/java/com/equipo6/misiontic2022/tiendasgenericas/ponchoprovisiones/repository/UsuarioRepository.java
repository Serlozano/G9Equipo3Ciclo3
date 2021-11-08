package com.equipo6.misiontic2022.tiendasgenericas.ponchoprovisiones.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.equipo6.misiontic2022.tiendasgenericas.ponchoprovisiones.model.Usuario;



public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	List<Usuario> findByUsername(String username);
	
	List<Usuario> findByNombre(String nombre);
}
