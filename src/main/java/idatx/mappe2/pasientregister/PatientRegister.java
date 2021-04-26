package idatx.mappe2.pasientregister;

import java.util.HashMap;

/**
 * PatientRegister class.
 * Contains HashMap of all patients in the hospital with social
 * security number as Key.
 */
public class PatientRegister {
  private HashMap<Integer, Patient> patients;

  /**
   * Constructor of PatientRegister.
   */
  public PatientRegister() {
    patients = new HashMap<>();
  }

  /**
   * Adds a patient to the hospital HashMap with social security number as key.
   * @param patient patient to add.
   */
  public void addPatient(Patient patient) {
    this.patients.put(patient.getSocialSecurityNumber(), patient);
  }

  /**
   * Returns the patients HashMap of the hospital.
   * @return patients in the hospital.
   */
  public HashMap getPatients() {
    return this.patients;
  }
}