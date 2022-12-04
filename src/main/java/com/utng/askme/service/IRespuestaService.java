package com.utng.askme.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Respuesta;
import com.utng.askme.entity.RespuestaDTO;

public interface IRespuestaService {
	
	public List<Respuesta> traeTodosPorID(Integer id);
		
	public Respuesta guardarRespuesta(RespuestaDTO respuestaDTO, MultipartFile archi) throws IOException;

	public void eliminarRespuestaId(Integer respuestaDTO);

	public Integer sumarLikes(Integer idRespuesta);
	
	public Integer restarLikes(Integer idRespuesta);
	
	
	
}
