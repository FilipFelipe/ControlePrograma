package com.controle.repository;

import javax.persistence.EntityManager;

import com.controle.model.GerenciadorM;

public class GerenciadorRepository extends GenericRepository<GerenciadorM, Long>{

	public GerenciadorRepository(EntityManager entityManager) {
		super(entityManager);
	}
}
