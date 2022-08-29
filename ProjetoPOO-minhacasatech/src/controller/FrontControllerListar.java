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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.ClienteBO;
import model.vo.ClienteVO;
import view.Telas;

public class FrontControllerListar implements Initializable{

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    try {
      initTable();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  @FXML
  private TableView<ClienteVO> tblclientes;
  @FXML
  private TableColumn<ClienteVO,String> clnnome;
  @FXML
  private TableColumn<ClienteVO,String> clnendereco;
  @FXML
  private TableColumn<ClienteVO,String> clncpf;
  @FXML
  private Button sair;
  
  public void initTable() throws SQLException{
    List<ClienteVO> clientes = new ArrayList<>();
    clnnome.setCellValueFactory(new PropertyValueFactory("nome"));
    clnendereco.setCellValueFactory(new PropertyValueFactory("endereco"));
    clncpf.setCellValueFactory(new PropertyValueFactory("CPF"));
    ClienteBO Cbo = new ClienteBO();
    clientes = Cbo.listar();
    tblclientes.setItems(FXCollections.observableArrayList(clientes));
  }
}
