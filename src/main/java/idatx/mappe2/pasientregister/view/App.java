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

 /**
  @Override
  public void start(Stage primaryStage) throws Exception {
    patientRegister = new PatientRegister();
    uiFactory = uiFactory.getInstance();

    try {
      this.patientRegister.importPatients("");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    this.observablePatientsList = FXCollections.observableArrayList(this.patientRegister.getPatients());

    BorderPane root = new BorderPane();
    VBox topContainer = new VBox();

    MenuBar menuBar = uiFactory.createMenuBar();
    GridPane buttonPane = uiFactory.createButtons();
    TableView tableView = uiFactory.createTableView(this.observablePatientsList);

    topContainer.getChildren().add(menuBar);

    GridPane menusGrid = new GridPane();
    root.setTop(menusGrid);

    menusGrid.add(menuBar, 0, 0);
    menusGrid.add(buttonPane, 0, 1);

    root.setCenter(tableView);

    Scene scene = new Scene(root);

    primaryStage.setTitle("Pasientregister");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  **/
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
