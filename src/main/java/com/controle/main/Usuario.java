package com.controle.main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import com.controle.model.UsuarioM;
import com.controle.model.TabelaUsuarioModel;
import com.controle.service.UsuarioService;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Toolkit;

public class Usuario extends JFrame {
	private static final long serialVersionUID = -7666904947797883899L;
	private JPanel contentPane;
	private JTextField nome_txt;
	private JTextField endereco_txt;
	private JTextField bairro_txt;
	private JTextField cidade_txt;
	private JTextField telefone_txt;
	private JTextField cep_txt;
	private JTextField numero_txt;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JTextField id_txt;
	private JComboBox tipo_txt;
	private JTable tabelaUsuario;
	private TabelaUsuarioModel tabelaUsuarioModel;
	private int linhaSelecionada;
	private int acao;
	private JTextField tipo1_txt;
	private JButton btnbuscar;
	private JPasswordField senha_txt;
	

	 public static void main(String[] args) { EventQueue.invokeLater(new
	 Runnable() { public void run() { try { for ( LookAndFeelInfo laf :
	  UIManager.getInstalledLookAndFeels()) { if ("Nimbus".equals(laf.getName())){
	  UIManager.setLookAndFeel(laf.getClassName()); } else { System.out.println();
	  }
	  
	  } Usuario frame = new Usuario(); frame.setVisible(true); } catch
	  (Exception e) { e.printStackTrace(); } } }); }
	 

	
	public Usuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Imagens\\Usuario2.png"));
		initComponents();
		
		createEvents();
		
		
	}


	private void createEvents() {
		
		btnSalvar.addActionListener(new ActionListener() { //salvar
			public void actionPerformed(ActionEvent arg0) {
				UsuarioService usuarioService = new UsuarioService();
				UsuarioM usuario = pegarDadosClienteFromTela(1);
				//usuarioService.alterarCLiente(usuario);
				usuarioService.salvarCliente(usuario);
				limpartela();
				JOptionPane.showMessageDialog(null, "Usuário " + usuario.getNome() + " foi cadastrado com sucesso!");
			}
		});

		btnExcluir.addActionListener(new ActionListener() { //excluir
			public void actionPerformed(ActionEvent e) {
				UsuarioService usuarioService = new UsuarioService();
				UsuarioM usuario = pegarDadosClienteFromTela(0);
				usuario = usuarioService.consultarCliente(Long.valueOf(usuario.getId()));
				usuarioService.excluirCliente(usuario);
				limpartela();
				JOptionPane.showMessageDialog(null, "Usuário " + usuario.getNome() + " foi excluido com sucesso!");
				
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}

	protected void limpartela() {
		id_txt.setText("");
		nome_txt.setText("");
		bairro_txt.setText("");
		endereco_txt.setText("");
		cep_txt.setText("");
		cidade_txt.setText("");
		numero_txt.setText("");
		telefone_txt.setText("");
		senha_txt.setText("");
		tipo1_txt.setText("");
	}

	@SuppressWarnings("deprecation")
	protected UsuarioM pegarDadosClienteFromTela(int op) {
		UsuarioM usuario = new UsuarioM();
		if (op == 1) {
			usuario.setNome(nome_txt.getText());
			usuario.setBairro(bairro_txt.getText());
			usuario.setCep(cep_txt.getText());
			usuario.setCidade(cidade_txt.getText());
			usuario.setNumero(numero_txt.getText());
			usuario.setTelefone(telefone_txt.getText());
			usuario.setSenha(senha_txt.getText());
			usuario.setTipo(tipo1_txt.getText());
			usuario.setEndereco(endereco_txt.getText());
	        return usuario;		
		}
		else {
			usuario.setId(Long.parseLong(id_txt.getText())); // converte para long
			usuario.setNome(nome_txt.getText());
			usuario.setBairro(bairro_txt.getText());
			usuario.setCep(cep_txt.getText());
			usuario.setCidade(cidade_txt.getText());
			usuario.setNumero(numero_txt.getText());
			usuario.setTelefone(telefone_txt.getText());
			usuario.setSenha(senha_txt.getText());
			usuario.setTipo(tipo1_txt.getText());
			usuario.setEndereco(endereco_txt.getText());
	        return usuario;	
		}
		
	}
	
	protected void pegarDadosClienteFromTabela(UsuarioM usuario) {
		
		id_txt.setText(Long.toString(usuario.getId()));
		nome_txt.setText(usuario.getNome());
		bairro_txt.setText(usuario.getBairro());
		cep_txt.setText(usuario.getCep());
		cidade_txt.setText(usuario.getCidade());
		numero_txt.setText(usuario.getNumero());
		telefone_txt.setText(usuario.getTelefone());
		tipo1_txt.setText(usuario.getTipo());
		endereco_txt.setText(usuario.getEndereco());
		senha_txt.setText(usuario.getSenha());
	}
	
	private void initComponents() {
		setTitle("Controle de usuário  ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblNome.setBounds(153, 98, 89, 26);
		
		nome_txt = new JTextField();
		nome_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		nome_txt.setBounds(245, 98, 514, 34);
		nome_txt.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço :");
		lblEndereo.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblEndereo.setBounds(115, 158, 118, 34);
		
		endereco_txt = new JTextField();
		endereco_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		endereco_txt.setBounds(245, 158, 445, 34);


		endereco_txt.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblBairro.setBounds(153, 218, 74, 34);
		
		bairro_txt = new JTextField();
		bairro_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		bairro_txt.setBounds(245, 218, 422, 34);
		bairro_txt.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade :");
		lblCidade.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblCidade.setBounds(145, 278, 89, 34);
		
		cidade_txt = new JTextField();
		cidade_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		cidade_txt.setBounds(245, 278, 522, 34);
		cidade_txt.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblTelefone.setBounds(129, 338, 106, 34);
		
		telefone_txt = new JTextField();
		telefone_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		telefone_txt.setBounds(245, 338, 383, 34);
		telefone_txt.setColumns(10);
		
		JLabel lblCep = new JLabel("Cep :");
		lblCep.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblCep.setBounds(173, 398, 54, 34);
		
		cep_txt = new JTextField();
		cep_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		cep_txt.setBounds(245, 398, 304, 34);
		cep_txt.setColumns(10);
		
		JLabel lblNmero = new JLabel("Número:");
		lblNmero.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblNmero.setBounds(712, 161, 89, 26);
		
		numero_txt = new JTextField();
		numero_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		numero_txt.setBounds(811, 158, 96, 34);
		numero_txt.setColumns(10);
		
		btnSalvar = new JButton("Cadastrar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setIcon(new ImageIcon(".\\Imagens\\adduser.png"));
		btnSalvar.setBounds(100, 550, 155, 64);
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(".\\Imagens\\delluser.png"));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(325, 550, 155, 64);
		btnCancelar = new JButton("Sair");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setIcon(new ImageIcon(".\\Imagens\\exit.png"));
		btnCancelar.setBounds(825, 550, 155, 64);
		
		JLabel lblCdigo = new JLabel("Matrícula :");
		lblCdigo.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblCdigo.setBounds(123, 42, 106, 30);
		
		id_txt = new JTextField();
		id_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		
		id_txt.setBounds(245, 38, 100, 34);
		id_txt.setColumns(10);
		
		JButton btnNewButton = new JButton("Mostrar Usuários");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setIcon(new ImageIcon(".\\Imagens\\users.png"));
		btnNewButton.setBounds(550, 550, 194, 64);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TabelaUsuario Tabela = new TabelaUsuario(); 
				Tabela.setVisible(true);  
			}
		});
		
		tipo1_txt = new JTextField();
		tipo1_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		tipo1_txt.setText("0");
		tipo1_txt.setBounds(318, 458, 46, 34);
		tipo1_txt.setColumns(10);
		contentPane.setLayout(null);
		
		JLabel lblTipoDeUsurio = new JLabel("Tipo de usuário :");
		lblTipoDeUsurio.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblTipoDeUsurio.setBounds(135, 458, 173, 34);
		contentPane.add(lblTipoDeUsurio);
		contentPane.add(lblCep);
		contentPane.add(lblTelefone);
		contentPane.add(lblCidade);
		contentPane.add(lblBairro);
		contentPane.add(lblNome);
		contentPane.add(lblEndereo);
		contentPane.add(lblCdigo);
		contentPane.add(btnSalvar);
		contentPane.add(btnExcluir);
		contentPane.add(btnCancelar);
		contentPane.add(tipo1_txt);
		contentPane.add(nome_txt);
		contentPane.add(telefone_txt);
		contentPane.add(cep_txt);
		contentPane.add(endereco_txt);
		contentPane.add(cidade_txt);
		contentPane.add(bairro_txt);
		contentPane.add(lblNmero);
		contentPane.add(numero_txt);
		contentPane.add(id_txt);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Senha : ");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblNewLabel.setBounds(544, 458, 93, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnatt = new JButton("Atualizar");
		btnatt.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnatt.setIcon(new ImageIcon(".\\Imagens\\attuser.png"));
		btnatt.setVisible(false);
		btnatt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioService usuarioService = new UsuarioService();
				UsuarioM usuario = pegarDadosClienteFromTela(0);
				usuarioService.alterarCLiente(usuario);
				limpartela();
				JOptionPane.showMessageDialog(null, "Usuário " + usuario.getNome() + " foi atualizado com sucesso!");
				btnSalvar.setVisible(true);
				btnatt.setVisible(false);
				btnExcluir.setEnabled(false);
			}
		});
		btnatt.setBounds(100, 550, 155, 64);
		contentPane.add(btnatt);
		
		btnbuscar = new JButton("");
		btnbuscar.setIcon(new ImageIcon(".\\Imagens\\buscar.png"));
		btnbuscar.addActionListener(new ActionListener() { // buscar
			public void actionPerformed(ActionEvent e) {
				if (id_txt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O número de matrícula deve ser informado!!");
					id_txt.requestFocus();
				}else {
					UsuarioService usuarioService = new UsuarioService();
					UsuarioM usuario = pegarDadosClienteFromTela(0);
					usuario = usuarioService.consultarCliente(Long.valueOf(usuario.getId()));
					pegarDadosClienteFromTabela(usuario);
					btnSalvar.setVisible(false);
					btnExcluir.setEnabled(true);
					btnatt.setVisible(true);
				}
				
				
			}
			
		});
		id_txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) // fazer busca utilizando o enter no campo ID
				{ UsuarioService usuarioService = new UsuarioService();
				UsuarioM usuario = pegarDadosClienteFromTela(0);
				usuario = usuarioService.consultarCliente(Long.valueOf(usuario.getId()));
				pegarDadosClienteFromTabela(usuario);
				btnSalvar.setVisible(false);
				btnExcluir.setEnabled(true);
				btnatt.setVisible(true); } 
			}
		});
		btnbuscar.setBounds(358, 41, 70, 34);
		contentPane.add(btnbuscar);
		
		senha_txt = new JPasswordField();
		senha_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		senha_txt.setBounds(638, 458, 154, 34);
		contentPane.add(senha_txt);
		
		JComboBox tipo_txt = new JComboBox();
		tipo_txt.setVisible(false);
		tipo_txt.setModel(new DefaultComboBoxModel(new String[] {"0 - Desligado", "1 - Funcionário", "2 - Administrador"}));
		tipo_txt.setBounds(1030, 470, 96, 19);
		contentPane.add(tipo_txt);
		setLocationRelativeTo(null);
	}

	public JTable gettabelaUsuario() {
		return tabelaUsuario;
	}

	public void settabelaUsuario(JTable tabelaUsuario) {
		this.tabelaUsuario = tabelaUsuario;
	}

	public TabelaUsuarioModel gettabelaUsuarioModel() {
		return tabelaUsuarioModel;
	}

	public void settabelaUsuarioModel(TabelaUsuarioModel tabelaUsuarioModel) {
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
