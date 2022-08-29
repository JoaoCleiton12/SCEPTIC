package model.bo;

import java.sql.SQLException;
import java.sql.ResultSet;
import model.InsertException;

import java.util.ArrayList;
import java.util.List;

import model.dao.EquipamentoDAO;
import model.vo.EquipamentoVO;
import model.vo.FuncionarioVO;
import model.vo.LocalVO;

public class EquipamentoBO implements BaseInterBO<EquipamentoVO> {
	EquipamentoDAO dao1 = new EquipamentoDAO();

	public void inserir(EquipamentoVO equipamento) throws SQLException {
		EquipamentoDAO dao = new EquipamentoDAO();
		dao.inserir(equipamento);
	}

	public void remover(Long equipamento) throws SQLException {
				dao1.remover(equipamento);
	}
	@Override
	public List<EquipamentoVO> listar() throws SQLException{
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.listar();
		List<EquipamentoVO> list = new ArrayList<EquipamentoVO>();
		try {
			while (rs.next()) {
				EquipamentoVO vo2 = new EquipamentoVO();
				FuncionarioVO vo3 = new FuncionarioVO();
				LocalVO vo4 = new LocalVO();
				vo2.setId(rs.getLong("id_eq"));
				vo2.setNome(rs.getString("nome_eq"));
				vo2.setNumeroDeSerie(rs.getString("num_serie_eq"));
				vo3.setNome(rs.getString("nome"));
				vo2.setResponsavel(vo3);
				vo2.setPeso(rs.getDouble("peso_eq"));
				vo2.setPreco(rs.getDouble("preco_eq"));
				vo2.setQuantidade(rs.getInt("quant_eq"));
				vo4.setNome(rs.getString("nome_loc"));
				vo2.setLocal(vo4);
				list.add(vo2);
				System.out.println("Id: "+rs.getInt("id_eq") + " Nome: "+rs.getString("nome_eq") +
				" Peso: "+rs.getInt("peso_eq") +" Preço: "+rs.getInt("preco_eq")+" responsavel: "+rs.getString("nome")+" local: "+rs.getString("nome_loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void alterar(EquipamentoVO equipamento) throws SQLException {
				dao1.alterar(equipamento);
	}

	@Override
	public List<EquipamentoVO> listarPorId(EquipamentoVO equipamento) throws SQLException {
		List<EquipamentoVO> list = new ArrayList<EquipamentoVO>();
		try {
			ResultSet rs = dao1.listarPorId(equipamento);
			while (rs.next()) {
				EquipamentoVO vo2 = new EquipamentoVO();
				equipamento.setId(rs.getLong("id_eq"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<EquipamentoVO> listarPorNome(EquipamentoVO equipamento) throws SQLException {
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.listarPorNome(equipamento);
		List<EquipamentoVO> list = new ArrayList<EquipamentoVO>();
		try {
			while (rs.next()) {
				EquipamentoVO vo2 = new EquipamentoVO();
				FuncionarioVO vo3 = new FuncionarioVO();
				LocalVO vo4 = new LocalVO();
				vo2.setId(rs.getLong("id_eq"));
				vo2.setNome(rs.getString("nome_eq"));
				vo2.setNumeroDeSerie(rs.getString("num_serie_eq"));
				vo3.setNome(rs.getString("nome"));
				vo2.setResponsavel(vo3);
				vo2.setPeso(rs.getDouble("peso_eq"));
				vo2.setPreco(rs.getDouble("preco_eq"));
				vo2.setQuantidade(rs.getInt("quant_eq"));
				vo4.setNome(rs.getString("nome_loc"));
				vo2.setLocal(vo4);
				list.add(vo2);
				System.out.println("Id: "+rs.getInt("id_eq") + " Nome: "+rs.getString("nome_eq") +
				" Peso: "+rs.getInt("peso_eq") +" Preço: "+rs.getInt("preco_eq")+" responsavel: "+rs.getString("nome")+" local: "+rs.getString("nome_loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<EquipamentoVO> listarPorNome(String equipamento) throws SQLException {
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.listarPorNome(equipamento);
		List<EquipamentoVO> list = new ArrayList<EquipamentoVO>();
		try {
			while (rs.next()) {
				EquipamentoVO vo2 = new EquipamentoVO();
				FuncionarioVO vo3 = new FuncionarioVO();
				LocalVO vo4 = new LocalVO();
				vo2.setId(rs.getLong("id_eq"));
				vo2.setNome(rs.getString("nome_eq"));
				vo2.setNumeroDeSerie(rs.getString("num_serie_eq"));
				vo3.setNome(rs.getString("nome"));
				vo2.setResponsavel(vo3);
				vo2.setPeso(rs.getDouble("peso_eq"));
				vo2.setPreco(rs.getDouble("preco_eq"));
				vo2.setQuantidade(rs.getInt("quant_eq"));
				vo4.setNome(rs.getString("nome_loc"));
				vo2.setLocal(vo4);
				list.add(vo2);
				System.out.println("Id: "+rs.getInt("id_eq") + " Nome: "+rs.getString("nome_eq") +
				" Peso: "+rs.getInt("peso_eq") +" Preço: "+rs.getInt("preco_eq")+" responsavel: "+rs.getString("nome")+" local: "+rs.getString("nome_loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<EquipamentoVO> listarPoLocal(String equipamento) throws SQLException {
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.listarPorLocal(equipamento);
		List<EquipamentoVO> list = new ArrayList<EquipamentoVO>();
		try {
			while (rs.next()) {
				EquipamentoVO vo2 = new EquipamentoVO();
				FuncionarioVO vo3 = new FuncionarioVO();
				LocalVO vo4 = new LocalVO();
				vo2.setId(rs.getLong("id_eq"));
				vo2.setNome(rs.getString("nome_eq"));
				vo2.setNumeroDeSerie(rs.getString("num_serie_eq"));
				vo3.setNome(rs.getString("nome"));
				vo2.setResponsavel(vo3);
				vo2.setPeso(rs.getDouble("peso_eq"));
				vo2.setPreco(rs.getDouble("preco_eq"));
				vo2.setQuantidade(rs.getInt("quant_eq"));
				vo4.setNome(rs.getString("nome_loc"));
				vo2.setLocal(vo4);
				list.add(vo2);
				System.out.println("Id: "+rs.getInt("id_eq") + " Nome: "+rs.getString("nome_eq") +
				" Peso: "+rs.getInt("peso_eq") +" Preço: "+rs.getInt("preco_eq")+" responsavel: "+rs.getString("nome")+" local: "+rs.getString("nome_loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void remover(EquipamentoVO equipamento) throws SQLException {
		dao1.remover(equipamento);
		
	}
	public List<EquipamentoVO> listarPorNumeroSerie(EquipamentoVO equipamento) throws SQLException {
		List<EquipamentoVO> list = new ArrayList<EquipamentoVO>();
		try {
			ResultSet rs = dao1.listarPorNumeroSerie(equipamento);
			while (rs.next()) {
				EquipamentoVO vo2 = new EquipamentoVO();
				equipamento.setNome(rs.getString("num_serie_eq"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<EquipamentoVO> listarPorNumeroSerie(String equipamento) throws SQLException {
		EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.listarPorNumeroSerie(equipamento);
		List<EquipamentoVO> list = new ArrayList<EquipamentoVO>();
		try {
			while (rs.next()) {
				EquipamentoVO vo2 = new EquipamentoVO();
				FuncionarioVO vo3 = new FuncionarioVO();
				LocalVO vo4 = new LocalVO();
				vo2.setId(rs.getLong("id_eq"));
				vo2.setNome(rs.getString("nome_eq"));
				vo2.setNumeroDeSerie(rs.getString("num_serie_eq"));
				vo3.setNome(rs.getString("nome"));
				vo2.setResponsavel(vo3);
				vo2.setPeso(rs.getDouble("peso_eq"));
				vo2.setPreco(rs.getDouble("preco_eq"));
				vo2.setQuantidade(rs.getInt("quant_eq"));
				vo4.setNome(rs.getString("nome_loc"));
				vo2.setLocal(vo4);
				list.add(vo2);
				System.out.println("Id: "+rs.getInt("id_eq") + " Nome: "+rs.getString("nome_eq") +
				" Peso: "+rs.getInt("peso_eq") +" Preço: "+rs.getInt("preco_eq")+" responsavel: "+rs.getString("nome")+" local: "+rs.getString("nome_loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
