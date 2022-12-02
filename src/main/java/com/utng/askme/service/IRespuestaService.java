package com.utng.askme.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Respuesta;

public interface IRespuestaService {
	
	public List<Respuesta> traeTodos();
	
	public Respuesta encoentrarRespuestaPorId(Integer id);
	
	public Respuesta guardarRespuesta(Respuesta respuestaDTO, MultipartFile archi) throws IOException;

	public void eliminarRespuestaId(Integer respuestaDTO);

	public Integer sumarLikes(Integer idRespuesta);
	
	public Integer restarLikes(Integer idRespuesta);
	
}
