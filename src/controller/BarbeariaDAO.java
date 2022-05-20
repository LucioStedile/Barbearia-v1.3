package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.BarbeariaDTO;
import model.ConnectionFactory;

public class BarbeariaDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<BarbeariaDTO> lista = new ArrayList<>();
 	
	public ResultSet autenticaUsuario(BarbeariaDTO objusuariodto) {
		String sql = "select * from usuarios where nome_usuario=? and senha_usuario=?";
		
		conn = new ConnectionFactory().getConnection();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objusuariodto.getNome_usuario());
			pstm.setString(2, objusuariodto.getSenha_usuario());
			
			ResultSet rs = pstm.executeQuery();
			return rs;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não autenticou usuario"+e);
			return null;
		}
	}
	
	public void cadastrarCliente(BarbeariaDTO objclientedto) {
		String sql = "insert into clientes(nome_cliente,telefone,tipo_de_corte,tipo_de_barba,adicional,preco_1,preco_2,preco_3,total) values(?,?,?,?,?,?,?,?,?)";
		conn = new ConnectionFactory().getConnection();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objclientedto.getNome_cliente());
			pstm.setString(2, objclientedto.getTelefone());
			pstm.setString(3, objclientedto.getTipo_de_corte());
			pstm.setString(4, objclientedto.getTipo_de_barba());
			pstm.setString(5, objclientedto.getAdicional());
			pstm.setFloat(6, objclientedto.getPreco_1());
			pstm.setFloat(7, objclientedto.getPreco_2());
			pstm.setFloat(8, objclientedto.getPreco_3());
			pstm.setFloat(9, objclientedto.getTotal());
			
			
			pstm.execute();
			pstm.close();
			
			JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar cliente"+ e);
		}
	}
	
	public ArrayList<BarbeariaDTO> consultarCliente(){
		String sql = "Select * from clientes";
		conn = new ConnectionFactory().getConnection();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				BarbeariaDTO objbarbeariadto = new BarbeariaDTO();
				
				objbarbeariadto.setId_cliente(rs.getInt("id_cliente"));
				objbarbeariadto.setNome_cliente(rs.getString("nome_cliente"));
				objbarbeariadto.setTelefone(rs.getString("telefone"));
				objbarbeariadto.setTipo_de_corte(rs.getString("tipo_de_corte"));
				objbarbeariadto.setTipo_de_barba(rs.getString("tipo_de_barba"));
				objbarbeariadto.setAdicional(rs.getString("adicional"));
				objbarbeariadto.setPreco_1(rs.getFloat("preco_1"));
				objbarbeariadto.setPreco_2(rs.getFloat("preco_2"));
				objbarbeariadto.setPreco_3(rs.getFloat("preco_3"));
				objbarbeariadto.setTotal(rs.getFloat("total"));
				
				lista.add(objbarbeariadto);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Consultar Cliente" + e);
		}
		return lista;
	}
	
	public void deleteCliente(BarbeariaDTO objBarbeariaDTO) {
		String sql = "delete from clientes where id_cliente = ?";
		
		conn = new ConnectionFactory().getConnection();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, objBarbeariaDTO.getId_cliente());
			
			pstm.execute();
			pstm.close();
			
			JOptionPane.showMessageDialog(null, "Cliente Deletado com Sucesso!");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao deletar cliente"+ e);
		}
	}
}
