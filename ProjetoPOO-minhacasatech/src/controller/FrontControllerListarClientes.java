package controller;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.ClienteBO;
import model.bo.EquipamentoBO;
import model.vo.ClienteVO;
import model.vo.EquipamentoVO;
import model.vo.LocalVO;
import model.vo.PessoaVO;
import view.Telas;

public class FrontControllerListarClientes implements Initializable{
  
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
  private TableColumn<ClienteVO,Long> clnid;
  @FXML
  private TableColumn<ClienteVO,String> clnnome;
  @FXML
  private TableColumn<ClienteVO,String> clnendereco;
  @FXML
  private TableColumn<ClienteVO,PessoaVO> clncpf;
  @FXML
  private Label seletcless;

  public void initTable() throws SQLException{
    clnid.setCellValueFactory(new PropertyValueFactory<>("id"));
    clnnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    clnendereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
    clncpf.setCellValueFactory(new PropertyValueFactory<>("CPF"));
    ClienteBO Cbo = new ClienteBO();
    tblclientes.setItems(FXCollections.observableArrayList(Cbo.listar()));
  }
  public void  cadastrar(ActionEvent Event) throws Exception {
    Telas.telaCadastroCliente();
}
public void editar(ActionEvent Event) throws Exception {
  Telas.telaAtualizarCliente();
}
public void  excluir(ActionEvent Event) throws Exception {
  ReadOnlyObjectProperty<ClienteVO> cli = tblclientes.getSelectionModel().selectedItemProperty();
  ClienteBO Cbo = new ClienteBO();
  System.out.println(cli.getValue().getId());
	Cbo.remover(cli.getValue().getId());
	}
public void sair(ActionEvent Event) throws Exception {
  Telas.telaLogin();
}
public void inicio(ActionEvent Event) throws Exception {
Telas.telaInicio();
}
}