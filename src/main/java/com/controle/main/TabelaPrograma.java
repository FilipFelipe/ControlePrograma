package com.controle.main;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import com.controle.model.ProgramaM;
import com.controle.model.TabelaProgramaM;
import com.controle.service.ProgramaService;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TabelaPrograma extends JFrame {


	private static final long serialVersionUID = -352389726581513577L;
	private JPanel contentPane;
	private JTable tabelaPrograma;
	private JButton btnIncluir;

	private static final int ID       		= 0;
	private static final int PERMISSAO     	= 1;
	private static final int NOME    		= 2;
	private static final int STATUS 		= 3;
	private static final int VERSAO   		= 4;

	
	
    private TabelaProgramaM tabelaProgramaModel;
    private JButton btnAlterar;
    
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for ( LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(laf.getName())){
							UIManager.setLookAndFeel(laf.getClassName());
						} else {
							System.out.println();
						}
						
					}
					TabelaPrograma frame = new TabelaPrograma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TabelaPrograma() {
		setTitle("Programas Cadastrados");
		
		
		initComponents();
		createEvents();
	}
	
	private void createEvents() {
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Users Users = new Users(new JFrame(), tabelaCliente, tabelaClienteModel, 0, 0);
				//Users.setLocationRelativeTo(null);
				//Users.setVisible(true);
			}
		});
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tabelaPrograma.getSelectedRow()!=1 && tabelaPrograma.getSelectedRow() < tabelaProgramaModel.getRowCount()) {
					int linhaSelecionada = tabelaPrograma.getSelectedRowCount();
					System.out.println(linhaSelecionada);
					//Users usuario = new Users(new JFrame(), tabelaCliente, tabelaClienteModel, linhaSelecionada, 1);
					//usuario.setLocationRelativeTo(null);
					//usuario.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,"Selecione um registro na tabela" ,"Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
	}


	private void initComponents() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1293, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnIncluir = new JButton("Incluir");
		btnAlterar = new JButton("Alterar");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(btnIncluir)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAlterar)
					.addContainerGap(1083, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1267, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 641, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir)
						.addComponent(btnAlterar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tabelaPrograma = new JTable();
		setLocationRelativeTo(null);
		scrollPane.setViewportView(tabelaPrograma);
		contentPane.setLayout(gl_contentPane);
		loadDataProgramaFromTable();
		
	}


	public void loadDataProgramaFromTable() {
		
		tabelaProgramaModel = new TabelaProgramaM();
		tabelaProgramaModel.setListaPrograma(listarTodosPrograma());
		tabelaPrograma.setModel(tabelaProgramaModel);

		tabelaPrograma.setFillsViewportHeight(true);
		tabelaPrograma.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabelaProgramaModel.fireTableDataChanged();

		tabelaPrograma.getColumnModel().getColumn(ID).setWidth(11);
		tabelaPrograma.getColumnModel().getColumn(PERMISSAO).setWidth(100);
		tabelaPrograma.getColumnModel().getColumn(NOME).setWidth(100);
		tabelaPrograma.getColumnModel().getColumn(STATUS).setWidth(50);
		tabelaPrograma.getColumnModel().getColumn(VERSAO).setWidth(100);
	
	}
	
	
	public List<ProgramaM> listarTodosPrograma(){
		ProgramaService programaService = new ProgramaService();
		return programaService.listarTodosProgramas();
	}
	
}
