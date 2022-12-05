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
public class RespuestaFacebookService implements IRespuestaService{

	@Autowired
	IPreguntaRepositoy preguntaRepository;
	
	@Autowired
	IRespuestaRepositoy respuestaRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Respuesta> traeTodosPorID(Integer idPregunta) {
		 List<Respuesta> todasRespuestas = respuestaRepository.buscarPreguntaPorId(idPregunta);
		 
		return todasRespuestas;
	}


	@Override
	public Respuesta guardarRespuesta(RespuestaDTO respuestaDTO, MultipartFile archi) throws IOException {
		
		Pregunta preguntaObtenida = new Pregunta();
		Respuesta respuesta = new Respuesta();
		Optional<Pregunta> optionalPregunta =  preguntaRepository.findById(respuestaDTO.getId_pregunta_fk());
		
		if(optionalPregunta.isPresent()) {
			preguntaObtenida = optionalPregunta.get();
			if(!archi.isEmpty()) {
				respuesta.setArchivo(archi.getBytes());
				respuesta.setDescripcionRespuesta(respuestaDTO.getDescripcionRespuesta());
				respuesta.setFecha(new Date());
				respuesta.setLike(0);
				respuesta.setPregunta(preguntaObtenida);
				
			}
		}	
		Respuesta guardarRespuesta = respuestaRepository.save(respuesta);
		return guardarRespuesta;
	}

	@Override
	public void eliminarRespuestaId(Integer respuestaDTO) {
		respuestaRepository.deleteById(respuestaDTO);
		
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
	Query query = entityManager.createNativeQuery("UPDATE respuesta r SET r.like_respuesta = r.like_respuesta -1 WHERE r.id =:id");
		
		query.setParameter("id", idRespuesta);
		query.executeUpdate();

		return idRespuesta;
	}

	
}
