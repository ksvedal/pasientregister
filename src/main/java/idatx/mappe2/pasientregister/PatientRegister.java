package idatx.mappe2.pasientregister;

import java.util.ArrayList;
import java.util.List;

/**
 * PatientRegister class.
 * Contains HashMap of all patients in the hospital with social
 * security number as Key.
 */
public class PatientRegister {
  private ArrayList<Patient> patients;
  private Patient patient1;
  private Patient patient2;

  /**
   * Constructor of PatientRegister.
   */
  public PatientRegister() {
    this.patients = new ArrayList<>();
  }

  public void fillWithPatients() {
    patient1 = new Patient(123, "Bob", "Skva", "dårleg i magen", "bob sagan");
    patient2 = new Patient(123445, "fddsf", "dsffds", "dårleg i taket", "bob sagan");
    this.patients.add(patient1);
    this.patients.add(patient2);
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