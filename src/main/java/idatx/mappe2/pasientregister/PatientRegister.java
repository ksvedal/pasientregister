package idatx.mappe2.pasientregister;

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

      BufferedReader br = new BufferedReader(new FileReader(newPath));

      //Dodge the first line of the csv file (Title bars).
      br.readLine();
      String diagnosis;

      while((line = br.readLine()) !=null) {
        String[] values = line.split(";");

        try {
          diagnosis = values[4];
        } catch (IndexOutOfBoundsException e) {
          diagnosis = "[Undiagnosed]";
        }
        patients.add(new Patient(values[0], values[1], values[2], values[3], diagnosis));
      }

      success = true;
      br.close();


    return success;
  }

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
   * Adds a patient to the hospital HashMap with social security number as key.
   * @param patient patient to add.
   */
  public void addPatient(Patient patient) {
    this.patients.add(patient);
  }

  /**
   * Returns the patients ArrayList of the hospital.
   * @return patients in the hospital.
   */
  public List getPatients() {
    return this.patients;
  }
}