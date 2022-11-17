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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utng.askme.entity.Subtema;
import com.utng.askme.entity.SubtemaDTO;
import com.utng.askme.service.ISubtemaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/subtema")
public class SubtemaController {

	@Autowired
	ISubtemaService subtemaService;
	
	@GetMapping("/consultarTodos")
	public ResponseEntity<List<Subtema>> consultarTodos(@RequestParam Integer id){
		List<Subtema> response = subtemaService.consultarSubtemaPorTema(id);
		return new ResponseEntity<List<Subtema>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/guardarSubtema")
	public ResponseEntity<SubtemaDTO> guardar(@RequestBody SubtemaDTO temaDTO ) {
		SubtemaDTO response = subtemaService.guardarSubtema(temaDTO);
		return new ResponseEntity<SubtemaDTO>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminarSubtema/{id}")
	public ResponseEntity<Object> eliminarPregunta(@PathVariable Integer id) {
		subtemaService.eliminarSubtema(id);
		return ResponseEntity.noContent().build();
	}
}
