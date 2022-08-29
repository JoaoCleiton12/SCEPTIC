package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaEquipamento extends Application{
    public static void main(String[] args) throws Exception{
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("VE/TelaEquipamento.fxml"));

        Scene cena2 = new Scene(root2);

        primaryStage.setTitle("Buscar");
        primaryStage.setScene(cena2);
        primaryStage.show();
        
        
    }
    
}
