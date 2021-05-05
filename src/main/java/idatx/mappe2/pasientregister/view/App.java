package idatx.mappe2.pasientregister.view;

import idatx.mappe2.pasientregister.model.Patient;
import idatx.mappe2.pasientregister.model.PatientRegister;
import idatx.mappe2.pasientregister.view.factories.UIFactory;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Sets up main scene.
 */
public class App extends Application {
  private PatientRegister patientRegister;
  private ObservableList<Patient> observablePatientsList;
  private UIFactory uiFactory;

  @Override
  public void start(Stage stage) throws Exception {
    URL url = getClass().getClassLoader().getResource("application.fxml");
    Parent root = FXMLLoader.load(url);
    Scene scene = new Scene(root);

    stage.setTitle("Pasientregister");
    scene.getStylesheets().add("patientregister.css");
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
