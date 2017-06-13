package br.univel.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	private String search_all = "SELECT * FROM CONTATO";

	public List<Aluno> getTodos() {
	
		Connection con = ConexaoDB.getInstance().getConnection();
		
		List<Aluno> lista = new ArrayList<>();
		try (PreparedStatement ps = con.prepareStatement(search_all);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				Aluno a = new Aluno();
				a.setId(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setNota(rs.getInt(3));
				lista.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
