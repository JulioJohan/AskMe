package com.utng.askme.controller;

import java.util.List;


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
import org.springframework.web.bind.annotation.RestController;

import com.utng.askme.entity.TemaDTO;
import com.utng.askme.service.ITemaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/tema")
public class TemaController {
	
	@Autowired
	ITemaService temaService;

	@GetMapping("/consultarTodos")
	public ResponseEntity<List<TemaDTO>> consultarTodos(){
		List<TemaDTO> response = temaService.consultarTodos();
		return new ResponseEntity<List<TemaDTO>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/buscarId/{id}")
	public ResponseEntity<TemaDTO> buscarPorId(@PathVariable Integer id){
		TemaDTO response = temaService.buscarPorId(id);
		return new ResponseEntity<TemaDTO>(response, HttpStatus.OK);
	}
	
	@PostMapping("/guardarTema")
	public ResponseEntity<TemaDTO> guardar(@RequestBody TemaDTO temaDTO ) {
		TemaDTO response = temaService.guardarTema(temaDTO);
		return new ResponseEntity<TemaDTO>(response, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/eliminarTema/{id}")
	public ResponseEntity<Object> eliminarPregunta(@PathVariable Integer id) {
		temaService.eliminarTema(id);
		return ResponseEntity.noContent().build();
	}
	
}
