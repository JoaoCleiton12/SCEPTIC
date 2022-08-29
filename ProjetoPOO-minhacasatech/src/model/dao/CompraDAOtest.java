package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.ClienteVO;
import model.vo.CompraVO;
import model.vo.EquipamentoVO;

public class CompraDAOtest {
  public static void main(String[] args) throws SQLException  {
    //inserirComp();
    //listarComp();
    //listarCompId();
    //listarCompData();
  }
  private static void listarComp() throws SQLException{
    CompraDAO dao = new CompraDAO();
    ResultSet list= dao.listar();
  }
  private static void inserirComp() throws SQLException{
    CompraVO vo = new CompraVO(); 
	  CompraDAO dao = new CompraDAO();
    ClienteVO cli = new ClienteVO();
    EquipamentoVO eq = new EquipamentoVO();

    cli.setId((long) 1);
    vo.setCliente(cli);
    eq.setId((long) 1);
    vo.setEquipamento(eq);
    vo.setQuantidade((long) 52);
    vo.setPreco(23.54);
	  dao.inserir(vo);
  }
  private static void listarCompId() throws SQLException{
    CompraVO vo = new CompraVO(); 
    ClienteVO cli = new ClienteVO();
    CompraDAO dao = new CompraDAO();
    cli.setId((long) 1);
    vo.setCliente(cli);
    ResultSet list= dao.listarPorId(vo);
  }
  private static void listarCompData() throws SQLException{
    CompraVO vo = new CompraVO(); 
    CompraDAO dao = new CompraDAO();

    vo.setDataCompra("2021-10-15");
    ResultSet list= dao.listarPordata(vo);
  }
}
