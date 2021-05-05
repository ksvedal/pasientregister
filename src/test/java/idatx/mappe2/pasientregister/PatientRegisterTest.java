package idatx.mappe2.pasientregister;

import idatx.mappe2.pasientregister.model.Patient;
import idatx.mappe2.pasientregister.model.PatientRegister;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for PatientRegister class.
 */
public class PatientRegisterTest {
  PatientRegister patientRegister = new PatientRegister();
  Patient patient = new Patient("0", "Bob", "Bobesen", "Dårleg i magen", "Steven seagal");
  Patient patient1 = new Patient("2", "Bob", "Bobesen", "Dårleg i magen", "Steven seagal");

  /**
   * Test for addPatient.
   * (Positive)
   * Adds two patients to the register then checks that the get-method returns two as size.
   */
  @Test
  public void addPatientTest() {
    patientRegister.addPatient(patient);
    patientRegister.addPatient(patient1);
    System.out.println(patientRegister.getPatients());
    assertEquals(2, patientRegister.getPatients().size());
   }

  /**
   * Tests importPatient.
   * (Positive)
   * Checks if import patients redirects to patients.csv if empty path is entered and that no
   * IOException occurs.
   */
  @Test
  public void importPatientsTest() {
    try {
      patientRegister.importPatients("");
    } catch (IOException e) {
      System.out.println(e.getMessage());
      fail();
    }
  }
}
