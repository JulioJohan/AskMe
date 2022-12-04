package com.utng.askme.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.askme.entity.Subtema;
import com.utng.askme.entity.SubtemaDTO;
import com.utng.askme.entity.Tema;
import com.utng.askme.repository.ISubtemaRepository;
import com.utng.askme.repository.ITemaRepository;

@Service
public class SubtemaService implements ISubtemaService {

	@Autowired
	ISubtemaRepository subtemaRepository;
	
	@Autowired
	ITemaRepository temaRepository;
	
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
	public Subtema guardarSubtema(SubtemaDTO subtemaR) {
		Subtema subtema = new Subtema();
		Tema tema = new Tema();
		Optional<Tema> optionalTema = temaRepository.findById(subtemaR.getTema());

		if(optionalTema.isPresent()) {
			tema = optionalTema.get();
			subtema.setNombre(subtemaR.getNombre());
			subtema.setTema(tema);
		}
		
		
		
		Subtema sub = subtemaRepository.save(subtema);
		return sub;
	}

	@Override
	public void eliminarSubtema(Integer id) {

		subtemaRepository.deleteById(id);
	}

}
