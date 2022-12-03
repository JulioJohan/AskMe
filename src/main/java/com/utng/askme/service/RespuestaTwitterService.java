package com.utng.askme.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Respuesta;
import com.utng.askme.entity.RespuestaDTO;

@Service
public class RespuestaTwitterService implements IRespuestaService{

	@Override
	public List<Respuesta> traeTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Respuesta guardarRespuesta(RespuestaDTO respuestaDTO, MultipartFile archi) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarRespuestaId(Integer respuestaDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer sumarLikes(Integer idRespuesta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer restarLikes(Integer idRespuesta) {
		// TODO Auto-generated method stub
		return null;
	}

}
