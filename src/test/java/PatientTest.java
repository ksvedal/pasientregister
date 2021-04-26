import idatx.mappe2.pasientregister.Patient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientTest {
  Patient patient = new Patient(2, "boB", "Vekke", "Mageknip", "Christian Bale");

  @Test
  public void getSocialSecurityNumberTest() {
    assertEquals(2, this.patient.getSocialSecurityNumber());
  }

  @Test
  public void getFirstNameTest() {
    assertEquals("boB", this.patient.getFirstName());
  }

  @Test
  public void getLastNameTest() {
    assertEquals("Vekke", this.patient.getLastName());
  }

  @Test
  public void getFullNameTest() {
    assertEquals("boB Vekke", patient.getFullName());
  }

  @Test
  public void getDiagnosisTest() {
    assertEquals("Mageknip", patient.getDiagnosis());
  }

  @Test
  public void getGeneralPractitionerTest() {
    assertEquals("Christian Bale", patient.getGeneralPractitioner());
  }
}