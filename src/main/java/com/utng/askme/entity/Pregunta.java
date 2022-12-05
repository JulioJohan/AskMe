package com.utng.askme.entity;

import java.util.Date;

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
	
	@Column(name = "LIKE_PREGUNTA")
	private Integer like;
	
	@Column(name = "FECHA_PUBLICACION")
	private Date fecha;
	
	@Column(name = "TIPO_PREGUNTA")
	private String tipoPregunta;
	
	@Lob
	@JsonIgnore
	@Column(name = "ARCHIVO")
	private byte[] archivo;
		
	public Pregunta() {
		
	}
	
	public Integer getArchivoHashCode() {
		return(this.archivo != null) ? this.archivo.hashCode():null;
	}
	
}

