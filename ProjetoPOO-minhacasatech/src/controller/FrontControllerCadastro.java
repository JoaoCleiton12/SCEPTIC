package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.bo.ClienteBO;
import model.bo.EquipamentoBO;
import model.bo.FuncionarioBO;
import model.bo.LocalBO;
import model.vo.ClienteVO;
import model.vo.EquipamentoVO;
import model.vo.FuncionarioVO;
import model.vo.LocalVO;
import view.Telas;

public class FrontControllerCadastro{
  public int valor = 2;
  private ObservableList<String> list = FXCollections.observableArrayList("Funcionário", "Gerente");
  @FXML
  private TextField nome;
  @FXML
  private TextArea quantestoque;
  @FXML
  private TextField preco;
  @FXML
  private TextField peso;
  @FXML
  private TextField numserie;
  @FXML
  private TextArea idresponsavel;
  @FXML
  private TextArea idlocal;
  // public void initialize(URL url, ResourceBundle rb) {
  //   tipoFuncionario();
  // }
  // public void tipoFuncionario(){
  //  tipo.setValue("Funcionário");
  //  tipo.setItems(list);
  // }
  public void casdastrarEquipamento(ActionEvent casdastrarEquipamento) throws Exception {
    EquipamentoVO Eq = new EquipamentoVO();
    Eq.setNome(nome.getText());
    Eq.setQuantidade(Integer.parseInt(quantestoque.getText()));
    Eq.setPeso(Double.parseDouble(peso.getText()));
    Eq.setPreco(Integer.parseInt(preco.getText()));
    Eq.setNumeroDeSerie(numserie.getText());
    FuncionarioVO Fun = new FuncionarioVO();
    LocalVO Lo = new LocalVO();
    Fun.setId(Long.parseLong(idresponsavel.getText()));
    Eq.setResponsavel(Fun);
    Lo.setId(Long.parseLong(idlocal.getText()));
    Eq.setLocal(Lo);
    EquipamentoBO Ebo = new EquipamentoBO();
    Ebo.inserir(Eq);
  }

  @FXML
  private TextArea localcadasloc;
  @FXML
  private TextArea compartimentocadasloc;

  public void casdastrarLocal(ActionEvent casdastrarLocal) throws Exception {
    LocalVO Loc = new LocalVO();
    Loc.setNome(localcadasloc.getText());
    Loc.setCompartimento(compartimentocadasloc.getText());
    LocalBO Lbo = new LocalBO();
    Lbo.inserir(Loc);
  }

  @FXML
  private TextArea endecadasrepon;
  @FXML
  private TextField nomecadasrespom;
  @FXML
  private TextField senhacadasrespon;
  // @FXML
  // private ComboBox<String> tipo;
  @FXML
  private TextField email;
  @FXML
  private TextField telefone;
  @FXML
  private TextField tipo;

  // @FXML
  // public void select(ActionEvent event) {
  //   String s = tipo.getSelectionModel().getSelectedItem().toString();
  //   System.out.println(s);
  //   if (s.equals("Funcionário")) {
  //     valor = 0;
  //   } else {
  //     valor = 1;
  //   }
  // }

  public void casdastrarFuncionario(ActionEvent casdastrarFuncionario) throws Exception {
    FuncionarioVO Fun = new FuncionarioVO();
    FuncionarioBO Fbo = new FuncionarioBO();
    Fun.setEmail(email.getText());
    Fun.setEndereco(endecadasrepon.getText());
    Fun.setSenha(senhacadasrespon.getText());
    Fun.setTipo(Integer.parseInt(tipo.getText()));
    Fun.setNome(nomecadasrespom.getText());
    Fun.setTelefone(telefone.getText());
    System.out.println(Fun.toString());
    Fbo.inserir(Fun);
  }

  @FXML
  private TextField nomecadascli;
  @FXML
  private TextField cpfcadascli;
  @FXML
  private TextArea enderecocadascli;
  @FXML
  private TextArea telefonecli;
  public void casdastrarCliente(ActionEvent casdastrarCliente) throws Exception {
    ClienteVO Cli = new ClienteVO();
    ClienteBO Cbo = new ClienteBO();
    Cli.setCPF(cpfcadascli.getText());
    Cli.setEndereco(enderecocadascli.getText());
    Cli.setNome(nomecadascli.getText());
    Cli.setTelefone(telefonecli.getText());
    Cbo.inserir(Cli);
  }
  public void sair(ActionEvent Event) throws Exception {
    Telas.telaLogin();
}
public void inicio(ActionEvent Event) throws Exception {
  Telas.telaInicio();
}
public void voltarlocal(ActionEvent Event) throws Exception {
  Telas.telaListarLocal();
}
public void voltarcliente(ActionEvent Event) throws Exception {
  Telas.telaListarCliente();
}
@FXML
public void voltarresponsavel(ActionEvent event) throws Exception {
  Telas.telaListarResponsaveis();
    }
    @FXML
    void voltarequipamento(ActionEvent event) throws Exception {
      Telas.telaListarEquipamento();
    }
}
