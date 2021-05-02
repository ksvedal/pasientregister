package idatx.mappe2.pasientregister;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
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

  @FXML
  private Button editPatientButton;
  @FXML
  private Button removePatientButton;
  @FXML
  private Button addNewPatientButton;
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
    this.patientRegister.importPatients();

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
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setHeaderText("No patient selected");
      alert.setContentText("You need to select a patient from the list before editing");
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
        patientsTableView.getItems().removeAll(patient);
      } else {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("No patient selected");
        alert.setContentText("You need to select a patient from the list before deleting");
        alert.showAndWait();
      }
  }

  /**
   * Updates displayed observable patient list.
   */
  private void updateObservableList() {
    this.observablePatientsList.setAll(this.patientRegister.getPatients());
  }

  /**
   * Opens about/info dialog.
   */
  public void openAboutDialog(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setHeaderText("About");
    alert.setContentText("Hello this application was made by me thank");
    alert.showAndWait();
  }
}
