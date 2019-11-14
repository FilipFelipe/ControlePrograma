package com.controle.service;

import java.util.List;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import com.controle.model.UsuarioM;
import com.controle.repository.UsuarioRepository;
public class UsuarioService extends ConexaoBancoService {
	
	private UsuarioRepository clienteRepository;
	
	private static Integer ERRO_INCLUSAO = 1;
	private static Integer ERRO_ALTERACAO = 2;
	private static Integer ERRO_EXCLUSAO = 3;
	private static Integer SUCESSO_TRANSACAO = 0;
	
	public UsuarioService() {
		clienteRepository = new UsuarioRepository(getEntityManager());
	}
	
		
	public Integer salvarCliente(UsuarioM usuario) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			clienteRepository.save(usuario);
			
			
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
	
	
	public Integer alterarCLiente(UsuarioM usuario) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			clienteRepository.update(usuario);
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
	
	
	public Integer excluirCliente(UsuarioM usuario) {
		EntityTransaction transacao = this.getEntityManager().getTransaction(); 
	      try {
	    	  transacao.begin();	
			clienteRepository.remove(usuario);
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
	public Integer listarcliente(UsuarioM usuario) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			clienteRepository.remove(usuario);
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
	
	
	public UsuarioM consultarCliente(Long id) {
		UsuarioM usuario=null;
	try {
		usuario = clienteRepository.findById(id);
        	JOptionPane.showMessageDialog(null, "Usuário: " + usuario.getNome() + " encontrado" );		
	} catch(Throwable e) {
		JOptionPane.showMessageDialog(null, "Usuário não cadastrado! Erro: " + e);
		}
		return usuario;
	}
	public UsuarioM consultarSenha(Long id) {
	
		return clienteRepository.findById(id);
	}
	public List<UsuarioM> listarTodosClientes(){
		return clienteRepository.findAll(UsuarioM.class);
	}

	public Integer calcularTotalRegistros() {
		return clienteRepository.calcularTotalRegistros(UsuarioM.class);
	}
	
	
	public List<UsuarioM> listarTodosRegistrosComPaginacao(Integer primeiro, Integer tamanhoPagina){
	    return clienteRepository.listarTodosRegistrosComPaginacao(primeiro, tamanhoPagina);
	}
	
}
