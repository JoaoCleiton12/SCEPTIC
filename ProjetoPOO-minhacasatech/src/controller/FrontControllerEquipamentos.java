package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.EquipamentoBO;
import model.vo.EquipamentoVO;
import model.vo.FuncionarioVO;
import model.vo.LocalVO;

public class FrontControllerEquipamentos implements Initializable{

  @FXML
  private TableView<EquipamentoVO> tblequipamentos;
  
  @FXML
  private TableColumn<EquipamentoVO, Long> clnid;

  @FXML
  private TableColumn<EquipamentoVO, LocalVO> clnlocal;

  @FXML
  private TableColumn<EquipamentoVO, String> clnnome;

  @FXML
  private TableColumn<EquipamentoVO, String> clnnumeroserie;

  @FXML
  private TableColumn<EquipamentoVO, Double> clnpeso;

  @FXML
  private TableColumn<EquipamentoVO, Double> clnpreco;

  @FXML
  private TableColumn<EquipamentoVO, Integer> clnquantidade;

  @FXML
  private TableColumn<EquipamentoVO, FuncionarioVO> clnresponsavel;
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    try {
      initTable();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public void initTable() throws SQLException{
    clnid.setCellValueFactory(new PropertyValueFactory("eq_id"));
    clnlocal.setCellValueFactory(new PropertyValueFactory("nome_loc"));
    clnnome.setCellValueFactory(new PropertyValueFactory("nome_eq"));
    clnnumeroserie.setCellValueFactory(new PropertyValueFactory("num_serie_eq"));
    clnpeso.setCellValueFactory(new PropertyValueFactory("peso_eq"));
    clnpreco.setCellValueFactory(new PropertyValueFactory("preco_eq"));
    clnquantidade.setCellValueFactory(new PropertyValueFactory("quant_eq"));
    clnresponsavel.setCellValueFactory(new PropertyValueFactory("nome"));
    tblequipamentos.setItems(atualizartabela());
  }
  public ObservableList<EquipamentoVO> atualizartabela() throws SQLException{
    EquipamentoBO Ebo = new EquipamentoBO();
    return FXCollections.observableArrayList(Ebo.listar());

  }
}
