package com.controle.main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import com.controle.model.TabelaUsuarioM;
import com.controle.model.UsuarioM;
import com.controle.reports.GeraRelatorio;
import com.controle.service.UsuarioService;


import net.sf.jasperreports.engine.JRParameter;

public class TabelaUsuario extends JFrame {

	

	private static final long serialVersionUID = -352389726581513577L;
	private JPanel contentPane1;
	private JButton btnIncluir1;

	private static final int MATRICULA = 0;
	private static final int NOME      = 1;
	private static final int BAIRRO    = 2;
	private static final int CIDADE    = 3;
	private static final int ENDERECO  = 4;
	private static final int CEP       = 5;
	private static final int NUMERO    = 6;
	private static final int VAZIO   = -1; 

	private JTable tabelaCliente;
	private JButton btnBuscar;
	private JComboBox<String> comboBox;
	private JButton btnPrimeiro;
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnUltimo;
	private TabelaUsuarioM tabelaClienteModel;
    private TableRowSorter<TabelaUsuarioM> sortTabelaCliente;
    private JButton btnAlterar;
    private JTextField textFieldNome;    	
    private Integer totalData = 0;
	private Integer defaultPagina = 5;
	private Integer totalPagina = 1;
	private Integer numeroPagina = 1;
	private JButton btnRelatorio;
    
    
    
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
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_F5) {
					loadDataClienteFromTable();
				}
			}
		});
		
		initComponents();
		createEvents();
	}
	
	private void createEvents() {
		btnIncluir1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario(new JFrame(), tabelaCliente, tabelaClienteModel, 0, 0);
				usuario.setLocationRelativeTo(null);
				usuario.setVisible(true);
			
			}
		});
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabelaCliente.getSelectedRow()!= VAZIO && tabelaCliente.getSelectedRow() < tabelaClienteModel.getRowCount()) {
					int linhaSelecionada = tabelaCliente.getSelectedRow();
					System.out.println("tesew" + linhaSelecionada);	
					System.out.println("programa 1 :" + linhaSelecionada + "+" + tabelaCliente + "+" + tabelaClienteModel);	
					Usuario clienteFrame = new Usuario(new JFrame(), tabelaCliente, tabelaClienteModel, linhaSelecionada, 1);
					clienteFrame.setLocationRelativeTo(null);
					clienteFrame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,"Selecione um registro na tabela" ,"Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String filtro = textFieldNome.getText();
				filtrarCampos(filtro);
			}
		});
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = 1;
				loadDataClienteFromTable();
			}
		});
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numeroPagina > 1) {
					numeroPagina = numeroPagina - 1;
					loadDataClienteFromTable();
				}
			}
		});
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (numeroPagina < totalPagina ) {
					 numeroPagina = numeroPagina + 1;
				     loadDataClienteFromTable();
				 }
			}
		});
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = totalPagina;
				loadDataClienteFromTable();
			}
		});
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeArquivo = "tabela_usuario";
				Map<String, Object> params = new HashMap<String, Object>();
				params.put(JRParameter.REPORT_LOCALE, new Locale("pt","BR"));
				GeraRelatorio geraRelatorio = new GeraRelatorio(nomeArquivo, params);
				geraRelatorio.generateReports();
			}
		});
	}


	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1371, 789);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 1331, 624);
		
		btnIncluir1 = new JButton("Incluir");
		btnIncluir1.setBounds(1085, 27, 85, 43);
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(983, 28, 92, 41);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNome.setBounds(12, 38, 49, 32);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldNome.setBounds(73, 42, 638, 28);
		textFieldNome.setColumns(10);
	    btnBuscar = new JButton("Buscar");
	    btnBuscar.setBounds(723, 27, 85, 44);
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(1203, 712, 123, 30);
		
		btnRelatorio = new JButton("Relatório");
		btnRelatorio.setBounds(1182, 25, 85, 45);
		
		btnPrimeiro = new JButton("x");
		//btnPrimeiro.setIcon(new ImageIcon(TabelaClienteFrame.class.getResource("/com/exemplo/images/go-first.png")));
		toolBar.add(btnPrimeiro);
		
		btnAnterior = new JButton("x");
		//btnAnterior.setIcon(new ImageIcon(TabelaClienteFrame.class.getResource("/com/exemplo/images/go-previous.png")));
		toolBar.add(btnAnterior);
		
		comboBox = new JComboBox<String>();
		toolBar.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"5", "10", "15", "20"}));
		
		btnProximo = new JButton("x");
		//btnProximo.setIcon(new ImageIcon(TabelaClienteFrame.class.getResource("/com/exemplo/images/go-next.png")));
		toolBar.add(btnProximo);
		
		btnUltimo = new JButton("x");
		//btnUltimo.setIcon(new ImageIcon(TabelaClienteFrame.class.getResource("/com/exemplo/images/go-last.png")));
		toolBar.add(btnUltimo);
		contentPane1.setLayout(null);
		contentPane1.add(lblNome);
		contentPane1.add(textFieldNome);
		contentPane1.add(btnBuscar);
		contentPane1.add(toolBar);
		contentPane1.add(btnIncluir1);
		contentPane1.add(btnAlterar);
		contentPane1.add(btnRelatorio);
		contentPane1.add(scrollPane);
		
		tabelaCliente = new JTable();
		scrollPane.setViewportView(tabelaCliente);
		loadDataClienteFromTable();
		setLocationRelativeTo(null);
		
	}


	public void loadDataClienteFromTable() {
		
		totalData = buscarTodosRegistroCliente();
		defaultPagina = Integer.valueOf(comboBox.getSelectedItem().toString());
		Double totalPaginacao = Math.ceil(totalData.doubleValue()/defaultPagina.doubleValue());
		
		totalPagina = totalPaginacao.intValue();
	
		if (numeroPagina.equals(1)) {
			btnPrimeiro.setEnabled(false);
			btnProximo.setEnabled(false);
		} else {
			btnPrimeiro.setEnabled(true);
			btnProximo.setEnabled(true);
		}
		
		if (numeroPagina.equals(totalPagina)) {
			btnUltimo.setEnabled(false);
			btnProximo.setEnabled(false);
		} else {
			btnUltimo.setEnabled(true);
			btnProximo.setEnabled(true);
		}
		
		if (numeroPagina > totalPagina) {
			numeroPagina = 1;
		}
		
		tabelaClienteModel = new TabelaUsuarioM();
		tabelaClienteModel.setListaClientes(listarTodosClientes(numeroPagina, defaultPagina));
		tabelaCliente.setModel(tabelaClienteModel);

		tabelaCliente.setFillsViewportHeight(true);
		tabelaCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		sortTabelaCliente = new TableRowSorter<TabelaUsuarioM>(tabelaClienteModel);
		tabelaCliente.setRowSorter(sortTabelaCliente);
		
		tabelaClienteModel.fireTableDataChanged();
		
		
		tabelaCliente.getColumnModel().getColumn(MATRICULA).setWidth(11);
		//tabelaUsuario.getColumnModel().getColumn(TIPO).setWidth(5);
		tabelaCliente.getColumnModel().getColumn(NOME).setWidth(50);
		tabelaCliente.getColumnModel().getColumn(ENDERECO).setWidth(50); 
		tabelaCliente.getColumnModel().getColumn(BAIRRO).setWidth(50);
		tabelaCliente.getColumnModel().getColumn(CEP).setWidth(20);
		tabelaCliente.getColumnModel().getColumn(NUMERO).setWidth(5);
		tabelaCliente.getColumnModel().getColumn(CIDADE).setWidth(100);
		
		
			}
	
	
	private Integer buscarTodosRegistroCliente() {
		UsuarioService clienteService = new UsuarioService();
		return clienteService.calcularTotalRegistros();
	}


	public List<UsuarioM> listarTodosClientes(Integer numeroPagina, Integer defaultPagina){
		UsuarioService clienteService = new UsuarioService();
		return clienteService.listarTodosRegistrosComPaginacao((defaultPagina * (numeroPagina - 1)), defaultPagina);
	}
	
	
	private void filtrarCampos(String filtro) {

		RowFilter<TabelaUsuarioM, Object> rowFilter = null;
		try {
			rowFilter = RowFilter.regexFilter(filtro);
		}catch(PatternSyntaxException e) {
			return;
		}
        sortTabelaCliente.setRowFilter(rowFilter);
	}
}
