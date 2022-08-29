package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.FuncionarioVO;

public class FuncionarioDAO<VO extends FuncionarioVO> extends PessoaDAO {

	public void inserir(FuncionarioVO vo) throws SQLException {
		super.inserir(vo);
		try {
			String sql = "INSERT INTO responsaveis (email,senha,tipo,pessoa_id_pes) values (?,?,?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getEmail());
			ptst.setString(2, vo.getSenha());
			ptst.setInt(3, vo.getTipo());
			ptst.setLong(4, vo.getId());
			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				vo.setId(generatedKeys.getLong(1));
			} else {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void remover(FuncionarioVO vo) {
		try {
			String sql = "DELETE FROM responsaveis where id_res = ?";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			super.remover(vo);
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void remover(Long vo) {
		try {
			String sql = "DELETE FROM responsaveis where id_res = ?";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo);
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet listar() {
		String sql = "select * from responsaveis INNER JOIN pessoa ON pessoa.id_pes = responsaveis.pessoa_id_pes";
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

	public void alterar(FuncionarioVO vo) {
		try {
			String sql = "UPDATE responsaveis INNER JOIN pessoa ON pessoa.id_pes = responsaveis.pessoa_id_pes set nome = ?, endereco = ?, tele = ? where id_res = ?";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereco());
			ptst.setString(3, vo.getTelefone());
			ptst.setLong(4, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet listarLogin(FuncionarioVO vo) {
		String sql = "select * from responsaveis INNER JOIN pessoa ON pessoa_id_pes = id_pes and email = ? and senha = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getEmail());
			ptst.setString(2, vo.getSenha());
			rs = ptst.executeQuery();
			// while(rs.next()) {
			// System.out.println("Id: "+rs.getInt("id_res")+" Email:
			// "+rs.getString("email")
			// +" Senha: "+rs.getString("senha")
			// +" Nome: "+rs.getString("nome")
			// +" Telefone: "+rs.getString("tele")
			// +" Tipo: "+rs.getString("tipo"));
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet listarPorId(FuncionarioVO vo) throws SQLException {

		PreparedStatement st;
		ResultSet rs = null;
		String sql = "SELECT * FROM responsaveis INNER JOIN pessoa ON ? = id_pes;";
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, vo.getId());
			rs = st.executeQuery();
			while (rs.next()) {
				System.out.println("Id: " + rs.getInt("id_res") + " Email: " + rs.getString("email") + " Senha: "
						+ rs.getString("senha") + " Nome: " + rs.getString("nome") + " Telefone: " + rs.getString("tele")
						+ " Tipo: " + rs.getString("tipo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
