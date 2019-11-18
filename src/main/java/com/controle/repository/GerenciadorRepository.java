package com.controle.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.controle.model.GerenciadorM;
import com.controle.model.ProgramaM;

public class GerenciadorRepository extends GenericRepository<GerenciadorM, Long>{

	public GerenciadorRepository(EntityManager entityManager) {
		super(entityManager);
	}
	public List<GerenciadorM> listarTodosRegistrosComPaginacao(Integer primeiro, Integer tamanhoPagina){
		List<GerenciadorM> listaPrograma = new ArrayList<GerenciadorM>();
		try {
			TypedQuery<GerenciadorM> query = this.getEntityManager()
			                                .createQuery("SELECT g FROM GerenciadorM g", GerenciadorM.class)
											.setFirstResult(primeiro)
											.setMaxResults(tamanhoPagina);
			listaPrograma = query.getResultList();
		} catch( Exception e) {
			e.printStackTrace();
		}

		return listaPrograma;
	}
}
