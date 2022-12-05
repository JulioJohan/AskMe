package com.utng.askme.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.BusquedaDTO;
import com.utng.askme.entity.Respuesta;
import com.utng.askme.entity.RespuestaDTO;

@Service
public class RespuestaFactoryService implements IAbstractFactory<Respuesta> {

	@Autowired
	RespuestaFacebookService respuestaFacebookService;
	
	@Override
	public Respuesta crear(Respuesta preguntaParam, MultipartFile archi) throws IOException {
//		if(preguntaParam.getPregunta().getTemaPregunta().contains("FB")) {
//			return respuestaFacebookService.guardarRespuesta(preguntaParam, archi);
//		}
//		if(preguntaParam.getTipoPregunta().contains("RD")) {
//			return preguntaRedditService.guardarPregunta(preguntaParam, archi);
//		}
//		if(preguntaParam.getTipoPregunta().contains("TW")) {
//			return preguntaTwitterService.guardarPregunta(preguntaParam, archi);
//		}	
		
		return null;
	}

	@Override
	public Respuesta eliminar(Respuesta preguntaParam) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public List<Respuesta> buscarTodo(String buscarTodos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Respuesta> buscarPorNombre(BusquedaDTO nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Respuesta> buscarPorNombreSubtema(BusquedaDTO preguntaParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Respuesta sumarLikes(Respuesta pregunta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Respuesta restarLikes(Respuesta pregunta) {
		// TODO Auto-generated method stub
		return null;
	}



}
