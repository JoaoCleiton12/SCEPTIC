package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.FuncionarioBO;
import model.vo.FuncionarioVO;
import view.Telas;

public class FrontControllerListarFuncionario implements Initializable{
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    try {
      initTable();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  @FXML
  private Button btnCadastro;

  @FXML
  private Button btnEditar;

  @FXML
  private Button btnExcluir;

  @FXML
  private Button btnInicio;

  @FXML
  private Button btnSair;

  @FXML
  private TableColumn<FuncionarioVO, String> clnemail;

  @FXML
  private TableColumn<FuncionarioVO, String> clnendereco;

  @FXML
  private TableColumn<FuncionarioVO, String> clnnome;

  @FXML
  private TableColumn<FuncionarioVO, String> clntelefone;

  @FXML
  private TableColumn<FuncionarioVO, Long> clnid;
  
  @FXML
  private TableColumn<FuncionarioVO, Integer> clntipo;

  @FXML
  private TableView<FuncionarioVO> tblresponsaveis;

  public void initTable() throws SQLException{
    clnemail.setCellValueFactory(new PropertyValueFactory<>("email"));
    clnendereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
    clnnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    clntelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
    clnid.setCellValueFactory(new PropertyValueFactory<>("id"));
    clntipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    FuncionarioBO Fbo = new FuncionarioBO();
    tblresponsaveis.setItems(FXCollections.observableArrayList(Fbo.listar()));
  }
  @FXML
  void cadastrar(ActionEvent event) throws Exception {
    Telas.telaCadastroFuncionario();
  }

  @FXML
  void editar(ActionEvent event) throws Exception {
    Telas.atualizarFuncionario();
  }

  @FXML
  void excluir(ActionEvent event) throws SQLException {
    ReadOnlyObjectProperty<FuncionarioVO> equi = tblresponsaveis.getSelectionModel().selectedItemProperty();
    FuncionarioBO Ebo = new FuncionarioBO();
  System.out.println(equi.getValue().getId());
	Ebo.remover(equi.getValue().getId());
  }

  @FXML
  void inicio(ActionEvent event) throws Exception {
    Telas.telaInicio();
  }

  @FXML
  void sair(ActionEvent event) throws Exception {
    Telas.telaLogin();
  }

  
}
