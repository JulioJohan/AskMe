package com.utng.askme.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.utng.askme.entity.Pregunta;

public interface IAbstractFactory<T> {

	T crearPregunta (Pregunta preguntaParam, MultipartFile archi)throws IOException ;
}
