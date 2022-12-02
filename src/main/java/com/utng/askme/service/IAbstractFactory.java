package com.utng.askme.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Pregunta;
import com.utng.askme.entity.BusquedaDTO;

public interface IAbstractFactory<T> {

	T crear (T preguntaParam, MultipartFile archi)throws IOException ;
	
	void eliminar(T preguntaParam);
	
	List<T> buscarTodo(String buscarTodos);
	
	List<T> buscarPorNombre (BusquedaDTO nombre);
	
	List<T> buscarPorNombreSubtema (BusquedaDTO  preguntaParam);

}
