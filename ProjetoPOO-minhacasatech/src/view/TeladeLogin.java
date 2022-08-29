package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TeladeLogin extends Application {

	public static void main(String[] args) throws Exception {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("VE/TelaDeLogin.fxml"));

		Scene cena = new Scene(root);

		primaryStage.setTitle("Projeto SCEPTIC");
		primaryStage.setScene(cena);
		primaryStage.show();
	}
}
