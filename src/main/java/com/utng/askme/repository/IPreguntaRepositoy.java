package com.utng.askme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.askme.entity.Pregunta;

public interface IPreguntaRepositoy extends JpaRepository<Pregunta, Integer>{
	@Query(value = "SELECT id,archivo,descripcion_pregunta,subtema_pregunta,tema_pregunta,titulo_pregunta,fecha_publicacion,tipo_pregunta,like_pregunta  FROM pregunta p WHERE p.tipo_pregunta = 'FB'", nativeQuery = true)
	List<Pregunta> buscarTodosFacebook();
	
	@Query(value = "SELECT id,archivo,descripcion_pregunta,subtema_pregunta,tema_pregunta,titulo_pregunta,fecha_publicacion,tipo_pregunta,like_pregunta  FROM pregunta p WHERE p.tipo_pregunta = 'TW'", nativeQuery = true)
	List<Pregunta> buscarTodosTwitter();	

	@Query(value = "SELECT id,archivo,descripcion_pregunta,subtema_pregunta,tema_pregunta,titulo_pregunta,fecha_publicacion,tipo_pregunta,like_pregunta FROM pregunta p WHERE p.tipo_pregunta = 'RD'", nativeQuery = true)
	List<Pregunta> buscarTodosRedit();	
	
	@Query(value = "SELECT * FROM pregunta p WHERE p.tema_pregunta like :temaPregunta AND p.tipo_pregunta = 'FB'", nativeQuery = true)
	List<Pregunta> buscarPorTemaFacebook(@Param("temaPregunta") String temaPregunta);	
	
	@Query(value = "SELECT * FROM pregunta p WHERE p.tema_pregunta like :temaPregunta AND p.tipo_pregunta = 'TW'", nativeQuery = true)
	List<Pregunta> buscarPorTemaTwitter(@Param("temaPregunta") String temaPregunta);	

	@Query(value = "SELECT * FROM pregunta p WHERE p.tema_pregunta like :temaPregunta AND p.tipo_pregunta = 'RD'", nativeQuery = true)
	List<Pregunta> buscarPorTemaReddit(@Param("temaPregunta") String temaPregunta);	
	
	@Query(value = "SELECT * FROM pregunta p WHERE p.subtema_pregunta  like :subtemaPregunta AND p.tipo_pregunta = 'FB'", nativeQuery = true)
	List<Pregunta> buscarPorSubtemaFacebook(@Param("subtemaPregunta") String subtemaPregunta);	
	
	@Query(value = "SELECT * FROM pregunta p WHERE p.subtema_pregunta  like :subtemaPregunta AND p.tipo_pregunta = 'TW'", nativeQuery = true)
	List<Pregunta> buscarPorSubtemaTwitter(@Param("subtemaPregunta") String subtemaPregunta);	
	
	@Query(value = "SELECT * FROM pregunta p WHERE p.subtema_pregunta  like :subtemaPregunta AND p.tipo_pregunta = 'RD'", nativeQuery = true)
	List<Pregunta> buscarPorSubtemaReddit(@Param("subtemaPregunta") String subtemaPregunta);	

}
