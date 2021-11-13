package com.equipo6.misiontic2022.tiendasgenericas.ekotiendas.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.equipo6.misiontic2022.tiendasgenericas.ekotiendas.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	List<Usuario> findByUsername(String username);
	
	List<Usuario> findByNombrecompleto(String nombrecompleto);
}

