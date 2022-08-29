package model.dao;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.vo.*;

public class PessoaDAOtest {
  private static ResultSet listarPorId;
  private static ResultSet listarPorNome;
  public static void main(String[] args) throws SQLException  {
    //inserir_pes();
    //remover_pes();
    //alterar_pes();
    //listar_pes();
    //listar_pes_id();
    //listar_pes_Nome();
  }
  private static void inserir_pes() throws SQLException{
    PessoaVO vo = new FuncionarioVO();
    PessoaDAO dao = new PessoaDAO();
    vo.setNome("Arouldo");
    vo.setEndereco("Manoel e Joaquim");
    vo.setTelefone("4002-8922");
    dao.inserir(vo);
  }
  private static void remover_pes() throws SQLException{
    PessoaVO vo = new FuncionarioVO();
    PessoaDAO dao = new PessoaDAO();
    vo.setId((long) 2);
    dao.remover(vo);
  }
  private static void alterar_pes() throws SQLException{
    PessoaVO vo = new FuncionarioVO();
    PessoaDAO dao = new PessoaDAO();
    vo.setNome("Joel");
    vo.setId((long) 1);
    dao.alterar(vo);
  }
  private static void listar_pes() throws SQLException{
    PessoaDAO dao = new PessoaDAO();
    dao.listar();
  }
  private static void listar_pes_id() throws SQLException{
    PessoaVO vo = new FuncionarioVO();
    PessoaDAO dao = new PessoaDAO();
    vo.setId((long) 1);
    listarPorId = dao.listarPorId(vo);
  }
  private static void listar_pes_Nome() throws SQLException{
    PessoaVO vo = new FuncionarioVO();
    PessoaDAO dao = new PessoaDAO();
    vo.setNome((String) "r");
    listarPorId = dao.listarPorNome(vo);
  }
}
