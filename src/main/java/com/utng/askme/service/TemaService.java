package com.utng.askme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.askme.entity.Subtema;
import com.utng.askme.entity.Tema;
import com.utng.askme.entity.TemaDTO;
import com.utng.askme.repository.ISubtemaRepository;
import com.utng.askme.repository.ITemaRepository;

@Service
public class TemaService implements ITemaService {

	@Autowired
	ITemaRepository temaRepository;
	
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
	
	private TemaDTO convertToDto(Tema temaE) {
		return modelMapperDTO.map(temaE, TemaDTO.class);
	}
	
	private Tema convertToEntity(TemaDTO temaDTO) {
		return modelMapperEntity.map(temaDTO, Tema.class);
	}
	
	@Override
	public List<TemaDTO> consultarTodos() {
		List<Tema> listaDTO = (List<Tema>) temaRepository.findAll();
		List<TemaDTO>regresa = new ArrayList<>();
		for(Tema tema: listaDTO) {
			regresa.add(convertToDto(tema));
		}
		return regresa;
	}

	@Override
	public TemaDTO buscarPorId(Integer id) {
		Optional<Tema> temaId = temaRepository.findById(id);
		TemaDTO temaDTO = convertToDto(temaId.get());		
		return temaDTO;
	}

	@Override
	public TemaDTO guardarTema(TemaDTO tema) {
		Tema tem = convertToEntity(tema);
		
		Tema tema1 = temaRepository.save(tem);

		return convertToDto(tema1);
	}

	@Override
	public void eliminarTema(Integer id) {
		List<Subtema> temaId = subtemaRepository.buscarSubtemaPorTema(id);
		if(!temaId.isEmpty()) {
			for(Subtema sub: temaId) {
				subtemaRepository.deleteById(sub.getId());
				
			}
		}		
		temaRepository.deleteById(id);
		
	}

}
