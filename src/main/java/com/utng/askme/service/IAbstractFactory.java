package com.utng.askme.service;

import com.utng.askme.entity.Pregunta;

public interface IAbstractFactory<T> {

	T crearPregunta (Pregunta preguntaParam);
}
