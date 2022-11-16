package com.utng.askme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utng.askme.entity.Tema;

public interface ITemaRepository extends JpaRepository<Tema, Integer> {

}
