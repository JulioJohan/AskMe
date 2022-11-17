package com.utng.askme.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SubtemaDTO {

	private Integer id;
	
	private String nombre;

	private TemaDTO tema;


}
