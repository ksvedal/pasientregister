package idatx.mappe2.pasientregister.view;

import idatx.mappe2.pasientregister.model.Patient;
import idatx.mappe2.pasientregister.view.factories.AlertFactory;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.io.IOException;

/**
 * A dialog used for the information of a patient to either add or
 * edit a select patient.
 *
 * The dialog can be used in two different modes:
 * NEW for adding a new patient.
 * EDIT to edit a selected patient.
 *
 * @author Kristoffer Svedal
 */
public class PatientDetailsDialog extends Dialog<Patient> {
  private AlertFactory alertFactory;

  /**
   * Dialog mode. Can be opened in EDIT mode to edit selected
   * patient, or ADD mode to add a new patient.
   */
  public enum Mode {
    NEW, EDIT
  }

  /**
   * Dialog mode. NEW if new patient, EDIT if edit existing patient.
   */
  private final Mode mode;

  /**
   * Holds the patient instance if need for editing.
   */
  private Patient existingPatient = null;

  /**
   * Creates instance of patient details with the intent of adding
   * a new patient.
   * @throws IOException Throws an IOException if fields have not
   * been properly filled out.
   */
  public PatientDetailsDialog() throws IllegalArgumentException {
    super();
    this.mode = Mode.NEW;

    createContent();
  }

  /**
   * Creates an instance of patient details with the intent of
   * editing a selected patient.
   * @param patient Patient to edit.
   * @throws IOException Throws if no patient is selected.
   */
  public PatientDetailsDialog(Patient patient) throws IllegalArgumentException {
    super();
    this.mode = Mode.EDIT;
    this.existingPatient = patient;
    createContent();
  }

  /**
   * Creates the content of the dialog.
   * @throws IOException
   */
  private void createContent() throws IllegalArgumentException {
    this.alertFactory = alertFactory.getInstance();;
    setTitle("Patient details");

    getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);


    // Configure grid
    GridPane grid = new GridPane();
    grid.setHgap(50);
    grid.setVgap(5);
    grid.setPadding(new Insets(20, 20, 20, 20));

    TextField firstName = new TextField();
    TextField lastName = new TextField();
    TextField socialSecurityNumber = new TextField();
    TextField generalPractitioner = new TextField();
    TextField diagnosis = new TextField();

    // If mode is edit: Set values of textfields to that of selected patient.
    if (mode == Mode.EDIT) {
      firstName.setText(existingPatient.getFirstName());
      lastName.setText(existingPatient.getLastName());
      socialSecurityNumber.setText(existingPatient.getSocialSecurityNumber());
      generalPractitioner.setText(existingPatient.getGeneralPractitioner());
      diagnosis.setText(existingPatient.getDiagnosis());
    }

    // Add labels to identify the text fields.
    grid.add(new Label("First name:"), 0, 0);
    grid.add(new Label("Last name:"), 0, 1);
    grid.add(new Label("Social Security number:"), 0, 2);
    grid.add(new Label("General Practitioner:"), 0, 3);
    grid.add(new Label("Diagnosis:"), 0, 4);

    // Add the text fields themselves.
    grid.add(firstName, 1, 0);
    grid.add(lastName, 1,1);
    grid.add(socialSecurityNumber, 1, 2);
    grid.add(generalPractitioner, 1, 3);
    grid.add(diagnosis, 1, 4);

    getDialogPane().setContent(grid);
    getDialogPane().getStyleClass().add("customDialog");
    getDialogPane().getStylesheets().add("patientregister.css");

    // Converts the result to patient instance when ok is pressed.
    setResultConverter(new Callback<ButtonType, Patient>() {
      @Override
      public Patient call(ButtonType buttonType) {
        Patient result = null;
        try {
          if (buttonType == ButtonType.OK) {
            if (mode == Mode.NEW)
              result = new Patient(firstName.getText(),
                  lastName.getText(),
                  generalPractitioner.getText(),
                  socialSecurityNumber.getText(),
                  diagnosis.getText());
          } else if (mode == Mode.EDIT) {
            existingPatient.setFirstName(firstName.getText());
            existingPatient.setLastName(lastName.getText());
            existingPatient.setGeneralPractitioner(generalPractitioner.getText());
            existingPatient.setSocialSecurityNumber(socialSecurityNumber.getText());
            existingPatient.setDiagnosis(diagnosis.getText());
            result = existingPatient;
          }
        } catch (IllegalArgumentException e) {
          Alert alert = alertFactory.fieldNotFilled(e.getMessage());
          alert.showAndWait();
        }
        return result;
      }
    });
  }
}
