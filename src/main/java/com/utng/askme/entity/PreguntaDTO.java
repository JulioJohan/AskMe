package com.utng.askme.entity;

import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PreguntaDTO {

	private Integer id;
	
	private String tituloPregunta;
	
	private String descripcionPregunta;
	
	private String temaPregunta;

	private String subtemaPregunta;

	@Lob
	@JsonIgnore
	private byte[] archivo;



	
}
