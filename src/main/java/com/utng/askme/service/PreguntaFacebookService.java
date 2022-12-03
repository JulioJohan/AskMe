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
import com.utng.askme.repository.IPreguntaRepositoy;
import com.utng.askme.repository.IRespuestaRepositoy;

@Service
public class PreguntaFacebookService implements IPreguntaService{

	@Autowired
	IPreguntaRepositoy iPreguntaRepositoy;
	
	@Autowired
	IRespuestaRepositoy respuestaRepository;
	
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

		Pregunta guardar = iPreguntaRepositoy.save(pregunta);

		return guardar;
	}

	@Override
	public Pregunta actualizarPregunta(Pregunta pregunta) {
		
		Pregunta regresaPregunta = iPreguntaRepositoy.save(pregunta);

		return regresaPregunta;
	}

	@Override
	public void eliminarPregunta(Pregunta id) {
		List<Respuesta> listaRespuesta = respuestaRepository.buscarPreguntaPorId(id.getId());
		if(!listaRespuesta.isEmpty()) {
			for(Respuesta respuestas : listaRespuesta) {
				respuestaRepository.deleteById(respuestas.getId());
			}
		}
		iPreguntaRepositoy.deleteById(id.getId());		
		
	}

	@Override
	public List<Pregunta> buscarPorNombre(String nombre) {
		List<Pregunta> listaPorNombre = iPreguntaRepositoy.buscarPorTemaFacebook(nombre);
		return listaPorNombre;
	}

	@Override
	public List<Pregunta> buscarPorNombreSubtema(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
