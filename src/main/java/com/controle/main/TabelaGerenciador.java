package com.controle.main;

import java.awt.EventQueue;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.UIManager;

import com.controle.model.GerenciadorM;
import com.controle.model.ProgramaM;
import com.controle.model.TabelaGerenciadorM;
import com.controle.model.TabelaProgramaM;
import com.controle.service.GerenciadorService;
import com.controle.service.ProgramaService;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TabelaGerenciador extends JFrame {

	

	private static final long serialVersionUID = -352389726581513577L;
	private JPanel contentPane1;
	private JButton btnIncluir1;

	private static final int ID       		= 0;
	private static final int NOME    		= 1;
	private static final int PROGRAMA		= 2;
	private static final int VAZIO   = -1; 

	private JTable tabelaPrograma;
	private JButton btnBuscar;
	private JComboBox<String> comboBox;
	private JButton btnPrimeiro;
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnUltimo;
	private TabelaGerenciadorM tabelaProgramaModelo;
    private TableRowSorter<TabelaGerenciadorM> sortTabelaCliente;
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


	public TabelaGerenciador() {
		setTitle("Tabela de programas");
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_F5) {
					loadDataTabelaFromTable();
				}
			}
		});
		
		initComponents();
		createEvents();
	}
	
	private void createEvents() {
		btnIncluir1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gerenciador gerenciador = new Gerenciador(new JFrame(), tabelaPrograma, tabelaProgramaModelo, 0, 0);
			
				gerenciador.setLocationRelativeTo(null);
				gerenciador.setVisible(true);
			
			}
		});
		btnAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				if (tabelaPrograma.getSelectedRow()!= VAZIO && tabelaPrograma.getSelectedRow() < tabelaProgramaModelo.getRowCount()) {
					int linhaSelecionada = tabelaPrograma.getSelectedRow();
					Gerenciador gerenciador = new Gerenciador(new JFrame(), tabelaPrograma, tabelaProgramaModelo, linhaSelecionada, 1);
					
					gerenciador.setLocationRelativeTo(null);
					gerenciador.setVisible(true);
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
				loadDataTabelaFromTable();
			}
		});
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numeroPagina > 1) {
					numeroPagina = numeroPagina - 1;
					loadDataTabelaFromTable();
				}
			}
		});
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (numeroPagina < totalPagina ) {
					 numeroPagina = numeroPagina + 1;
				     loadDataTabelaFromTable();
				 }
			}
		});
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = totalPagina;
				loadDataTabelaFromTable();
			}
		});
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		     	//String nomeArquivo = "relatorio_cliente";
				//Map<String, Object> params = new HashMap<String, Object>();
				//params.put(JRParameter.REPORT_LOCALE, new Locale("pt","BR"));
				//GeraRelatorio geraRelatorio = new GeraRelatorio(nomeArquivo, params);
				//geraRelatorio.generateReports();
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
		toolBar.setBounds(1203, 712, 138, 30);
		
		btnRelatorio = new JButton("Relatório");
		btnRelatorio.setBounds(1182, 25, 85, 45);
		
		btnPrimeiro = new JButton("<<");
		//btnPrimeiro.setIcon(new ImageIcon(TabelaClienteFrame.class.getResource("/com/exemplo/images/go-first.png")));
		toolBar.add(btnPrimeiro);
		
		btnAnterior = new JButton("<");
		//btnAnterior.setIcon(new ImageIcon(TabelaClienteFrame.class.getResource("/com/exemplo/images/go-previous.png")));
		toolBar.add(btnAnterior);
		
		comboBox = new JComboBox<String>();
		toolBar.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"5", "10", "15", "20"}));
		
		btnProximo = new JButton(">");
		//btnProximo.setIcon(new ImageIcon(TabelaClienteFrame.class.getResource("/com/exemplo/images/go-next.png")));
		toolBar.add(btnProximo);
		
		btnUltimo = new JButton(">>");
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
		
		tabelaPrograma = new JTable();
		scrollPane.setViewportView(tabelaPrograma);
		loadDataTabelaFromTable();
		setLocationRelativeTo(null);
		
	}


	public void loadDataTabelaFromTable() {
		
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
		
		tabelaProgramaModelo = new TabelaGerenciadorM();
		tabelaProgramaModelo.setListaPrograma(listarTodosServicos(numeroPagina, defaultPagina));
		tabelaPrograma.setModel(tabelaProgramaModelo);
		tabelaPrograma.setFillsViewportHeight(true);
		tabelaPrograma.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sortTabelaCliente = new TableRowSorter<TabelaGerenciadorM>(tabelaProgramaModelo);
		tabelaPrograma.setRowSorter(sortTabelaCliente);
		tabelaProgramaModelo.fireTableDataChanged();
		tabelaPrograma.getColumnModel().getColumn(ID).setWidth(11);
		tabelaPrograma.getColumnModel().getColumn(NOME).setWidth(100);
		tabelaPrograma.getColumnModel().getColumn(PROGRAMA).setWidth(50);
	
		
		
			}
	
	
	private Integer buscarTodosRegistroCliente() {
		ProgramaService programaService = new ProgramaService();
		return programaService.calcularTotalRegistros();
	}


	public List<GerenciadorM> listarTodosServicos(Integer numeroPagina, Integer defaultPagina){
		GerenciadorService gerenciadorService = new GerenciadorService();
		return gerenciadorService.listarTodosRegistrosComPaginacao((defaultPagina * (numeroPagina - 1)), defaultPagina);
	}
	
	
	private void filtrarCampos(String filtro) {

		RowFilter<TabelaGerenciadorM, Object> rowFilter = null;
		try {
			rowFilter = RowFilter.regexFilter(filtro);
		}catch(PatternSyntaxException e) {
			return;
		}
        sortTabelaCliente.setRowFilter(rowFilter);
	}
}
