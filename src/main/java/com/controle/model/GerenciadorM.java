package com.controle.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_GERENCIADOR")
public class GerenciadorM {
	
	
	private Long   id;
	private String nome;
	private String bairro;
	private String cidade;
	private String cep;
	private String numero;
	public GerenciadorM() {
	}


	public GerenciadorM(Long id, String nome, String bairro, String cidade,List<TelefoneM> telefone, String cep, String numero,String senha, List<TelefoneM> telefones) {
		this.id = id;
		this.nome = nome;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.numero = numero;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROCESSO_ID")
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Column(name = "PROGRAMA_ID", nullable = false, length = 100 )
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	@Column(name = "USUARIO_ID", nullable = false, length = 50 )
	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	


	@Override
	public String toString() {
		return "Gerenciador [id=" + id + ", nome=" + nome + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + ", numero=" + numero + "]";
	}
	
	
	
	
	
	
	
	
	

}
