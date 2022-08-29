package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.CompraBO;
import model.vo.CompraVO;
import view.Telas;

public class FrontControllerListarCompra implements Initializable{
    @FXML
    private TableColumn<CompraVO, String> data;

    @FXML
    private TableColumn<CompraVO, String> nome;

    @FXML
    private TableColumn<CompraVO, Double> peso;

    @FXML
    private TableColumn<CompraVO, Double> preco;
    @FXML
    private TableColumn<CompraVO, Double> preco2;

    @FXML
    private TableColumn<CompraVO, Long> quantidade;

    @FXML
    private TableView<CompraVO> relatoriodevendas;

    @FXML
    private TableColumn<CompraVO, String> serie;
    @FXML
    private TableColumn<CompraVO, Long> id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      try {
        initTable();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    }
    public void initTable() throws SQLException {
      data.setCellValueFactory(new PropertyValueFactory<>("dataCompra"));
      nome.setCellValueFactory(new PropertyValueFactory<>("equipamentoNome"));
      peso.setCellValueFactory(new PropertyValueFactory<>("EquipamentoPeso"));
      preco.setCellValueFactory(new PropertyValueFactory<>("equipamentopreco"));
      quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
      serie.setCellValueFactory(new PropertyValueFactory<>("equipamentoSerie"));
      preco2.setCellValueFactory(new PropertyValueFactory<>("preco"));
      id.setCellValueFactory(new PropertyValueFactory<>("id"));
      CompraBO Cbo = new CompraBO();
      System.out.println(Cbo.listar());
      relatoriodevendas.setItems(FXCollections.observableArrayList(Cbo.listar()));
    
    }
    public void  cadastrar(ActionEvent Event) throws Exception {
      Telas.telaCadastroEquipamento();
  }
  public void editar(ActionEvent Event) throws Exception {
    Telas.telaCadastroEquipamento();
  }
  public void  excluir(ActionEvent Event) throws Exception {
    ReadOnlyObjectProperty<CompraVO> comp = relatoriodevendas.getSelectionModel().selectedItemProperty();
    CompraBO Cbo = new CompraBO();
    System.out.println(comp.getValue().getId());
    Cbo.remover(comp.getValue().getId());
  }
    public void sair(ActionEvent Event) throws Exception {
      Telas.telaLogin();
    }
    public void inicio(ActionEvent Event) throws Exception {
    Telas.telaInicio();
    }
}
