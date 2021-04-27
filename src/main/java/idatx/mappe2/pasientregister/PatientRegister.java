package idatx.mappe2.pasientregister;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
   */
  public PatientRegister() {
    this.patients = new ArrayList<>();
  }

  /**
   * Imports the patients.csv file to the patients arraylist.
   * @return import success or failure
   */
  public boolean importPatients() {
    String path = "src/main/resources/patients.csv";
    String line = "";
    boolean success = false;

    try {
      BufferedReader br = new BufferedReader(new FileReader(path));

      //Dodge the first line of the csv file (Title bars).
      br.readLine();

      while((line = br.readLine()) !=null) {
        String[] values = line.split(";");
        patients.add(new Patient(values[0], values[1], values[2], values[3], "Diagnosis"));
      }
      success = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return success;
  }

  /**
   * Adds a patient to the hospital HashMap with social security number as key.
   * @param patient patient to add.
   */
  public void addPatient(Patient patient) {
    this.patients.add(patient);
  }

  /**
   * Returns the patients HashMap of the hospital.
   * @return patients in the hospital.
   */
  public List getPatients() {
    return this.patients;
  }
}