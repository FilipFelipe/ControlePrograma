package com.controle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_TELEFONE")
public class TelefoneM {

	private Long id;
	private String numeroTelefone;
	private String tipoTelefone;
	private UsuarioM usuario;

	public TelefoneM() {
		super();
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TELEFONE_ID")
	public Long getId() {
		
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="NUMERO_TELEFONE")
	public String getNumeroTelefone() {
		return numeroTelefone;
	}
	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	
	@Column(name = "TIPO_TELEFONE", 
			length = 20, 
			columnDefinition = "VARCHAR(20)", 
			nullable = false )
	public String getTipoTelefone() {
		return tipoTelefone;
	}
	
	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = UsuarioM.class)
	@JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID",
		foreignKey = @ForeignKey(name="FK_USUARIO_TELEFONE"), nullable = false,
		columnDefinition = "BIGINT(20)")
	public UsuarioM getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioM usuario) {
		this.usuario = usuario;
	}


	@Override
	public String toString() {
		return numeroTelefone;
	}
	
	
	
	
}
