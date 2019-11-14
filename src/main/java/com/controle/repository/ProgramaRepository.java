package com.controle.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.controle.model.ProgramaM;

public class ProgramaRepository extends GenericRepository<ProgramaM, Long>{

	public ProgramaRepository(EntityManager entityManager) {
		super(entityManager);
	}

	public List<ProgramaM> listarTodosRegistrosComPaginacao(Integer primeiro, Integer tamanhoPagina){
		List<ProgramaM> listaPrograma = new ArrayList<ProgramaM>();
		try {
			TypedQuery<ProgramaM> query = this.getEntityManager()
			                                .createQuery("SELECT p FROM ProgramaM p", ProgramaM.class)
											.setFirstResult(primeiro)
											.setMaxResults(tamanhoPagina);
			listaPrograma = query.getResultList();
		} catch( Exception e) {
			e.printStackTrace();
		}

		return listaPrograma;
	}
}
