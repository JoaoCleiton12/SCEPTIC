package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.CompraVO;

public class CompraDAO extends BaseDAO<CompraVO> {

  @Override
  public void inserir(CompraVO vo) throws SQLException {
    String sql = "INSERT INTO equipamentos_has_clientes (equipamentos_id_eq,clientes_id_cli,qtd_produto,preco_eq,comentario) VALUES (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1,vo.getEquipamento().getId());
			ptst.setLong(2,vo.getCliente().getId());
			ptst.setLong(3,vo.getQuantidade());
			ptst.setDouble(4,vo.getPreco());
			ptst.setString(5,vo.getDescricao());
			System.out.println(ptst);
			int affectedRows = ptst.executeUpdate();
			if(affectedRows ==0) {
				throw new SQLException("Cadastro falhou");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
  }
  @Override
  public ResultSet listar() throws SQLException {
    String sql = "SELECT * FROM equipamentos_has_clientes INNER JOIN equipamentos ON equipamentos_id_eq = id_eq INNER JOIN clientes ON id_cli=clientes_id_cli INNER JOIN responsaveis ON responsaveis_id_res = id_res INNER JOIN pessoa ON clientes.pessoa_id_pes=id_pes;";
		Statement st;
		ResultSet rs = null;
		try {
			st = getConnection().createStatement();
			rs=st.executeQuery(sql);
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
  }

  @Override
  public ResultSet listarPorId(CompraVO vo) throws SQLException {
		PreparedStatement st;
		ResultSet rs = null;
    String sql = "SELECT * "
    +"FROM equipamentos_has_clientes INNER JOIN equipamentos ON equipamentos_id_eq = id_eq "
    +"INNER JOIN clientes ON "+vo.getCliente().getId()+" = clientes_id_cli "
    +"INNER JOIN responsaveis ON responsaveis_id_res = id_res "
    +"INNER JOIN pessoa ON clientes.pessoa_id_pes=id_pes;";
		try {
			st = getConnection().prepareStatement(sql);
      // st.setLong(1,vo.getCliente().getId());
			rs=st.executeQuery(sql);
			// System.out.println(st);
			while(rs.next()) {
				System.out.println("Id do equipamento: "+rs.getInt("equipamentos_id_eq") + " Nome do equipamento: "+rs.getString("nome_eq") +
        " Id do cliente: "+rs.getInt("clientes_id_cli") + " Nome do funcionario: "+rs.getString("nome")+ " Data da compra: "+rs.getString("dt_compra"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
  }
  public ResultSet listarPordata(CompraVO vo) throws SQLException {
    PreparedStatement st;
		ResultSet rs = null;
    String sql = "SELECT * "
    +"FROM equipamentos_has_clientes INNER JOIN equipamentos ON equipamentos_id_eq = id_eq AND dt_compra = '" +vo.getDataCompra()
    +"' INNER JOIN clientes ON id_cli = clientes_id_cli "
    +"INNER JOIN responsaveis ON responsaveis_id_res = id_res "
    +"INNER JOIN pessoa ON clientes.pessoa_id_pes=id_pes;";
		try {
			st = getConnection().prepareStatement(sql);
      // st.setLong(1,vo.getCliente().getId());
			rs=st.executeQuery(sql);
			//System.out.println(st);
			while(rs.next()) {
				System.out.println("Id do equipamento: "+rs.getInt("equipamentos_id_eq") + " Nome do equipamento: "+rs.getString("nome_eq") +
        " Id do cliente: "+rs.getInt("clientes_id_cli") + " Nome do cliente: "+rs.getString("nome")+ " Data da compra: "+rs.getString("dt_compra"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
  }
  @Override
  public void alterar(CompraVO vo) throws SQLException {
    // TODO Auto-generated method stub
  }
  @Override
  public void remover(CompraVO vo) throws SQLException {
		String sql = "DELETE FROM equipamentos_has_clientes WHERE id_eq_cli = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
  }
	public void remover(Long vo) throws SQLException {
    String sql = "DELETE FROM equipamentos_has_clientes WHERE id_eq_cli = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo);
			ptst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
  }
  @Override
  public ResultSet listarPorNome(CompraVO vo) throws SQLException {
    return null;
  }

  
  
}
