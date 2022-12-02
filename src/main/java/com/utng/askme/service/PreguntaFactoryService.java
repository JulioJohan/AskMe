package com.utng.askme.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Pregunta;
import com.utng.askme.entity.BusquedaDTO;

@Service
public class PreguntaFactoryService implements IAbstractFactory<Pregunta> {

	@Autowired
	PreguntaFacebookService preguntaFacebookService;
	
	@Autowired
	PreguntaRedditService preguntaRedditService;
	
	@Autowired
	PreguntaTwitterService preguntaTwitterService;
	
	@Override
	public Pregunta crear(Pregunta preguntaParam, MultipartFile archi)throws IOException {
		if(preguntaParam.getTipoPregunta().contains("FB")) {
			return preguntaFacebookService.guardarPregunta(preguntaParam, archi);
		}
		if(preguntaParam.getTipoPregunta().contains("RD")) {
			return preguntaRedditService.guardarPregunta(preguntaParam, archi);
		}
		if(preguntaParam.getTipoPregunta().contains("TW")) {
			return preguntaTwitterService.guardarPregunta(preguntaParam, archi);
		}	
		return null;
	}

	@Override
	public void eliminar(Pregunta preguntaParam) {
		if(preguntaParam.getTipoPregunta().contains("FB")) {
			preguntaFacebookService.eliminarPregunta(preguntaParam);
		}
		if(preguntaParam.getTipoPregunta().contains("RD")) {
			preguntaRedditService.eliminarPregunta(preguntaParam);
		}
		if(preguntaParam.getTipoPregunta().contains("TW")) {
			preguntaTwitterService.eliminarPregunta(preguntaParam);
		}	
	}

	@Override
	public List<Pregunta> buscarPorNombre(BusquedaDTO preguntaParam) {
		if(preguntaParam.getTipo().contains("FB")) {
			return preguntaFacebookService.buscarPorNombre(preguntaParam.getBusqueda());
		}
		if(preguntaParam.getTipo().contains("RD")) {
			return preguntaRedditService.buscarPorNombre(preguntaParam.getBusqueda());
		}
		if(preguntaParam.getTipo().contains("TW")) {
			return preguntaTwitterService.buscarPorNombre(preguntaParam.getBusqueda());
		}
		return null;	
	}

	@Override
	public List<Pregunta> buscarPorNombreSubtema(BusquedaDTO preguntaParam) {
		if(preguntaParam.getTipo().contains("FB")) {
			return preguntaFacebookService.buscarPorNombreSubtema(preguntaParam.getBusqueda());
		}
		if(preguntaParam.getTipo().contains("RD")) {
			return preguntaRedditService.buscarPorNombreSubtema(preguntaParam.getBusqueda());
		}
		if(preguntaParam.getTipo().contains("TW")) {
			return preguntaTwitterService.buscarPorNombreSubtema(preguntaParam.getBusqueda());
		}	
		return null;
	}

	@Override
	public List<Pregunta> buscarTodo(String buscarTodos) {
		if(buscarTodos.contains("FB")) {
			return preguntaFacebookService.buscarTodos(buscarTodos);
		}
		if(buscarTodos.contains("RD")) {
			return preguntaRedditService.buscarTodos(buscarTodos);
		}
		if(buscarTodos.contains("TW")) {
			return preguntaTwitterService.buscarTodos(buscarTodos);
		}	
		return null;
	}

	


	


}
