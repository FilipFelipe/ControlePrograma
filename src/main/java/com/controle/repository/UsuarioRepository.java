package com.controle.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.controle.model.TelefoneM;
import com.controle.model.UsuarioM;

public class UsuarioRepository extends GenericRepository<UsuarioM, Long>{

	public UsuarioRepository(EntityManager entityManager) {
		super(entityManager);
	}


	public List<UsuarioM> listarTodosRegistrosComPaginacao(Integer primeiro, Integer tamanhoPagina){
		List<UsuarioM> listaUsuario = new ArrayList<UsuarioM>();
		try {
			TypedQuery<UsuarioM> query = this.getEntityManager()
			                                .createQuery("SELECT u FROM UsuarioM u", UsuarioM.class)
											.setFirstResult(primeiro)
											.setMaxResults(tamanhoPagina);
			listaUsuario = query.getResultList();
		} catch( Exception e) {
			e.printStackTrace();
		}

		return listaUsuario;
	}



}
