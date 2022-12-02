package com.utng.askme.entity;

import java.util.Date;

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

	private Integer preguntaDto;
	
	private Integer tipoPregunta;
	
	private byte[] archivo;
}
