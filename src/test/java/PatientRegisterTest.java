import idatx.mappe2.pasientregister.model.Patient;
import idatx.mappe2.pasientregister.model.PatientRegister;
import org.junit.jupiter.api.Test;

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
}
