package com.utng.askme.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Pregunta;
import com.utng.askme.entity.PreguntaDTO;
import com.utng.askme.entity.Respuesta;
import com.utng.askme.repository.IPreguntaRepositoy;
import com.utng.askme.repository.IRespuestaRepositoy;

@Service
public class PreguntaTwitterService implements IPreguntaService {

	@Autowired
	IPreguntaRepositoy iPreguntaRepositoy;
	
	@Autowired
	IRespuestaRepositoy respuestaRepository;
	
	/**
	 * modelMapperEntity: Mappper para entidades  
	 */
	@Autowired
	private ModelMapper modelMapperEntity;

	/**
	 * modelMapperEntity: Mappper para DTO  
	 */
	@Autowired
	private ModelMapper modelMapperDTO;
	
	private PreguntaDTO convertToDto(Pregunta preguntaE) {
		return modelMapperDTO.map(preguntaE, PreguntaDTO.class);
	}
	
	private Pregunta convertToEntity(PreguntaDTO preguntaD) {
		return modelMapperEntity.map(preguntaD, Pregunta.class);
	}

	@Override
	public List<Pregunta> buscarTodos() {
		List<Pregunta> lista = iPreguntaRepositoy.findAll();
		
			
		return lista;
	}

	@Override
	public Pregunta buscarPorId(Integer id) {
		Optional<Pregunta> idOpcional = iPreguntaRepositoy.findById(id);
		Pregunta pregunta = idOpcional.get();
		return pregunta;
	}

	@Override
	public Pregunta guardarPregunta(Pregunta pregunta, MultipartFile archi) throws IOException {
		if(!archi.isEmpty()) {
			pregunta.setArchivo(archi.getBytes());
		}
				
		
		Pregunta guardar = iPreguntaRepositoy.save(pregunta);
		
		return guardar;
	}

	@Override
	public Pregunta actualizarPregunta(Pregunta pregunta) {
		Optional<Pregunta> idPerfil = iPreguntaRepositoy.findById(pregunta.getId());
		
				
		Pregunta regresaPregunta = iPreguntaRepositoy.save(pregunta);
		return regresaPregunta;
	}

	@Override
	public void eliminarPregunta(Integer id) {
		List<Respuesta> listaRespuesta = respuestaRepository.buscarPreguntaPorId(id);
		
		iPreguntaRepositoy.deleteById(id);		
	}
	
}
