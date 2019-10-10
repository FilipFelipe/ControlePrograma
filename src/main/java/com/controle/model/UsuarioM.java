package com.controle.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_USUARIOS")
public class UsuarioM {
	
	
	private Long   id;
	private String nome;
	private String bairro;
	private String cidade;
	private String endereco;
	private List<TelefoneM> telefones;
	private String cep;
	private String numero;
	private String senha;
	private String tipo;
	
	
	public UsuarioM() {
	}


	public UsuarioM(Long id, String nome, String bairro, String endereco, String cidade, List<TelefoneM> telefone, String cep, String numero,String senha, String tipo) {
		this.id = id;
		this.nome = nome;
		this.bairro = bairro;
		this.cidade = cidade;
		this.telefones = telefone;
		this.cep = cep;
		this.numero = numero;
		this.senha = senha;
		this.tipo = tipo;
		this.endereco = endereco;
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
	@OneToMany(mappedBy = "usuario",targetEntity = TelefoneM.class, cascade =
	CascadeType.ALL,fetch = FetchType.LAZY)
	public List<TelefoneM> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<TelefoneM>telefone) {
			this.telefones = telefone;
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
	@Column(name = "USUARIO_SENHA", nullable = false, length = 20 )
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Column(name = "USUARIO_TIPO", nullable = false, length = 50 )
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		UsuarioM other = (UsuarioM) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + ", numero=" + numero + ", tipo=" + tipo +"]";
	}

	@Column(name = "USUARIO_ENDERECO", nullable = false, length = 50 )
	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	
	
	
	
	
	
	
	
	

}
