package com.utng.askme.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SUBTEMA")
public class Subtema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOMBRE_SUBTEMA")
	private String nombre;
	
	//Muchos Subtemas puede tener un tema
	@ManyToOne
	@JoinColumn(name="ID_TEMA_FK")
	private Tema tema;
	
}
