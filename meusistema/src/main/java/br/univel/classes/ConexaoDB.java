package br.univel.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton
public final class ConexaoDB {

	private static ConexaoDB self;
	
	private Connection con;
	
	private ConexaoDB() {
		try {
			Class.forName("org.postgresql.Driver");
			this.con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/~","postgres", "univel");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	public final static ConexaoDB getInstance() {
		if (self == null) {
			self = new ConexaoDB();
		}
		return self;
	}
	
	public Connection getConnection() {
		return this.con;
	}

	
}