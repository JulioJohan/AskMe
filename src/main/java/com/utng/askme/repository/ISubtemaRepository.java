package com.utng.askme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.askme.entity.Subtema;

public interface ISubtemaRepository extends JpaRepository<Subtema, Integer>{

	@Query(value = "SELECT id, nombre_subtema, id_tema_fk  FROM subtema s WHERE s.id_tema_fk = :idTema",nativeQuery = true)
	List<Subtema> buscarSubtemaPorTema(@Param ("idTema") Integer idTema) ;
}
