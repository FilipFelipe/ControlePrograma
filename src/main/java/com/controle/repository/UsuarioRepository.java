package com.controle.repository;

import javax.persistence.EntityManager;

import com.controle.model.UsuarioM;

public class UsuarioRepository extends GenericRepository<UsuarioM, Long>{

	public UsuarioRepository(EntityManager entityManager) {
		super(entityManager);
	}
}
