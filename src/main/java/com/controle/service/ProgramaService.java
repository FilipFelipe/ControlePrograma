package com.controle.service;

import java.util.List;

import javax.persistence.EntityTransaction;


import com.controle.model.ProgramaM;
import com.controle.model.UsuarioM;
import com.controle.repository.ProgramaRepository;


public class ProgramaService extends ConexaoBancoService {
	
	private ProgramaRepository ProgramaRepository;
	
	private static Integer ERRO_INCLUSAO = 1;
	private static Integer ERRO_ALTERACAO = 2;
	private static Integer ERRO_EXCLUSAO = 3;
	private static Integer SUCESSO_TRANSACAO = 0;
	
	public ProgramaService() {
		ProgramaRepository = new ProgramaRepository(getEntityManager());
	}
	
		
	public Integer salvarPrograma(ProgramaM programa) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			ProgramaRepository.save(programa);
			transacao.commit();
		}catch (Throwable e) {
			e.printStackTrace();
	        if (transacao.isActive()) {
	        	transacao.rollback();
	        	close();
	        }
			return ERRO_INCLUSAO;
		} finally {
			close();
		}
		return SUCESSO_TRANSACAO;
	}
	

	public Integer alterarPrograma(ProgramaM programa) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			ProgramaRepository.update(programa);
			transacao.commit();
		} catch(Throwable e) {
			e.printStackTrace();
			if (transacao.isActive()) {
				transacao.rollback();
				close();
			}
			return ERRO_ALTERACAO;
		} finally {
			close();
		}
		return SUCESSO_TRANSACAO;
	}
	
	
	public Integer excluirPrograma(ProgramaM programa) {
		EntityTransaction transacao = this.getEntityManager().getTransaction(); 
	      try {
	    	  transacao.begin();	
			ProgramaRepository.remove(programa);
			transacao.commit();
		} catch(Throwable e) {
			e.printStackTrace();
			if (transacao.isActive()) {
				transacao.rollback();
				close();
			}
			return ERRO_EXCLUSAO;
		} finally {
			close();
		}
		return SUCESSO_TRANSACAO;
	}
	
	
	
	public ProgramaM consultar(Long id) {
		return ProgramaRepository.findById(id);
	}
	public List<ProgramaM> listarTodosProgramas(){
		return ProgramaRepository.findAll(ProgramaM.class);
	}
}
