package idatx.mappe2.pasientregister.view.factories;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;

/**
 * Class responsible for creating alert dialogs to show the user and apply
 * stylesheet to them.
 * Also a response to task 3 along with UIFactory.
 */
public class AlertFactory {
  private static AlertFactory instance;

  private AlertFactory() {}

  public static AlertFactory getInstance() {
    if (instance == null) {
      instance = new AlertFactory();
    }
    return instance;
  }

  public Alert noPatientSelectedDialog() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setHeaderText("No patient selected");
    alert.setContentText("You need to select a patient from the list first!");

    //Styling
    DialogPane dialogPane = alert.getDialogPane();
    dialogPane.getStylesheets().add("patientregister.css");
    dialogPane.getStyleClass().add("customDialog");
    return alert;
  }

  public Alert aboutDialog() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setHeaderText("About");
    alert.setContentText("Hello this application was made by kristoffer thank you");

    //Styling
    DialogPane dialogPane = alert.getDialogPane();
    dialogPane.getStylesheets().add("patientregister.css");
    dialogPane.getStyleClass().add("customDialog");
    return alert;
  }

  public Alert confirmDeletionDialog() {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setHeaderText("Are you sure?");
    alert.setContentText("Are you sure you want to delete this patient?");

    //Styling
    DialogPane dialogPane = alert.getDialogPane();
    dialogPane.getStylesheets().add("patientregister.css");
    dialogPane.getStyleClass().add("customDialog");
    return alert;
  }

  public Alert fieldNotFilled(String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setHeaderText("Insufficient input.");
    alert.setContentText(message);

    //Styling
    DialogPane dialogPane = alert.getDialogPane();
    dialogPane.getStylesheets().add("patientregister.css");
    dialogPane.getStyleClass().add("customDialog");
    return alert;
  }
}