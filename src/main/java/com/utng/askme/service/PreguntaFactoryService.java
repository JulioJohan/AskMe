package com.utng.askme.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Pregunta;

@Service
public class PreguntaFactoryService implements IAbstractFactory<Pregunta> {

	@Autowired
	PreguntaFacebookService preguntaFacebookService;
	
	@Autowired
	PreguntaRedditService preguntaRedditService;
	
	@Autowired
	PreguntaTwitterService preguntaTwitterService;
	
	@Override
	public Pregunta crearPregunta(Pregunta preguntaParam, MultipartFile archi)throws IOException {
		if(preguntaParam.getTipoPregunta().contains("FB")) {
			return preguntaFacebookService.guardarPregunta(preguntaParam, archi);
		}
		if(preguntaParam.getTipoPregunta().contains("RD")) {
			return preguntaRedditService.guardarPregunta(preguntaParam, archi);
		}
		if(preguntaParam.getTipoPregunta().contains("TW")) {
			return preguntaTwitterService.guardarPregunta(preguntaParam, archi);
		}
		
//		if(preguntaParam.getTipoPregunta().isEmpty()) {
//			
//		}
		
		
		return null;
	}

}
