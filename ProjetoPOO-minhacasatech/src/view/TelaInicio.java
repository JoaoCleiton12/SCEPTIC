package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaInicio extends Application {
    public static void main(String[] args) throws Exception {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root1 = FXMLLoader.load(TelaInicio.class.getResource("VE/TelaInicio.fxml"));
        Scene cena1 = new Scene(root1);
        primaryStage.setTitle("Inicio");
        primaryStage.setScene(cena1);
        primaryStage.show();
    }
    public static void telaInicio() throws Exception {
        
        
    };
}
