package com.utng.askme.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Pregunta;
import com.utng.askme.entity.Respuesta;
import com.utng.askme.entity.RespuestaDTO;
import com.utng.askme.repository.IRespuestaRepositoy;
import com.utng.askme.service.IRespuestaService;
import com.utng.askme.service.RespuestaFacebookService;

@RestController
@CrossOrigin("*")
@RequestMapping("/respuesta")
public class RespuestaController {

	@Autowired
	RespuestaFacebookService respuestaService;
	
	
	@Autowired
	IRespuestaRepositoy respuestaRepositoy;

	
	
	@GetMapping("/consultar/img/{id}")
	public ResponseEntity<?> verFoto(@PathVariable Integer id){
		Optional<Respuesta> optionalR = respuestaRepositoy.findById(id);
			
		Resource image = new ByteArrayResource(optionalR.get().getArchivo());
		
//		if(optionalR.isEmpty()|| optionalR.get().getArchivo()==null) {
//			return ResponseEntity.notFound().build();
//		}
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	}
	
//	@GetMapping("/consultarTodos")
//	public ResponseEntity<List<RespuestaDTO>> consultarTodos(){
//		List<RespuestaDTO> response = respuestaService.traeTodos();
//		return new ResponseEntity<List<RespuestaDTO>>(response, HttpStatus.OK);
//	}
//	
	@GetMapping("/buscarId/{idPregunta}")
	public ResponseEntity<List<Respuesta>> buscarPorId(@PathVariable Integer idPregunta){
		List<Respuesta> response = respuestaService.traeTodosPorID(idPregunta);
		return new ResponseEntity <List<Respuesta>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/guardarRespuesta")
	public ResponseEntity<Respuesta> guardar(@Valid RespuestaDTO pregunta,@RequestParam MultipartFile archi) throws IOException{
		Respuesta response = respuestaService.guardarRespuesta(pregunta,archi);
		return new ResponseEntity<Respuesta>(response, HttpStatus.OK);

	}
//	
	@DeleteMapping("/eliminarRespuesta/{id}")
	public ResponseEntity<Object> eliminarPregunta(@PathVariable Integer id) {
		respuestaService.eliminarRespuestaId(id);
		return ResponseEntity.noContent().build();
	}
//	
//	
//	@PutMapping("/sumarLikes/{idRespuesta}")
//	public ResponseEntity<Integer> sumarLikes(@PathVariable Integer idRespuesta) throws IOException{
//		Integer response = respuestaService.sumarLikes(idRespuesta);
//		return new ResponseEntity<Integer>(response,HttpStatus.OK);
//	}
//	
//	@PutMapping("/restarLikes/{idRespuesta}")
//	public ResponseEntity<Integer> restarLikes(@PathVariable Integer idRespuesta) throws IOException{
//		Integer response = respuestaService.restarLikes(idRespuesta);
//		return new ResponseEntity<Integer>(response,HttpStatus.OK);
//	}
	
	
	
}
