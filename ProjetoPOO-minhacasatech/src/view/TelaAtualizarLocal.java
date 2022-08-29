package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaAtualizarLocal extends Application{
public static void main(String[] args) throws Exception{
    launch();
}
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("VE/AtualizarLocal.fxml"));

       Scene cena2 = new Scene(root2);

       primaryStage.setTitle("Atualizar");
       primaryStage.setScene(cena2);
       primaryStage.show();
        
    }
    
}
