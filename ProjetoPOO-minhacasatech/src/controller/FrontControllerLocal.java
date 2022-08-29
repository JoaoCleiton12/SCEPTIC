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
import model.bo.LocalBO;
import model.vo.LocalVO;
import view.Telas;

public class FrontControllerLocal implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            listarLocal();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    @FXML
    private TextArea localatualoc;
    @FXML
    private TextArea compartimentoatualoc;
    @FXML
    private ComboBox<LocalVO> localatua;
    public void listarLocal() throws Exception {
        LocalVO loc2 = new LocalVO();
        LocalBO Lbo= new LocalBO();
        localatua.setItems(FXCollections.observableArrayList(Lbo.listar()));
        System.out.println(Lbo.listar());
        
        // LocalVO Loc = new LocalVO();
        // Loc.setNome(localatualoc.getText());
        // Loc.setCompartimento(compartimentoatualoc.getText());
        // LocalBO Lbo = new LocalBO();
        // Lbo.alterar(Loc);
    }
    @FXML

    void atualizar(ActionEvent event) throws SQLException {
        localatua.getSelectionModel().getSelectedItem().getId();
        LocalBO loc = new LocalBO();
        System.out.println(localatua.getSelectionModel().getSelectedItem().getId());
        LocalVO LOC = new LocalVO();
        LOC.setId(localatua.getSelectionModel().getSelectedItem().getId());
        LOC.setNome(localatualoc.getText());
        LOC.setCompartimento(compartimentoatualoc.getText());
        loc.alterar(LOC);
    }

    public void sair(ActionEvent Event) throws Exception {
        Telas.telaLogin();
      }
      public void inicio(ActionEvent Event) throws Exception {
      Telas.telaInicio();
      }
     
}
