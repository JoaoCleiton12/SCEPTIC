package model.dao;
import model.vo.EquipamentoVO;
import model.vo.FuncionarioVO;
import model.vo.LocalVO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipamentoDAOtest {
  public static void main(String[] args) throws SQLException  {
    //inserirEq();
    //removerEq();
    //alterarEq();
    //listarPorId();
    //listarPorNome();
    //CompraEq();
    //listarPorNumeroSerie();
    //listarPorResponsavel();
    //listarPorLocal();
    //listarEq();
	}


  private static void inserirEq() throws SQLException{
    EquipamentoVO vo = new EquipamentoVO();
	  EquipamentoDAO dao = new EquipamentoDAO();
    FuncionarioVO fu = new FuncionarioVO();
    LocalVO  lo = new LocalVO();
    vo.setNome("Mouse");
    vo.setPeso(2.5);
    vo.setNumeroDeSerie("123423");
    vo.setPreco(22.5);
	  vo.setQuantidade(25);
    lo.setId((long) 1);
    vo.setLocal(lo);
    fu.setId((long) 1);
    vo.setResponsavel(fu);
	dao.inserir(vo);
  }
	private static void removerEq() throws SQLException{
  		EquipamentoVO vo = new EquipamentoVO();
		EquipamentoDAO dao = new EquipamentoDAO();
		vo.setId((long) (5));
		dao.remover(vo);	
		}
	private static void alterarEq() throws SQLException{
		EquipamentoVO vo = new EquipamentoVO();
		EquipamentoDAO dao = new EquipamentoDAO();
		vo.setNome("Teclado");
		vo.setPreco(55);
		vo.setId((long) 7);
		dao.alterar(vo);
	}
  private static void listarPorId() throws SQLException{
    EquipamentoVO vo = new EquipamentoVO();
    EquipamentoDAO dao = new EquipamentoDAO();
    vo.setId((long) 1);
    ResultSet list= dao.listarPorId(vo);
  }
  private static void listarPorNome() throws SQLException{
    EquipamentoVO vo = new EquipamentoVO();
    EquipamentoDAO dao = new EquipamentoDAO();
    vo.setNome("M");
    ResultSet list= dao.listarPorNome(vo);
  }
  private static void listarPorNumeroSerie() throws SQLException{
    EquipamentoVO vo = new EquipamentoVO();
    EquipamentoDAO dao = new EquipamentoDAO();
    vo.setNumeroDeSerie("123423");
    ResultSet list= dao.listarPorNumeroSerie(vo);
  }
  private static void listarPorResponsavel() throws SQLException{
    EquipamentoVO vo = new EquipamentoVO();
    FuncionarioVO vo2 = new FuncionarioVO();
    EquipamentoDAO dao = new EquipamentoDAO();
    vo2.setId((long)2);
    vo.setResponsavel(vo2);
    ResultSet list= dao.listarPorResponsavel(vo);
  }
  private static void listarPorLocal() throws SQLException{
    EquipamentoVO vo = new EquipamentoVO();
    LocalVO vo2 = new LocalVO();
    EquipamentoDAO dao = new EquipamentoDAO();
    vo2.setId((long)1);
    vo.setLocal(vo2);
    ResultSet list= dao.listarPorLocal(vo);
  }
  private static void listarEq() throws SQLException{
    EquipamentoDAO dao = new EquipamentoDAO();
    ResultSet list= dao.listar();
  }
  private static void CompraEq() throws SQLException{
  EquipamentoVO vo = new EquipamentoVO();
  EquipamentoDAO dao = new EquipamentoDAO();
  vo.setId((long) (1));
  dao.Compra(vo);	
  }
}
