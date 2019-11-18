package com.controle.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaGerenciadorM extends AbstractTableModel{

	private static final long serialVersionUID = 6893553425576264421L;

	private final String colunas[] = {"ID","Nome","Programa"};
	
	private List<GerenciadorM> ListaServico;
	
	private static final int ID       		= 0;
	private static final int NOME        	= 1;
	private static final int PROGRAMA 		= 2;


	public TabelaGerenciadorM() {
		ListaServico = new ArrayList<GerenciadorM>(); 
	}

	
	public GerenciadorM getPrograma(int linhaIndex) {
		return this.getListaPrograma().get(linhaIndex);
	}
	
	public void addCliente(GerenciadorM  gerenciador) {
		this.getListaPrograma().add(gerenciador);
		fireTableRowsInserted(getRowCount()-1, getRowCount()-1 );
	}
	
	public void updateCliente(GerenciadorM  gerenciador, int linhaIndex) {
		this.getListaPrograma().set(linhaIndex, gerenciador);
		fireTableRowsUpdated(linhaIndex, linhaIndex);
	}
	
	public void removeCliente(int linhaIndex) {
		this.getListaPrograma().remove(linhaIndex);
		fireTableRowsDeleted(linhaIndex, linhaIndex);
	}
	
	public void removeTodosClientes() {
		this.getListaPrograma().clear();
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
		return this.getListaPrograma().size();
	}


	@Override
	public Object getValueAt(int linhaIndex, int colunaIndex) {
		
		GerenciadorM gerenciador = this.getListaPrograma().get(linhaIndex);
	
		switch(colunaIndex) {
		case ID:
			return gerenciador.getId();
		case NOME:
			return gerenciador.getNome();
		case PROGRAMA:
			return gerenciador.getprograma();
		
		default:
			return gerenciador;
		
		}
	}
	
	@Override
	public Class<?> getColumnClass(int colunaIndex){
		switch(colunaIndex) {
		case ID:
			return Long.class;
		case NOME:
			return String.class;
		case PROGRAMA:
			return String.class;
		}
		return null;
	}
	

	public String[] getColunas() {
		return colunas;
	}

	public List<GerenciadorM> getListaPrograma() {
		return ListaServico;
	}
	
	
	public void setListaPrograma(List<GerenciadorM> ListaServico) {
		this.ListaServico = ListaServico;
	}


	public static int getId() {
		return ID;
	}

	public static int getNome() {
		return NOME;
	}
	public static int getprograma() {
		return PROGRAMA;
	}



	

	
}
