package com.utng.askme.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.askme.entity.Subtema;
import com.utng.askme.entity.SubtemaDTO;
import com.utng.askme.repository.ISubtemaRepository;

@Service
public class SubtemaService implements ISubtemaService {

	@Autowired
	ISubtemaRepository subtemaRepository;
	
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
	
	private SubtemaDTO convertToDto(Subtema subtemaE) {
		return modelMapperDTO.map(subtemaE, SubtemaDTO.class);
	}
	
	private Subtema convertToEntity(SubtemaDTO subtemaD) {
		return modelMapperEntity.map(subtemaD, Subtema.class);
	}
	
	@Override
	public List<Subtema> consultarSubtemaPorTema(Integer id) {
		List<Subtema> buscar = subtemaRepository.buscarSubtemaPorTema(id);
		return buscar;
	}

	@Override
	public SubtemaDTO guardarSubtema(SubtemaDTO pregunta) {
		Subtema subtem = convertToEntity(pregunta);
		
		Subtema subtema = subtemaRepository.save(subtem);
		
		return convertToDto(subtema);
	}

	@Override
	public void eliminarSubtema(Integer id) {

		subtemaRepository.deleteById(id);
	}

}
