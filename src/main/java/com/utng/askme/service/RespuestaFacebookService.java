package com.utng.askme.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	
	@Override
	public List<Respuesta> traeTodos() {
		// TODO Auto-generated method stub
		return null;
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
				respuesta.setDescripcionRespuesta(respuestaDTO.getDescrpcionRespuesta());
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer sumarLikes(Integer idRespuesta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer restarLikes(Integer idRespuesta) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
