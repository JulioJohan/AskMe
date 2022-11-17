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

import com.utng.askme.entity.PreguntaDTO;
import com.utng.askme.service.IPreguntaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/pregunta")
public class PreguntaController {
	
	@Autowired
	IPreguntaService preguntaService;
	
	@GetMapping("/consultarTodos")
	public ResponseEntity<List<PreguntaDTO>> consultarTodos(){
		List<PreguntaDTO> response = preguntaService.buscarTodos();
		return new ResponseEntity<List<PreguntaDTO>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/buscarId/{id}")
	public ResponseEntity<PreguntaDTO> buscarPorId(@PathVariable Integer id){
		PreguntaDTO response = preguntaService.buscarPorId(id);
		return new ResponseEntity<PreguntaDTO>(response, HttpStatus.OK);
	}
	
	@PostMapping("/guardarPregunta")
	public ResponseEntity<PreguntaDTO> guardar(@Valid PreguntaDTO pregunta,@RequestParam MultipartFile archi) throws IOException{
		PreguntaDTO response = preguntaService.guardarPregunta(pregunta,archi);
		return new ResponseEntity<PreguntaDTO>(response, HttpStatus.OK);

	}
	@DeleteMapping("/eliminarPregunta/{id}")
	public ResponseEntity<Object> eliminarPregunta(@PathVariable Integer id) {
		preguntaService.eliminarPregunta(id);
		return ResponseEntity.noContent().build();
	}
	
}
