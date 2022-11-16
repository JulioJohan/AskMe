package com.utng.askme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.askme.entity.Pregunta;
import com.utng.askme.entity.PreguntaDTO;
import com.utng.askme.repository.IPreguntaRepositoy;

@Service
public class PreguntaService implements IPreguntaService {

	@Autowired
	IPreguntaRepositoy iPreguntaRepositoy;
	
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
	public List<PreguntaDTO> buscarTodos() {
		List<Pregunta> listaDTO = (List<Pregunta>) iPreguntaRepositoy.findAll();
		List<PreguntaDTO>regresa = new ArrayList<>();
		for(Pregunta pregu: listaDTO) {
			regresa.add(convertToDto(pregu));
		}
			
		return regresa;
	}

	@Override
	public PreguntaDTO buscarPorId(Integer id) {
		Optional<Pregunta> idOpcional = iPreguntaRepositoy.findById(id);
		PreguntaDTO preguntaDto = convertToDto(idOpcional.get());
		return preguntaDto;
	}

	@Override
	public PreguntaDTO guardarPregunta(PreguntaDTO pregunta) {
		Pregunta preguntaEntity = convertToEntity(pregunta);
		
		
		Pregunta guardar = iPreguntaRepositoy.save(preguntaEntity);
		
		return convertToDto(guardar);
	}

	@Override
	public PreguntaDTO actualizarPregunta(PreguntaDTO pregunta) {
		Optional<Pregunta> idPerfil = iPreguntaRepositoy.findById(pregunta.getId());
		
		Pregunta preguntaEntity = convertToEntity(pregunta);
		
		Pregunta regresaPregunta = iPreguntaRepositoy.save(preguntaEntity);
		return convertToDto(regresaPregunta);
	}

	@Override
	public void eliminarPregunta(Integer id) {
		
		iPreguntaRepositoy.deleteById(id);
		
	}

	
	

	
}
