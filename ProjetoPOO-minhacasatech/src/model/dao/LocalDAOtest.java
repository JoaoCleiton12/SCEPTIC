package model.dao;
import model.vo.LocalVO;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LocalDAOtest{
	private static ResultSet listarPorId;
  private static ResultSet listarPorNome;
  public static void main(String[] args) throws SQLException  {
    inserir_local();
    //remover_local();
    //alterar_local();
    //listar_local_id();
    //listar_local_nome();
    //listar_local();
	}
  private static void listar_local() throws SQLException{
    LocalDAO dao = new LocalDAO();
    dao.listar();
	//   for (ResultSet vo_0) {
	// 	System.out.println("Id: "+vo_0.getId()+ ", Nome: "+vo_0.getNome()+", Compartimento: "+vo_0.getCompartimento());
	// }
  }
  private static void inserir_local() throws SQLException{
    LocalVO vo = new LocalVO();
		LocalDAO dao = new LocalDAO();
    vo.setNome("Robin");
    vo.setCompartimento("Batcaverna");
		dao.inserir(vo);
  }
  private static void remover_local() throws SQLException{
    LocalVO vo = new LocalVO();
		LocalDAO dao = new LocalDAO();
    vo.setId((long) 2);
	  dao.remover(vo);
  }
  private static void alterar_local() throws SQLException{
    LocalVO vo = new LocalVO();
		LocalDAO dao = new LocalDAO();
    vo.setNome("Alfred");
    vo.setCompartimento("teen titans");
    vo.setId((long) 1);
		dao.alterar(vo);
  }
  private static void listar_local_id() throws SQLException{
    LocalVO vo = new LocalVO();
    LocalDAO dao = new LocalDAO();
    vo.setId((long) 1);
    listarPorId = dao.listarPorId(vo);
  }
  private static void listar_local_nome() throws SQLException{
    LocalVO vo = new LocalVO();
    LocalDAO dao = new LocalDAO();
    vo.setNome("Al");
    listarPorNome = dao.listarPorNome(vo);
  }
}