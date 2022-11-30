package com.utng.askme.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Pregunta;

@Service
public class PreguntaFacebook implements IPreguntaService{

	@Override
	public List<Pregunta> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta guardarPregunta(Pregunta pregunta, MultipartFile archi) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta actualizarPregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPregunta(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
}
