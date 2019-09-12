package com.controle.repository;

import javax.persistence.EntityManager;

import com.controle.model.ProgramaM;

public class ProgramaRepository extends GenericRepository<ProgramaM, Long>{

	public ProgramaRepository(EntityManager entityManager) {
		super(entityManager);
	}


}
