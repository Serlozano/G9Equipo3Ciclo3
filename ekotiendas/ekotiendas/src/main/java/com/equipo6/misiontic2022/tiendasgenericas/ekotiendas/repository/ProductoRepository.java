package com.equipo6.misiontic2022.tiendasgenericas.ekotiendas.repository;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.equipo6.misiontic2022.tiendasgenericas.ekotiendas.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String>{
	
	List<Producto> findByCodigoproducto(Long codigoproducto);
	
	List<Producto> findByNombreproducto(String nombreproducto);

}
