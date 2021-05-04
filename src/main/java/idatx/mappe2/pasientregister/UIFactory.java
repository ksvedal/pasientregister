package idatx.mappe2.pasientregister;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

/**
 * Is responsible for creating elements of the user interface of the application.
 *
 * This class is not in use as i do not need it when using fxml for my main window,
 * but i made this to show a UI factory.
 */
public class UIFactory {
  private static UIFactory instance;

  /**
   * Creates an instance of UIFactory.
   */
  private UIFactory() {}

  /**
   * Returns the instance of the UIFactory
   * Will only be set once (singleton pattern).
   * @return Return the instance of UIFactory
   */
  public static UIFactory getInstance() {
    if (instance == null) {
      instance = new UIFactory();
    }
    return instance;
  }

  /**
   * Creates the menu bar for the application.
   * @return Return created menu bar.
   */
  public MenuBar createMenuBar() {
    MenuBar menuBar = new MenuBar();

    Menu menuFile = new Menu("File");
    MenuItem importCSV = new MenuItem("Import from csv");
    MenuItem exportCSV = new MenuItem("Export to csv");
    MenuItem exitApp = new MenuItem("Exit");
    menuFile.getItems().addAll(importCSV, exportCSV, exitApp);

    Menu menuEdit = new Menu("Edit");
    MenuItem addPatient = new MenuItem("Add patient");
    MenuItem removePatient = new MenuItem("Remove patient");
    MenuItem editPatient = new MenuItem("Edit patient");
    menuEdit.getItems().addAll(addPatient, removePatient, editPatient);

    Menu menuHelp = new Menu("Help");
    MenuItem about = new MenuItem("About");
    menuHelp.getItems().addAll(about);
    menuBar.getMenus().addAll(menuFile, menuEdit, menuHelp);

    return menuBar;
  }

  /**
   * Creates a grid pane of three buttons for the user interface.
   * Add patient, Remove patient, Edit patient.
   * @return Returns a horizontal gridpane of three buttons.
   */
  public GridPane createButtons() {
    GridPane buttonPane = new GridPane();
    buttonPane.setHgap(10);
    buttonPane.setVgap(10);
    buttonPane.setPadding(new Insets(10, 10, 10, 10));
    Button addPatientButton = new Button("Add patient");
    Button removePatientButton = new Button("Remove patient");
    Button editPatientButton = new Button("Edit patient");
    buttonPane.add(addPatientButton, 0, 0);
    buttonPane.add(removePatientButton, 1, 0);
    buttonPane.add(editPatientButton, 2, 0);

    return buttonPane;
  }

  /**
   * Creates a tableview of the patient list.
   * @param patientOList Observable list of patients that tableview will be created with.
   * @return Return a tableview of the patient list.
   */
  public TableView createTableView(ObservableList patientOList) {
    TableView tableView = new TableView();
    TableColumn<Patient, String> firstNameColumn = new TableColumn<>("First Name");
    firstNameColumn.setMaxWidth(300);
    firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

    TableColumn<Patient, String> lastNameColumn = new TableColumn<>("Last Name");
    lastNameColumn.setMaxWidth(300);
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

    TableColumn<Patient, String> socialSecurityNumberColumn = new TableColumn<>("SSN");
    socialSecurityNumberColumn.setMaxWidth(300);
    socialSecurityNumberColumn.setCellValueFactory(new PropertyValueFactory<>("socialSecurityNumber"));

    TableColumn<Patient, String> generalPractitionerColumn = new TableColumn<>("General Practitioner");
    generalPractitionerColumn.setMaxWidth(300);
    generalPractitionerColumn.setCellValueFactory(new PropertyValueFactory<>("generalPractitioner"));

    TableColumn<Patient, String> diagnosisColumn = new TableColumn<>("Diagnosis");
    diagnosisColumn.setMaxWidth(300);
    diagnosisColumn.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));

    tableView.setItems(patientOList);
    tableView.getColumns().addAll(firstNameColumn, lastNameColumn, socialSecurityNumberColumn, generalPractitionerColumn, diagnosisColumn);


    return tableView;
  }
}
