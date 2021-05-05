package idatx.mappe2.pasientregister.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PatientRegister class.
 * Contains HashMap of all patients in the hospital with social
 * security number as Key.
 */
public class PatientRegister {
  private ArrayList<Patient> patients;

  /**
   * Constructor of PatientRegister.
   * Created an arraylist of patients.
   * Could also have used a hashmap and used social security number as
   * key, because all persons have a unique social security number.
   */
  public PatientRegister() {
    this.patients = new ArrayList<>();
  }

  /**
   * Imports the patients.csv file to the patients arraylist.
   * If path to import parameter is empty, will be set to the standard patients.csv file in resources.
   * @return import success or failure
   */
  public boolean importPatients(String path) throws IOException {
    patients.clear();
    String newPath = "";
    if (path.isEmpty()) {
      newPath = "src/main/resources/patients.csv";
    } else {
      newPath = path;
    }

    String line = "";
    boolean success = false;
    String diagnosis;

      BufferedReader br = new BufferedReader(new FileReader(newPath));

      // Skip the first line of the csv file (Title bars).
      br.readLine();
      while((line = br.readLine()) !=null) {
        String[] values = line.split(";");

        // Try-catch block checks if the fifth value (diagnosis) is out of bounds.
        // If it is, sets the value in the arraylist to null.
        try {
          diagnosis = values[4];
        } catch (IndexOutOfBoundsException e) {
          diagnosis = null;
        }
        patients.add(new Patient(values[0], values[1], values[2], values[3], diagnosis));
      }

      success = true;
      br.close();

    return success;
  }

  /**
   * Export items in patients arrayList to csv file that user selects.
   * @param path Where to export.
   * @throws IOException IOException thrown from filewriter.
   */
  public void exportPatients(String path) throws IOException {
    File file = new File(path);
    FileWriter fileWriter = new FileWriter(file);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

    bufferedWriter.write("Patients:");
    bufferedWriter.newLine();
    for (int i = 0; i < getPatients().size(); i++) {
      bufferedWriter.write(getPatients().get(i) + ";\n");
    }

    bufferedWriter.close();
    fileWriter.close();
  }

  /**
   * Adds a patient to the patientRegister ArrayList.
   * @param patient patient to add.
   */
  public void addPatient(Patient patient) throws IllegalArgumentException {
    this.patients.add(patient);
  }

  /**
   * Returns the patients ArrayList of the hospital.
   * @return patients in the hospital.
   */
  public List<Patient> getPatients() {
    return this.patients;
  }
}