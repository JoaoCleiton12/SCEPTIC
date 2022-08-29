package model.dao;

import model.vo.LocalVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LocalDAO extends BaseDAO<LocalVO> {
	
	@Override
	public void inserir(LocalVO lo)throws SQLException {
		String sql = "INSERT INTO locais (nome_loc,nome_comp_loc) VALUES (?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1,lo.getNome());
			ptst.setString(2, lo.getCompartimento());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cadastro falhou");
		}
	}
	public void remover(Long lo) throws SQLException{
		String sql = "DELETE FROM Locais WHERE id_loc = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1,lo);
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void remover(LocalVO lo) throws SQLException{
		String sql = "DELETE FROM Locais WHERE id_loc = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1,lo.getId());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ResultSet listar() throws SQLException {
		String sql = "SELECT * FROM locais";
		Statement st;
		ResultSet rs = null;
		try {
			st = getConnection().createStatement();
			rs=st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public void alterar(LocalVO lo) throws SQLException{
		String sql = "UPDATE locais SET nome_loc = ?, nome_comp_loc = ? where id_loc = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, lo.getNome());
			ptst.setString(2,lo.getCompartimento());
			ptst.setLong(3,lo.getId());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ResultSet listarPorId(LocalVO vo) throws SQLException {
		PreparedStatement st;
		ResultSet rs = null;
		String sql = "select * from locais where id_loc = ?";
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1,vo.getId());
			rs=st.executeQuery();
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt("id_loc")+" Nome: "+rs.getString("nome_loc")
				+" Compartimento: "+rs.getString("nome_comp_loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public ResultSet listarPorNome(LocalVO vo) throws SQLException {
		PreparedStatement st;
		ResultSet rs = null;
		String sql = "SELECT * FROM locais WHERE nome_loc LIKE ?";
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1,"%"+vo.getNome()+"%");
			rs=st.executeQuery();
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt("id_loc")+" Nome: "+rs.getString("nome_loc")
				+" Compartimento: "+rs.getString("nome_comp_loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
