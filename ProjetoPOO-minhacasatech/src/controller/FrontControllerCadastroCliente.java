package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.bo.ClienteBO;
import model.vo.ClienteVO;
import view.Telas;

public class FrontControllerCadastroCliente {
  
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
public void voltarcliente(ActionEvent Event) throws Exception {
  Telas.telaListarCliente();
}
}
