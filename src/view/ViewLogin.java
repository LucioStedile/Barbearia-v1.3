package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BarbeariaDAO;
import model.BarbeariaDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassoword;
	public static Boolean acessoLiberado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
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
	public ViewLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lgste.000\\Documents\\Git\\Barbearia_1.2\\navalha2.png"));
		setTitle("BARBEARIA V1.3");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(322, 130, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(322, 74, 63, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(302, 99, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassoword = new JPasswordField();
		txtPassoword.setBounds(302, 155, 83, 20);
		contentPane.add(txtPassoword);
		
		JButton btnLogar = new JButton("Entrar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logar();
			}
		});
		btnLogar.setBounds(302, 202, 89, 23);
		contentPane.add(btnLogar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lgste.000\\Documents\\Git\\Barbearia_1.2\\barbearia2.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
	}
	
	private void Logar() {
		String usuario,senha;
		
		usuario = txtUsuario.getText();
		senha = new String(txtPassoword.getPassword());
		
		BarbeariaDTO objbarbeariadto = new BarbeariaDTO();
		
		objbarbeariadto.setNome_usuario(usuario);
		objbarbeariadto.setSenha_usuario(senha);
		
		BarbeariaDAO barbeariadao = new BarbeariaDAO();
		
		ResultSet rs = barbeariadao.autenticaUsuario(objbarbeariadto);
		
		try {
			if(rs.next()) {
				acessoLiberado = true;
				JOptionPane.showMessageDialog(null, "Login efetuado com Sucesso!");
				
				dispose();
			}else {
				acessoLiberado = false;
				JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválida!");
			}
			
			if(acessoLiberado == true) {
				ViewPrincipal vp = new ViewPrincipal();
				vp.setVisible(true);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao tentar se Logar!" + e);
			throw new RuntimeException(e);
		}
	}
}























