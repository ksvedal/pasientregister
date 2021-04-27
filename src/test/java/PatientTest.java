import idatx.mappe2.pasientregister.Patient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientTest {
  Patient patient = new Patient("FN", "LN", "GP", "SSN", "D");

  @Test
  public void getSocialSecurityNumberTest() {
    assertEquals("SSN", this.patient.getSocialSecurityNumber());
  }

  @Test
  public void getFirstNameTest() {
    assertEquals("FN", this.patient.getFirstName());
  }

  @Test
  public void getLastNameTest() {
    assertEquals("LN", this.patient.getLastName());
  }

  @Test
  public void getFullNameTest() {
    assertEquals("FN LN", patient.getFullName());
  }

  @Test
  public void getDiagnosisTest() {
    assertEquals("D", patient.getDiagnosis());
  }

  @Test
  public void getGeneralPractitionerTest() {
    assertEquals("GP", patient.getGeneralPractitioner());
  }
}