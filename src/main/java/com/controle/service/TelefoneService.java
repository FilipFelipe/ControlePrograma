package com.controle.service;

import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

import com.controle.model.TelefoneM;
import com.controle.repository.TelefoneRepository;
public class TelefoneService<telefoneRepository> extends ConexaoBancoService {
	
	private TelefoneRepository telefoneRepository;
	
	private static Integer ERRO_INCLUSAO = 1;
	private static Integer ERRO_ALTERACAO = 2;
	private static Integer ERRO_EXCLUSAO = 3;
	private static Integer SUCESSO_TRANSACAO = 0;
	
	public TelefoneService() {
		telefoneRepository = new TelefoneRepository(getEntityManager());
	}
	
		
	public Integer salvarTelefone(TelefoneM telefone) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			telefoneRepository.save(telefone);
			
			
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
	
	
	public Integer alterarTelefone(TelefoneM telefone) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			telefoneRepository.update(telefone);
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
	
	
	public Integer excluirCliente(TelefoneM telefone) {
		EntityTransaction transacao = this.getEntityManager().getTransaction(); 
	      try {
	    	  transacao.begin();	
			telefoneRepository.remove(telefone);
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
	public Integer listarcliente(TelefoneM telefone) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			telefoneRepository.remove(telefone);
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
	
	
	public TelefoneM consultarTelefone(Long id) {
		TelefoneM telefone=null;
	try {
		telefone = telefoneRepository.findById(id);
        		
	} catch(Throwable e) {
		JOptionPane.showMessageDialog(null, "Usuário não cadastrado! Erro: " + e);
		}
		return telefone;
	}

	
	
}
