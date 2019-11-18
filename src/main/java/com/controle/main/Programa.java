package com.controle.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import com.controle.model.ProgramaM;
import com.controle.model.TabelaProgramaM;
import com.controle.service.ProgramaService;
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

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField programa_txt;
	private JTextField permissao_txt;
	private JTextField status_txt;
	private JTextField versao_txt;
	private JTextField id_txt;
	private int linhaSelecionada;
	private TabelaProgramaM tabelaProgramaModelo;
	private JTable tabelaPrograma;
	private int acao;



	
	
	public Programa(JFrame frame, JTable tabelaPrograma,
            TabelaProgramaM tabelaProgramaModelo,
            int linhaSelecionada,
            int acao ) {

			this.tabelaPrograma = tabelaPrograma;
			this.tabelaProgramaModelo = tabelaProgramaModelo;
			this.linhaSelecionada = linhaSelecionada;
			this.acao = acao;
			
initComponents();

createEvents();

configurarAcao();

}
	protected void limpartela() {
			id_txt.setText("");
			programa_txt.setText("");
			status_txt.setText("");
			versao_txt.setText("");
			permissao_txt.setText("");
			
		}
	protected void pegarDadosProgramaFromTabela() {
		ProgramaM programa = gettabelaPrograM().getPrograma(getLinhaSelecionada());	
		id_txt.setText(Long.toString(programa.getId()));
		programa_txt.setText(programa.getNome());
		permissao_txt.setText(programa.getPermissao());
		status_txt.setText(programa.getStatus());
		versao_txt.setText(programa.getVersao());
	};                           
	private void initComponents(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Imagens\\programashow.png"));
		setTitle("Programas Cadastrados ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 841, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSalvar = new JButton("Cadastrar");
		btnSalvar.setIcon(new ImageIcon(".\\Imagens\\programadd.png"));
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalvar.setBounds(43, 286, 179, 64);
	
		
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
		permissao_txt.setBounds(250, 147, 123, 34);
		permissao_txt.setColumns(10);
		
		JLabel lblCep = new JLabel("Status :");
		lblCep.setBounds(158, 204, 79, 26);
		lblCep.setFont(new Font("Dialog", Font.PLAIN, 23));
		
		status_txt = new JTextField();
		status_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		status_txt.setBounds(250, 200, 70, 34);
		status_txt.setColumns(10);
		
		versao_txt = new JTextField();
		versao_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		versao_txt.setBounds(574, 200, 147, 34);
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
		btnExcluir.setIcon(new ImageIcon(".\\Imagens\\programremove.png"));
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnExcluir.setBounds(319, 286, 155, 64);
		contentPane.add(btnExcluir);
		
		
		btnatt.setIcon(new ImageIcon(".\\Imagens\\attprogram.png"));
		btnatt.setVisible(false);
		btnatt.setFont(new Font("Tahoma", Font.BOLD, 16));
	
		btnatt.setBounds(43, 286, 179, 64);
		contentPane.add(btnatt);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(".\\Imagens\\sair.png"));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnSair.setBounds(606, 286, 155, 64);
		contentPane.add(btnSair);
		
		id_txt = new JTextField();
		id_txt.setEnabled(false);
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
					pegarDadosProgramaFromTabela();
					btnSalvar.setVisible(false);
					btnExcluir.setEnabled(true);
					btnatt.setVisible(true);
			} } 
			}
		});
		id_txt.setBounds(250, 50, 86, 34);
		contentPane.add(id_txt);
		id_txt.setColumns(10);
		
		JLabel lblId = new JLabel("ID : ");
		lblId.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblId.setBounds(200, 54, 48, 26);
		contentPane.add(lblId);
		setLocationRelativeTo(null);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgramaService programaService = new ProgramaService();
				ProgramaM programa = pegarDadosProgramaFromTela(1);
				
				programaService.salvarPrograma(programa);
					
				limpartela();
				JOptionPane.showMessageDialog(null, "O programa " + programa.getNome() + " foi cadastrado com sucesso!");
			}
		});
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
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Main main = new Main(); 
				//main.setVisible(true); 
				dispose();
			}
		});
		if (getAcao() == 0) {     //incluir
			btnatt.setVisible(false);
			btnSalvar.setVisible(true);
			System.out.println("passou aqui");
		} else if ( getAcao() == 1 )  {   //alterar
			btnatt.setVisible(true);
			btnSalvar.setVisible(false);
			btnExcluir.setVisible(true);
			pegarDadosProgramaFromTabela();
		} else {  //excluir
			pegarDadosProgramaFromTabela();  
		
		}
	};

	private void createEvents(){
		
	};

	protected void configurarAcao(){
		
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

public JTable gettabelaPrograma() {
	return tabelaPrograma;
}

public void settabelaUsuario(JTable tabelaPrograma) {
	this.tabelaPrograma = tabelaPrograma;
}

public TabelaProgramaM gettabelaPrograM() {
	return tabelaProgramaModelo;
}

public void settabelaProgramaM(TabelaProgramaM tabelaProgramaM) {
	this.tabelaProgramaModelo = tabelaProgramaM;
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