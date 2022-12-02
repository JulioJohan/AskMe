package com.utng.askme.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.BusquedaDTO;
import com.utng.askme.entity.Respuesta;

@Service
public class RespuestaFactoryService implements IAbstractFactory<Respuesta> {

	@Override
	public Respuesta crear(Respuesta preguntaParam, MultipartFile archi) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Respuesta preguntaParam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Respuesta> buscarTodo(String buscarTodos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Respuesta> buscarPorNombre(BusquedaDTO nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Respuesta> buscarPorNombreSubtema(BusquedaDTO preguntaParam) {
		// TODO Auto-generated method stub
		return null;
	}



}
