package com.controle.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ProgressBarUI;

import com.controle.reports.GeraRelatorio;

import net.sf.jasperreports.engine.JRParameter;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JTextPane;

public class Main extends JFrame {

	private static final long serialVersionUID = 5304272365760308901L;
	
	public JPanel contentPane;
	private JTextField tipo_txt;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for ( LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(laf.getName())){
							UIManager.setLookAndFeel(laf.getClassName());
						}
					}
					Main frame = new Main();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Imagens\\IconeS.png"));
		setTitle("Menu do Gerenciador de Aplicativos  v1.02 - Filip Junio Felipe - P: 1760319");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 338);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmUsurios = new JMenuItem("Usuários");
		mntmUsurios.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				TabelaUsuario tabela = new TabelaUsuario(); 
				tabela.setVisible(true); 
			}
		});
		mnMenu.add(mntmUsurios);
		
		JMenuItem mntmProgramas = new JMenuItem("Programas");
		mntmProgramas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				TabelaPrograma Tabela = new TabelaPrograma(); 
				Tabela.setVisible(true); 
			}
		});
		mnMenu.add(mntmProgramas);
		
		JMenuItem mntmGerenciador = new JMenuItem("Gerenciador");
		mntmGerenciador.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				TabelaGerenciador admin = new TabelaGerenciador(); 
				//dispose();
				admin.setVisible(true); 
			}
		});
		mnMenu.add(mntmGerenciador);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				dispose();
			}
		});
		mnMenu.add(mntmSair);
		
		JMenu mnRelatrios = new JMenu("Relatórios");
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmUsurios_1 = new JMenuItem("Usuários");
		mntmUsurios_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				String nomeArquivo = "tabela_usuario";
				Map<String, Object> params = new HashMap<String, Object>();
				params.put(JRParameter.REPORT_LOCALE, new Locale("pt","BR"));
				GeraRelatorio geraRelatorio = new GeraRelatorio(nomeArquivo, params);
				geraRelatorio.generateReports();
			}
			
		});
		mnRelatrios.add(mntmUsurios_1);
		
		JMenuItem mntmProgramas_1 = new JMenuItem("Programas");
		mntmProgramas_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				String nomeArquivo = "tabela_programa";
				Map<String, Object> params = new HashMap<String, Object>();
				params.put(JRParameter.REPORT_LOCALE, new Locale("pt","BR"));
				GeraRelatorio geraRelatorio = new GeraRelatorio(nomeArquivo, params);
				geraRelatorio.generateReports();
			}
		});
		mnRelatrios.add(mntmProgramas_1);
		
		JMenuItem mntmGerenciador_1 = new JMenuItem("Gerenciador");
		mntmGerenciador_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				String nomeArquivo = "tabela_gerenciamento";
				Map<String, Object> params = new HashMap<String, Object>();
				params.put(JRParameter.REPORT_LOCALE, new Locale("pt","BR"));
				GeraRelatorio geraRelatorio = new GeraRelatorio(nomeArquivo, params);
				geraRelatorio.generateReports();
			}
		});
		mnRelatrios.add(mntmGerenciador_1);
		
		JMenu mnSobre = new JMenu("Help");
		menuBar.add(mnSobre);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Programa desenvolvido na disciplina: Programação orientada a eventos \nProfessor: Francisco Sergio dos Santos \nAluno: Filip Junio Felipe");
			}
		});
		mnSobre.add(mntmSobre);
		
		JMenuItem mntmVerso = new JMenuItem("Versão");
		mntmVerso.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Date data = new Date();
				JOptionPane.showMessageDialog(null, "Programa está na versão: 1.02 \nUltima verificação: " + data +"\nPrograma está atualizado :)" );

			    }	
			
		});
		mnSobre.add(mntmVerso);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilipJunioFelipe = new JLabel("Filip Junio Felipe");
		lblFilipJunioFelipe.setBounds(713, 260, 94, 14);
		contentPane.add(lblFilipJunioFelipe);
		
		tipo_txt = new JTextField();
		tipo_txt.setVisible(false);
		tipo_txt.setText("tipo");
		tipo_txt.setEditable(false);
		tipo_txt.setColumns(10);
		tipo_txt.setBorder(new EmptyBorder(0, 0, 0, 0));
		tipo_txt.setBounds(770, 13, 27, 27);
		contentPane.add(tipo_txt);
		
		
		setLocationRelativeTo(null);
	}


public void usuario(String nome,String tipo) {
	String Name = "o";
	String status = "o";
	int op  = Integer.parseInt(tipo);
	if (op == 2) {
		status = ("Admin");
		Name = (nome + " | " + status);
	}
	if (op == 1) {
		status = ("Funcionário");
		Name = (nome + " | " + status);
	}
	if (op == 0) {
		status = ("Desligado");
		Name = (nome + " | " + status);
	}
	//nome_txt.setText(Name);
	tipo_txt.setText(tipo);
}
}
