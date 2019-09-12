package com.controle.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controle.model.GerenciadorM;
import com.controle.service.GerenciadorService;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.List;
import javax.swing.JScrollPane;

public class Gerenciador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome_txt;
	private JTextField bairro_txt;
	private JTextField cep_txt;
	private JTextField cidade_txt;
	private JTextField numero_txt;
	private JTextField telefone_txt;
	private JTextField id_txt;
	private JPasswordField senha_txt;

	/**
	 * Launch the application.
	 */
	@SuppressWarnings("deprecation")
	protected GerenciadorM pegarDadosClienteFromTela(int op) {
		GerenciadorM cliente = new GerenciadorM();
		if (op == 1) {
			cliente.setNome(nome_txt.getText());
			cliente.setBairro(bairro_txt.getText());
			cliente.setCep(cep_txt.getText());
			cliente.setCidade(cidade_txt.getText());
			cliente.setNumero(numero_txt.getText());
			cliente.setTelefone(telefone_txt.getText());
			cliente.setSenha(senha_txt.getText());
	        return cliente;		
		}
		else {
			cliente.setId(Long.parseLong(id_txt.getText())); // converte para long
			cliente.setNome(nome_txt.getText());
			cliente.setBairro(bairro_txt.getText());
			cliente.setCep(cep_txt.getText());
			cliente.setCidade(cidade_txt.getText());
			cliente.setNumero(numero_txt.getText());
			cliente.setTelefone(telefone_txt.getText());
			cliente.setSenha(senha_txt.getText());
	        return cliente;	
		}
		
	}
	
	protected void pegarDadosClienteFromTabela(GerenciadorM cliente) {
		
		id_txt.setText(Long.toString(cliente.getId()));
		nome_txt.setText(cliente.getNome());
		bairro_txt.setText(cliente.getBairro());
		cep_txt.setText(cliente.getCep());
		cidade_txt.setText(cliente.getCidade());
		numero_txt.setText(cliente.getNumero());
		telefone_txt.setText(cliente.getTelefone());
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gerenciador frame = new Gerenciador();
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
	public Gerenciador() {
		setType(Type.UTILITY);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 833, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton Cadastrar = new JButton("Cadastrar");
		Cadastrar.setBounds(33, 256, 89, 23);
		Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciadorService gerenciadorService = new GerenciadorService();
				GerenciadorM cliente = pegarDadosClienteFromTela(1);
				//GerenciadorService.alterarCLiente(cliente);
					gerenciadorService.salvarGerenciador(cliente);
					
				
			}
		});
		
		JLabel lblNomeDoUsurio = new JLabel("Nome do Usuário:");
		lblNomeDoUsurio.setBounds(12, 12, 111, 17);
		lblNomeDoUsurio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		nome_txt = new JTextField();
		nome_txt.setBounds(127, 12, 198, 20);
		nome_txt.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(82, 127, 41, 17);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		bairro_txt = new JTextField();
		bairro_txt.setBounds(127, 127, 96, 20);
		bairro_txt.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(94, 155, 29, 17);
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cep_txt = new JTextField();
		cep_txt.setBounds(127, 155, 96, 20);
		cep_txt.setColumns(10);
		
		cidade_txt = new JTextField();
		cidade_txt.setBounds(127, 99, 147, 20);
		cidade_txt.setColumns(10);
		
		numero_txt = new JTextField();
		numero_txt.setBounds(127, 183, 96, 20);
		numero_txt.setColumns(10);
		
		telefone_txt = new JTextField();
		telefone_txt.setBounds(127, 211, 96, 20);
		telefone_txt.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(77, 99, 46, 17);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNmero = new JLabel("Número:");
		lblNmero.setBounds(69, 183, 54, 17);
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(66, 211, 57, 17);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(63, 43, 60, 17);
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		id_txt = new JTextField();
		id_txt.setBounds(127, 43, 34, 20);
		id_txt.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(81, 71, 43, 17);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.setLayout(null);
		
		senha_txt = new JPasswordField();
		senha_txt.setBounds(127, 71, 96, 20);
		contentPane.add(senha_txt);
		contentPane.add(lblNomeDoUsurio);
		contentPane.add(nome_txt);
		contentPane.add(lblMatricula);
		contentPane.add(id_txt);
		contentPane.add(lblSenha);
		contentPane.add(lblBairro);
		contentPane.add(bairro_txt);
		contentPane.add(lblTelefone);
		contentPane.add(telefone_txt);
		contentPane.add(Cadastrar);
		contentPane.add(lblNmero);
		contentPane.add(numero_txt);
		contentPane.add(lblCidade);
		contentPane.add(cidade_txt);
		contentPane.add(lblCep);
		contentPane.add(cep_txt);
		
		JButton atualizar = new JButton("Atualizar");
		atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciadorService GerenciadorService = new GerenciadorService();
				GerenciadorM cliente = pegarDadosClienteFromTela(0);
				GerenciadorService.alterarGerenciador(cliente);
			}
		});
		atualizar.setBounds(134, 256, 89, 23);
		contentPane.add(atualizar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(236, 256, 89, 23);
		contentPane.add(btnSair);
		
		List list = new List();
		list.setBounds(237, 127, 110, 60);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("EXCLUIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciadorService gerenciadorService = new GerenciadorService();
				
				gerenciadorService.remove(Long.parseLong(id_txt.getText()));	
			}
		});
		btnNewButton.setBounds(43, 295, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(353, 148, 462, 286);
		contentPane.add(scrollPane);
		setLocationRelativeTo(null);
		
	}
}
