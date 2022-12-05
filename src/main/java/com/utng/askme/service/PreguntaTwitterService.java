package com.utng.askme.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.BusquedaDTO;
import com.utng.askme.entity.Pregunta;
import com.utng.askme.entity.PreguntaDTO;
import com.utng.askme.entity.Respuesta;
import com.utng.askme.repository.IPreguntaRepositoy;
import com.utng.askme.repository.IRespuestaRepositoy;

@Service
public class PreguntaTwitterService implements IPreguntaService {

	@Autowired
	IPreguntaRepositoy iPreguntaRepositoy;
	
	@Autowired
	IRespuestaRepositoy respuestaRepository;
	
	@Autowired
	EntityManager entityManager;
	

	@Override
	public List<Pregunta> buscarTodos(String tipoPregunta) {
		List<Pregunta> lista = iPreguntaRepositoy.buscarTodosTwitter();
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
		}else {
			pregunta.setArchivo(null);
		}
		pregunta.setFecha(new Date());
				
		pregunta.setLike(0);
		Pregunta guardar = iPreguntaRepositoy.save(pregunta);
		
		return guardar;
	}

	@Override
	public Pregunta actualizarPregunta(Pregunta pregunta) {
		Optional<Pregunta> idPerfil = iPreguntaRepositoy.findById(pregunta.getId());
		
				
		Pregunta regresaPregunta = iPreguntaRepositoy.save(pregunta);
		return regresaPregunta;
	}

	@Override
	public Pregunta  eliminarPregunta(Pregunta preguntaId) {
		List<Respuesta> listaRespuesta = respuestaRepository.buscarPreguntaPorId(preguntaId.getId());
		if(!listaRespuesta.isEmpty()) {
			for(Respuesta respuestas : listaRespuesta) {
				respuestaRepository.deleteById(respuestas.getId());
			}
		}
		iPreguntaRepositoy.deleteById(preguntaId.getId());
		return	preguntaId;
	}

	@Override
	public List<Pregunta> buscarPorNombre(BusquedaDTO preguntaParam) {
		List<Pregunta> listaPorNombre = iPreguntaRepositoy.buscarPorTemaTwitter(preguntaParam.getTema(),preguntaParam.getSubtema(),preguntaParam.getTipo());
		return listaPorNombre;
	}

	@Override
	public List<Pregunta> buscarPorNombreSubtema(String nombre) {
		List<Pregunta> listaPorNombre = iPreguntaRepositoy.buscarPorSubtemaTwitter(nombre);
		return listaPorNombre;
	}

	@Override
	@Transactional
	public Pregunta sumarLikes(Pregunta idRespuesta) {
		Query query = entityManager.createNativeQuery("UPDATE pregunta p SET p.like_pregunta = p.like_pregunta +1 WHERE p.id =:id");
		query.setParameter("id", idRespuesta.getId());
		
		query.executeUpdate();
		
		return idRespuesta;
	}

	@Override
	public Pregunta restarLikes(Pregunta idRespuesta) {
		Query query = entityManager.createNativeQuery("UPDATE pregunta p SET p.like_pregunta = p.like_pregunta -1 WHERE p.id =:id");
		query.setParameter("id", idRespuesta.getId());
		query.executeUpdate();
		return idRespuesta;


	}
	
}
