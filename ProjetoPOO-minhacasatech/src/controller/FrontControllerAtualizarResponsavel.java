package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.bo.FuncionarioBO;
import model.vo.FuncionarioVO;
import view.Telas;

public class FrontControllerAtualizarResponsavel implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            listarFuncinario();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    @FXML
    private TextArea telefoneatuarespon;
    @FXML
    private TextArea endeatuarepon;

    @FXML
    private TextField nomeatuarespom;
    @FXML
    private ComboBox<FuncionarioVO> atuarespon;
    public void listarFuncinario() throws Exception {
        FuncionarioVO func = new FuncionarioVO();
        FuncionarioBO Fbo= new FuncionarioBO();
        atuarespon.setItems(FXCollections.observableArrayList(Fbo.listar()));
        System.out.println(Fbo.listar());
    }
    @FXML
    void sair(ActionEvent event) throws Exception {
        Telas.telaLogin();
    }

    @FXML
    void inicio(ActionEvent event) throws Exception {
        Telas.telaInicio();
    }
    @FXML
    void voltar(ActionEvent event) throws Exception {
        Telas.telaListarFuncionario();
    }

    @FXML
    void atualizar(ActionEvent event) throws SQLException{
        atuarespon.getSelectionModel().getSelectedItem().getId();
        FuncionarioBO func = new FuncionarioBO<>();
        System.out.println(atuarespon.getSelectionModel().getSelectedItem().getId());
        FuncionarioVO FUNC = new FuncionarioVO();
        FUNC.setId(atuarespon.getSelectionModel().getSelectedItem().getId());
        FUNC.setNome(nomeatuarespom.getText());
        FUNC.setEndereco(endeatuarepon.getText());
        FUNC.setTelefone(telefoneatuarespon.getText());
        func.alterar(FUNC);
    }
}
