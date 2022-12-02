package com.utng.askme.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PreguntaBusquedaDTO {

	private String tipoPregunta;
	
	private String busqueda;
}
