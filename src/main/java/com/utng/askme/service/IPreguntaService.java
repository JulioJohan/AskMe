package com.utng.askme.service;

import java.util.List;

import com.utng.askme.entity.PreguntaDTO;

public interface IPreguntaService {

	public List<PreguntaDTO> buscarTodos();
	
	public PreguntaDTO buscarPorId(Integer id);
	
	public PreguntaDTO guardarPregunta(PreguntaDTO pregunta);
	
	public PreguntaDTO actualizarPregunta(PreguntaDTO pregunta);
	
	public void eliminarPregunta(Integer id);

}
