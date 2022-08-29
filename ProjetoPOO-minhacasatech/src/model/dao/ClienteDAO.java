package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.ClienteVO;

public class ClienteDAO<VO extends ClienteVO> extends PessoaDAO{
	public void inserir(ClienteVO vo) throws SQLException {
		try {
			super.inserir(vo);
			String sql = "INSERT INTO  clientes (cpf_cli,pessoa_id_pes) values (?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getCPF());
			ptst.setLong(2, vo.getId());
			int affectedRows = ptst.executeUpdate();
			if(affectedRows == 0) {
				throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void remover(Long vo) {
		try {
			super.remover(vo);
			String sql = "DELETE FROM clientes where id_cli = ?";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo);
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void alterar(ClienteVO vo) {
		try {
			String sql = "UPDATE clientes INNER JOIN pessoa ON pessoa_id_pes = id_pes SET nome = ?,endereco = ? WHERE id_cli= ?";
		  	PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereco());
			ptst.setLong(3, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet listar(){
		String sql = "SELECT * FROM clientes JOIN pessoa ON pessoa_id_pes = id_pes";
		ResultSet rs = null;
		Statement st;
		try {	
			st = getConnection().createStatement();
			System.out.println(st);
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
