package com.utng.askme.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RespuestaDTO {

	private Integer id;
	 
	private String descrpcionRespuesta;
	
	private PreguntaDTO preguntaDto;
	
	private byte[] archivo;
}
