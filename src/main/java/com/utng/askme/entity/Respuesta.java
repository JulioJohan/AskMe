package com.utng.askme.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "RESPUESTA")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "DESCRIPCION_RESPUESTA")
	private String descripcionRespuesta;
	
	@Column(name = "LIKE_RESPUESTA")
	private Integer like;
	
	//Muchas Respuestas tienen una pregunta
	@ManyToOne
	@JoinColumn(name = "ID_PREGUNTA_FK")
	private Pregunta pregunta;
	
	@Lob
	@JsonIgnore
	private byte[] archivo;
	
}
