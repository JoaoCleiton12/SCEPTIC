package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.EquipamentoVO;

public class EquipamentoDAO extends BaseDAO<EquipamentoVO> {
	@Override
	public void inserir(EquipamentoVO vo) throws SQLException {
		String sql = "INSERT INTO equipamentos (nome_eq,peso_eq,num_serie_eq,preco_eq,quant_eq,responsaveis_id_res,locais_id_loc) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1,vo.getNome());
			ptst.setDouble(2,vo.getPeso());
			ptst.setString(3,vo.getNumeroDeSerie());
			ptst.setDouble(4,vo.getPreco());
			ptst.setInt(5,vo.getQuantidade());
			ptst.setLong(6,vo.getResponsavel().getId());
			ptst.setLong(7,vo.getLocal().getId());
			
			int affectedRows = ptst.executeUpdate();
			if(affectedRows ==0) {
				throw new SQLException("Cadastro falhou");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setId(generatedKeys.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet listar(){
		//String sql = "SELECT id_eq,nome_eq,peso_eq,num_serie_eq,preco_eq,quant_eq,nome_loc,nome_comp_loc,email,tipo,nome FROM equipamentos LEFT JOIN locais ON locais_id_loc = locais.id_loc INNER JOIN responsaveis ON responsaveis_id_res = responsaveis.id_res INNER JOIN pessoa ON pessoa.id_pes = responsaveis.pessoa_id_pes";
	  String sql = "SELECT * FROM equipamentos LEFT JOIN locais ON locais_id_loc = locais.id_loc INNER JOIN responsaveis ON responsaveis_id_res = responsaveis.id_res INNER JOIN pessoa ON pessoa.id_pes = responsaveis.pessoa_id_pes";
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
	@Override
	public void alterar(EquipamentoVO vo) throws SQLException {
		String sql = "UPDATE equipamentos SET nome_eq = ?, preco_eq = ?, quant_eq = ?, responsaveis_id_res = ?, locais_id_loc = ? where id_eq = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			ptst.setDouble(2,vo.getPreco());
			ptst.setInt(3, vo.getQuantidade());
			ptst.setLong(4, vo.getResponsavel().getId());
			ptst.setLong(5, vo.getLocal().getId());
			ptst.setLong(6 ,vo.getId());
			ptst.execute();
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void remover(Long vo) throws SQLException {
		String sql = "DELETE FROM equipamentos WHERE id_eq = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo);
			ptst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	public void Compra(EquipamentoVO vo) throws SQLException {
			String sql = "UPDATE equipamentos SET equipamentos.quant_eq=equipamentos.quant_eq - 1 WHERE id_eq = ?;";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setLong(1, vo.getId());
				ptst.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
	@Override
	public ResultSet listarPorId(EquipamentoVO vo) throws SQLException {
		
		PreparedStatement st;
		ResultSet rs = null;
		String sql = "select * from equipamentos where id_eq = ?";
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1,vo.getId());
			rs=st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet listarPorNumeroSerie(EquipamentoVO vo) throws SQLException {
		PreparedStatement st;
		ResultSet rs = null;
		String sql = "SELECT * FROM equipamentos WHERE num_serie_eq LIKE ?";
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1,vo.getNumeroDeSerie());
			rs=st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet listarPorNumeroSerie(String vo) throws SQLException {
		PreparedStatement st;
		ResultSet rs = null;
		String sql = "SELECT * FROM equipamentos LEFT JOIN locais ON locais_id_loc = locais.id_loc INNER JOIN responsaveis ON responsaveis_id_res = responsaveis.id_res INNER JOIN pessoa ON pessoa.id_pes = responsaveis.pessoa_id_pes AND num_serie_eq LIKE ?";
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1,"%"+vo+"%");
			rs=st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public ResultSet listarPorNome(EquipamentoVO vo) throws SQLException {
		PreparedStatement st;
		ResultSet rs = null;
		String sql = "SELECT * FROM equipamentos LEFT JOIN locais ON locais_id_loc = locais.id_loc INNER JOIN responsaveis ON responsaveis_id_res = responsaveis.id_res INNER JOIN pessoa ON pessoa.id_pes = responsaveis.pessoa_id_pes AND nome_eq LIKE ?";
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1,"%"+vo.getNome()+"%");
			rs=st.executeQuery();
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt("id_eq") + " Nome: "+rs.getString("nome_eq") +
				 " Peso: "+rs.getInt("peso_eq") +" Preço: "+rs.getInt("preco_eq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet listarPorNome(String vo) throws SQLException {
		PreparedStatement st;
		ResultSet rs = null;
		String sql = "SELECT * FROM equipamentos LEFT JOIN locais ON locais_id_loc = locais.id_loc INNER JOIN responsaveis ON responsaveis_id_res = responsaveis.id_res INNER JOIN pessoa ON pessoa.id_pes = responsaveis.pessoa_id_pes AND nome_eq LIKE ?";
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1,"%"+vo+"%");
			rs=st.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet listarPorLocal(String vo) throws SQLException {
		PreparedStatement st;
		ResultSet rs = null;
		String sql = "SELECT * FROM equipamentos LEFT JOIN locais ON locais_id_loc = locais.id_loc INNER JOIN responsaveis ON responsaveis_id_res = responsaveis.id_res INNER JOIN pessoa ON pessoa.id_pes = responsaveis.pessoa_id_pes AND nome_loc LIKE ?";
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1,"%"+vo+"%");
			rs=st.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet listarPorResponsavel(EquipamentoVO vo) throws SQLException {
		PreparedStatement st;
		ResultSet rs = null;
		String sql = "SELECT * "
		+"FROM equipamentos INNER JOIN responsaveis ON ? = id_res"
		+" INNER JOIN pessoa ON id_pes = pessoa_id_pes;";
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1,vo.getResponsavel().getId());
			rs=st.executeQuery();
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt("id_eq") + " Nome: "+rs.getString("nome_eq") +
			  " Preço: "+rs.getInt("preco_eq")+" Nome do Responsavel: "+rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet listarPorLocal(EquipamentoVO vo) throws SQLException {
		PreparedStatement st;
		ResultSet rs = null;
		String sql = "SELECT * "+
		"FROM equipamentos INNER JOIN locais ON ? =  locais.id_loc;";
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1,vo.getLocal().getId());
			rs=st.executeQuery();
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt("id_eq") + " Nome: "+rs.getString("nome_eq") +
			  " Preço: "+rs.getInt("preco_eq")+" Nome do Local: "+rs.getString("nome_loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public void remover(EquipamentoVO vo) throws SQLException {
		String sql = "DELETE FROM equipamentos WHERE id_eq = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
