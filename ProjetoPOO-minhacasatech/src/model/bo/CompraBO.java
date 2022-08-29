package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.InsertException;
import model.dao.CompraDAO;
import model.vo.CompraVO;
import model.vo.EquipamentoVO;

public class CompraBO implements BaseInterBO<CompraVO>{
  CompraDAO dao = new CompraDAO();

  @Override
  public void inserir(CompraVO compra) throws SQLException {
    dao.inserir(compra);
  }

  @Override
  public void alterar(CompraVO compra) throws SQLException {
    try {
      ResultSet rs = dao.listar();
      if (rs.next()){
        throw new InsertException("Não será possivel");
      }
      else{
        dao.remover(compra);
      }
      }
      catch (SQLException e){
        throw new InsertException(e.getMessage());
      }
    
  }

  @Override
  public void remover(CompraVO compra) throws SQLException {
        dao.remover(compra);
  }

  @Override
  public List<CompraVO> listarPorId(CompraVO entity) throws SQLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<CompraVO> listarPorNome(CompraVO entity) throws SQLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<CompraVO> listar() throws SQLException {
    List<CompraVO> list = new ArrayList<CompraVO>();
    ResultSet rs = dao.listar();
    try {
      while(rs.next()) {
        CompraVO vo2 = new CompraVO();
        EquipamentoVO vo3 = new EquipamentoVO();
        vo2.setId(rs.getLong("id_eq_cli"));
        vo2.setDataCompra(rs.getString("dt_compra"));
        vo3.setNome(rs.getString("nome_eq"));
        vo3.setNumeroDeSerie(rs.getString("num_serie_eq"));
        vo3.setPeso(rs.getDouble("peso_eq"));
        vo3.setPreco(rs.getDouble("equipamentos.preco_eq"));
        vo2.setEquipamento(vo3);
        vo2.setQuantidade(rs.getLong("qtd_produto"));
        vo2.setPreco(rs.getDouble("equipamentos_has_clientes.preco_eq"));
        list.add(vo2);
        System.out.println("Id: "+rs.getInt("id_eq") + " Nome: "+rs.getString("nome_eq") +
				" Peso: "+rs.getInt("peso_eq") +" responsavel: "+rs.getString("nome"));
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }
  public void remover(Long compra) throws SQLException {
    dao.remover(compra);
}
}
