package com.controle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_PROGRAMA")
public class ProgramaM {
	
	
	private Long   id;
	private String nome;
	private String versao;
	private String permissao;
	private String status;
	
	public ProgramaM() {
	}


	public ProgramaM(Long id, String nome, String versao, String permissao, String status) {
		this.id = id;
		this.nome = nome;
		this.setVersao(versao);
		this.setPermissao(permissao);
		this.setStatus(status);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROGRAMA_ID")
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Column(name = "PROGRAMA_NOME", nullable = false, length = 100 )
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProgramaM other = (ProgramaM) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", versao=" + versao + ", permissao=" + permissao +", status=" + status + "]";
	}

	@Column(name = "PROGRAMA_VERSAO", nullable = false, length = 15 )
	public String getVersao() {
		return versao;
	}


	public void setVersao(String versao) {
		this.versao = versao;
	}

	@Column(name = "PROGRAMA_PERMISSAO", nullable = false, length = 15 )
	public String getPermissao() {
		return permissao;
	}


	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	@Column(name = "PROGRAMA_STATUS", nullable = false, length = 15 )
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	


}
