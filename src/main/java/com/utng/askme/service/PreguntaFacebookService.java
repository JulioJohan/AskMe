package com.utng.askme.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Pregunta;
import com.utng.askme.repository.IPreguntaRepositoy;

@Service
public class PreguntaFacebookService implements IPreguntaService{

	@Autowired
	IPreguntaRepositoy iPreguntaRepositoy;
	
	
	@Override
	public List<Pregunta> buscarTodos() {
		List<Pregunta> lista = iPreguntaRepositoy.findAll();
		
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
//		Optional<Pregunta> idPerfil = iPreguntaRepositoy.findById(pregunta.getId());
		
		Pregunta regresaPregunta = iPreguntaRepositoy.save(pregunta);

		return regresaPregunta;
	}

	@Override
	public void eliminarPregunta(Integer id) {
		iPreguntaRepositoy.deleteById(id);		
		
	}

	
}
