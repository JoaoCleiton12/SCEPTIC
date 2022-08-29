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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.ClienteBO;
import model.bo.LocalBO;
import model.vo.ClienteVO;
import model.vo.LocalVO;
import view.Telas;

public class FrontControllerListarLocal implements Initializable{
  @FXML
  private TableColumn<LocalVO, String> clncompartimentoloc;

  @FXML
  private TableColumn<LocalVO, Long> clnid;

  @FXML
  private TableColumn<LocalVO, String> clnomeloc;

  @FXML
  private TableView<LocalVO> tblocais;
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    try {
      initTable();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public void initTable() throws SQLException{
    clnomeloc.setCellValueFactory(new PropertyValueFactory("nome"));
    clncompartimentoloc.setCellValueFactory(new PropertyValueFactory("compartimento"));
    clnid.setCellValueFactory(new PropertyValueFactory("id"));
    tblocais.setItems(atualizartabelaLocal());
  }
  public ObservableList<LocalVO> atualizartabelaLocal() throws SQLException{
    LocalBO Lbo = new LocalBO();
    return FXCollections.observableArrayList(Lbo.listar());
  }
  
  public void  cadastrar(ActionEvent Event) throws Exception {
    Telas.telaCadastroLocal();
}
public void editar(ActionEvent Event) throws Exception {
  Telas.atualizarLocal();
}
public void  excluir(ActionEvent Event) throws Exception {
  ReadOnlyObjectProperty<LocalVO> loc = tblocais.getSelectionModel().selectedItemProperty();
  LocalBO Lbo = new LocalBO();
  System.out.println(loc.getValue().getId());
	Lbo.remover(loc.getValue().getId());
	}
public void sair(ActionEvent Event) throws Exception {
  Telas.telaLogin();
}
public void inicio(ActionEvent Event) throws Exception {
Telas.telaInicio();
}
}
