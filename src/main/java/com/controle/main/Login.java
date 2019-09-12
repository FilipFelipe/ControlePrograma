package com.controle.main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.controle.model.UsuarioM;
import com.controle.service.UsuarioService;


import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login extends JFrame {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id_txt;
	private JPasswordField senha_txt;
	private JTextField senhabanco_txt;
	private JTextField nome_txt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{
							for ( LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
								if ("Nimbus".equals(laf.getName())){
									UIManager.setLookAndFeel(laf.getClassName());
								}
							}
					Login frame = new Login();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("deprecation")
	protected UsuarioM pegarDadosClienteFromTela(int op) {
		UsuarioM cliente = new UsuarioM();
			cliente.setId(Long.parseLong(id_txt.getText())); // converte para long
			cliente.setSenha(senha_txt.getText());
	        return cliente;	

	}
	
	public void pegarDadosClienteFromTabela(UsuarioM cliente) {
		senhabanco_txt.setText(cliente.getSenha());
		nome_txt.setText(cliente.getNome());
	}
	public Login() {
		setResizable(false);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		id_txt = new JTextField();
		id_txt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		id_txt.setBounds(284, 89, 142, 38);
		contentPane.add(id_txt);
		id_txt.setColumns(10);
		
		senha_txt = new JPasswordField();
		senha_txt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		senha_txt.setBounds(284, 158, 142, 38);
		contentPane.add(senha_txt);
		
		JLabel lblNewLabel = new JLabel("Matrícula : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(147, 91, 125, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha : ");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSenha.setBounds(184, 160, 88, 27);
		contentPane.add(lblSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				UsuarioService clienteService = new UsuarioService();
				UsuarioM cliente = pegarDadosClienteFromTela(0);
				cliente = clienteService.consultarSenha(Long.valueOf(cliente.getId()));
				pegarDadosClienteFromTabela(cliente);
				if((senha_txt.getText().equals("")) || (id_txt.getText().equals("")) ) {
					JOptionPane.showMessageDialog(null, "Preencher todos os campos!");
					id_txt.requestFocus();
				}else {
					
					if(cliente.getSenha().equals(senha_txt.getText())) {
						if (cliente.getTipo().equals("0")) {
							JOptionPane.showMessageDialog(null, "Usuário sem privilégio de acesso !" );
						}
						else{Main menu = new Main(); 
						menu.setState(NORMAL);
						menu.usuario(cliente.getNome(),cliente.getTipo());
						menu.setVisible(true);
						dispose();}
					}else {
						id_txt.setText("");
						senha_txt.setText("");
						JOptionPane.showMessageDialog(null, "Usuário ou senha incorreta!" );
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(184, 240, 125, 48);
		contentPane.add(btnNewButton);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSair.setBounds(337, 240, 125, 48);
		contentPane.add(btnSair);
		
		senhabanco_txt = new JTextField();
		senhabanco_txt.setVisible(false);
		senhabanco_txt.setEditable(false);
		senhabanco_txt.setEnabled(false);
		senhabanco_txt.setBounds(652, 51, 74, 27);
		contentPane.add(senhabanco_txt);
		senhabanco_txt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(".\\Imagens\\IconeS.png"));
		lblNewLabel_1.setBounds(280, 0, 79, 88);
		contentPane.add(lblNewLabel_1);
		
		nome_txt = new JTextField();
		nome_txt.setVisible(false);
		nome_txt.setEditable(false);
		nome_txt.setEnabled(false);
		nome_txt.setBounds(652, 92, 74, 38);
		contentPane.add(nome_txt);
		nome_txt.setColumns(10);
		setLocationRelativeTo(null);
	}
}
