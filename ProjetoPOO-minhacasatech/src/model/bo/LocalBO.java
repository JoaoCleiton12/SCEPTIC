package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.InsertException;
import model.dao.LocalDAO;
import model.vo.LocalVO;

public class LocalBO implements BaseInterBO<LocalVO>{
  LocalDAO dao = new LocalDAO(); 
  @Override
  public void inserir(LocalVO local) throws SQLException {
        dao.inserir(local);
}

  @Override
  public void alterar(LocalVO local) throws SQLException {
          dao.alterar(local);
  }
  public void remover(Long local) throws SQLException {
    dao.remover(local);    
}
  @Override
  public void remover(LocalVO local) throws SQLException {
        dao.remover(local);    
  }

  @Override
  public List<LocalVO> listarPorId(LocalVO local) throws SQLException {
    List<LocalVO> list = new ArrayList<LocalVO>();
		 try {
			 ResultSet rs = dao.listarPorId(local);
			 while(rs.next()) {
        LocalVO vo2 = new LocalVO();
				local.setId(rs.getLong("id_loc"));
				list.add(vo2);
			 }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return list;
  }

  @Override
  public List<LocalVO> listarPorNome(LocalVO local) throws SQLException {
    List<LocalVO> list = new ArrayList<LocalVO>();
		 try {
			 ResultSet rs = dao.listarPorNome(local);
			 while(rs.next()) {
        LocalVO vo2 = new LocalVO();
				 local.setNome(rs.getString("nome"));
				 list.add(vo2);
			 }
      }
      catch (SQLException e) {
        e.printStackTrace();
      }
      return list;
  }
  @Override
  public List<LocalVO> listar() throws SQLException {
    List<LocalVO> list = new ArrayList<LocalVO>();
		 try {
			 ResultSet rs = dao.listar();
			 
			 while(rs.next()) {
				 LocalVO vo = new LocalVO();
				vo.setId(rs.getLong("id_loc"));
				vo.setNome(rs.getString("nome_loc"));
        vo.setCompartimento(rs.getString("nome_comp_loc"));
				 list.add(vo);
			 }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return list;
  }
  
}
