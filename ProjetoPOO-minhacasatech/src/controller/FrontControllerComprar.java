package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.bo.ClienteBO;
import model.bo.CompraBO;
import model.bo.EquipamentoBO;
import model.vo.ClienteVO;
import model.vo.CompraVO;
import model.vo.EquipamentoVO;
import view.Telas;

public class FrontControllerComprar implements Initializable{
  private List<ClienteVO> cli = new ArrayList<ClienteVO>();
  private List<EquipamentoVO> eq = new ArrayList<EquipamentoVO>();
  @FXML
  private ComboBox<ClienteVO> cbbcliente;

  @FXML
  private ComboBox<EquipamentoVO> cbbequipamento;

  @FXML
  private TextField descriprodcompra;

  @FXML
  private Button enviarcadastrocli;

  @FXML
  private TextField quantiprodcompra;

  @FXML
  private TextField valortotalprodcompra;

  @FXML
  private TextField valoruniprodcompra;

  public void cadastrarcompra(ActionEvent casdastrarcompra) throws Exception {
    CompraVO Com = new CompraVO();
    CompraBO Cbo = new CompraBO();
    EquipamentoVO Evo = new EquipamentoVO();
    ClienteVO Cvo = new ClienteVO();
    Evo.setId(cbbequipamento.getSelectionModel().getSelectedItem().getId());
    Cvo.setId(cbbcliente.getSelectionModel().getSelectedItem().getId());
    Com.setDescricao(descriprodcompra.getText());
    Com.setEquipamento(Evo);
    Com.setCliente(Cvo);
    Com.setPreco(Double.parseDouble(valortotalprodcompra.getText()));
    Com.setQuantidade(Long.parseLong(quantiprodcompra.getText()));
    Cbo.inserir(Com);
    // System.out.println(cbbcliente.getSelectionModel().getSelectedItem().getId());
    // System.out.println(cbbequipamento.getSelectionModel().getSelectedItem().getId());
  }
  public void carregarclientes() throws SQLException{
    ClienteBO Cbo= new ClienteBO();
    cbbcliente.setItems(FXCollections.observableArrayList(Cbo.listar()));
    System.out.println("cbbcliente.getId()");
  }
  public void carregarequipamentos() throws SQLException{
    EquipamentoBO Ebo= new EquipamentoBO();
    cbbequipamento.setItems(FXCollections.observableArrayList(Ebo.listar()));
  }
  public void sair(ActionEvent Event) throws Exception {
    Telas.telaLogin();
}
public void inicio(ActionEvent Event) throws Exception {
  Telas.telaInicio();
}
@Override
public void initialize(URL location, ResourceBundle resources) {
  try {
    carregarclientes();
    carregarequipamentos();
  } catch (SQLException e) {
    e.printStackTrace();
  }
}
}
