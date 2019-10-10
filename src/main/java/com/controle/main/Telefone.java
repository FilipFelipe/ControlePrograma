package com.controle.main;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controle.model.TelefoneM;
import com.controle.model.UsuarioM;
import com.controle.service.TelefoneService;
import com.controle.service.UsuarioService;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;

public class Telefone extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final Component btnNewButton = null;
	private JPanel contentPane;
	private UsuarioM usuarios;
	private JTextField tipo_telefone_txt;
	private JTextField telefone_txt;
	public TelefoneM pegartel(UsuarioM usuario) {
		List<TelefoneM> telusers = new ArrayList<TelefoneM>();
		TelefoneM tel = new TelefoneM();
		tel.setNumeroTelefone(telefone_txt.getText());
		tel.setTipoTelefone(tipo_telefone_txt.getText());
		tel.setUsuario(usuario);
		return tel;
	}
	
	public Telefone(UsuarioM usuario) {
		setType(Type.UTILITY);
		
		
		this.usuarios = usuario;
		
	
	
	

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelefoneService telefoneService = new TelefoneService();
				TelefoneM tel = pegartel(usuarios);
				telefoneService.salvarTelefone(tel);
				JOptionPane.showMessageDialog(null, "O Telefone " + tel.getNumeroTelefone() +" foi salvo com sucesso!");
				 int Confirm = JOptionPane.showConfirmDialog(null,"Deseja Incluir mais um telefone?","Adicionar outro telefone?", JOptionPane.YES_NO_OPTION);
				    if (Confirm == JOptionPane.YES_OPTION) {
				    	telefone_txt.setText("");
						tipo_telefone_txt.setText("");
					
				    } else if (Confirm == JOptionPane.NO_OPTION){
				    	
				    	dispose();

				    }	
				
			}
		});
	

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		tipo_telefone_txt = new JTextField();
		tipo_telefone_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tipo_telefone_txt.setBounds(137, 119, 204, 29);
		contentPane.add(tipo_telefone_txt);
		tipo_telefone_txt.setColumns(10);
		
		telefone_txt = new JTextField();
		telefone_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		telefone_txt.setBounds(137, 65, 204, 29);
		contentPane.add(telefone_txt);
		telefone_txt.setColumns(10);
		
		
		btnNewButton.setBounds(81, 188, 119, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(257, 188, 119, 48);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Usuário :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(42, 25, 96, 29);
		contentPane.add(lblNewLabel);
		
		JLabel usuario_txt = new JLabel("");
		usuario_txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usuario_txt.setBounds(148, 25, 177, 29);
		contentPane.add(usuario_txt);
		usuario_txt.setText(usuario.getNome());
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefone.setBounds(31, 65, 96, 29);
		contentPane.add(lblTelefone);
		
		JLabel lblTipo = new JLabel("Tipo :");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipo.setBounds(70, 119, 57, 29);
		contentPane.add(lblTipo);
		setLocationRelativeTo(null);
	}
}
