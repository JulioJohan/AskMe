package com.utng.askme.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PREGUNTA")
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "TITULO_PREGUNTA")
	private String tituloPregunta;
	
	@Column(name = "DESCRIPCION_PREGUNTA")
	private String descripcionPregunta;
	
	@Column(name = "TEMA_PREGUNTA")
	private String temaPregunta;
	
	@Column(name = "SUBTEMA_PREGUNTA")
	private String subtemaPregunta;
	
	@Lob
	@JsonIgnore
	private byte[] archivo;
		
	
}

