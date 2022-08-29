package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO<VO> implements BaseInterDAO<VO>{
	private static Connection conn = null;
	private static final String url = "jdbc:mariadb://localhost:3306/sceptic";
	private static final String user = "root";
	private static final String senha = "root";
	
	public static Connection getConnection(){
		if(conn==null) {
			try {
				conn= DriverManager.getConnection(url,user,senha);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return conn;
		}
		else return conn;	
	}
	public static void closeConnection() {
	if(conn != null) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	}
	public abstract void inserir(VO vo) throws SQLException;
	public abstract void alterar(VO vo) throws SQLException;
	public abstract void remover(VO vo) throws SQLException;
	public abstract ResultSet listar() throws SQLException;
	public abstract ResultSet listarPorId(VO vo) throws SQLException;
	public abstract ResultSet listarPorNome(VO vo) throws SQLException;
}


