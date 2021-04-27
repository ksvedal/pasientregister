package idatx.mappe2.pasientregister;

/**
 * Patient class with all values of a patient.
 */
public class Patient {
  private String firstName;
  private String lastName;
  private String generalPractitioner;
  private String socialSecurityNumber;
  private String diagnosis;

  public Patient(
                 String firstName,
                 String lastName,
                 String generalPractitioner,
                 String socialSecurityNumber,
                 String diagnosis) {
    this.socialSecurityNumber = socialSecurityNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.diagnosis = diagnosis;
    this.generalPractitioner = generalPractitioner;
  }

  /**
   * Return social security number of patient.
   * @return social security number.
   */
  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  /**
   * Returns first name of patient.
   * @return first name.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Returns last name of patient.
   * @return last name.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Returns full name of patient.
   * @return full name.
   */
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  /**
   * Returns diagnosis of patient
   * @return diagnosis.
   */
  public String getDiagnosis() {
    return this.diagnosis;
  }

  /**
   * Returns general practitioner of a patient.
   * @return general practitioner.
   */
  public String getGeneralPractitioner() {
    return this.generalPractitioner;
  }

  @Override
  public String toString() {
    return "Patient: " + socialSecurityNumber + ", " + firstName + " " + lastName + ", " + diagnosis + ", " + generalPractitioner;
  }
}
