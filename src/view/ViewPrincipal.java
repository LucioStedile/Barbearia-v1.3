package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;

public class ViewPrincipal extends JFrame {

	private JPanel contentPane;
	JTable tableCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipal frame = new ViewPrincipal();
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
	public ViewPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lgste.000\\Documents\\Git\\Barbearia_1.2\\navalha2.png"));
		setTitle("BARBEARIA V1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsulta = new JButton("INICIAR");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLista vl = new ViewLista();
				vl.setVisible(true);
			}
		});
		btnConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConsulta.setBounds(501, 658, 148, 23);
		contentPane.add(btnConsulta);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSair.setBounds(689, 658, 148, 23);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lgste.000\\Documents\\Git\\Barbearia_1.2\\barbearia.jpg"));
		lblNewLabel.setBounds(0, 0, 1584, 761);
		contentPane.add(lblNewLabel);
	}
	
		
}
