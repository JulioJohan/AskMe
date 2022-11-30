package com.utng.askme.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Pregunta;

public interface IPreguntaService {

	public List<Pregunta> buscarTodos();
	
	public Pregunta buscarPorId(Integer id);
	
	public Pregunta guardarPregunta(Pregunta pregunta, MultipartFile archi)throws IOException ;
	
	public Pregunta actualizarPregunta(Pregunta pregunta);
	
	public void eliminarPregunta(Integer id);

}
