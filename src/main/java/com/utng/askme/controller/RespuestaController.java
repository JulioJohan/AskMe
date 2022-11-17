package com.utng.askme.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.RespuestaDTO;
import com.utng.askme.service.IRespuestaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/respuesta")
public class RespuestaController {

	@Autowired
	IRespuestaService respuestaService;
	
	@GetMapping("/consultarTodos")
	public ResponseEntity<List<RespuestaDTO>> consultarTodos(){
		List<RespuestaDTO> response = respuestaService.traeTodos();
		return new ResponseEntity<List<RespuestaDTO>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/buscarId/{id}")
	public ResponseEntity<RespuestaDTO> buscarPorId(@PathVariable Integer id){
		RespuestaDTO response = respuestaService.encoentrarRespuestaPorId(id);
		return new ResponseEntity<RespuestaDTO>(response, HttpStatus.OK);
	}
	
	@PostMapping("/guardarRespuesta")
	public ResponseEntity<RespuestaDTO> guardar(@Valid RespuestaDTO pregunta,@RequestParam MultipartFile archi) throws IOException{
		RespuestaDTO response = respuestaService.guardarRespuesta(pregunta,archi);
		return new ResponseEntity<RespuestaDTO>(response, HttpStatus.OK);

	}
	
	@DeleteMapping("/eliminarRespuesta/{id}")
	public ResponseEntity<Object> eliminarPregunta(@PathVariable Integer id) {
		respuestaService.eliminarRespuestaId(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
