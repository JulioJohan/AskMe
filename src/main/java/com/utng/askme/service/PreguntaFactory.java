package com.utng.askme.service;

import org.springframework.stereotype.Service;

import com.utng.askme.entity.Pregunta;

@Service
public class PreguntaFactory implements IAbstractFactory<IPreguntaService> {

	@Override
	public IPreguntaService crearPregunta(Pregunta preguntaParam) {
		if(preguntaParam.getTipoPregunta().contains("FB")) {
			return new PreguntaFacebook();
		}
		if(preguntaParam.getTipoPregunta().contains("RD")) {
			return new PreguntaRedditService();
		}
		if(preguntaParam.getTipoPregunta().contains("TW")) {
			return new PreguntaTwitterService();
		}
		
		
		return null;
	}

}
