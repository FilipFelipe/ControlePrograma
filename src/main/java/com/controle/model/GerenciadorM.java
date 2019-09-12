package com.controle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "TAB_GERENCIADOR")
public class GerenciadorM {
	
	
	private Long   id;
	private String nome;
	private String bairro;
	private String cidade;
	private String telefone;
	private String cep;
	private String numero;
	private String senha;
	private UsuarioM usuario;

	public GerenciadorM() {
	}


	public GerenciadorM(Long id, String nome, String bairro, String cidade, String telefone, String cep, String numero,String senha) {
		this.id = id;
		this.nome = nome;
		this.bairro = bairro;
		this.cidade = cidade;
		this.telefone = telefone;
		this.cep = cep;
		this.numero = numero;
		this.senha = senha;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USUARIO_ID")
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Column(name = "USUARIO_NOME", nullable = false, length = 100 )
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	@Column(name = "USUARIO_BAIRRO", nullable = false, length = 50 )
	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	@Column(name = "USUARIO_CIDADE", nullable = false, length = 100 )
	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	@Column(name = "USUARIO_TELEFONE", nullable = false, length = 15 )
	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Column(name = "USUARIO_CEP", nullable = false, length = 10 )
	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}

	
	@Column(name = "USUARIO_NUMERO", nullable = false, length = 5 )
	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Column(name = "USUARIO_SENHA", nullable = false, length = 50 )
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
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
		GerenciadorM other = (GerenciadorM) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", bairro=" + bairro + ", cidade=" + cidade + ", telefone="
				+ telefone + ", cep=" + cep + ", numero=" + numero + "]";
	}
	
	
	
	
	
	
	
	
	

}
