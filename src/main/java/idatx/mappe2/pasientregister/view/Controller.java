package idatx.mappe2.pasientregister.view;

import idatx.mappe2.pasientregister.model.Patient;
import idatx.mappe2.pasientregister.model.PatientRegister;
import idatx.mappe2.pasientregister.view.factories.AlertFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Controller for main application. Handles all buttons and
 * the view of the patients register.
 */
public class Controller implements Initializable {

  private PatientRegister patientRegister;
  private ObservableList<Patient> observablePatientsList;
  private AlertFactory alertFactory;

  @FXML
  private Button importFromCSVButton;
  @FXML
  private Button exportToCSVButton;
  @FXML
  private javafx.scene.control.Button closeButton;
  @FXML
  private Button editPatientButton;
  @FXML
  private Button removePatientButton;
  @FXML
  private Button addNewPatientButton;
  @FXML
  private TextField importStatus;
  @FXML
  private TableView<Patient> patientsTableView;
  @FXML
  private TableColumn<Patient, String> patientFirstName;
  @FXML
  private TableColumn<Patient, String> patientLastName;
  @FXML
  private TableColumn<Patient, String> patientSocialSecurityNumber;
  @FXML
  private TableColumn<Patient, String> patientGeneralPractitioner;
  @FXML
  private TableColumn<Patient, String> patientDiagnosis;

  /**
   * Creates an instance of the Controller.
   */
  public Controller() {
    alertFactory = alertFactory.getInstance();
    patientRegister = new PatientRegister();

    this.patientsTableView = new TableView<>();
    this.patientFirstName = new TableColumn<>();
    this.patientLastName = new TableColumn<>();
    this.patientSocialSecurityNumber = new TableColumn<>();
    this.patientGeneralPractitioner = new TableColumn<>();
    this.patientDiagnosis = new TableColumn<>();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    try {
      this.patientRegister.importPatients("");
      importStatus.setText("Import successful");
    } catch (IOException e) {
      importStatus.setText("Error importing "+ e.getMessage());
    }

    //Creating columns
    this.patientFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    this.patientLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    this.patientSocialSecurityNumber.setCellValueFactory(new PropertyValueFactory<>("socialSecurityNumber"));
    this.patientGeneralPractitioner.setCellValueFactory(new PropertyValueFactory<>("generalPractitioner"));
    this.patientDiagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));

    this.observablePatientsList = FXCollections.observableArrayList(this.patientRegister.getPatients());
    this.patientsTableView.setItems(this.observablePatientsList);
  }

  /**
   * Button to import from csv.
   * Sets import status bar to reflect if import was successfull or not,
   * and shows error from the exception if it failed.
   */
  @FXML
  public void importFromCSVButton() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Import csv file.");
    FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("csv.", "*.csv");
    fileChooser.getExtensionFilters().add(extensionFilter);

    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
      String path = file.getAbsolutePath();
      try {
        patientRegister.importPatients(path);
        importStatus.setText("Import successful");
        this.updateObservableList();
      } catch (IOException e) {
        importStatus.setText("Error importing "+ e.getMessage());
      }
    }
  }

  /**
   * Button to export to csv.
   * Sets import status bar to reflect if export was successfull or not,
   * and shows error from the exception if it failed.
   */
  @FXML
  public void exportToCSVButton() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Export csv file.");
    FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("csv.", "*.csv");
    fileChooser.getExtensionFilters().add(extensionFilter);

    File file = fileChooser.showSaveDialog(null);
    if (file != null) {
      String path = file.getAbsolutePath();
      try {
        patientRegister.exportPatients(path);
      } catch (IOException e) {
        importStatus.setText("Error importing "+ e.getMessage());
      }
    }
  }

  /**
   * Button that exits the application.
   */
  @FXML
  public void closeButton() {
    App app = new App();
    app.stop();
  }

  /**
   * Button to add new patient through custom dialog.
   * Shows alert if all fields not correctly filled out.
   */
  @FXML
  public void addNewPatientButton() {
    try {
      PatientDetailsDialog pDialog = new PatientDetailsDialog();

      Optional<Patient> result = pDialog.showAndWait();

      if (result.isPresent()) {
        Patient patient = result.get();
        patientRegister.addPatient(patient);
        updateObservableList();
      }
    } catch (IOException e) {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setHeaderText("All fields must be filled out");
      alert.setContentText("Fill out all fields before adding.");
      alert.showAndWait();
    }
  }

  /**
   * Button to edit the selected patient through a custom dialog.
   * Shows alert if user has not selected a patient before pressing.
   */
  @FXML
  public void editPatientButton() {
    try {
      Patient patient = patientsTableView.getSelectionModel().getSelectedItem();
      PatientDetailsDialog pDialog = new PatientDetailsDialog(patient);
      pDialog.showAndWait();
      updateObservableList();
    } catch (NullPointerException | IOException e) {
      Alert alert = alertFactory.noPatientSelectedDialog();
      alert.showAndWait();
    }
  }

  /**
   * Button to remove selected patient.
   * Shows alert if user has not yet selected patient to delete.
   */
  @FXML
  public void removePatientButton() {
      Patient patient = patientsTableView.getSelectionModel().getSelectedItem();

      if (patientsTableView.getItems().contains(patient)) {
        Alert alert = alertFactory.confirmDeletionDialog();
        if (alert.showAndWait().get().getButtonData().isDefaultButton()) {
          patientRegister.getPatients().remove(patient);
          updateObservableList();
        }
      } else {
        Alert alert = alertFactory.noPatientSelectedDialog();
        alert.showAndWait();
      }
  }

  /**
   * Updates displayed observable patient list.
   */
  private void updateObservableList() {
    this.observablePatientsList.clear();
    this.observablePatientsList.setAll(this.patientRegister.getPatients());
  }

  /**
   * Opens about/info dialog.
   */
  public void openAboutDialog(ActionEvent event) {
    Alert alert = this.alertFactory.aboutDialog();
    alert.showAndWait();
  }
}
