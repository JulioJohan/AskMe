package com.utng.askme.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Pregunta;
import com.utng.askme.repository.IPreguntaRepositoy;

@Service
public class PreguntaRedditService implements IPreguntaService{

	@Autowired
	IPreguntaRepositoy iPreguntaRepositoy;
	
	
	@Override
	public List<Pregunta> buscarTodos(String tipoPregunta) {
		List<Pregunta> lista = iPreguntaRepositoy.buscarTodosRedit();
		return lista;
	}

	@Override
	public Pregunta buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta guardarPregunta(Pregunta pregunta, MultipartFile archi) throws IOException {
		if(!archi.isEmpty()) {
			pregunta.setArchivo(archi.getBytes());
		}
		pregunta.setLike(0);
		pregunta.setFecha(new Date());
		Pregunta guardar = iPreguntaRepositoy.save(pregunta);
		return guardar;
	}

	@Override
	public Pregunta actualizarPregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta eliminarPregunta(Pregunta preguntaId) {
		iPreguntaRepositoy.deleteById(preguntaId.getId());		
		return preguntaId;
	}

	@Override
	public List<Pregunta> buscarPorNombre(String nombre) {
		List<Pregunta> listaPorNombre = iPreguntaRepositoy.buscarTodosRedit();
		return listaPorNombre;
	}

	@Override
	public List<Pregunta> buscarPorNombreSubtema(String nombre) {
		List<Pregunta> listaBusquedaSubtema = iPreguntaRepositoy.buscarPorSubtemaReddit(nombre);
		return listaBusquedaSubtema;
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
