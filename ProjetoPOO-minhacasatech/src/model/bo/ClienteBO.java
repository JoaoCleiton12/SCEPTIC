package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import model.InsertException;
import model.dao.ClienteDAO;
import model.dao.PessoaDAO;
import model.vo.ClienteVO;

public class ClienteBO implements BaseInterBO<ClienteVO> {
	PessoaDAO dao0 = new ClienteDAO();
	ClienteDAO dao = new ClienteDAO();

	public void inserir(ClienteVO Cliente) throws SQLException {
				dao.inserir(Cliente);
	}
	public void remover(Long cliente) throws SQLException {
				dao.remover(cliente);
	}

	@Override
	public List<ClienteVO> listar() throws SQLException {
		ResultSet rs = dao.listar();
		List<ClienteVO> list = new ArrayList<ClienteVO>();

		try {
			while (rs.next()) {
				ClienteVO vo2 = new ClienteVO();
				vo2.setId(rs.getLong("id_cli"));
				vo2.setNome(rs.getString("nome"));
				vo2.setCPF(rs.getString("cpf_cli"));
				vo2.setEndereco(rs.getString("endereco"));
				list.add(vo2);
				System.out.println("Id: "+rs.getInt("id_cli")+" CPF: "+rs.getInt("cpf_cli")+" Nome: "+rs.getString("nome")+" Endereço: "+rs.getString("endereco"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void alterar(ClienteVO cliente) throws SQLException {

				dao.alterar(cliente);
	}

	@Override
	public List<ClienteVO> listarPorId(ClienteVO cliente) throws SQLException {
		List<ClienteVO> list = new ArrayList<ClienteVO>();
		try {
			ResultSet rs = dao0.listar();
			while (rs.next()) {
				ClienteVO vo2 = new ClienteVO();
				cliente.setId(rs.getLong("id_cli"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ClienteVO> listarPorNome(ClienteVO cliente) throws SQLException {
		List<ClienteVO> list = new ArrayList<ClienteVO>();
		try {
			ResultSet rs = dao0.listar();
			while (rs.next()) {
				ClienteVO vo2 = new ClienteVO();
				cliente.setNome(rs.getString("nome"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void remover(ClienteVO cliente) throws SQLException {
		try {
			ResultSet rs = dao.listar();
			if (rs.next()) {
				throw new InsertException("Não será possivel");
			} else {
				dao.remover(cliente);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
		
	}

}