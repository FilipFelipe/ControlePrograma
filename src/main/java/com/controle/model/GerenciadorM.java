package com.controle.model;

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
	private String nome_id;
	private String programa;
	private String programa_id;

	public GerenciadorM() {
	}


	public GerenciadorM(Long id, String nome, String nome_id, String programa,String programa_id) {
		this.id = id;
		this.nome = nome;
		this.nome_id = nome_id;
		this.programa = programa;
		this.programa_id = programa_id;
	
	}
 // *** ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GERENCIADOR_ID")
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	//*** NOME PROGRAMA
	@Column(name = "PROGRAMA", nullable = false, length = 100 )
	public String getprograma() {
		return programa;
	}


	public void setprograma(String programa) {
		this.programa = programa;
	}
	
	//*** PROGRAMA ID 
	
	
	@Column(name = "PROGRAMA_ID", nullable = false, length = 100 )
	public String getPrograma_id() {
		return programa_id;
	}


	public void setPrograma_id(String programa_id) {
		this.programa_id = programa_id;
	}

	
	//*** NOME ID
	
	@Column(name = "NOME_ID", nullable = false, length = 50 )
	public String getNome_id() {
		return nome_id;
	}


	public void setNome_id(String nome_id) {
		this.nome_id = nome_id;
	}

	//*** NOME
	
	@Column(name = "NOME", nullable = false, length = 50 )
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	


	@Override
	public String toString() {
		return "Gerenciador [id=" + id + ", nome=" + nome + ", nome_id=" + nome_id + ", programa=" + programa + ", programa_id=" + programa_id + "]";
	}
	
	
	
	
	
	
	
	
	

}
