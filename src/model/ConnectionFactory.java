package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	public Connection getConnection() {
		
		String connectionUrl = "jdbc:sqlserver://DESKTOP-D76RND4\\SQLEXPRES:1433;databaseName=BARBEARIA_1_2;user=sa;password=823345";
		
		try {
			return DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Conecção não realizada no ConnectionFactory"+e);
			throw new RuntimeException(e);
		}
	}
}
