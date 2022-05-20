package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BarbeariaDAO;
import model.BarbeariaDTO;

import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ViewLista extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtTipocorte;
	private JTable table_1;
	DefaultTableModel model;
	ArrayList<BarbeariaDTO> lista;
	private JTextField txtTipobarba;
	private JTextField txtPreco_1;
	private JTextField txtPreco_2;
	private JTextField txtAdicional;
	private JTextField txtPreco_3;
	private JTextField txtTotal;
	final Object[] row;
	public Boolean avista = false;
	public Boolean debito = false;
	public Boolean credito = false;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLista frame = new ViewLista();
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
	public ViewLista() {
		setTitle("BARBEARIA V1.3");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1202, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 1186, 503);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(23, 210, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(334, 210, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setBounds(901, 210, 56, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo corte:");
		lblNewLabel_3.setBounds(23, 241, 76, 14);
		panel.add(lblNewLabel_3);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(120, 204, 192, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(394, 204, 486, 20);
		panel.add(txtNome);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(965, 204, 192, 20);
		panel.add(txtTelefone);
		
		txtTipocorte = new JTextField();
		txtTipocorte.setColumns(10);
		txtTipocorte.setBounds(120, 235, 192, 20);
		panel.add(txtTipocorte);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 1166, 106);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table_1.getSelectedRow();
				txtId.setText(model.getValueAt(i, 0).toString());
				txtNome.setText(model.getValueAt(i, 1).toString());
				txtTelefone.setText(model.getValueAt(i, 2).toString());
				txtTipocorte.setText(model.getValueAt(i, 3).toString());
				txtTipobarba.setText(model.getValueAt(i, 4).toString());
				txtAdicional.setText(model.getValueAt(i, 5).toString());
				txtPreco_1.setText(model.getValueAt(i, 6).toString());
				txtPreco_2.setText(model.getValueAt(i, 7).toString());
				txtPreco_3.setText(model.getValueAt(i, 8).toString());
				txtTotal.setText(model.getValueAt(i, 9).toString());
				
			}
		});
		table_1.setBackground(new Color(240, 248, 255));
		model = new DefaultTableModel();
		Object[] column = {"ID","Name","Telefone","Tipo de Corte","Tipo de Barba","Adicionais","Preço Corte","Preço Barba","Valor Adicional","Total"};
		row = new Object[10];
		model.setColumnIdentifiers(column);
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					BarbeariaDTO objBarbeariadto = new BarbeariaDTO();
					BarbeariaDAO objBarbeariaDAO = new BarbeariaDAO();
					lista = objBarbeariaDAO.consultarCliente();
										
					
					row[0] = objBarbeariadto.getId_cliente() + lista.size() + 1;
					row[1] = txtNome.getText();
					row[2] = txtTelefone.getText();
					row[3] = txtTipocorte.getText();
					row[4] = txtTipobarba.getText();
					row[5] = txtAdicional.getText();
					row[6] = txtPreco_1.getText();
					row[7] = txtPreco_2.getText();
					row[8] = txtPreco_3.getText();
					row[9] = txtTotal.getText();
					
					
					
					objBarbeariadto.setNome_cliente(txtNome.getText().toString());
					objBarbeariadto.setTelefone(txtTelefone.getText().toString());
					objBarbeariadto.setTipo_de_corte(txtTipocorte.getText().toString());
					objBarbeariadto.setTipo_de_barba(txtTipobarba.getText().toString());
					objBarbeariadto.setAdicional(txtAdicional.getText().toString());
					objBarbeariadto.setPreco_1(Float.parseFloat(txtPreco_1.getText().toString()));
					objBarbeariadto.setPreco_2(Float.parseFloat(txtPreco_2.getText().toString()));
					objBarbeariadto.setPreco_3(Float.parseFloat(txtPreco_3.getText().toString()));
					objBarbeariadto.setTotal(Float.parseFloat(txtTotal.getText().toString()));
					
					objBarbeariaDAO.cadastrarCliente(objBarbeariadto);
					
					model.addRow(row);
					
					
					txtId.setText("");
					txtNome.setText("");
					txtTelefone.setText("");
					txtTipocorte.setText("");
					txtTipobarba.setText("");
					txtAdicional.setText("");
					txtPreco_1.setText("");
					txtPreco_2.setText("");
					txtPreco_3.setText("");
					txtTotal.setText("");
				
			}
		});
		btnNewButton.setBounds(48, 420, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_1.getSelectedRow();
								
				if(i >= 0) {
					model.removeRow(i);
					
					delete();
															
					JOptionPane.showMessageDialog(null, "Removido com sucesso!");
				}else{
					JOptionPane.showMessageDialog(null, "Favor selecionar a linha!");
				}
			}
		});
		btnDelete.setBounds(413, 420, 89, 23);
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
								
				int i = table_1.getSelectedRow();
				if(i  >= 0) {
					model.setValueAt(txtId.getText(), i, 0);
					model.setValueAt(txtNome.getText(), i, 1);
					model.setValueAt(txtTelefone.getText(), i, 2);
					model.setValueAt(txtTipocorte.getText(), i, 3);
					model.setValueAt(txtTipobarba.getText(), i, 4);
					model.setValueAt(txtAdicional.getText(), i, 5);
					model.setValueAt(txtPreco_1.getText(), i, 6);
					model.setValueAt(txtPreco_2.getText(), i, 7);
					model.setValueAt(txtPreco_3.getText(), i, 8);
					model.setValueAt(txtTotal.getText(), i, 9);
					
					JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
				}else {
					JOptionPane.showMessageDialog(null, "Favor selecionar a linha!");
				}
				
			}
		});
		btnUpdate.setBounds(171, 420, 89, 23);
		panel.add(btnUpdate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtNome.setText("");
				txtTelefone.setText("");
				txtTipocorte.setText("");
				txtTipobarba.setText("");
				txtAdicional.setText("");
				txtPreco_1.setText("");
				txtPreco_2.setText("");
				txtPreco_3.setText("");
				txtTotal.setText("");
			}
		});
		btnClear.setBounds(536, 420, 89, 23);
		panel.add(btnClear);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarValores();
			}
		});
		btnConsultar.setBounds(292, 420, 89, 23);
		panel.add(btnConsultar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(657, 420, 89, 23);
		panel.add(btnSair);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tipo de Barba");
		lblNewLabel_3_1.setBounds(23, 274, 89, 14);
		panel.add(lblNewLabel_3_1);
		
		txtTipobarba = new JTextField();
		txtTipobarba.setColumns(10);
		txtTipobarba.setBounds(120, 268, 192, 20);
		panel.add(txtTipobarba);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pre\u00E7o R$");
		lblNewLabel_1_1.setBounds(334, 241, 56, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Pre\u00E7o R$");
		lblNewLabel_1_2.setBounds(334, 271, 56, 14);
		panel.add(lblNewLabel_1_2);
		
		txtPreco_1 = new JTextField();
		txtPreco_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPreco_1.setColumns(10);
		txtPreco_1.setBounds(394, 235, 98, 20);
		panel.add(txtPreco_1);
		
		txtPreco_2 = new JTextField();
		txtPreco_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtPreco_2.setColumns(10);
		txtPreco_2.setBounds(394, 268, 98, 20);
		panel.add(txtPreco_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Adicional");
		lblNewLabel_1_3.setBounds(521, 241, 63, 14);
		panel.add(lblNewLabel_1_3);
		
		txtAdicional = new JTextField();
		txtAdicional.setColumns(10);
		txtAdicional.setBounds(581, 235, 299, 20);
		panel.add(txtAdicional);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Pre\u00E7o R$");
		lblNewLabel_1_1_1.setBounds(901, 241, 56, 14);
		panel.add(lblNewLabel_1_1_1);
		
		txtPreco_3 = new JTextField();
		txtPreco_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtPreco_3.setColumns(10);
		txtPreco_3.setBounds(965, 238, 98, 20);
		panel.add(txtPreco_3);
		
		txtTotal = new JTextField();
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTotal.setColumns(10);
		txtTotal.setBounds(965, 411, 98, 32);
		panel.add(txtTotal);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Total");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setBounds(965, 389, 98, 20);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("R$");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_2.setBounds(901, 417, 56, 29);
		panel.add(lblNewLabel_1_1_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 187, 1166, 123);
		panel.add(panel_1);
		
	}
		
	private void listarValores() {
		
		BarbeariaDAO objBarbeariaDAO = new BarbeariaDAO();
		
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setNumRows(0);
		
		lista = objBarbeariaDAO.consultarCliente();
		
		for(int num = 0; num < lista.size(); num++) {
			model.addRow(new Object[]{
					lista.get(num).getId_cliente(),
					lista.get(num).getNome_cliente(),
					lista.get(num).getTelefone(),
					lista.get(num).getTipo_de_corte(),
					lista.get(num).getTipo_de_barba(),
					lista.get(num).getAdicional(),
					lista.get(num).getPreco_1(),
					lista.get(num).getPreco_2(),
					lista.get(num).getPreco_3(),
					lista.get(num).getTotal(),
					
				});
			table_1.setModel(model);
		}
	}
	
	private void delete() {
		int id_cliente;
		
		id_cliente = Integer.parseInt(txtId.getText());
		
		BarbeariaDTO objBarbeariaDTO = new BarbeariaDTO();
		objBarbeariaDTO.setId_cliente(id_cliente);
		
		BarbeariaDAO objBarbeariaDAO = new BarbeariaDAO();
		objBarbeariaDAO.deleteCliente(objBarbeariaDTO);
		
	}
}