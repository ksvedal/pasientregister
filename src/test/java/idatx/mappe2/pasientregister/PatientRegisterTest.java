package idatx.mappe2.pasientregister;

import idatx.mappe2.pasientregister.model.Patient;
import idatx.mappe2.pasientregister.model.PatientRegister;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PatientRegisterTest {
  PatientRegister patientRegister = new PatientRegister();
  Patient patient = new Patient("0", "Bob", "Bobesen", "Dårleg i magen", "Steven seagal");
  Patient patient1 = new Patient("2", "Bob", "Bobesen", "Dårleg i magen", "Steven seagal");

  @Test
  public void addPatientTest() {
    patientRegister.addPatient(patient);
    patientRegister.addPatient(patient1);
    System.out.println(patientRegister.getPatients());
    assertEquals(2, patientRegister.getPatients().size());
   }

   @Test
  public void importPatientsTest() {
    try {
      patientRegister.importPatients("");
      assertNotNull(patientRegister.getPatients());
    } catch (IOException e) {
      System.out.println(e.getMessage());
      fail();
    }
   }
}
