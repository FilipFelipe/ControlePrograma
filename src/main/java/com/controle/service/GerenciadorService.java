package com.controle.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;


import com.controle.model.GerenciadorM;
import com.controle.model.UsuarioM;
import com.controle.repository.GerenciadorRepository;

public class GerenciadorService extends ConexaoBancoService {
	
	private GerenciadorRepository GerenciadorRepository;
	
	private static Integer ERRO_INCLUSAO = 1;
	private static Integer ERRO_ALTERACAO = 2;
	private static Integer ERRO_EXCLUSAO = 3;
	private static Integer SUCESSO_TRANSACAO = 0;
	
	public GerenciadorService() {
		GerenciadorRepository = new GerenciadorRepository(getEntityManager());
	}
	
	public static class ConnectionFactory {
	    
	    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("controle");
	    
	    public EntityManager getConnection(){
	        return emf.createEntityManager();
	    }
	}
	public Integer salvarGerenciador(GerenciadorM cliente) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			GerenciadorRepository.save(cliente);
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
	

	public Integer alterarGerenciador(GerenciadorM cliente) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			GerenciadorRepository.update(cliente);
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
	
	
	
	public Integer listarcliente(GerenciadorM cliente) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			GerenciadorRepository.remove(cliente);
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

	 public GerenciadorM remove(long l) {
	        EntityManager em = new ConnectionFactory().getConnection();
	        GerenciadorM carros = null;
	        try {
	        	
	            carros = em.find(GerenciadorM.class, l);
	            em.getTransaction().begin();
	            em.remove(carros);
	            em.getTransaction().commit();
	            JOptionPane.showMessageDialog(null, "Removido com Sucesso");
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Erro ao remover remove " + e);
	            em.getTransaction().rollback();
	        } finally {
	            em.close();
	        }

	        return carros;
	    }
	 public GerenciadorM consultarGerenciador(Long id) {
		 GerenciadorM gerenciador=null;
		try {
			gerenciador = GerenciadorRepository.findById(id);
	        	JOptionPane.showMessageDialog(null, "Usuário: " + gerenciador.getNome() + " encontrado" );		
		} catch(Throwable e) {
			JOptionPane.showMessageDialog(null, "Usuário não cadastrado! Erro: " + e);
			}
			return gerenciador;
		}
		

}
