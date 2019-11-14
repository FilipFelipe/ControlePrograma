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
import javax.swing.border.EmptyBorder;
import com.controle.model.UsuarioM;
import com.controle.model.TabelaUsuarioM;
import com.controle.service.TelefoneService;
import com.controle.service.UsuarioService;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Font;

public class Usuario extends JFrame {
	private static final long serialVersionUID = -7666904947797883899L;
	
	private JPanel contentPane;
	private JTextField nome_txt;
	private JTextField endereco_txt;
	private JTextField bairro_txt;
	private JTextField cidade_txt;
	private JTextField cep_txt;
	private JTextField numero_txt;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JButton btnatt;
	private JTextField id_txt;
	private JComboBox<?> tipo_txt;
	private JTable tabelaUsuario;
	
	private TabelaUsuarioM tabelaUsuarioModel;
	private int linhaSelecionada;
	private int acao;
	private JTextField tipo1_txt;
	private JPasswordField senha_txt;
	private JButton btnatt_1;

	
	

	public Usuario(JFrame frame, JTable tabelaUsuario,
            TabelaUsuarioM tabelaUsuarioModel,
            int linhaSelecionada,
            int acao ) {

			this.tabelaUsuario = tabelaUsuario;
			this.tabelaUsuarioModel = tabelaUsuarioModel;
			this.linhaSelecionada = linhaSelecionada;
			this.acao = acao;
			System.out.println(gettabelaUsuarioModel().getUsuario(getLinhaSelecionada()));
			
initComponents();

createEvents();

configurarAcao();
}

	protected void configurarAcao() {
		if (getAcao() == 0) {     //incluir
			btnExcluir.setEnabled(false);
			btnatt_1.setVisible(false);
		} else if ( getAcao() == 1 )  {   //alterar
			btnSalvar.setVisible(false);
			btnExcluir.setEnabled(false);
			pegarDadosClienteFromTabela();
		} else {  //excluir
			pegarDadosClienteFromTabela();  
			btnSalvar.setEnabled(false);
		}
	}

	private void createEvents() {
		
		
		
		btnSalvar.addActionListener(new ActionListener() { //salvar
			public void actionPerformed(ActionEvent arg0) {
				UsuarioService usuarioService = new UsuarioService();
				UsuarioM usuario = pegarDadosClienteFromTela(1);
				TelefoneService telefoneService = new TelefoneService();
				//usuarioService.alterarCLiente(usuario);
				usuarioService.salvarCliente(usuario);
			
				limpartela();
				
				int Confirm = JOptionPane.showConfirmDialog(null,"O usuário " + usuario.getNome() + " foi cadastrado com sucesso!\n Deseja cadastrar um número de telefone para "+ usuario.getNome()+ " ?","Adicionar telefone?", JOptionPane.YES_NO_OPTION);
			    if (Confirm == JOptionPane.YES_OPTION) {
			    	
					Telefone tel = new Telefone(usuario); 
					tel.setVisible(true);  
				
			    } else if (Confirm == JOptionPane.NO_OPTION){
			    	

			    }	
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
		senha_txt.setText("");
		tipo1_txt.setText("");
	}

	@SuppressWarnings("deprecation")
	protected UsuarioM pegarDadosClienteFromTela(int op) {
		UsuarioM usuario = new UsuarioM();
		if (op == 1) {	// Novo Usuario
			usuario.setNome(nome_txt.getText());
			usuario.setBairro(bairro_txt.getText());
			usuario.setCep(cep_txt.getText());
			usuario.setCidade(cidade_txt.getText());
			usuario.setNumero(numero_txt.getText());
			usuario.setSenha(senha_txt.getText());
			usuario.setTipo(tipo1_txt.getText());
			usuario.setEndereco(endereco_txt.getText());
	        return usuario;		
		}
		else {
		
			// telefone 2 telefone2_txt e telefone 3 telefone3_txt 
			usuario.setId(Long.parseLong(id_txt.getText())); // converte para long
			usuario.setNome(nome_txt.getText());
			usuario.setBairro(bairro_txt.getText());
			usuario.setCep(cep_txt.getText());
			usuario.setCidade(cidade_txt.getText());
			usuario.setNumero(numero_txt.getText());
			usuario.setSenha(senha_txt.getText());
			usuario.setTipo(tipo1_txt.getText());
			usuario.setEndereco(endereco_txt.getText());
			//usuario.getTelefones(salvartel());
			
			//usuario.setTelefones(telefone_txt.getText());
			
	        return usuario;	
		}
		
	}

	
	protected void pegarDadosClienteFromTabela() {
		
		System.out.println(gettabelaUsuarioModel());
		
		System.out.println(gettabelaUsuarioModel().getUsuario(getLinhaSelecionada()));
		UsuarioM usuario = gettabelaUsuarioModel().getUsuario(getLinhaSelecionada());
		System.out.println(Long.toString(usuario.getId()));
		id_txt.setText(Long.toString(usuario.getId()));
		nome_txt.setText(usuario.getNome());
		bairro_txt.setText(usuario.getBairro());
		cep_txt.setText(usuario.getCep());
		cidade_txt.setText(usuario.getCidade());
		numero_txt.setText(usuario.getNumero());
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
		JButton btntel = new JButton("Adicionar Telefone");
		btntel.setBounds(610, 351, 178, 51);
		contentPane.add(btntel);
		btntel.setEnabled(false);
		btntel.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblBairro.setBounds(153, 218, 74, 34);
		if ( getAcao() == 1 ) {
			btntel.setEnabled(true);
		}
		else if( getAcao() == 0 ){
			btntel.setEnabled(false);
		}
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
		
		JLabel lblCep = new JLabel("Cep :");
		lblCep.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblCep.setBounds(171, 356, 54, 34);
		
		cep_txt = new JTextField();
		cep_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		cep_txt.setBounds(243, 356, 304, 34);
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
		btnExcluir.setBounds(430, 550, 155, 64);
		btnCancelar = new JButton("Sair");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setIcon(new ImageIcon(".\\Imagens\\exit.png"));
		btnCancelar.setBounds(743, 550, 155, 64);
		
		JLabel lblCdigo = new JLabel("Matrícula :");
		lblCdigo.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblCdigo.setBounds(123, 42, 106, 30);
		
		id_txt = new JTextField();
		id_txt.setEnabled(false);
		id_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		
		id_txt.setBounds(245, 38, 100, 34);
		id_txt.setColumns(10);
		
		tipo1_txt = new JTextField();
		tipo1_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		tipo1_txt.setText("0");
		tipo1_txt.setBounds(314, 439, 46, 34);
		tipo1_txt.setColumns(10);
		contentPane.setLayout(null);
		
		JLabel lblTipoDeUsurio = new JLabel("Tipo de usuário :");
		lblTipoDeUsurio.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblTipoDeUsurio.setBounds(131, 439, 173, 34);
		contentPane.add(lblTipoDeUsurio);
		contentPane.add(lblCep);
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
		contentPane.add(cep_txt);
		contentPane.add(endereco_txt);
		contentPane.add(cidade_txt);
		contentPane.add(bairro_txt);
		contentPane.add(lblNmero);
		contentPane.add(numero_txt);
		contentPane.add(id_txt);
		
		JLabel lblNewLabel = new JLabel("Senha : ");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblNewLabel.setBounds(540, 439, 93, 34);
		contentPane.add(lblNewLabel);
		
		btnatt_1 = new JButton("Atualizar");
		btnatt_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnatt_1.setIcon(new ImageIcon(".\\Imagens\\attuser.png"));
		btnatt_1.addActionListener(new ActionListener() { // BOTAO ATUALIZAR
			public void actionPerformed(ActionEvent e) {
				UsuarioService usuarioService = new UsuarioService();
				
				UsuarioM usuario = pegarDadosClienteFromTela(0);
				usuarioService.alterarCLiente(usuario);
				
				
				limpartela();
				JOptionPane.showMessageDialog(null, "Usuário " + usuario.getNome() + " foi atualizado com sucesso!");
				dispose();
			}
		});
		btnatt_1.setBounds(100, 550, 155, 64);
		contentPane.add(btnatt_1);
		id_txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) // fazer busca utilizando o enter no campo ID
				{ UsuarioService usuarioService = new UsuarioService();
				UsuarioM usuario = pegarDadosClienteFromTela(0);
				usuario = usuarioService.consultarCliente(Long.valueOf(usuario.getId()));
				//pegarDadosClienteFromTabela(usuario);
				btnSalvar.setVisible(false);
				btnExcluir.setEnabled(true);
				btnatt_1.setVisible(true);
				btntel.setEnabled(true);} 
			}
		});
		
		btntel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioM usuario = pegarDadosClienteFromTela(0);
				Telefone tel = new Telefone(usuario); 
				tel.setVisible(true);  
			}
		});
		senha_txt = new JPasswordField();
		senha_txt.setFont(new Font("Dialog", Font.PLAIN, 23));
		senha_txt.setBounds(634, 439, 154, 34);
		contentPane.add(senha_txt);
		
		
		
		setLocationRelativeTo(null);
		
	}

	public JTable gettabelaUsuario() {
		return tabelaUsuario;
	}

	public void settabelaUsuario(JTable tabelaUsuario) {
		this.tabelaUsuario = tabelaUsuario;
	}

	public TabelaUsuarioM gettabelaUsuarioModel() {
		return tabelaUsuarioModel;
	}

	public void settabelaUsuarioModel(TabelaUsuarioM tabelaUsuarioModel) {
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
