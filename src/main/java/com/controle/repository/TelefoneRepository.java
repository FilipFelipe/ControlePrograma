package com.controle.repository;

import javax.persistence.EntityManager;

import com.controle.model.TelefoneM;

public class TelefoneRepository extends GenericRepository<TelefoneM, Long>{

	public TelefoneRepository(EntityManager entityManager) {
		super(entityManager);
	}





}
