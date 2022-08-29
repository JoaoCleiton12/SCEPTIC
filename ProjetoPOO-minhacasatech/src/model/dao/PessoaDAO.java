package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.PessoaVO;

public class PessoaDAO extends BaseDAO<PessoaVO>{
	
	public void inserir(PessoaVO vo) throws SQLException {
		String sql = "INSERT INTO pessoa (nome,endereco,tele) values (?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereco());
			ptst.setString(3, vo.getTelefone());
			// ptst.executeUpdate();
			int affectedRows = ptst.executeUpdate();
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void alterar(PessoaVO vo) throws SQLException {
		String sql = "UPDATE pessoa set nome = ? where id_pes = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setLong(2, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void remover(Long vo) throws SQLException {
		String sql = "DELETE FROM pessoa where id_pes = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo);
			ptst.executeUpdate();
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ResultSet listar() throws SQLException {
		String sql = "select * from pessoa";
		Statement st;
		ResultSet rs = null;
		
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt("id_pes")+" Nome: "+rs.getString("nome")
				+" Telefone: "+rs.getString("tele"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet listar2() {
		String sql = "select * from pessoa";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			rs = ptst.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public ResultSet listarPorId(PessoaVO vo) throws SQLException {
		PreparedStatement st;
		ResultSet rs = null;
		String sql = "select * from pessoa where id_pes = ?";
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1,vo.getId());
			rs=st.executeQuery();
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt("id_pes")+" Nome: "+rs.getString("nome")
				+" Endereço: "+rs.getString("endereco"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public ResultSet listarPorNome(PessoaVO vo) throws SQLException {
		PreparedStatement st;
		ResultSet rs = null;
		String sql = "SELECT * FROM pessoa WHERE nome LIKE ?";
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1,"%"+vo.getNome()+"%");
			rs=st.executeQuery();
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt("id_pes")+" Nome: "+rs.getString("nome")
				+" Endereço: "+rs.getString("endereco"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public void remover(PessoaVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}