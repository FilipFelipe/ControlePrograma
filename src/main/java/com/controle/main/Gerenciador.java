package com.controle.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.controle.model.GerenciadorM;
import com.controle.model.ProgramaM;
import com.controle.model.TabelaGerenciadorM;
import com.controle.model.TabelaUsuarioM;
import com.controle.model.UsuarioM;
import com.controle.service.GerenciadorService;
import com.controle.service.ProgramaService;
import com.controle.service.UsuarioService;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;

public class Gerenciador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome_txt;
	private JTextField id_txt;
	private JTextField id_programa;
	private JTextField nome_programa;
	private JTable tabelaUsuario;
	private TabelaGerenciadorM tabelaUsuarioModel;
	private int linhaSelecionada;
	private int acao;
	private JTextField id;

	
	protected GerenciadorM pegarDadosClienteFromTela() {
		GerenciadorM reg = new GerenciadorM();
		reg.setNome(nome_txt.getText());
		reg.setNome_id(id_txt.getText());
		reg.setprograma(nome_programa.getText());
		reg.setPrograma_id(id_programa.getText());
		return reg;
	}
	protected GerenciadorM pegarDadosClienteFromTelas() {
		GerenciadorM reg = new GerenciadorM();
		reg.setId(Long.parseLong(id.getText()));
		reg.setNome(nome_txt.getText());
		reg.setNome_id(id_txt.getText());
		reg.setprograma(nome_programa.getText());
		reg.setPrograma_id(id_programa.getText());
		return reg;
	}
	
	protected void pegarDadosClienteFromTabela(GerenciadorM cliente) {
		
	}

protected void pegarDadosClienteFromTabela() {
		
		GerenciadorM reg = gettabelaUsuarioModel().getPrograma(getLinhaSelecionada());
		id.setText(Long.toString(reg.getId()));
		id_txt.setText(reg.getNome_id());
		nome_txt.setText(reg.getNome());
		id_programa.setText(reg.getPrograma_id());
		nome_programa.setText(reg.getprograma());
		
	
	}
	protected UsuarioM pegarid(){
		UsuarioM usuario = new UsuarioM();
		usuario.setId(Long.parseLong(id_txt.getText()));
		return usuario;
	}
	protected ProgramaM pegarid_programa(){
		ProgramaM programa = new ProgramaM();
		programa.setId(Long.parseLong(id_programa.getText()));
		return programa;
	}
	public Gerenciador(JFrame frame, JTable tabelaUsuario,
            TabelaGerenciadorM tabelaUsuarioModel,
            int linhaSelecionada,
            int acao ) {
		
		this.tabelaUsuario = tabelaUsuario;
		this.tabelaUsuarioModel = tabelaUsuarioModel;
		this.linhaSelecionada = linhaSelecionada;
		this.acao = acao;
		
		
		setType(Type.UTILITY);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 528, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton Cadastrar = new JButton("Cadastrar");
		Cadastrar.setBounds(190, 265, 89, 23);
		Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciadorService gerenciadorService = new GerenciadorService();
				GerenciadorM reg = pegarDadosClienteFromTela();
				gerenciadorService.salvarGerenciador(reg);
			}
		});
		
		
		JLabel lblNomeDoUsurio = new JLabel("Nome do Usuário:");
		lblNomeDoUsurio.setBounds(31, 91, 166, 39);
		lblNomeDoUsurio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		nome_txt = new JTextField();
		nome_txt.setEnabled(false);
		nome_txt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nome_txt.setBounds(204, 94, 232, 33);
		nome_txt.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(97, 39, 80, 35);
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		id_txt = new JTextField();
		id_txt.setBounds(204, 42, 75, 33);
		id_txt.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblNomeDoUsurio);
		contentPane.add(nome_txt);
		contentPane.add(lblMatricula);
		contentPane.add(id_txt);
		contentPane.add(Cadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(389, 265, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioService usuarioService = new UsuarioService();
				UsuarioM usuario = pegarid();
				usuario = usuarioService.consultarCliente(Long.valueOf(usuario.getId()));
				nome_txt.setText(usuario.getNome());
			}
		});
		btnNewButton.setBounds(356, 39, 80, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNomeDoPrograma = new JLabel("Nome do Programa:");
		lblNomeDoPrograma.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeDoPrograma.setBounds(12, 191, 166, 39);
		contentPane.add(lblNomeDoPrograma);
		
		JLabel lblNumeroPrograma = new JLabel("Número Programa:");
		lblNumeroPrograma.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeroPrograma.setBounds(28, 143, 149, 35);
		contentPane.add(lblNumeroPrograma);
		
		id_programa = new JTextField();
		id_programa.setColumns(10);
		id_programa.setBounds(202, 144, 75, 33);
		contentPane.add(id_programa);
		
		nome_programa = new JTextField();
		nome_programa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nome_programa.setEnabled(false);
		nome_programa.setColumns(10);
		nome_programa.setBounds(204, 192, 232, 33);
		contentPane.add(nome_programa);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgramaService programaService = new ProgramaService();
				ProgramaM programa = pegarid_programa();
				programa = programaService.consultarPrograma(Long.valueOf(programa.getId()));
				nome_programa.setText(programa.getNome());
			}
		});
		button.setBounds(356, 140, 80, 39);
		contentPane.add(button);
		
		JButton atualizar = new JButton("atualizar");
		atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciadorService gerenciadorService = new GerenciadorService();
				
				GerenciadorM reg = pegarDadosClienteFromTelas();
				gerenciadorService.alterarGerenciador(reg);
				JOptionPane.showMessageDialog(null, "O Gerenciador foi atualizado com sucesso!");
				dispose();
			}
		});
		atualizar.setBounds(62, 265, 89, 23);
		contentPane.add(atualizar);
		
		id = new JTextField();
		id.setVisible(false);
		id.setBounds(12, 13, 38, 22);
		contentPane.add(id);
		id.setColumns(10);
		setLocationRelativeTo(null);
		if ( getAcao() == 1 ) {
			Cadastrar.setEnabled(false);
			atualizar.setEnabled(true);
			pegarDadosClienteFromTabela();
		}
		else if( getAcao() == 0 ){
			atualizar.setEnabled(false);
			Cadastrar.setEnabled(true);
		}
		
	}
	public JTable gettabelaGerenciador() {
		return tabelaUsuario;
	}

	public void settabelaGerenciador(JTable tabelaUsuario) {
		this.tabelaUsuario = tabelaUsuario;
	}

	public TabelaGerenciadorM gettabelaUsuarioModel() {
		return tabelaUsuarioModel;
	}

	public void settabelaGerenciadorModel(TabelaGerenciadorM tabelaUsuarioModel) {
		this.tabelaUsuarioModel = tabelaUsuarioModel;
	}

	public int getLinhaSelecionada() {
		return linhaSelecionada;
	}

	public void setLinhaSelecionada(int linhaSelecionada) {
		this.linhaSelecionada = linhaSelecionada;
	}

	public int getAcao() {
		return acao;
	}

	public void setAcao(int acao) {
		this.acao = acao;
	}
}
