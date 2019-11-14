package com.controle.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaUsuarioM extends AbstractTableModel{

	private static final long serialVersionUID = 6893553424676264421L;

	private final String colunas[] = {"Matricula","Tipo","Nome",
									   "Endereço","Número",
									   "Bairro","CEP","Cidade"};
	
	private List<UsuarioM> listaClientes;
	
	private static final int ID       = 0;
	private static final int TIPO     = 1;
	private static final int NOME     = 2;
	private static final int ENDERECO = 3;
	private static final int NUMERO   = 4;
	private static final int BAIRRO   = 5;
	private static final int CEP      = 6;
	private static final int CIDADE   = 7;
	


	
	public TabelaUsuarioM() {
           listaClientes = new ArrayList<UsuarioM>(); 
	}

	
	public UsuarioM getUsuario(int linhaIndex) {
		return this.getListaClientes().get(linhaIndex);
	}
	
	public void addCliente(UsuarioM  usuario) {
		this.getListaClientes().add(usuario);
		fireTableRowsInserted(getRowCount()-1, getRowCount()-1 );
	}
	
	public void updateCliente(UsuarioM  usuario, int linhaIndex) {
		this.getListaClientes().set(linhaIndex, usuario);
		fireTableRowsUpdated(linhaIndex, linhaIndex);
	}
	
	public void removeCliente(int linhaIndex) {
		this.getListaClientes().remove(linhaIndex);
		fireTableRowsDeleted(linhaIndex, linhaIndex);
	}
	
	public void removeTodosClientes() {
		this.getListaClientes().clear();
	}
		
	@Override
	public String getColumnName(int nomeColuna) {
		return this.colunas[nomeColuna];
	}
	
	
	@Override
	public int getColumnCount() {
		return this.getColunas().length;
	}

	@Override
	public int getRowCount() {
		return this.getListaClientes().size();
	}

	@Override
	public Object getValueAt(int linhaIndex, int colunaIndex) {
		
		UsuarioM usuario = this.getListaClientes().get(linhaIndex);
		
		switch(colunaIndex) {
		case ID:
			return usuario.getId();
		case NOME:
			return usuario.getNome();
		case BAIRRO:
			return usuario.getBairro();
		case CIDADE:
			return usuario.getCidade();
		case ENDERECO:
			return usuario.getEndereco();
		case CEP:
			return usuario.getCep();
		case NUMERO:
			return usuario.getNumero();
		case TIPO:
			return usuario.getTipo();
		
		default:
			return usuario;
		
		}
	}
	
	@Override
	public Class<?> getColumnClass(int colunaIndex){
		switch(colunaIndex) {
		case ID:
			return Long.class;
		case NOME:
			return String.class;
		case BAIRRO:
			return String.class;
		case CIDADE:
			return String.class;
		case ENDERECO:
			return String.class;
		case CEP:
			return String.class;
		case NUMERO:
			return String.class;
		case TIPO:
			return String.class;
		
		}
		return null;
	}
	

	public String[] getColunas() {
		return colunas;
	}

	public List<UsuarioM> getListaClientes() {
		return listaClientes;
	}
	
	
	public void setListaClientes(List<UsuarioM> listaClientes) {
		this.listaClientes = listaClientes;
	}


	public static int getId() {
		return ID;
	}

	public static int getNome() {
		return NOME;
	}

	public static int getBairro() {
		return BAIRRO;
	}

	public static int getCidade() {
		return CIDADE;
	}

	public static int getEndereco() {
		return ENDERECO;
	}
	
	public static int getCep() {
		return CEP;
	}

	public static int getNumero() {
		return NUMERO;
	}
	public static int getTipo() {
		return TIPO;
	}
	

	
}
