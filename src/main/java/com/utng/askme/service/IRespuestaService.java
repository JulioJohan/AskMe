package com.utng.askme.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.RespuestaDTO;

public interface IRespuestaService {
	
	public List<RespuestaDTO> traeTodos();
	
	public RespuestaDTO encoentrarRespuestaPorId(Integer id);
	
	public RespuestaDTO guardarRespuesta(RespuestaDTO respuestaDTO, MultipartFile archi) throws IOException;

	public void eliminarRespuestaId(Integer respuestaDTO);

	public Integer sumarLikes(Integer like);
}
