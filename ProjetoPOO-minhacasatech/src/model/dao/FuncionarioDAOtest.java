package model.dao;
import model.vo.FuncionarioVO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAOtest {
  public static void main(String[] args) throws SQLException  {
    inserir_func();
    //remover_func();
    //alterar_func();
    //listar_func();
    //listar_funcEmail();
    //listar_funcId();
	}
  
  private static void inserir_func() throws SQLException{
    FuncionarioVO vo = new FuncionarioVO();
		FuncionarioDAO dao = new FuncionarioDAO();
    vo.setNome("Batman");
    vo.setEndereco("Batcaverna N - 121");
    vo.setTelefone("888888888");
    vo.setEmail("wayne@gmail.com");
    vo.setSenha("morcego123");
    vo.setTipo(0);
		dao.inserir(vo);
  }
  private static void remover_func(){
    FuncionarioVO vo = new FuncionarioVO();
		FuncionarioDAO dao = new FuncionarioDAO();
    vo.setId((long)1);
	  dao.remover(vo);
  }
  private static void alterar_func(){
    FuncionarioVO vo = new FuncionarioVO();
		FuncionarioDAO dao = new FuncionarioDAO();
    vo.setTipo(0);
    vo.setId((long) 3);
		dao.alterar(vo);
  }
  private static void listar_func(){
    FuncionarioDAO dao = new FuncionarioDAO();
    ResultSet list = dao.listar();
  }
  private static void listar_funcEmail(){
    FuncionarioVO vo = new FuncionarioVO();
    FuncionarioDAO dao = new FuncionarioDAO();
    vo.setEmail("wayne@gmail.com");
    vo.setSenha("morcego123");
    ResultSet list = dao.listarLogin(vo);
  }
  private static void listar_funcId() throws SQLException{
    FuncionarioVO vo = new FuncionarioVO();
    FuncionarioDAO dao = new FuncionarioDAO();
    vo.setId((long) 1);
    ResultSet list = dao.listarPorId(vo);
  }
}

