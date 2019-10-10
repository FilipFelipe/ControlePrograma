package com.controle.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.controle.model.TelefoneM;
import com.controle.model.UsuarioM;

public class UsuarioRepository extends GenericRepository<UsuarioM, Long>{

	public UsuarioRepository(EntityManager entityManager) {
		super(entityManager);
	}




}
