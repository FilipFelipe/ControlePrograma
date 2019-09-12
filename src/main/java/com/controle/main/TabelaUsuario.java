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
import com.controle.model.UsuarioM;
import com.controle.model.TabelaUsuarioModel;
import com.controle.service.UsuarioService;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TabelaUsuario extends JFrame {


	private static final long serialVersionUID = -352389726581513577L;
	private JPanel contentPane;
	private JTable tabelaUsuario;
	private JButton btnIncluir;

	private static final int MATRICULA = 0;
	private static final int NOME      = 1;
	private static final int BAIRRO    = 2;
	private static final int CIDADE    = 3;
	private static final int ENDERECO  = 4;
	private static final int TELEFONE  = 5;
	private static final int CEP       = 6;
	private static final int NUMERO    = 7;
	private static final int TIPO    = 8;
	
	
    private TabelaUsuarioModel tabelaClienteModel;
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
					TabelaUsuario frame = new TabelaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TabelaUsuario() {
		setTitle("Usuários Cadastrados");
		setType(Type.UTILITY);
		
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
				
				if (tabelaUsuario.getSelectedRow()!=1 && tabelaUsuario.getSelectedRow() < tabelaClienteModel.getRowCount()) {
					int linhaSelecionada = tabelaUsuario.getSelectedRowCount();
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
		
		tabelaUsuario = new JTable();
		scrollPane.setViewportView(tabelaUsuario);
		contentPane.setLayout(gl_contentPane);
		loadDataClienteFromTable();
		
	}


	public void loadDataClienteFromTable() {
		
		tabelaClienteModel = new TabelaUsuarioModel();
		tabelaClienteModel.setListaClientes(listarTodosClientes());
		tabelaUsuario.setModel(tabelaClienteModel);

		tabelaUsuario.setFillsViewportHeight(true);
		tabelaUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabelaClienteModel.fireTableDataChanged();
		
		tabelaUsuario.getColumnModel().getColumn(MATRICULA).setWidth(11);
		tabelaUsuario.getColumnModel().getColumn(NOME).setWidth(100);
		tabelaUsuario.getColumnModel().getColumn(ENDERECO).setWidth(100);
		tabelaUsuario.getColumnModel().getColumn(BAIRRO).setWidth(50);
		tabelaUsuario.getColumnModel().getColumn(CIDADE).setWidth(100);
		tabelaUsuario.getColumnModel().getColumn(CEP).setWidth(20);
		tabelaUsuario.getColumnModel().getColumn(TELEFONE).setWidth(20);
		tabelaUsuario.getColumnModel().getColumn(NUMERO).setWidth(5);
		tabelaUsuario.getColumnModel().getColumn(TIPO).setWidth(5);
		setLocationRelativeTo(null);
	}
	
	
	public List<UsuarioM> listarTodosClientes(){
		UsuarioService clienteService = new UsuarioService();
		return clienteService.listarTodosClientes();
	}
}
