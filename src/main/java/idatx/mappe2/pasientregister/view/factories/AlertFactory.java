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

  /**
   * Creates an instance of AlertFactory. Constructor private to follow singleton pattern.
   */
  private AlertFactory() {}

  /**
   * Returns the instance of AlertFactory that will only be set once.
   * @return Return the instance of AlertFactory.
   */
  public static AlertFactory getInstance() {
    if (instance == null) {
      instance = new AlertFactory();
    }
    return instance;
  }

  /**
   * Creates a dialog that prompts the user to select a patient from the list before performing
   * an action.
   * @return the no patients selected warning Alert.
   */
  public Alert noPatientSelectedDialog() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setHeaderText("No patient selected");
    alert.setContentText("You need to select a patient from the list first!\n");

    //Styling
    DialogPane dialogPane = alert.getDialogPane();
    dialogPane.getStylesheets().add("patientregister.css");
    dialogPane.getStyleClass().add("customDialog");
    return alert;
  }

  /**
   * Creates a dialog with information about the application and who made it.
   * @return the about information Alert.
   */
  public Alert aboutDialog() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setHeaderText("About");
    alert.setContentText("Hello! This application was made by Kristoffer. Thank you ");

    //Styling
    DialogPane dialogPane = alert.getDialogPane();
    dialogPane.getStylesheets().add("patientregister.css");
    dialogPane.getStyleClass().add("customDialog");
    return alert;
  }

  /**
   * Creates a dialog that asks if the user is sure about deletion.
   * @return the confirm deletion confirmation Alert.
   */
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

  /**
   * Creates a dialog that warns the user about an empty field that cant be empty.
   * @param message the message of the exception thrown by the set-method of the
   *                corresponding field..
   * @return the field not filled error Alert.
   */
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