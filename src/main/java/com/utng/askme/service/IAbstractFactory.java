package com.utng.askme.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Pregunta;
import com.utng.askme.entity.PreguntaBusquedaDTO;

public interface IAbstractFactory<T> {

	T crearPregunta (Pregunta preguntaParam, MultipartFile archi)throws IOException ;
	
	void eliminarPregunta(Pregunta preguntaParam);
	
	List<T> buscarTodo(String buscarTodos);
	
	List<T> buscarPorNombre (PreguntaBusquedaDTO nombre);
	
	List<T> buscarPorNombreSubtema (PreguntaBusquedaDTO preguntaParam);

}
