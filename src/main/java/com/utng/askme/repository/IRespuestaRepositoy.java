package com.utng.askme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.askme.entity.Respuesta;

public interface IRespuestaRepositoy extends JpaRepository<Respuesta, Integer> {

	@Query(value = "SELECT id,descripcion_respuesta,id_pregunta_fk FROM respuesta r WHERE r.id_pregunta_fk = :idPregunta", nativeQuery = true)
	List<Respuesta> buscarPreguntaPorId(@Param("idPregunta") Integer idPregunta);
	
//	@Query(value = "UPDATE respuesta r SET r.like_respuesta =:likea WHERE r.id =:id",nativeQuery = true)
	
}
