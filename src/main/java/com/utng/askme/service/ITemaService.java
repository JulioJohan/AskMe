package com.utng.askme.service;

import java.util.List;

import com.utng.askme.entity.TemaDTO;

public interface ITemaService {

	public List<TemaDTO> consultarTodos();
	
	public TemaDTO buscarPorId(Integer id);
	
	public TemaDTO guardarTema(TemaDTO pregunta);

	public void eliminarTema(Integer id);


}
