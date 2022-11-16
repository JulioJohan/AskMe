package com.utng.askme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utng.askme.entity.Pregunta;

public interface IPreguntaRepositoy extends JpaRepository<Pregunta, Integer>{

}
