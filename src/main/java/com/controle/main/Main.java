package com.controle.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ProgressBarUI;
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
		setTitle("Menu do Gerenciador de Aplicativos  v0.12 - Filip Junio Felipe - P: 1760319");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("Usuários");
		btnNewButton.setIcon(new ImageIcon(".\\Imagens\\Usuario.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				TabelaUsuario tabela = new TabelaUsuario(); 
				//usuario.usuario(tipo_txt.getText());
				//dispose();
			
				
				tabela.setVisible(true); 
			
			}
		});
		btnNewButton.setBounds(48, 63, 173, 70);
		contentPane.add(btnNewButton);
		
		JButton btnProgramas = new JButton("Programas");
		btnProgramas.setIcon(new ImageIcon(".\\Imagens\\Programa.png"));
		btnProgramas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaPrograma Tabela = new TabelaPrograma(); 
				Tabela.setVisible(true);  
				//dispose();
			}
		});
		btnProgramas.setBounds(261, 63, 173, 70);
		contentPane.add(btnProgramas);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(".\\Imagens\\exit.png"));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnSair.setBounds(261, 160, 173, 49);
		contentPane.add(btnSair);
		
		JButton btnGerenciador = new JButton("Gerenciador");
		btnGerenciador.setEnabled(false);
		btnGerenciador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gerenciador admin = new Gerenciador(); 
				//dispose();
				admin.setVisible(true); 
			}
		});
		btnGerenciador.setIcon(new ImageIcon(".\\Imagens\\Gerenciamento.png"));
		btnGerenciador.setBounds(459, 63, 173, 70);
		contentPane.add(btnGerenciador);
		
		JLabel lblFilipJunioFelipe = new JLabel("Filip Junio Felipe");
		lblFilipJunioFelipe.setBounds(550, 226, 94, 14);
		contentPane.add(lblFilipJunioFelipe);
		
		tipo_txt = new JTextField();
		tipo_txt.setVisible(false);
		tipo_txt.setText("tipo");
		tipo_txt.setEditable(false);
		tipo_txt.setColumns(10);
		tipo_txt.setBorder(new EmptyBorder(0, 0, 0, 0));
		tipo_txt.setBounds(652, 0, 27, 27);
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
