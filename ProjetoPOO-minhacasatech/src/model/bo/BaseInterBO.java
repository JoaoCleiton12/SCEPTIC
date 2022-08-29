package model.bo;

import java.sql.SQLException;
import java.util.List;

public interface BaseInterBO<VO>{
  public void inserir(VO entity) throws SQLException;
	public void alterar(VO entity) throws SQLException;
	public void remover(VO entity) throws SQLException;
	public List<VO> listarPorId(VO entity) throws SQLException;
	public List<VO> listarPorNome(VO entity) throws SQLException;
	public List<VO> listar() throws SQLException;
	
}
