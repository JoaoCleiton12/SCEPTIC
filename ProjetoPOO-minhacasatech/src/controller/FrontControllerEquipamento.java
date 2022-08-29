package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.text.html.parser.Parser;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.bo.EquipamentoBO;
import model.bo.FuncionarioBO;
import model.vo.EquipamentoVO;
import model.vo.FuncionarioVO;
import model.vo.LocalVO;
import view.Telas;

public class FrontControllerEquipamento implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            listarEquipamento();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @FXML
    private TextField nomeatuaequi;
    @FXML
    private TextField precoatuaequi;
    @FXML
    private TextArea quantestoqueatuaequi;
    @FXML 
    private TextArea identiresponatuaequi;
    @FXML
    private TextField localatuaequi;
    @FXML 
    private ComboBox<EquipamentoVO> equiatua;
    public void listarEquipamento() throws Exception {
        EquipamentoVO equi = new EquipamentoVO();
        EquipamentoBO EQUI = new EquipamentoBO();
        equiatua.setItems(FXCollections.observableArrayList(EQUI.listar()));
        // EquipamentoVO Eq = new EquipamentoVO();
        // Eq.setNome(nomeatuaequi.getText());
        // Eq.setPreco(Integer.parseInt(precoatuaequi.getText()));
        //Eq.setQuantidade(Integer.parseInt(quantestoqueatuaequi.getText())

        // FuncionarioVO Fun = new FuncionarioVO();

        // Fun.setId(Long.parseLong(identiresponatuaequi.getText()));
        // Eq.setResponsavel(Fun);
        // LocalVO Lo = new LocalVO();

        // Lo.setId(Long.parseLong(idlocalatuaequi.getText()));
        // Eq.setLocal(Lo);

        // EquipamentoBO Ebo = new EquipamentoBO();
        // Ebo.alterar(Eq);
    }
    @FXML
    void atualizar(ActionEvent event) throws SQLException {
        equiatua.getSelectionModel().getSelectedItem().getId();
        EquipamentoBO equi = new EquipamentoBO();
        System.out.println(equiatua.getSelectionModel().getSelectedItem().getId());
        EquipamentoVO EQUI = new EquipamentoVO();
        EQUI.setId(equiatua.getSelectionModel().getSelectedItem().getId());
        EQUI.setNome(nomeatuaequi.getText());
        EQUI.setPreco(Double.parseDouble(precoatuaequi.getText()));
        
        EQUI.setQuantidade(Integer.parseInt(quantestoqueatuaequi.getText()));
        System.out.println(identiresponatuaequi.getText());
        FuncionarioVO func = new FuncionarioVO();
        func.setId(Long.parseLong(identiresponatuaequi.getText()));
        LocalVO loc = new LocalVO();
        System.out.println(localatuaequi.getText());
        loc.setId(Long.parseLong(localatuaequi.getText()));
        
        EQUI.setLocal(loc);
        EQUI.setResponsavel(func);
        equi.alterar(EQUI);
    }
    public void sair(ActionEvent Event) throws Exception {
        Telas.telaLogin();
      }
      public void inicio(ActionEvent Event) throws Exception {
      Telas.telaInicio();
      }
}
