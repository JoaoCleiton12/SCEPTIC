package model.bo;

import java.sql.SQLException;
import java.sql.ResultSet;
import model.InsertException;

import java.util.ArrayList;
import java.util.List;

import model.dao.FuncionarioDAO;
import model.dao.PessoaDAO;
import model.vo.FuncionarioVO;

public class FuncionarioBO<VO extends FuncionarioVO> implements BaseInterBO<FuncionarioVO> {
	PessoaDAO dao0 = new FuncionarioDAO();
	FuncionarioDAO dao = new FuncionarioDAO();

	public void remover(Long cliente) throws SQLException {
				dao.remover(cliente);
	}
	public FuncionarioVO autenticar(FuncionarioVO vo) throws Exception {
		ResultSet rs = dao.listarLogin(vo);
		try {
			if (rs.next()) {
				if (rs.getString("email").equals(vo.getEmail()) & rs.getString("senha").equals(vo.getSenha())) {
					FuncionarioVO fun = new FuncionarioVO();
					fun.setEmail(rs.getString("email"));
					fun.setSenha(rs.getString("senha"));
					fun.setNome(rs.getString("nome"));
					fun.setEndereco(rs.getString("endereco"));
					fun.setTelefone(rs.getString("tele"));
					fun.setTipo(rs.getInt("tipo"));
					return fun;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void inserir(FuncionarioVO funcionario) throws SQLException {
				dao.inserir(funcionario);
	}

	public void remover(FuncionarioVO funcionario) throws SQLException {
		dao.remover(funcionario);
	}
	@Override
	public List<FuncionarioVO> listar() throws SQLException {
		FuncionarioDAO dao = new FuncionarioDAO();
		ResultSet rs = dao.listar();
		List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		try {
			while (rs.next()) {
				FuncionarioVO vo2 = new FuncionarioVO();
				vo2.setId(rs.getLong("id_res"));
				vo2.setNome(rs.getString("nome"));
				vo2.setEmail(rs.getString("email"));
				vo2.setEndereco(rs.getString("endereco"));
				vo2.setTelefone(rs.getString("tele"));
				vo2.setTipo(rs.getInt("tipo"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void alterar(FuncionarioVO funcionario) throws InsertException {

				dao.alterar(funcionario);
	}

	@Override
	public List<FuncionarioVO> listarPorId(FuncionarioVO funcionario) throws SQLException {
		List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		try {
			ResultSet rs = dao.listarPorId(funcionario);
			while (rs.next()) {
				FuncionarioVO vo2 = new FuncionarioVO();
				funcionario.setId(rs.getLong("id_res"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<FuncionarioVO> listarPorNome(FuncionarioVO funcionario) throws SQLException {
		List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		try {
			ResultSet rs = dao.listarPorNome(funcionario);
			while (rs.next()) {
				FuncionarioVO vo2 = new FuncionarioVO();
				funcionario.setNome(rs.getString("nome"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<FuncionarioVO> listarPorLogin(FuncionarioVO funcionario) throws SQLException {
		List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		try {
			ResultSet rs = dao.listarLogin(funcionario);
			while (rs.next()) {
				FuncionarioVO vo2 = new FuncionarioVO();
				funcionario.setId(rs.getLong("id_res"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setSenha(rs.getString("senha"));
				funcionario.setTipo(rs.getInt("tipo"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setTelefone(rs.getString("telefone"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
