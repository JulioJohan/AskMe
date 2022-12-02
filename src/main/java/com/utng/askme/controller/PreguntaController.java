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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Pregunta;
import com.utng.askme.entity.PreguntaBusquedaDTO;
import com.utng.askme.service.IPreguntaService;
import com.utng.askme.service.PreguntaFactoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/pregunta")
public class PreguntaController {
	
//	@Autowired
//	IPreguntaService preguntaService;
	
	@Autowired
	PreguntaFactoryService preguntaFactory;
	
	@GetMapping("/consultarTodos/{tipoPregunta}")
	public ResponseEntity<List<Pregunta>> buscarTodo(@PathVariable String tipoPregunta){
		List<Pregunta> response = preguntaFactory.buscarTodo(tipoPregunta);
		return new ResponseEntity<List<Pregunta>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/buscarPorNombreTema")
	public ResponseEntity <List<Pregunta>>buscarPorNombreTema(@RequestBody PreguntaBusquedaDTO preguntaParam){
		List<Pregunta> response = preguntaFactory.buscarPorNombre(preguntaParam);
		return new ResponseEntity<List<Pregunta>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/buscarPorNombreSubtema")
	public ResponseEntity <List<Pregunta>>buscarPorNombreSubtema(@RequestBody PreguntaBusquedaDTO preguntaParam){
		List<Pregunta> response = preguntaFactory.buscarPorNombre(preguntaParam);
		return new ResponseEntity<List<Pregunta>>(response, HttpStatus.OK);
	}
	
	
	
//	@PostMapping("/guardarPregunta")
//	public ResponseEntity<Pregunta> guardar(@Valid Pregunta pregunta,@RequestParam MultipartFile archi) throws IOException{
//		Pregunta response = preguntaService.guardarPregunta(pregunta,archi);
//		return new ResponseEntity<Pregunta>(response, HttpStatus.OK);
//
//	}
	@DeleteMapping("/eliminarPregunta/{id}")
	public ResponseEntity<Object> eliminarPregunta(@Valid Pregunta pregunta) {
		preguntaFactory.eliminarPregunta(pregunta);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/guardarPregunta")
	public ResponseEntity<Pregunta> guardarPreguntaTipo(@Valid Pregunta pregunta,@RequestParam MultipartFile archi) throws IOException{
		Pregunta response = preguntaFactory.crearPregunta(pregunta,archi);
		return new ResponseEntity<Pregunta>(response, HttpStatus.OK);
	}
	
}
