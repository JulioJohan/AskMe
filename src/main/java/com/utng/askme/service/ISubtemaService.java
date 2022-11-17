package com.utng.askme.service;

import java.util.List;

import com.utng.askme.entity.Subtema;
import com.utng.askme.entity.SubtemaDTO;

public interface ISubtemaService {

	public List<Subtema> consultarSubtemaPorTema(Integer id);
	
	public SubtemaDTO guardarSubtema(SubtemaDTO pregunta);
	
	public void eliminarSubtema(Integer id);
	
}
