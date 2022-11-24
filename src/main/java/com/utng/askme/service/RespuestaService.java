package com.utng.askme.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Respuesta;
import com.utng.askme.entity.RespuestaDTO;
import com.utng.askme.entity.RespuestaLikesDTO;
import com.utng.askme.repository.IPreguntaRepositoy;
import com.utng.askme.repository.IRespuestaRepositoy;

@Service
public class RespuestaService implements IRespuestaService {

	@Autowired
	IRespuestaRepositoy respuestaRepositoy;
	
	@Autowired
	IPreguntaRepositoy preguntaRepository;
	
	@Autowired
	EntityManager entityManager;

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

	private RespuestaDTO convertToDto(Respuesta respuestaE) {
		return modelMapperDTO.map(respuestaE, RespuestaDTO.class);
	}

	private Respuesta convertToEntity(RespuestaDTO respuestaD) {
		return modelMapperEntity.map(respuestaD, Respuesta.class);
	}

	@Override
	public List<RespuestaDTO> traeTodos() {
		List<Respuesta> listaRespuesta = (List<Respuesta>) respuestaRepositoy.findAll();
		List<RespuestaDTO> regresa = new ArrayList<>();
		for (Respuesta respuesta : listaRespuesta) {
			regresa.add(convertToDto(respuesta));
		}
		return regresa;
	}

	@Override
	public RespuestaDTO encoentrarRespuestaPorId(Integer id) {
		Optional<Respuesta> buscarId = respuestaRepositoy.findById(id);

		RespuestaDTO respuestaDTO = convertToDto(buscarId.get());

		return respuestaDTO;
	}

	@Override
	public RespuestaDTO guardarRespuesta(RespuestaDTO respuestaDTO, MultipartFile archi) throws IOException {
		if (!archi.isEmpty()) {
			respuestaDTO.setArchivo(archi.getBytes());
		}
		Respuesta respuesta = convertToEntity(respuestaDTO);

		Respuesta guardar = respuestaRepositoy.save(respuesta);
		return convertToDto(guardar);
	}

	@Override
	public void eliminarRespuestaId(Integer respuestaDTO) {
		respuestaRepositoy.deleteById(respuestaDTO);
		

	}

	@Override
	@Transactional
	public Integer sumarLikes(Integer idRespuesta) {
		
		Query query = entityManager.createNativeQuery("UPDATE respuesta r SET r.like_respuesta = r.like_respuesta +1 WHERE r.id =:id");
		query.setParameter("id", idRespuesta);
		
		query.executeUpdate();
		return idRespuesta;
				
	}

	@Override
	@Transactional
	public Integer restarLikes(Integer idRespuesta) {
		Query query = entityManager.createNativeQuery("UPDATE respuesta r SET r.like_respuesta = r.like_respuesta -1 WHERE r.id =:id");
		
		query.setParameter("id", idRespuesta);
		query.executeUpdate();

		return idRespuesta;
		
	}
	
	

}