package com.utng.askme.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Pregunta;
import com.utng.askme.entity.Respuesta;
import com.utng.askme.entity.RespuestaDTO;
import com.utng.askme.repository.IPreguntaRepositoy;
import com.utng.askme.repository.IRespuestaRepositoy;

@Service
public class PreguntaFacebookService implements IPreguntaService{

	@Autowired
	IPreguntaRepositoy iPreguntaRepositoy;
	
	@Autowired
	IRespuestaRepositoy respuestaRepository;
	
	@Autowired
	EntityManager entityManager;

	
	@Override
	public List<Pregunta> buscarTodos(String tipoPregunta) {
		List<Pregunta> lista = iPreguntaRepositoy.buscarTodosFacebook();
		return lista;
	}

	@Override
	public Pregunta buscarPorId(Integer id) {
		Optional<Pregunta> idOpcional = iPreguntaRepositoy.findById(id);
		Pregunta pregunta = idOpcional.get();

		return pregunta;
	}

	@Override
	public Pregunta guardarPregunta(Pregunta pregunta, MultipartFile archi) throws IOException {
		if(!archi.isEmpty()) {
			pregunta.setArchivo(archi.getBytes());
		}
		pregunta.setFecha(new Date());
		pregunta.setLike(0);
		Pregunta guardar = iPreguntaRepositoy.save(pregunta);

		return guardar;
	}

	@Override
	public Pregunta actualizarPregunta(Pregunta pregunta) {
		
		Pregunta regresaPregunta = iPreguntaRepositoy.save(pregunta);

		return regresaPregunta;
	}

	@Override
	public Pregunta eliminarPregunta(Pregunta id) {
		List<Respuesta> listaRespuesta = respuestaRepository.buscarPreguntaPorId(id.getId());
		if(!listaRespuesta.isEmpty()) {
			for(Respuesta respuestas : listaRespuesta) {
				respuestaRepository.deleteById(respuestas.getId());
			}
		}
		iPreguntaRepositoy.deleteById(id.getId());
		return	id;
		
	}

	@Override
	public List<Pregunta> buscarPorNombre(String nombre) {
		List<Pregunta> listaPorNombre = iPreguntaRepositoy.buscarPorTemaFacebook(nombre);
		return listaPorNombre;
	}

	@Override
	public List<Pregunta> buscarPorNombreSubtema(String nombre) {
		List<Pregunta> listaPorNombreSubtema = iPreguntaRepositoy.buscarPorSubtemaFacebook(nombre);
		return null;
	}
	
	@Override
	@Transactional
	public Integer sumarLikes(Integer idRespuesta) {
		
		Query query = entityManager.createNativeQuery("UPDATE respuesta r SET r.like_respuesta = r.like_respuesta +1 WHERE r.id =:id");
		query.setParameter("id", idRespuesta);
		
		query.executeUpdate();
		return idRespuesta;
				
	}

	@Override
	@Transactional
	public Integer restarLikes(Integer idRespuesta) {
		Query query = entityManager.createNativeQuery("UPDATE pregunta p SET p.like = r.like_respuesta -1 WHERE r.id =:id");
		
		query.setParameter("id", idRespuesta);
		query.executeUpdate();

		return idRespuesta;
		
	}

	
}
