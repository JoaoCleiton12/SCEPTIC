package view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Telas extends Application{
  private static Stage primaryStage;

  public static Stage getPrimaryStage() {
    return primaryStage;
  }

  public static void setPrimaryStage(Stage primaryStage) {
    Telas.primaryStage = primaryStage;
  }
  public static void main(String[] args){
    launch();
  }
  public void start(Stage primaryStage) throws Exception {
    setPrimaryStage(primaryStage);
    primaryStage.setTitle("SCEPTIC");
    primaryStage.show();
    //telaLogin();
    telaInicio();
    //telaCadastroEquipamento();
    //telaCadastroLocal();
    //telaCadastroFuncionario();
    //telaCadastroCliente();
    //telaListarCliente();
    //telaListarEquipamento();
    //telaListarLocal();
    //telaListarCompra();
    //atualizarLocal();
    //telaListarFuncionario();
  }

  public static void telaLogin() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaDeLogin.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  }
  public static void telaInicio() throws Exception {
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaInicio.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  };
  public static void telaEquipamento() throws Exception {
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaEquipamento.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  };
  public static void telaCadastroEquipamento() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/CadastroEquipamento.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  } 
  public static void telaCadastroLocal() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/CadastroLocal.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  } 
  public static void telaCadastroFuncionario() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/CadastroResponsavel.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  } 
  public static void telaCadastroCliente() throws Exception{
    
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/CadastroCliente.fxml"));
    Scene cena = new Scene(root);
    
    primaryStage.setScene(cena);
  } 
  public static void telaListarCliente() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCliente.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  } 
  public static void telaListarEquipamento() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaEquipamento.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  } 
  public static void telaListarFuncionario() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaResponsavel.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  } 
  public static void telaListarLocal() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaLocal.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  }
  public static void telaListarCompra() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCompra.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  }
  public static void telaListarResponsaveis() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaResponsavel.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  }
  public static void telaRelatorio() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaRelatorioVendas.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  }
  public static void telaAtualizarCliente() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/AtualizarCliente.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  }
  public static void atualizarFuncionario() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/AtualizarResponsavel.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  }
  public static void atualizarLocal() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/AtualizarLocal.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  }
  public static void atualizarEquipamento() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/AtualizarEquipamento.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  }
  
}
