package com.controle.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controle.model.ProgramaM;
import com.controle.model.UsuarioM;
import com.controle.service.ProgramaService;
import com.controle.service.UsuarioService;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class Programa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField programa_txt;
	private JTextField permissao_txt;
	private JTextField status_txt;
	private JTextField versao_txt;
	private JTextField id_txt;

	/**
	 * Launch the application.
	 */

protected void pegarDadosProgramaFromTabela(ProgramaM programa) {
		
		id_txt.setText(Long.toString(programa.getId()));
		programa_txt.setText(programa.getNome());
		permissao_txt.setText(programa.getPermissao());
		status_txt.setText(programa.getStatus());
		versao_txt.setText(programa.getVersao());
}
	protected ProgramaM pegarDadosProgramaFromTela(int op) {
		ProgramaM programa = new ProgramaM();
		if (op == 1) {
			programa.setNome(programa_txt.getText());
			programa.setVersao(versao_txt.getText());
			programa.setPermissao(permissao_txt.getText());
			programa.setStatus(status_txt.getText());
	        return programa;		
		}
		else {
			programa.setId(Long.parseLong(id_txt.getText())); // converte para long
			programa.setNome(programa_txt.getText());
			programa.setVersao(versao_txt.getText());
			programa.setPermissao(permissao_txt.getText());
			programa.setStatus(status_txt.getText());
	        return programa;	
		}
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programa frame = new Programa();
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
	protected void limpartela() {
			id_txt.setText("");
			programa_txt.setText("");
			status_txt.setText("");
			versao_txt.setText("");
			permissao_txt.setText("");
			
		}

	public Programa() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\3-Documentos\\eclipse\\workspace\\com.controle\\Imagens\\programashow.png"));
		setTitle("Programas Cadastrados ");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 841, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSalvar = new JButton("Cadastrar");
		btnSalvar.setIcon(new ImageIcon("D:\\3-Documentos\\eclipse\\workspace\\com.controle\\Imagens\\programadd.png"));
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalvar.setBounds(43, 286, 179, 64);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgramaService programaService = new ProgramaService();
				ProgramaM programa = pegarDadosProgramaFromTela(1);
				//clienteService.alterarCLiente(cliente);
				programaService.salvarPrograma(programa);
					
				limpartela();
				JOptionPane.showMessageDialog(null, "O programa " + programa.getNome() + " foi cadastrado com sucesso!");
			}
		});
		
		JLabel lblNomeDoUsurio = new JLabel("Nome do programa :");
		lblNomeDoUsurio.setBounds(28, 100, 209, 26);
		lblNomeDoUsurio.setFont(new Font("Dialog", Font.PLAIN, 23));
		
		programa_txt = new JTextField();
		programa_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		programa_txt.setBounds(250, 100, 299, 34);
		programa_txt.setColumns(10);
		
		JLabel lblBairro = new JLabel("Permissão :");
		lblBairro.setBounds(115, 154, 123, 26);
		lblBairro.setFont(new Font("Dialog", Font.PLAIN, 23));
		
		permissao_txt = new JTextField();
		permissao_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		permissao_txt.setBounds(250, 200, 123, 34);
		permissao_txt.setColumns(10);
		
		JLabel lblCep = new JLabel("Status :");
		lblCep.setBounds(158, 204, 79, 26);
		lblCep.setFont(new Font("Dialog", Font.PLAIN, 23));
		
		status_txt = new JTextField();
		status_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		status_txt.setBounds(573, 200, 70, 34);
		status_txt.setColumns(10);
		
		versao_txt = new JTextField();
		versao_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		versao_txt.setBounds(250, 150, 147, 34);
		versao_txt.setColumns(10);
		
		JLabel lblCidade = new JLabel("Versão :");
		lblCidade.setBounds(476, 204, 86, 26);
		lblCidade.setFont(new Font("Dialog", Font.PLAIN, 23));
		contentPane.setLayout(null);
		contentPane.add(lblNomeDoUsurio);
		contentPane.add(programa_txt);
		contentPane.add(lblBairro);
		contentPane.add(permissao_txt);
		contentPane.add(btnSalvar);
		contentPane.add(lblCidade);
		contentPane.add(versao_txt);
		contentPane.add(lblCep);
		contentPane.add(status_txt);
		JButton btnatt = new JButton("Atualizar");
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("D:\\3-Documentos\\eclipse\\workspace\\com.controle\\Imagens\\programremove.png"));
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // excluir
				
				
				ProgramaService programaService = new ProgramaService();
				ProgramaM programa = pegarDadosProgramaFromTela(0);
				programa = programaService.consultar((Long.valueOf(programa.getId())));
				programaService.excluirPrograma(programa);	
				limpartela();
				JOptionPane.showMessageDialog(null, "O programa " + programa.getNome() + " foi excluido com sucesso!");
				btnSalvar.setVisible(true);
				btnatt.setVisible(false);
				btnExcluir.setEnabled(false);
			}
		});
		btnExcluir.setBounds(252, 286, 155, 64);
		contentPane.add(btnExcluir);
		
		
		btnatt.setIcon(new ImageIcon("D:\\3-Documentos\\eclipse\\workspace\\com.controle\\Imagens\\attprogram.png"));
		btnatt.setVisible(false);
		btnatt.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnatt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // atualizar botao 
				ProgramaService programaService = new ProgramaService();
				ProgramaM programa = pegarDadosProgramaFromTela(0);
				programaService.alterarPrograma(programa);
				limpartela();
				JOptionPane.showMessageDialog(null, "O programa " + programa.getNome() + " foi atualizado com sucesso!");
				btnSalvar.setVisible(true);
				btnatt.setVisible(false);
				btnExcluir.setEnabled(false);
			}
		});
		btnatt.setBounds(43, 286, 179, 64);
		contentPane.add(btnatt);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon("D:\\3-Documentos\\eclipse\\workspace\\com.controle\\Imagens\\sair.png"));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Main main = new Main(); 
				//main.setVisible(true); 
				dispose();
			}
		});
		btnSair.setBounds(637, 286, 155, 64);
		contentPane.add(btnSair);
		
		id_txt = new JTextField();
		id_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		id_txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{ if (id_txt.getText().equals("")) { // busca com enter 
					JOptionPane.showMessageDialog(null, "O ID do programa deve ser informado!!");
					id_txt.requestFocus();
				}else {
					ProgramaService programaService = new ProgramaService();
					ProgramaM programa = pegarDadosProgramaFromTela(0);
					programa = programaService.consultar(Long.valueOf(programa.getId()));
					pegarDadosProgramaFromTabela(programa);
					btnSalvar.setVisible(false);
					btnExcluir.setEnabled(true);
					btnatt.setVisible(true);
			} } 
			}
		});
		id_txt.setBounds(250, 50, 86, 34);
		contentPane.add(id_txt);
		id_txt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("D:\\3-Documentos\\eclipse\\workspace\\com.controle\\Imagens\\buscar.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (id_txt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O ID do programa deve ser informado!!");
					id_txt.requestFocus();
				}else {
					ProgramaService programaService = new ProgramaService();
					ProgramaM programa = pegarDadosProgramaFromTela(0);
					programa = programaService.consultar(Long.valueOf(programa.getId()));
					pegarDadosProgramaFromTabela(programa);
					btnSalvar.setVisible(false);
					btnExcluir.setEnabled(true);
					btnatt.setVisible(true);
			}
		
			}});
		btnNewButton_1.setBounds(348, 43, 64, 46);
		contentPane.add(btnNewButton_1);
		
		JLabel lblId = new JLabel("ID : ");
		lblId.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblId.setBounds(200, 54, 48, 26);
		contentPane.add(lblId);
		
		JButton btnVisualizarProgramas = new JButton("Programas");
		btnVisualizarProgramas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TabelaPrograma Tabela = new TabelaPrograma(); 
				Tabela.setVisible(true);  
			}
		});
		btnVisualizarProgramas.setIcon(new ImageIcon("D:\\3-Documentos\\eclipse\\workspace\\com.controle\\Imagens\\programashow.png"));
		btnVisualizarProgramas.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVisualizarProgramas.setBounds(440, 286, 167, 64);
		contentPane.add(btnVisualizarProgramas);
		setLocationRelativeTo(null);
	}
}
