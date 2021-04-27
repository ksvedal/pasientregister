package idatx.mappe2.pasientregister;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for main application.
 */
public class Controller implements Initializable {
  private PatientRegister patientRegister;
  private ObservableList<Patient> observablePatientsList;

  @FXML
  private TableView<Patient> patientsTableView;
  @FXML
  private TableColumn<Patient, String> patientFirstName;
  @FXML
  private TableColumn<Patient, String> paientLastName;
  @FXML
  private TableColumn<Patient, Integer> patientSocialSecurityNumber;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    patientRegister = new PatientRegister();
    patientRegister.fillWithPatients();

    //Creating columns
    this.patientFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    this.paientLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    this.patientSocialSecurityNumber.setCellValueFactory(new PropertyValueFactory<>("socialSecurityNumber"));

    this.observablePatientsList = FXCollections.observableArrayList(this.patientRegister.getPatients());
    this.patientsTableView.setItems(this.observablePatientsList);
  }

  /**
   * Updates displayed patient list.
   */
  private void updateObservableList() {
    this.observablePatientsList.setAll(this.patientRegister.getPatients());
  }

  /**
   * Add person button
   */
  @FXML
  public void addPerson(ActionEvent event) {
    this.patientRegister.addPatient(new Patient(123, "ads", "sad", "dsa", "sda"));
    this.updateObservableList();
  }
}
