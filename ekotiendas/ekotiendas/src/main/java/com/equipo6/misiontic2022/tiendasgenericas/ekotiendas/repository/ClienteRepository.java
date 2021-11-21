package com.equipo6.misiontic2022.tiendasgenericas.ekotiendas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.equipo6.misiontic2022.tiendasgenericas.ekotiendas.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente,String>{
	List<Cliente>findByCedula(Integer cedula);
	List<Cliente>findByNombrecliente(String nombrecliente);

}
