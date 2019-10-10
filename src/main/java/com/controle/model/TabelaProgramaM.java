package com.controle.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaProgramaM extends AbstractTableModel{

	private static final long serialVersionUID = 6893553424676264421L;

	private final String colunas[] = {"ID do Programa","Permissão","Nome",
									   "Status","Versão"};
	
	private List<ProgramaM> ListaPrograma;
	
	private static final int ID       		= 0;
	private static final int PERMISSAO     	= 1;
	private static final int NOME    		= 2;
	private static final int STATUS 		= 3;
	private static final int VERSAO   		= 4;

	
	public TabelaProgramaM() {
		ListaPrograma = new ArrayList<ProgramaM>(); 
	}

	
	public ProgramaM getPrograma(int linhaIndex) {
		return this.getListaPrograma().get(linhaIndex-1);
	}
	
	public void addPrograma(ProgramaM programa) {
		this.getListaPrograma().add(programa);
		fireTableRowsInserted(getRowCount()-1, getRowCount()-1 );
	}
	
	public void updatePrograma(ProgramaM programa, int linhaIndex) {
		this.getListaPrograma().set(linhaIndex, programa);
		fireTableRowsUpdated(linhaIndex, linhaIndex);
	}
	
	public void removePrograma(int linhaIndex) {
		this.getListaPrograma().remove(linhaIndex);
		fireTableRowsDeleted(linhaIndex, linhaIndex);
	}
	
	public void removeTodosPrograma() {
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
		
		ProgramaM programa = this.getListaPrograma().get(linhaIndex);
	
		switch(colunaIndex) {
		case ID:
			return programa.getId();
		case NOME:
			return programa.getNome();
		case PERMISSAO:
			return programa.getPermissao();
		case STATUS:
			return programa.getStatus();
		case VERSAO:
			return programa.getVersao();
		default:
			return programa;
		
		}
	}
	
	@Override
	public Class<?> getColumnClass(int colunaIndex){
		switch(colunaIndex) {
		case ID:
			return Long.class;
		case NOME:
			return String.class;
		case PERMISSAO:
			return String.class;
		case STATUS:
			return String.class;
		case VERSAO:
			return String.class;	
		}
		return null;
	}
	

	public String[] getColunas() {
		return colunas;
	}

	public List<ProgramaM> getListaPrograma() {
		return ListaPrograma;
	}
	
	
	public void setListaPrograma(List<ProgramaM> listaPrograma) {
		this.ListaPrograma = listaPrograma;
	}


	public static int getId() {
		return ID;
	}

	public static int getNome() {
		return NOME;
	}

	public static int getPermissao() {
		return PERMISSAO;
	}

	public static int getStatus() {
		return STATUS;
	}

	public static int getVersao() {
		return VERSAO;
	}

	

	
}
