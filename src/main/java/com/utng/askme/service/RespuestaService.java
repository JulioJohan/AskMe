package com.utng.askme.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

	@Override
	public List<Respuesta> traeTodos() {
		List<Respuesta> listaRespuesta = respuestaRepositoy.findAll();
		return listaRespuesta;
	}

	@Override
	public Respuesta encoentrarRespuestaPorId(Integer id) {
		Optional<Respuesta> buscarId = respuestaRepositoy.findById(id);
		return buscarId.get();
	}

	@Override
	public Respuesta guardarRespuesta(Respuesta respuestaDTO, MultipartFile archi) throws IOException {
		if (!archi.isEmpty()) {
			respuestaDTO.setArchivo(archi.getBytes());
		}
		respuestaDTO.setLike(0);
		respuestaDTO.setFecha(new Date());
		Respuesta guardar = respuestaRepositoy.save(respuestaDTO);
		return guardar;
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
