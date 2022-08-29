package model.dao;
import model.vo.ClienteVO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAOtest {
  public static void main(String[] args) throws SQLException  {
    //inserir_clien();
    //remover_clien();
    //alterar_clien();
    listar_clien();
	}
  private static void listar_clien(){
    ClienteDAO dao = new ClienteDAO();
    ResultSet list= dao.listar();
	  // for (ClienteVO vo_0: list) {
		// System.out.println("Id: "+vo_0.getId()+ ", Nome: "+vo_0.getNome()+", CPF: "+vo_0.getCPF());
	//}
  }
  private static void inserir_clien() throws SQLException{
    ClienteVO vo = new ClienteVO();
		ClienteDAO dao = new ClienteDAO();
    vo.setNome("Harry");
    vo.setEndereco("Hogwarts");
    vo.setTelefone("987245232");
    vo.setCPF("01723000123");
		dao.inserir(vo);
		System.out.println("Salvo com sucesso");
		
  }
  private static void remover_clien() throws SQLException{
    ClienteVO vo = new ClienteVO();
    ClienteDAO dao = new ClienteDAO();
    vo.setId((long) 2);
		dao.remover(vo);
		System.out.println("Salvo com sucesso");

  }
  private static void alterar_clien(){
    ClienteVO vo = new ClienteVO();
		ClienteDAO dao = new ClienteDAO();
    vo.setNome("Hermione");
    vo.setCPF("93897754");
    vo.setId((long)1);
		dao.alterar(vo);
		System.out.println("Salvo com sucesso");
  }
}
