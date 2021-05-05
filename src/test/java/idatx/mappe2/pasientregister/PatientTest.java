package idatx.mappe2.pasientregister;

import idatx.mappe2.pasientregister.model.Patient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for Patient class.
 */
public class PatientTest {
  Patient patient = new Patient("FN", "LN", "GP", "SSN", "D");

  /**
   * Tests getSocialSecurityNumber
   * (Positive)
   * Assert SSN is whats been given.
   */
  @Test
  public void getSocialSecurityNumberTest() {
    assertEquals("SSN", this.patient.getSocialSecurityNumber());
  }

  /**
   * Tests getFirstName
   * (Positive)
   * Assert first name is whats been given.
   */
  @Test
  public void getFirstNameTest() {
    assertEquals("FN", this.patient.getFirstName());
  }

  /**
   * Tests getLastName
   * (Positive)
   * Assert last name is whats been given.
   */
  @Test
  public void getLastNameTest() {
    assertEquals("LN", this.patient.getLastName());
  }

  /**
   * Tests getFullName
   * (Positive)
   * Assert both first name and last name combined is whats been given.
   */
  @Test
  public void getFullNameTest() {
    assertEquals("FN LN", patient.getFullName());
  }

  /**
   * Tests getDiagnosis
   * (Positive)
   * Asserts diagnosis is whats been given.
   */
  @Test
  public void getDiagnosisTest() {
    assertEquals("D", patient.getDiagnosis());
  }

  /**
   * Tests getGeneralPractitioner
   * (Postive)
   * Asserts general practitioner is whats been given.
   */
  @Test
  public void getGeneralPractitionerTest() {
    assertEquals("GP", patient.getGeneralPractitioner());
  }

  /**
   * Test that set diagnosis changes empty string to [Undiagnosed]
   * (Positive)
   * Assert diagnosis is [Undiagnosed].
   */
  @Test
  public void setDiagnosisTest() {
    patient.setDiagnosis("");
    assertEquals("[Undiagnosed]", this.patient.getDiagnosis());
  }

  /**
   * Tests that social security number can not be given empty string or null.
   * (Positive)
   * Assert social security number is the old one.
   */
  @Test
  public void setSecurityNumberTest() {
    try {
      this.patient.setSocialSecurityNumber("");
      this.patient.setSocialSecurityNumber(null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    assertEquals("SSN", this.patient.getSocialSecurityNumber());
  }
}