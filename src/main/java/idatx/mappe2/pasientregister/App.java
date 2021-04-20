package idatx.mappe2.pasientregister;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class App extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    URL url = getClass().getClassLoader()
        .getResource("application.fxml");

    Parent root = FXMLLoader.load(url);

    Scene scene = new Scene(root);

    stage.setTitle("Pasientregister");
    stage.setScene(scene);
    stage.show();
  }
}
