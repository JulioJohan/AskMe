package com.utng.askme.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.PreguntaDTO;

public interface IPreguntaService {

	public List<PreguntaDTO> buscarTodos();
	
	public PreguntaDTO buscarPorId(Integer id);
	
	public PreguntaDTO guardarPregunta(PreguntaDTO pregunta, MultipartFile archi)throws IOException ;
	
	public PreguntaDTO actualizarPregunta(PreguntaDTO pregunta);
	
	public void eliminarPregunta(Integer id);

}
