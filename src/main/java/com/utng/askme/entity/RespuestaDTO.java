package com.utng.askme.entity;

import java.util.Date;

import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RespuestaDTO {

	private Integer id;
	 
	private String descrpcionRespuesta;
	
	private Integer like;
	
	private Date fecha;
	
	private Integer id_pregunta_fk;
	
	private String tipoPregunta;
	
	@Lob
	@JsonIgnore
	private byte[] archivo;

	
}
